package com.adaming.dto;

public class TribunalDTO {
	
	private static final long serialVersionUID = -3942592616039205862L;

	private Long idTribunal;

	private String adresse;

	private String email;

	private double tel;

	private String region;

	private String nomTribunal;

	private boolean archive;

	public TribunalDTO() {
		super();
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

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
