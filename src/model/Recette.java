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
public class Recette extends DBTable{
    String idPlat;
    String recette;

    public String getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(String idPlat) {
        this.idPlat = idPlat;
    }

    public String getRecette() {
        return recette;
    }

    public void setRecette(String recette) {
        this.recette = recette;
    }
    
    public Recette getRecette(String idPlat) throws Exception {
        Connection con = DBConnection.psqlConnection();
        String condition = " where idPlat='" + idPlat + "'";
        Recette plat = new Recette();
        Vector v = plat.find(condition, con);
        Recette[] res = new Recette[v.size()];
        v.copyInto(res);
        con.close();
        return res[0];
    }
}
