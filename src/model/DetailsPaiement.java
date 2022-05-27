/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBConnection;
import database.DBTable;
import java.sql.Connection;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Vola
 */
public class DetailsPaiement extends DBTable{
    String idCommande;
    String nomTypePaiement;
    double sommePaiement;
    Date datePaiement;

    public String getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    public String getNomTypePaiement() {
        return nomTypePaiement;
    }

    public void setNomTypePaiement(String nomTypePaiement) {
        this.nomTypePaiement = nomTypePaiement;
    }

    public double getSommePaiement() {
        return sommePaiement;
    }

    public void setSommePaiement(double sommePaiement) {
        this.sommePaiement = sommePaiement;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }
    
    public DetailsPaiement[] getPaiement(String date1, String date2) throws Exception {
        Connection con = DBConnection.psqlConnection();
        String condition = " where datePaiement between '" + date1 + "' and '" + date2 + "'" +
                " group by (idCommande,nomPaiement,datePaiement)";
        DetailsPaiement detailsPaiement = new DetailsPaiement();
        detailsPaiement.setColonne(" idCommande,nomPaiement as nomtypepaiement,sum(sommePaye) as SommePaiement,datePaiement ");
        Vector v = detailsPaiement.find(condition, con);
        DetailsPaiement[] res = new DetailsPaiement[v.size()];
        v.copyInto(res);
        con.close();
        return res; 
    }
    
    public static double totalPaiement(DetailsPaiement[] detailsPaiements) {
        double res = 0;
        for (DetailsPaiement detailsPaiement : detailsPaiements) {
            res += detailsPaiement.getSommePaiement();
        }
        return res;
    } 
    
    public DetailsPaiement[] totalPaiementParType(String date1, String date2) throws Exception {
        Connection con = DBConnection.psqlConnection();
        String condition = " where datePaiement between '" + date1 + "' and '" + date2 + "'" +
                " group by (nomtypepaiement)";
        DetailsPaiement detailsPaiement = new DetailsPaiement();
        detailsPaiement.setColonne(" '' idCommande,nomPaiement as nomtypepaiement,sum(sommePaye) as SommePaiement,'"+date1+"' datePaiement ");
        Vector v = detailsPaiement.find(condition, con);
        DetailsPaiement[] res = new DetailsPaiement[v.size()];
        v.copyInto(res);
        con.close();
        return res; 
    }
}
