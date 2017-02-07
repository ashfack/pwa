package com.models;
// Generated 7 f�vr. 2017 11:34:38 by Hibernate Tools 5.2.0.Beta1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Automate generated by hbm2java
 */
@Entity
@XmlRootElement(name="Automate")
public class Automate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numSerie;
	private String type;
	private String adresse;
	private String emplacement;
	private String gps;
	private Date dateIntervention;
	private String commentaires;
	private Set<Rapport> rapports = new HashSet<Rapport>(0);

	public Automate() {
	}

	public Automate(String type, String adresse, Date dateIntervention) {
		this.type = type;
		this.adresse = adresse;
		this.dateIntervention = dateIntervention;
	}

	public Automate(String type, String adresse, String emplacement, String gps, Date dateIntervention,
			String commentaires, Set<Rapport> rapports) {
		this.type = type;
		this.adresse = adresse;
		this.emplacement = emplacement;
		this.gps = gps;
		this.dateIntervention = dateIntervention;
		this.commentaires = commentaires;
		this.rapports = rapports;
	}
	
	public Automate(Integer numSerie, String type, String adresse, String emplacement, String gps,
			Date dateIntervention, String commentaires) {
		super();
		this.numSerie = numSerie;
		this.type = type;
		this.adresse = adresse;
		this.emplacement = emplacement;
		this.gps = gps;
		this.dateIntervention = dateIntervention;
		this.commentaires = commentaires;
	}

	public Integer getNumSerie() {
		return this.numSerie;
	}

	public void setNumSerie(Integer numSerie) {
		this.numSerie = numSerie;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmplacement() {
		return this.emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getGps() {
		return this.gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public Date getDateIntervention() {
		return this.dateIntervention;
	}

	public void setDateIntervention(Date dateIntervention) {
		this.dateIntervention = dateIntervention;
	}

	public String getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public Set<Rapport> getRapports() {
		return this.rapports;
	}

	public void setRapports(Set<Rapport> rapports) {
		this.rapports = rapports;
	}

	@Override
	public String toString() {
		return "Automate [numSerie=" + numSerie + ", type=" + type + ", adresse=" + adresse + ", emplacement="
				+ emplacement + ", gps=" + gps + ", dateIntervention=" + dateIntervention + ", commentaires="
				+ commentaires + ", rapports=" + rapports + "]";
	}
	

}
