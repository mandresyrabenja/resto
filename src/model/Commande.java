/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBConnection;
import database.DBTable;
import database.DatabaseAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Vola
 */
public class Commande extends DBTable{
    String idCommande;
    String idTable;
    Date dateCommande;
    double addition;

    public String getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    @Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", idTable=" + idTable + ", dateCommande=" + dateCommande
				+ ", addition=" + addition + "]";
	}

	public String getIdTable() {
        return idTable;
    }

    public void setIdTable(String idTable) {
        this.idTable = idTable;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public double getAddition() {
        return addition;
    }

    public void setAddition(double addition) {
        this.addition = addition;
    }
    
    public Commande nouvelleCommande() throws Exception {
    	String sequenceSQL = "SELECT CONCAT('commande-', nextval('commandeSeq'))";
        try(Connection connection = DBConnection.psqlConnection();
        		Statement statement = connection.createStatement();
        		ResultSet resultSet = statement.executeQuery(sequenceSQL)) {
        	if(resultSet.next()) {
            	String idCmd = resultSet.getString(1);
        		Commande commande = new Commande();
        		commande.setIdCommande(idCmd);

            	DatabaseAccess.insertToTable(commande, connection);
            	return commande;
        	}
        }
        
        return null;
    }
    
    public Commande[] getAdditionTable() throws Exception {
        Connection con = DBConnection.psqlConnection();
        String condition = "";
        Commande commande = new Commande();
        Vector v = commande.find(condition, con);
        Commande[] res = new Commande[v.size()];
        v.copyInto(res);
        con.close();
        return res; 
    }
    
    public void valider() throws SQLException {
//        Connection con = DBConnection.psqlConnection();
//        DetailsCommande detCom = new DetailsCommande(); 
//        detCom.setIdCommande(this.getIdCommande());
//        detCom.
//        this.update(con);
//        con.close();
    }
}
