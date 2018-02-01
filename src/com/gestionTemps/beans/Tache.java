package com.gestionTemps.beans;

import java.util.Date;
import java.util.List;

public class Tache {
	
	private Long idTache;
	private String nomTache;
	private String descriptionTache;
	private Date dateDeCreationDeTache;
	private Date DateLimiteDeTache;
	private Integer priorite;
	private List<Marque> marquesDeTache;
	private Long listeID;
	private Long tableauID;
	
	public Long getIdTache() {
		return idTache;
	}
	public void setIdTache(Long idTache) {
		this.idTache = idTache;
	}
	public String getNomTache() {
		return nomTache;
	}
	public void setNomTache(String nomTache) {
		this.nomTache = nomTache;
	}
	public String getDescriptionTache() {
		return descriptionTache;
	}
	public void setDescriptionTache(String descriptionTache) {
		this.descriptionTache = descriptionTache;
	}
	public Date getDateDeCreationDeTache() {
		return dateDeCreationDeTache;
	}
	public void setDateDeCreationDeTache(Date dateDeCreationDeTache) {
		this.dateDeCreationDeTache = dateDeCreationDeTache;
	}
	public Date getDateLimiteDeTache() {
		return DateLimiteDeTache;
	}
	public void setDateLimiteDeTache(Date dateLimiteDeTache) {
		DateLimiteDeTache = dateLimiteDeTache;
	}
	public Integer getPriorite() {
		return priorite;
	}
	public void setPriorite(Integer priorite) {
		this.priorite = priorite;
	}
	public List<Marque> getMarquesDeTache() {
		return marquesDeTache;
	}
	public void setMarquesDeTache(List<Marque> marquesDeTache) {
		this.marquesDeTache = marquesDeTache;
	}
	public Long getListeID() {
		return listeID;
	}
	public void setListeID(Long listeID) {
		this.listeID = listeID;
	}
	public Tache() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tache(String nomTache, String descriptionTache, Date dateDeCreationDeTache, Date dateLimiteDeTache,
			Integer priorite, Long listeID) {
		super();
		this.nomTache = nomTache;
		this.descriptionTache = descriptionTache;
		this.dateDeCreationDeTache = dateDeCreationDeTache;
		DateLimiteDeTache = dateLimiteDeTache;
		this.priorite = priorite;
		this.listeID = listeID;
	}
	public Long getTableauID() {
		return tableauID;
	}
	public void setTableauID(Long tableauID) {
		this.tableauID = tableauID;
	}
	
	

}
