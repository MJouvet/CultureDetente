package com.sql.bean;

public class Document {

	private String IdCote = " ";
	private String Titre = " ";
	private String Auteur = " ";
	private String typeDoc;
	private String Genre = " ";
	private Boolean Disponible;
	private int Caution;
	
	
	public Document(String IdCote, String Titre, String Auteur, String typeDoc, String Genre, Boolean Disponible, int Caution) {
		this.IdCote = IdCote;
		this.Titre = Titre;
		this.Auteur = Auteur;
		this.typeDoc = typeDoc;
		this.Genre = Genre;
		this.Disponible = Disponible;
		this.Caution = Caution;
	}
	
	public Document(){};
	
	public String getId() {
		return IdCote;
	}
	
	public void setId(String IdCote) {
		this.IdCote = IdCote;
	}
	
	public String getTitre() {
		return Titre;
	}
	
	public void setTitre(String Titre) {
		this.Titre = Titre;
	}
	public String getAuteur() {
		return Auteur;
	}
	
	public void setAuteur(String Auteur) {
		this.Auteur = Auteur;
	}
	
	public String getTypeDoc() {
		return typeDoc;
	}
	
	public void setTypeDoc(String typeDoc) {
		this.typeDoc = typeDoc;
	}
	
	public String getGenre() {
		return Genre;
	}
	
	public void setGenre(String Genre) {
		this.Genre = Genre;
	}
	
	public Boolean getDisponible() {
		return Disponible;
	}
	
	public void setDisponible(Boolean Disponible) {
		this.Disponible = Disponible;
	}
	
	public int getCaution() {
		return Caution;
	}
	
	public void setCaution(int Caution) {
		this.Caution = Caution;
	}

}
