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
public class Plat extends DBTable{
    String idPlat;
    String idTypePlat;
    String nomPlat;
    String nomTypePlat;
    double prixPlat;
    double prixRevient;

    public String getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(String idPlat) {
        this.idPlat = idPlat;
    }

    public String getIdTypePlat() {
        return idTypePlat;
    }

    public void setIdTypePlat(String idTypePlat) {
        this.idTypePlat = idTypePlat;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public void setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
    }

    public String getNomTypePlat() {
        return nomTypePlat;
    }

    public void setNomTypePlat(String nomTypePlat) {
        this.nomTypePlat = nomTypePlat;
    }

    public double getPrixPlat() throws Exception {
        return getPrixRevient() + calculPourcentage(pourcentage(getPrixRevient()), getPrixRevient());
    }

    public void setPrixPlat(double prixPlat) {
        this.prixPlat = prixPlat;
    }

    public double getPrixRevient() {
        return prixRevient;
    }

    public void setPrixRevient(double prixRevient) {
        this.prixRevient = prixRevient;
    }
    
    public Plat[] getListePlats(String idTypePlat) throws Exception{
        Connection con = DBConnection.psqlConnection();
        String condition = "";
        if(idTypePlat != null){
            if(idTypePlat.compareTo("") != 0)condition = " where idTypePlat='"+idTypePlat+"'";
        }
        Plat plat = new Plat();
        plat.setNomTable("platPrixRevient");
        Vector v = plat.find(condition, con);
        Plat[] res = new Plat[v.size()];
        v.copyInto(res);
        return res; 
    }
    
    public Plat[] getListePrixRevient() throws Exception{
        Connection con = DBConnection.psqlConnection();
        String condition = "";
        Plat plat = new Plat();
        plat.setNomTable("platPrixRevient");
        Vector v = plat.find(condition, con);
        Plat[] res = new Plat[v.size()];
        v.copyInto(res);
        return res; 
    }
    
    public double calculPourcentage(double pourcentage, double prix) {
        return (pourcentage * prix) / 100;
    }
    
    public double pourcentage(double prix) throws Exception {
        Marge[] listMarges = new Marge().getListeMarge();
        for (Marge listMarge : listMarges) {
            if(prix <= listMarge.getMax() && prix > listMarge.getMin())
                return listMarge.getPourcentage();
        }
        return 0;

    } 
    
    public Plat getPlatById(String id) throws Exception {
        Connection con = DBConnection.psqlConnection();
        String condition = " where idPlat='" + id + "'";
        Plat plat = new Plat();
        plat.setNomTable("platPrixRevient");
        Vector v = plat.find(condition, con);
        Plat[] res = new Plat[v.size()];
        v.copyInto(res);
        con.close();
        return res[0];
    }
}
