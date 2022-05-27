/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBConnection;
import database.DBTable;
import java.sql.Connection;
import java.util.Vector;

/**
 *
 * @author Vola
 */
public class Marge extends DBTable{
    double min;
    double max;
    double pourcentage;

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }
    
    public Marge[] getListeMarge() throws Exception{
        Connection con = DBConnection.psqlConnection();
        String condition = "";
        Marge marge = new Marge();
        Vector v = marge.find(condition, con);
        Marge[] res = new Marge[v.size()];
        v.copyInto(res);
        con.close();
        return res; 
    }
}
