package com.models;
// Generated 7 f�vr. 2017 11:34:38 by Hibernate Tools 5.2.0.Beta1

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Erreur generated by hbm2java
 */
@Entity
@XmlRootElement(name="erreurs")
public class Erreur implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ErreurId id;
	//private Rapport rapport;
	private String description;

	public Erreur() {
	}

	public Erreur(ErreurId id//, Rapport rapport) {
	){	this.id = id;
		//this.rapport = rapport;
	}

	public Erreur(ErreurId id, Rapport rapport//, String description) {
	){	this.id = id;
		//this.rapport = rapport;
		this.description = description;
	}

	public ErreurId getId() {
		return this.id;
	}

	public void setId(ErreurId id) {
		this.id = id;
	}

//	public Rapport getRapport() {
//		return this.rapport;
//	}
//
//	public void setRapport(Rapport rapport) {
//		this.rapport = rapport;
//	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
