package com.adaming.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author VITTOZ Guillaume
 *
 */
@Entity
public class Tache implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTache;
	private LocalDate dateCreation;
	private String titreTache;
	private String descriptionTache;
	private Boolean statusAudience;

	private Long idUtilisateur;
	private Long idTribunal;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Tache [idTache=" + idTache + ", dateCreation=" + dateCreation + ", titreTache=" + titreTache
				+ ", descriptionTache=" + descriptionTache + ", statusAudience=" + statusAudience + ", idUtilisateur="
				+ idUtilisateur + ", idTribunal=" + idTribunal + "]";
	}

	public Tache() {
		super();
	}

	public Tache(Long idTache, LocalDate dateCreation, String titreTache, String descriptionTache,
			Boolean statusAudience, Long idUtilisateur, Long idTribunal) {
		super();
		this.idTache = idTache;
		this.dateCreation = dateCreation;
		this.titreTache = titreTache;
		this.descriptionTache = descriptionTache;
		this.statusAudience = statusAudience;
		this.idUtilisateur = idUtilisateur;
		this.idTribunal = idTribunal;
	}
	
	public Tache(LocalDate dateCreation, String titreTache, String descriptionTache,
			Boolean statusAudience, Long idUtilisateur, Long idTribunal) {
		super();
		this.dateCreation = dateCreation;
		this.titreTache = titreTache;
		this.descriptionTache = descriptionTache;
		this.statusAudience = statusAudience;
		this.idUtilisateur = idUtilisateur;
		this.idTribunal = idTribunal;
	}

}
