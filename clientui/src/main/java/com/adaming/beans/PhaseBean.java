package com.adaming.beans;

import java.util.Date;
import java.util.List;

public class PhaseBean {

	private Long idPhase;

	private Enum<LibellePhaseBean> libellePhase;

	private Date dateDebut;

	private Date dateFin;

	private List<TacheBean> taches;

	public PhaseBean() {
		super();
	}

	public PhaseBean(Enum<LibellePhaseBean> libellePhase, Date dateDebut, Date dateFin, List<TacheBean> taches) {
		super();
		this.libellePhase = libellePhase;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.taches = taches;
	}

	public Long getIdPhase() {
		return idPhase;
	}

	public void setIdPhase(Long idPhase) {
		this.idPhase = idPhase;
	}

	public Enum<LibellePhaseBean> getLibellePhase() {
		return libellePhase;
	}

	public void setLibellePhase(Enum<LibellePhaseBean> libellePhase) {
		this.libellePhase = libellePhase;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public List<TacheBean> getTaches() {
		return taches;
	}

	public void setTaches(List<TacheBean> taches) {
		this.taches = taches;
	}

}
