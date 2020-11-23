package com.adaming.beans;

import java.time.LocalDate;

public class TacheBean {

	private Long idTache;
	private LocalDate dateCreation;
	private String titreTache;
	private String descriptionTache;
	private Boolean statusAudience;

	private Long idUtilisateur;
	private Long idTribunal;

	public TacheBean() {
		super();
	}

	public TacheBean(LocalDate dateCreation, String titreTache, String descriptionTache, Boolean statusAudience,
			Long idUtilisateur, Long idTribunal) {
		super();
		this.dateCreation = dateCreation;
		this.titreTache = titreTache;
		this.descriptionTache = descriptionTache;
		this.statusAudience = statusAudience;
		this.idUtilisateur = idUtilisateur;
		this.idTribunal = idTribunal;
	}

	public Long getIdTache() {
		return idTache;
	}

	public void setIdTache(Long idTache) {
		this.idTache = idTache;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getTitreTache() {
		return titreTache;
	}

	public void setTitreTache(String titreTache) {
		this.titreTache = titreTache;
	}

	public String getDescriptionTache() {
		return descriptionTache;
	}

	public void setDescriptionTache(String descriptionTache) {
		this.descriptionTache = descriptionTache;
	}

	public Boolean getStatusAudience() {
		return statusAudience;
	}

	public void setStatusAudience(Boolean statusAudience) {
		this.statusAudience = statusAudience;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Long getIdTribunal() {
		return idTribunal;
	}

	public void setIdTribunal(Long idTribunal) {
		this.idTribunal = idTribunal;
	}

}
