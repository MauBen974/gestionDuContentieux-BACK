package com.adaming.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author VITTOZ Guillaume
 *
 */
@Entity
public class Phase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPhase;

	private String libellePhase;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	@ManyToOne
	@JoinColumn(name = "id_tache")
	private Tache tache;

	public Long getIdPhase() {
		return idPhase;
	}

	public void setIdPhase(Long idPhase) {
		this.idPhase = idPhase;
	}

	public String getLibellePhase() {
		return libellePhase;
	}

	public void setLibellePhase(String libellePhase) {
		this.libellePhase = libellePhase;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Phase [idPhase=" + idPhase + ", libellePhase=" + libellePhase + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", tache=" + tache + "]";
	}

	public Phase() {
		super();
	}

	public Phase(Long idPhase, String libellePhase, LocalDate dateDebut, LocalDate dateFin, Tache tache) {
		super();
		this.idPhase = idPhase;
		this.libellePhase = libellePhase;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tache = tache;
	}
	
	public Phase(String libellePhase, LocalDate dateDebut, LocalDate dateFin, Tache tache) {
		super();
		this.libellePhase = libellePhase;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tache = tache;
	}

}
