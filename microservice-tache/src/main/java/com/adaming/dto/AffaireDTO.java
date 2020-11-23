package com.adaming.dto;

import java.util.List;


import com.adaming.entities.Document;

public class AffaireDTO {
	private Long idAffaire;
	private String referenceAffaire;
	private String titreAffaire;
	private String descriptionAffaire; 
	private String status;
	private List<Document> document;
	
	public AffaireDTO(String referenceAffaire, String titreAffaire, String descriptionAffaire, String status) {
		super();
		this.referenceAffaire = referenceAffaire;
		this.titreAffaire = titreAffaire;
		this.descriptionAffaire = descriptionAffaire;
		this.status = status;}

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

	public List<Document> getDocument() {
		return document;
	}

	public void setDocument(List<Document> document) {
		this.document = document;
	}

	public AffaireDTO(String referenceAffaire, String titreAffaire, String descriptionAffaire, String status,
			List<Document> document) {
		super();
		this.referenceAffaire = referenceAffaire;
		this.titreAffaire = titreAffaire;
		this.descriptionAffaire = descriptionAffaire;
		this.status = status;
		this.document = document;
	}

	public AffaireDTO() {
		super();
	}

	@Override
	public String toString() {
		return "AffaireDTO [idAffaire=" + idAffaire + ", referenceAffaire=" + referenceAffaire + ", titreAffaire="
				+ titreAffaire + ", descriptionAffaire=" + descriptionAffaire + ", status=" + status + ", document="
				+ document + "]";
	}
	
}
