package com.adaming.beans;

import java.util.List;

public class AffaireBean {
	
private Long idAffaire;
	private String referenceAffaire;
	private String titreAffaire;
	private String descriptionAffaire; 
	private String status;
	private List<DocumentBean> document;
	
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

	public List<DocumentBean> getDocument() {
		return document;
	}
	public void setDocument(List<DocumentBean> document) {
		this.document = document;
	}
	public AffaireBean(String referenceAffaire, String titreAffaire, String descriptionAffaire, String status,
			List<Document> document) {
		super();
		this.referenceAffaire = referenceAffaire;
		this.titreAffaire = titreAffaire;
		this.descriptionAffaire = descriptionAffaire;
		this.status = status;
		this.document = document;
	}
	public AffaireBean() {
		super();
	}
	@Override
	public String toString() {
		return "Affaire [idAffaire=" + idAffaire + ", referenceAffaire=" + referenceAffaire + ", titreAffaire="
				+ titreAffaire + ", descriptionAffaire=" + descriptionAffaire + ", status=" + status + ", document="
				+ document + "]";
	}
}
