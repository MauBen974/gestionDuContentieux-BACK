package com.adaming.beans;

public enum LibellePhaseBean {
	
	TERMINE("Terminé"), ENCOURS("En cours"), ENATTENTE("En attente");

	private String name = "";

	LibellePhaseBean(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

}
