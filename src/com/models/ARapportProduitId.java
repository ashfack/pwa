package com.models;
// Generated 7 f�vr. 2017 11:34:38 by Hibernate Tools 5.2.0.Beta1

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ARapportProduitId generated by hbm2java
 */
@Entity
@XmlRootElement(name="ARapportProduitId")
public class ARapportProduitId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rapportId;
	private String produitNom;
	private int numSerie;

	public ARapportProduitId() {
	}

	public ARapportProduitId(int rapportId, String produitNom, int numSerie) {
		this.rapportId = rapportId;
		this.produitNom = produitNom;
		this.numSerie = numSerie;
	}

	public int getRapportId() {
		return this.rapportId;
	}

	public void setRapportId(int rapportId) {
		this.rapportId = rapportId;
	}

	public String getProduitNom() {
		return this.produitNom;
	}

	public void setProduitNom(String produitNom) {
		this.produitNom = produitNom;
	}

	public int getNumSerie() {
		return this.numSerie;
	}

	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ARapportProduitId))
			return false;
		ARapportProduitId castOther = (ARapportProduitId) other;

		return (this.getRapportId() == castOther.getRapportId())
				&& ((this.getProduitNom() == castOther.getProduitNom()) || (this.getProduitNom() != null
						&& castOther.getProduitNom() != null && this.getProduitNom().equals(castOther.getProduitNom())))
				&& (this.getNumSerie() == castOther.getNumSerie());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getRapportId();
		result = 37 * result + (getProduitNom() == null ? 0 : this.getProduitNom().hashCode());
		result = 37 * result + this.getNumSerie();
		return result;
	}

}
