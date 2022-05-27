/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Vola
 */
public class DBTable {

    String nomTable;
    String limit = "";
    String colonne = " * ";

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getNomTable() {
        return nomTable;
    }

    public void setNomTable(String nomTable) {
        this.nomTable = nomTable;
    }

    public String getColonne() {
        return colonne;
    }

    public void setColonne(String colonne) {
        this.colonne = colonne;
    }

    public void insert(Connection con) throws Exception {
        boolean isPsqlCon = con.getMetaData().getURL().startsWith("jdbc:postgresql://");
        boolean isMysqlCon = con.getMetaData().getURL().startsWith("jdbc:mysql://");
        String req = "insert into ";
        String table = getClass().getSimpleName();
        req += table + " values (";
        Method[] getters = listGettersSetters("get");
        for (Method ter : getters) {
            String attr = ter.getName().substring(3).toLowerCase();
            if (attr.toLowerCase().compareTo(("id"+table).toLowerCase()) == 0) {
                if (isPsqlCon) {
                    req += "CONCAT('" + table + "-', nextval('" + table + "Seq'))";
                }
                if (isMysqlCon) {
                    req += "null";
                }
            } else {
                Object temp = ter.invoke(this);
                if (temp instanceof Timestamp) {
                    req += ",TO_TIMESTAMP('" + temp + "', 'YYYY-MM-DD HH24:MI:SS.FF')";
                } else if (temp instanceof java.util.Date || temp instanceof java.sql.Date) {
                    Date d = (Date) temp;
                    int j = d.getDate();
                    int m = d.getMonth() + 1;
                    int a = d.getYear() + 1900;
//                    int h=d.getHours();
//                    int mi=d.getMinutes();
//                    int s=d.getSeconds();
                    req += ",'" + a + "-" + m + "-" + j + "'";
                } else {
                    if (temp == null) {
                        req += ",null";
                    } else if (isNumber(temp)) {
                        req += "," + temp;
                    } else {
                        req += ",'" + temp + "'";
                    }
                }
            }
        }
        req += ")";
        System.out.println(req);

        try {
            Statement stmt = con.createStatement();
            int res = stmt.executeUpdate(req);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Connection c) throws Exception {
        String table = getClass().getSimpleName();
        if (getNomTable() != null) {
            table = getNomTable();
        }
        String idtable = "id" + table;
        String req = "update " + table + " set ";
        Method[] getters = listGettersSetters("get");
        int w = 0;
        int verif = 0;
        for (Method ter : getters) {
            Object temp = ter.invoke(this);
            if (temp != null) {
                w++;
            }
        }
        if (w == 0) {
            throw new Exception("no update");
        }
        for (Method ter : getters) {
            String attr = ter.getName().substring(3).toLowerCase();
            Object temp = ter.invoke(this);
            if (idtable.toLowerCase().compareTo(attr) != 0) {
                if (temp != null) {
                    verif++;
                    if (isNumber(temp)) {
                        req = req + attr + "=" + temp;
                        if (verif != w) {
                            req = req + " , ";
                        }
                    } else {
                        req = req + attr + "='" + temp + "'";
                        if (verif != w) {
                            req = req + " , ";
                        }
                    }
                }
            }
        }
        req = req + " where ";
        for (Method ter : getters) {
            String attr = ter.getName().substring(3).toLowerCase();
            Object temp = ter.invoke(this);
            if ("id".toLowerCase().compareTo(attr) == 0) {
                if (temp == null) {
                    throw new Exception("id Null");
                }
                req = req + "id='" + temp + "'";
            }
        }
        System.out.println(req);
        Statement stmt = c.createStatement();
        int res = stmt.executeUpdate(req);
    }

    public Vector find(String condition, Connection con) throws Exception {
        Vector v = new Vector();
        String table = getClass().getSimpleName();
        if (getNomTable() != null) {
            table = getNomTable();
        }
        String req = "select " + getLimit() + getColonne() +" from " + table + " " + condition;
        System.out.println(req);
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(req);
        Method[] setters = listGettersSetters("set");
        int dd = 0;
        while (res.next()) {
            dd++;
            Object temp = getClass().newInstance();
            for (Method setter : setters) {
                Object arg = strToObject(res.getString(setter.getName().substring(3)), setter.getParameterTypes()[0]);
                Object o = setter.invoke(temp, arg);
            }
            v.add(temp);
        }
        return v;
    }

    public boolean isNumber(Object nbr) {
        return nbr instanceof Number;
    }

    public Object strToObject(String str, Class<?> classType) throws ParseException, InstantiationException, IllegalAccessException {
        String className = classType.getSimpleName();
        if (str == null) {
            return null;
        }
        if (className.compareTo("int") == 0) {
            return Integer.parseInt(str);
        } else if (className.compareTo("float") == 0) {
            return Float.parseFloat(str);
        } else if (className.compareTo("double") == 0) {
            return Double.parseDouble(str);
        } else if (className.compareTo("String") == 0) {
            return str;
        } else if (className.compareTo("Date") == 0) {
            String dateStr = str.replace("-", "/");
            if (dateStr.length() == 10) {
                dateStr += " 00:00:00.000";
            }
            return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").parse(dateStr);
        } else {
            return classType.newInstance();
        }
    }

    public Method[] listGettersSetters(String getSet) {
        Method[] allMeth = getClass().getDeclaredMethods();
        Field[] listField = getClass().getDeclaredFields();
        Vector v = new Vector<Method>();
        for (Field listField1 : listField) {
            for (Method allMeth1 : allMeth) {
                String fieldToGetter = getSet + listField1.getName();
                if (allMeth1.getName().toLowerCase().compareTo(fieldToGetter.toLowerCase()) == 0) {
                    v.add(allMeth1);
                }
            }
        }
        Method[] rep = new Method[v.size()];
        v.copyInto(rep);
        return rep;
    }
}
