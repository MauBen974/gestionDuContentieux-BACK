package com.adaming.dto;

import java.util.Date;
import java.util.List;

import com.adaming.entities.LibellePhase;
import com.adaming.entities.Tache;

/**
 * @author VITTOZ Guillaume
 *
 */
public class PhaseDTO {

	private Long idPhase;
	private Enum<LibellePhase> libellePhase;
	private Date dateDebut;
	private Date dateFin;
	private List<Tache> taches;

	public Long getIdPhase() {
		return idPhase;
	}

	public void setIdPhase(Long idPhase) {
		this.idPhase = idPhase;
	}

	public Enum<LibellePhase> getLibellePhase() {
		return libellePhase;
	}

	public void setLibellePhase(Enum<LibellePhase> libellePhase) {
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

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public PhaseDTO(Long idPhase, Enum<LibellePhase> libellePhase, Date dateDebut, Date dateFin, List<Tache> taches) {
		super();
		this.idPhase = idPhase;
		this.libellePhase = libellePhase;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.taches = taches;
	}

	public PhaseDTO() {

	}

	@Override
	public String toString() {
		return "PhaseDTO [idPhase=" + idPhase + ", libellePhase=" + libellePhase + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", taches=" + taches + "]";
	}

}
