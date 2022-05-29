package model;

import java.util.Date;

public class PaiementCommande{
	String idCommande;
    String idTable;
    Date dateCommande;
    double addition;
	private double paye;

	public double getPaye() {
		return paye;
	}

	public void setPaye(double paye) {
		this.paye = paye;
	}

	@Override
	public String toString() {
		return "PaiementCommande [idCommande=" + idCommande + ", idTable=" + idTable + ", dateCommande=" + dateCommande
				+ ", addition=" + addition + ", paye=" + paye + "]";
	}

	public String getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(String idCommande) {
		this.idCommande = idCommande;
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

	
	
}
