package model;

public class TypePaiement {
	private String idtypepaiement;
	private String nompaiement;
	
	
	public String getIdtypepaiement() {
		return idtypepaiement;
	}
	public void setIdtypepaiement(String idtypepaiement) {
		this.idtypepaiement = idtypepaiement;
	}
	public String getNompaiement() {
		return nompaiement;
	}
	public void setNompaiement(String nompaiement) {
		this.nompaiement = nompaiement;
	}
	@Override
	public String toString() {
		return "TypePaiement [idtypepaiement=" + idtypepaiement + ", nompaiement=" + nompaiement + "]";
	}
	
	
}
