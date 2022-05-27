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
public class Tablee extends DBTable{
    String idtable;
    String numerotable;

    

    public String getIdtable() {
		return idtable;
	}



	public void setIdtable(String idtable) {
		this.idtable = idtable;
	}



	public String getNumerotable() {
		return numerotable;
	}



	public void setNumerotable(String numerotable) {
		this.numerotable = numerotable;
	}



	public Tablee[] getTables() throws Exception {
        Connection con = DBConnection.psqlConnection();
        String condition = "";
        Tablee table = new Tablee();
        Vector v = table.find(condition, con);
        Tablee[] res = new Tablee[v.size()];
        v.copyInto(res);
        con.close();
        return res; 
    }
}
