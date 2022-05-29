package model.commande;

/**
 * Modèle du view du base de données qui permet de voir une commande de plat
 * 
 * @author Mandresy
 *
 */
public class PlatCommande {

	private String iddetailscommande;
	private String idcommande;
	private String nomplat;
	private String idserveur;
	private int quantite;
	private double prixplat;
	private String idetat;

	@Override
	public String toString() {
		return "PlatCommande [iddetailscommande=" + iddetailscommande + ", idcommande=" + idcommande + ", nomplat="
				+ nomplat + ", idserveur=" + idserveur + ", quantite=" + quantite + ", prixplat=" + prixplat
				+ ", idetat=" + idetat + "]";
	}

	public String getIddetailscommande() {
		return iddetailscommande;
	}

	public void setIddetailscommande(String iddetailscommande) {
		this.iddetailscommande = iddetailscommande;
	}

	public String getIdcommande() {
		return idcommande;
	}

	public void setIdcommande(String idcommande) {
		this.idcommande = idcommande;
	}

	public String getNomplat() {
		return nomplat;
	}

	public void setNomplat(String nomplat) {
		this.nomplat = nomplat;
	}

	public String getIdserveur() {
		return idserveur;
	}

	public void setIdserveur(String idserveur) {
		this.idserveur = idserveur;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixplat() {
		return prixplat;
	}

	public void setPrixplat(double prixplat) {
		this.prixplat = prixplat;
	}

	public String getIdetat() {
		return idetat;
	}

	public void setIdetat(String idetat) {
		this.idetat = idetat;
	}

}
