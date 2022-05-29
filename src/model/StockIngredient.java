/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.util.Vector;

import database.DBConnection;
import database.DBTable;
import database.DatabaseAccess;

/**
 *
 * @author Vola
 */
public class StockIngredient extends DBTable{
    String idIngredient;
    String nomIngredient;
    double reste;

    public String getIdIngredient() {
        return idIngredient;
    }

    public double getReste() {
		return reste;
	}

	public void setReste(double reste) {
		this.reste = reste;
	}

	public void setIdIngredient(String idIngredient) {
        this.idIngredient = idIngredient;
    }

    @Override
	public String toString() {
		return "StockIngredient [idIngredient=" + idIngredient + ", nomIngredient=" + nomIngredient + ", reste=" + reste
				+ "]";
	}

	public String getNomIngredient() {
        return nomIngredient;
    }

    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }

    public double getQuantiteReste() {
        return reste;
    }

    public void setQuantiteReste(double quantiteReste) {
        this.reste = quantiteReste;
    }
    
    public StockIngredient[] getStock() throws Exception {
        Connection con = DBConnection.psqlConnection();

        Vector<StockIngredient> vector = DatabaseAccess.find("select  *  from  stockActuelle", StockIngredient.class, con);
        StockIngredient[] result = new StockIngredient[vector.size()];
        vector.copyInto(result);
        
        con.close();
        return result;
    }
}
