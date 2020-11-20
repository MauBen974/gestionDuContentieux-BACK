package com.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	private Enum<LibellePhase> libellePhase;
	private Date dateDebut;
	private Date dateFin;
	@ManyToMany(mappedBy = "phases")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Phase [idPhase=" + idPhase + ", libellePhase=" + libellePhase + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", taches=" + taches + "]";
	}

	public Phase() {
		super();
	}

}
