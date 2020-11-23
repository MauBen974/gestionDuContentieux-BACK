package com.adaming.beans;

import java.util.Date;
import java.util.List;

public class DocumentBean {

	private Long id ; 
	private Date dateCreation; 
	private String nom; 
	private String description;
	private boolean archive; 
	private AffaireBean affaire;

		public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	public AffaireBean getAffaire() {
		return affaire;
	}
	public void setAffaire(AffaireBean affaire) {
		this.affaire = affaire;
	}
	public DocumentBean(Date dateCreation, String nom, String description, boolean archive, Affaire affaire) {
		super();
		this.dateCreation = dateCreation;
		this.nom = nom;
		this.description = description;
		this.archive = archive;
		this.affaire = affaire;
	}
	public DocumentBean() {
		super();
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", dateCreation=" + dateCreation + ", nom=" + nom + ", description=" + description
				+ ", archive=" + archive + ", affaire=" + affaire + "]";
	}

}
