package com.gestionTemps.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gestionTemps.beans.Liste;
import com.gestionTemps.beans.Tableau;
import com.gestionTemps.beans.TableauCommit;

public class TableauService {
	private TableauDAOImplem tableauDAOImplem = new TableauDAOImplem();
	
	private Tableau retournerTableau(Long tableauID) {
		Tableau tableau = tableauDAOImplem.recupererTableau(tableauID);
		return tableau;
	}
	
	public Tableau retournerTableau(HttpServletRequest request) {
		return retournerTableau(Long.parseLong(request.getParameter("id")));
	}
	
	public List<Liste> retournerListesDuTableau(Long tableauID){
		return tableauDAOImplem.recupererToutesLesListesDuTableau(tableauID);
	}
	
	public void ajouterListeDansLeTableau(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		String desc = request.getParameter("desc");
		Long id = Long.parseLong(request.getParameter("id"));
		Liste liste = new Liste(nom, desc, id);
		tableauDAOImplem.ajouterListeAuTableau(liste);
	}
	
	public List<TableauCommit> recupererToutesLesCommitesDuTableau(HttpServletRequest request){
		return tableauDAOImplem.recupererToutesLesCommitesDuTableau(Long.parseLong(request.getParameter("id")));
	}

}
