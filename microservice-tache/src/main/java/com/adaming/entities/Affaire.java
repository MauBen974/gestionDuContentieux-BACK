package com.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class Affaire implements Serializable {
	@Id @GeneratedValue
	private Long idAffaire;
	private String referenceAffaire;
	private String titreAffaire;
	private String descriptionAffaire; 
	private String status;
	@OneToMany(mappedBy="affaire",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Document> document;
	public Long getIdAffaire() {
		return idAffaire;
	}
	public void setIdAffaire(Long idAffaire) {
		this.idAffaire = idAffaire;
	}
	public String getReferenceAffaire() {
		return referenceAffaire;
	}
	public void setReferenceAffaire(String referenceAffaire) {
		this.referenceAffaire = referenceAffaire;
	}
	public String getTitreAffaire() {
		return titreAffaire;
	}
	public void setTitreAffaire(String titreAffaire) {
		this.titreAffaire = titreAffaire;
	}
	public String getDescriptionAffaire() {
		return descriptionAffaire;
	}
	public void setDescriptionAffaire(String descriptionAffaire) {
		this.descriptionAffaire = descriptionAffaire;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@JsonManagedReference
	public List<Document> getDocument() {
		return document;
	}
	public void setDocument(List<Document> document) {
		this.document = document;
	}
	public Affaire(String referenceAffaire, String titreAffaire, String descriptionAffaire, String status,
			List<Document> document) {
		super();
		this.referenceAffaire = referenceAffaire;
		this.titreAffaire = titreAffaire;
		this.descriptionAffaire = descriptionAffaire;
		this.status = status;
		this.document = document;
	}
	public Affaire() {
		super();
	}
	@Override
	public String toString() {
		return "Affaire [idAffaire=" + idAffaire + ", referenceAffaire=" + referenceAffaire + ", titreAffaire="
				+ titreAffaire + ", descriptionAffaire=" + descriptionAffaire + ", status=" + status + ", document="
				+ document + "]";
	}
	


	

}
