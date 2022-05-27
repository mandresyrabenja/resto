/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBTable;
import database.DBConnection;
import java.sql.Connection;

/**
 *
 * @author Vola
 */
public class DetailsCommande extends DBTable{
    String idDetailsCommande;
    String idCommande;
    String idPlat;
    int quantite;
    String idServeur;
    double prixPlat;
    int etat;

    public String getIdDetailsCommande() {
        return idDetailsCommande;
    }

    @Override
	public String toString() {
		return "DetailsCommande [idDetailsCommande=" + idDetailsCommande + ", idCommande=" + idCommande + ", idPlat="
				+ idPlat + ", quantite=" + quantite + ", idServeur=" + idServeur + ", prixPlat=" + prixPlat + ", etat="
				+ etat + "]";
	}

	public void setIdDetailsCommande(String idDetailsCommande) {
        this.idDetailsCommande = idDetailsCommande;
    }
    
    public String getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    public String getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(String idPlat) {
        this.idPlat = idPlat;
    }
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getIdServeur() {
        return idServeur;
    }

    public void setIdServeur(String idServeur) {
        this.idServeur = idServeur;
    }
    
    public double getPrixPlat() {
        return prixPlat;
    }

    public void setPrixPlat(double prixPlat) {
        this.prixPlat = prixPlat;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    
    public void commander() throws Exception {
        Connection con = DBConnection.psqlConnection();
        this.insert(con);
        con.close();
    }
    
//    public void valider() throws Exception {
//        Connection con = DBConnection.psqlConnection();
//        this.setValide(1);
//        this.update(con);
//        con.close();
//    }
}
