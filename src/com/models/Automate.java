package com.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement(name = "Automate")
public class Automate 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "[num_serie]")
	private int num_serie;

	@Column(name = "[type]")
	private String type;
	
	@Column(name = "[adresse]")
	private String adresse;
	
	@Column(name = "[emplacement]")
	private String emplacement;
	
	@Column(name = "[gps]")
	private String gps;
	
	@Column(name = "[date_intervention]")
	private Date date_intervention;
	
	@Column(name = "[commentaires]")
	private String commentaires;
	
	/*
	@ElementCollection
	@CollectionTable(name="[items]", joinColumns=@JoinColumn(name="[automate_id]"))
	@Column(name="item")	
	private List<String> items; 
	*/
	
	public Automate() {
		super();
	}

	public Automate(int num_serie, String type, String adresse, String emplacement, String gps, Date date_intervention, String commentaires) {
		super();
		this.num_serie = num_serie;
		this.type = type;
		this.adresse = adresse;
		this.emplacement = emplacement;
		this.gps = gps;
		this.date_intervention = date_intervention;
		this.commentaires = commentaires;
	}
	
	
	//Getters & Setters
	public int getNum_serie() {
		return num_serie;
	}
	
	public void setNum_serie(int num_serie) {
		this.num_serie = num_serie;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public Date getDate_intervention() {
		return date_intervention;
	}

	public void setDate_intervention(Date date_intervention) {
		this.date_intervention = date_intervention;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	@Override
	public String toString() {
		return "Automate [num_serie=" + num_serie + ", type=" + type + ", adresse=" + adresse + ", emplacement="
				+ emplacement + ", gps=" + gps + ", date_intervention=" + date_intervention + ", commentaires="
				+ commentaires + "]";
	}
}