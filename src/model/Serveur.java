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
public class Serveur extends DBTable{
    String idserveur;
    String nomServeur;

    public String getIdServeur() {
        return idserveur;
    }

    public void setIdServeur(String id) {
        this.idserveur = id;
    }

    public String getNomServeur() {
        return nomServeur;
    }

    public void setNomServeur(String nomServeur) {
        this.nomServeur = nomServeur;
    }
    
    public Serveur[] getServeurs() throws Exception {
        Connection con = DBConnection.psqlConnection();
        String condition = "";
        Serveur serveur = new Serveur();
        Vector v = serveur.find(condition, con);
        Serveur[] res = new Serveur[v.size()];
        v.copyInto(res);
        con.close();
        return res; 
    }
}
