package com.models;
// Generated 7 f�vr. 2017 11:34:38 by Hibernate Tools 5.2.0.Beta1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.json.JSONObject;

/**
 * Rapport generated by hbm2java
 */
@Entity
@XmlRootElement(name="Rapport")
@JsonIgnoreProperties
public class Rapport implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RapportId id;
	private Automate automate;
	private Date dateGeneration;
	private String statutFonctionnement;
	private String etat;
	private Integer temperature;
	private String monnayeur;
	private String cb;
	private String cbSc;
	private Integer montantVentes;
	private Set<ARapportProduit> ARapportProduits = new HashSet<ARapportProduit>(0);
	private Set<Erreur> erreurs = new HashSet<Erreur>(0);

	public Rapport() {
	}

	public Rapport(RapportId id, Automate automate, Date dateGeneration, String statutFonctionnement, String etat,
			String monnayeur, String cb, String cbSc) {
		this.id = id;
		this.automate = automate;
		this.dateGeneration = dateGeneration;
		this.statutFonctionnement = statutFonctionnement;
		this.etat = etat;
		this.monnayeur = monnayeur;
		this.cb = cb;
		this.cbSc = cbSc;
	}

	public Rapport(RapportId id, Automate automate, Date dateGeneration, String statutFonctionnement, String etat,
			Integer temperature, String monnayeur, String cb, String cbSc, Integer montantVentes,Set<ARapportProduit> ARapportProduits,
			Set<Erreur> erreurs) {
		this.id = id;
		this.automate = automate;
		this.dateGeneration = dateGeneration;
		this.statutFonctionnement = statutFonctionnement;
		this.etat = etat;
		this.temperature = temperature;
		this.monnayeur = monnayeur;
		this.cb = cb;
		this.cbSc = cbSc;
		this.montantVentes = montantVentes;
		this.ARapportProduits = ARapportProduits;
		this.erreurs = erreurs;
	}

	public RapportId getId() {
		return this.id;
	}

	public void setId(RapportId id) {
		this.id = id;
	}

	public Automate getAutomate() {
		return this.automate;
	}

	public void setAutomate(Automate automate) {
		this.automate = automate;
	}

	public Date getDateGeneration() {
		return this.dateGeneration;
	}

	public void setDateGeneration(Date dateGeneration) {
		this.dateGeneration = dateGeneration;
	}

	public String getStatutFonctionnement() {
		return this.statutFonctionnement;
	}

	public void setStatutFonctionnement(String statutFonctionnement) {
		this.statutFonctionnement = statutFonctionnement;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Integer getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	public String getMonnayeur() {
		return this.monnayeur;
	}

	public void setMonnayeur(String monnayeur) {
		this.monnayeur = monnayeur;
	}

	public String getCb() {
		return this.cb;
	}

	public void setCb(String cb) {
		this.cb = cb;
	}

	public String getCbSc() {
		return this.cbSc;
	}

	public void setCbSc(String cbSc) {
		this.cbSc = cbSc;
	}

	public Integer getMontantVentes() {
		return this.montantVentes;
	}

	public void setMontantVentes(Integer montantVentes) {
		this.montantVentes = montantVentes;
	}

	public String toString() {

			return "Rapport [rapport_id=" + id.getRapportId() + ", temperature=" + temperature+ ", montant=" + montantVentes +"]";
	}
	 @JsonProperty("ARapportProduits")
	public Set<ARapportProduit> getARapportProduits() {
		return this.ARapportProduits;
	}

	public void setARapportProduits(Set<ARapportProduit> ARapportProduits) {
		this.ARapportProduits = ARapportProduits;
	}

	public Set<Erreur> getErreurs() {
		return this.erreurs;
	}

	public void setErreurs(Set<Erreur> erreurs) {
		this.erreurs = erreurs;
	}
	
	
//	public Rapport fromJSON(JSONObject json)
//	{
//		Rapport r = new Rapport(json.get("id"), )
//	}
}
