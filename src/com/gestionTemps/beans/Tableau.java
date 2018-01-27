package com.gestionTemps.beans;

import java.util.List;

public class Tableau {
	
	private Long idTableau;
	private String nomTableau;
	private List<Liste> listesDuTableau;
	
	public Long getIdTableau() {
		return idTableau;
	}
	public void setIdTableau(Long idTableau) {
		this.idTableau = idTableau;
	}
	public String getNomTableau() {
		return nomTableau;
	}
	public void setNomTableau(String nomTableau) {
		this.nomTableau = nomTableau;
	}
	public List<Liste> getListesDuTableau() {
		return listesDuTableau;
	}
	public void setListesDuTableau(List<Liste> listesDuTableau) {
		this.listesDuTableau = listesDuTableau;
	}
	public Tableau() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tableau(String nomTableau, List<Liste> listesDuTableau) {
		super();
		this.nomTableau = nomTableau;
		this.listesDuTableau = listesDuTableau;
	}
	
	

}
