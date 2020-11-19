package com.adaming.beans;

public class TribunalBean {
	
	private Long idTribunal;

	private String adresse;

	private String email;

	private double tel;

	private String region;

	private String nomTribunal;

	private boolean archive;

	public TribunalBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TribunalBean(String adresse, String email, double tel, String region, String nomTribunal, boolean archive) {
		super();
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.region = region;
		this.nomTribunal = nomTribunal;
		this.archive = archive;
	}

	public Long getIdTribunal() {
		return idTribunal;
	}

	public void setIdTribunal(Long idTribunal) {
		this.idTribunal = idTribunal;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getTel() {
		return tel;
	}

	public void setTel(double tel) {
		this.tel = tel;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getNomTribunal() {
		return nomTribunal;
	}

	public void setNomTribunal(String nomTribunal) {
		this.nomTribunal = nomTribunal;
	}

	public boolean isArchive() {
		return archive;
	}

}
