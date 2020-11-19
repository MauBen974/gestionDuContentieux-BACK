package com.adaming.beans;

public class UtilisateurBean {

	private Long idUtilisateur;

	private String email;

	private String nom;

	private String prenom;

	private String password;

	private String role;

	private boolean archive;

	public UtilisateurBean(Long idUtilisateur, String email, String nom, String prenom, String password, String role,
			boolean archive) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.role = role;
		this.archive = archive;
	}

	public UtilisateurBean() {
		super();
	}

	public UtilisateurBean(String email, String nom, String prenom, String password, String role, boolean archive) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.role = role;
		this.archive = archive;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", email=" + email + ", nom=" + nom + ", prenom="
				+ prenom + ", password=" + password + ", role=" + role + ", archive=" + archive + "]";
	}

}
