package model;

import java.sql.Date;

public class Paiement {
	private String idpaiement;
	private String idcommande;
	private String idtypepaiement;
	private double sommepaye;
	private Date datepaiement;
	
	@Override
	public String toString() {
		return "Paiement [idpaiement=" + idpaiement + ", idcommande=" + idcommande + ", idtypepaiement="
				+ idtypepaiement + ", sommepaye=" + sommepaye + ", datepaiement=" + datepaiement + "]";
	}
	public String getIdpaiement() {
		return idpaiement;
	}
	public void setIdpaiement(String idpaiement) {
		this.idpaiement = idpaiement;
	}
	public String getIdcommande() {
		return idcommande;
	}
	public void setIdcommande(String idcommande) {
		this.idcommande = idcommande;
	}
	public String getIdtypepaiement() {
		return idtypepaiement;
	}
	public void setIdtypepaiement(String idtypepaiement) {
		this.idtypepaiement = idtypepaiement;
	}
	public double getSommepaye() {
		return sommepaye;
	}
	public void setSommepaye(double sommepaye) {
		this.sommepaye = sommepaye;
	}
	public Date getDatepaiement() {
		return datepaiement;
	}
	public void setDatepaiement(Date datepaiement) {
		this.datepaiement = datepaiement;
	}
	
	
}
