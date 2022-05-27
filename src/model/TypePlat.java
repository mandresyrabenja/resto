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
public class TypePlat extends DBTable{
    String idTypePlat;
    String nomTypePlat;

    public String getIdTypePlat() {
        return idTypePlat;
    }

    public void setIdTypePlat(String idTypePlat) {
        this.idTypePlat = idTypePlat;
    }

    public String getNomTypePlat() {
        return nomTypePlat;
    }

    public void setNomTypePlat(String nomTypePlat) {
        this.nomTypePlat = nomTypePlat;
    }
    
    public TypePlat[] getTypePlat() throws Exception {
        Connection con = DBConnection.psqlConnection();
        TypePlat typePlat = new TypePlat();
        Vector v = typePlat.find("", con);
        TypePlat[] res = new TypePlat[v.size()];
        v.copyInto(res);
        con.close();
        return res; 
    }
}
