package com.adaming.dto;

import java.util.Date;


import com.adaming.entities.Affaire;

public class DocumentDTO {
	private Long id ; 
	private Date dateCreation; 
	private String nom; 
	private String description;
	private boolean archive; 
	private Affaire affaire;
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
	public Affaire getAffaire() {
		return affaire;
	}
	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}
	public DocumentDTO() {
		super();
	}
	public DocumentDTO(Date dateCreation, String nom, String description, boolean archive, Affaire affaire) {
		super();
		this.dateCreation = dateCreation;
		this.nom = nom;
		this.description = description;
		this.archive = archive;
		this.affaire = affaire;
	}
	@Override
	public String toString() {
		return "DocumentDTO [id=" + id + ", dateCreation=" + dateCreation + ", nom=" + nom + ", description="
				+ description + ", archive=" + archive + ", affaire=" + affaire + "]";
	}
}
