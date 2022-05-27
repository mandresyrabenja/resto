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
public class NonPaye extends DBTable{
    String idCommande;
    double somme;
    double total;
    double resteAPaye;

    public String getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getResteAPaye() {
        return resteAPaye;
    }

    public void setResteAPaye(double resteAPaye) {
        this.resteAPaye = resteAPaye;
    }
    
    public NonPaye[] getPaiementNonPaye() throws Exception {
        Connection con = DBConnection.psqlConnection();
        NonPaye paiement = new NonPaye();
        String condition = " where  resteapaye > 0";
        Vector v = paiement.find(condition, con);
        NonPaye[] res = new NonPaye[v.size()];
        v.copyInto(res);
        con.close();
        return res; 
    }
}
