package com.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author VITTOZ Guillaume
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tache implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTache;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private String titreTache;
	private String descriptionTache;
	private Boolean statusAudience;

	private Long idUtilisateur;
	private Long idTribunal;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Tache_Phase", joinColumns = { @JoinColumn(name = "idTache") }, inverseJoinColumns = {
			@JoinColumn(name = "idPhase") })
	private List<Phase> phases;

}
