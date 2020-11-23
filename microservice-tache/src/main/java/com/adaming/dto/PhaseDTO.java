package com.adaming.dto;

import java.time.LocalDate;

import com.adaming.entities.Tache;

/**
 * @author VITTOZ Guillaume
 *
 */
public class PhaseDTO {

	private Long idPhase;
	private String libellePhase;
	private LocalDate dateDebut;
	private LocalDate dateFin;
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

	public PhaseDTO(Long idPhase, String libellePhase, LocalDate dateDebut, LocalDate dateFin, Tache tache) {
		super();
		this.idPhase = idPhase;
		this.libellePhase = libellePhase;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tache = tache;
	}

	public PhaseDTO() {

	}

	@Override
	public String toString() {
		return "PhaseDTO [idPhase=" + idPhase + ", libellePhase=" + libellePhase + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", tache=" + tache + "]";
	}

}
