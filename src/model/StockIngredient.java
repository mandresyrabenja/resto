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
public class StockIngredient extends DBTable{
    String idIngredient;
    String nomIngredient;
    double reste;

    public String getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(String idIngredient) {
        this.idIngredient = idIngredient;
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
        String condition = "";
        StockIngredient ingredientConsome = new StockIngredient();
        ingredientConsome.setNomTable(" stockActuelle ");
        Vector v = ingredientConsome.find(condition, con);
        StockIngredient[] res = new StockIngredient[v.size()];
        v.copyInto(res);
        con.close();
        return res;
    }
}
