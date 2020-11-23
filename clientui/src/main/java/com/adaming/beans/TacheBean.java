package com.adaming.beans;

import java.util.Date;
import java.util.List;

public class TacheBean {

	private Long idTache;

	private Date dateCreation;

	private String titreTache;

	private String descriptionTache;

	private Boolean statusAudience;

	private Long idUtilisateur;

	private Long idTribunal;

	private List<PhaseBean> phases;

	public TacheBean() {
		super();
	}

	public TacheBean(Date dateCreation, String titreTache, String descriptionTache, Boolean statusAudience,
			Long idUtilisateur, Long idTribunal, List<PhaseBean> phases) {
		super();
		this.dateCreation = dateCreation;
		this.titreTache = titreTache;
		this.descriptionTache = descriptionTache;
		this.statusAudience = statusAudience;
		this.idUtilisateur = idUtilisateur;
		this.idTribunal = idTribunal;
		this.phases = phases;
	}

	public Long getIdTache() {
		return idTache;
	}

	public void setIdTache(Long idTache) {
		this.idTache = idTache;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
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

	public List<PhaseBean> getPhases() {
		return phases;
	}

	public void setPhases(List<PhaseBean> phases) {
		this.phases = phases;
	}

}
