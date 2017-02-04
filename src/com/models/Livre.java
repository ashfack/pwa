package com.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Livre")
public class Livre {
	
	private String titre, auteur;
	private long ISBN;
	
	public Livre()
	{
		this.titre = "inconnu";
		this.auteur = "inconnu";
		ISBN = 1; 
	}
	public Livre(String titre, String auteur, long iSBN) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		ISBN = iSBN;
	}
	
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	
	

}
