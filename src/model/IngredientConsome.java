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
public class IngredientConsome extends DBTable{
    String idIngredient;
    String nomIngredient;
    double sommeConsommation;
    double prix;

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

    public double getSommeConsommation() {
        return sommeConsommation;
    }

    public void setSommeConsommation(double sommeConsomation) {
        this.sommeConsommation = sommeConsomation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public IngredientConsome[] getIngredientConsomes(String date1, String date2) throws Exception {
        Connection con = DBConnection.psqlConnection();
        String condition = "where dateCommande" +
        " BETWEEN '"+date1+"' AND '"+ date2 +"'" +
        " group by (idIngredient,nomIngredient,prixIngredient)";
        IngredientConsome ingredientConsome = new IngredientConsome();
        ingredientConsome.setNomTable(" consommation ");
        ingredientConsome.setColonne(" idIngredient,nomIngredient,sum(nb*qtt) as sommeconsommation,(sum(nb*qtt)*prixIngredient) / 1000 as prix ");
        Vector v = ingredientConsome.find(condition, con);
        IngredientConsome[] res = new IngredientConsome[v.size()];
        v.copyInto(res);
        con.close();
        return res;
    }
    
    public double sommeIngredientConsome(IngredientConsome[] ingredientConsomes) {
        double res = 0;
        for (IngredientConsome ingredientConsome : ingredientConsomes) {
            res += ingredientConsome.getPrix();
        }
        return res;
    }
}
