package com.adaming.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

public class Document {
	@Id @GeneratedValue
	private Long id ; 
	private Date dateCreation; 
	private String nom; 
	private String description;
	private boolean archive; 
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CODE_Affaire")
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
	@JsonBackReference
	public Affaire getAffaire() {
		return affaire;
	}
	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}
	public Document(Date dateCreation, String nom, String description, boolean archive, Affaire affaire) {
		super();
		this.dateCreation = dateCreation;
		this.nom = nom;
		this.description = description;
		this.archive = archive;
		this.affaire = affaire;
	}
	public Document() {
		super();
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", dateCreation=" + dateCreation + ", nom=" + nom + ", description=" + description
				+ ", archive=" + archive + ", affaire=" + affaire + "]";
	}
	
	
	
	

}
