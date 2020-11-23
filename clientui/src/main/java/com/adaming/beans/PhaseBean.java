package com.adaming.beans;

import java.time.LocalDate;

public class PhaseBean {

	private Long idPhase;
	private String libellePhase;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private TacheBean tache;

	public PhaseBean() {
		super();
	}

	public PhaseBean(String libellePhase, LocalDate dateDebut, LocalDate dateFin, TacheBean tache) {
		super();
		this.libellePhase = libellePhase;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tache = tache;
	}

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

	public TacheBean getTache() {
		return tache;
	}

	public void setTache(TacheBean tache) {
		this.tache = tache;
	}

}
