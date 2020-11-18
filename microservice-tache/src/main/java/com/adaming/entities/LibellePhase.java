package com.adaming.entities;

/**
 * @author VITTOZ Guillaume
 *
 */
public enum LibellePhase {
	TERMINE("Terminé"), ENCOURS("En cours"), ENATTENTE("En attente");

	private String name = "";

	LibellePhase(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

}
