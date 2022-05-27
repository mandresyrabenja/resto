/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBConnection;
import database.DBTable;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Vola
 */
public class ServeurPourBoire extends DBTable{
    String idServeur;
    String nomServeur;
    double sommePourBoire;

    public String getIdServeur() {
        return idServeur;
    }

    public void setIdServeur(String idServeur) {
        this.idServeur = idServeur;
    }

    public String getNomServeur() {
        return nomServeur;
    }

    public void setNomServeur(String nomServeur) {
        this.nomServeur = nomServeur;
    }

    public double getSommePourBoire() {
        return sommePourBoire;
    }

    public void setSommePourBoire(double sommePourBoire) {
        this.sommePourBoire = sommePourBoire;
    }
    
    public ServeurPourBoire[] getPouboire(String date1, String date2) throws Exception {
        Connection con = DBConnection.psqlConnection();
        String condition = " where dateCommande between '" + date1 + "' and '" + date2 + "' group by (idServeur, nomServeur)";
        ServeurPourBoire serveurPourBoire = new ServeurPourBoire();
        serveurPourBoire.setColonne(" idServeur, nomServeur, sum(pourBoire) as sommePourBoire ");
        serveurPourBoire.setNomTable(" pourBoire ");
        Vector v = serveurPourBoire.find(condition, con);
        ServeurPourBoire[] res = new ServeurPourBoire[v.size()];
        v.copyInto(res);
        con.close();
        return res;
    }
}
