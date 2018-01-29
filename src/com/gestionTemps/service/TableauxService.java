package com.gestionTemps.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gestionTemps.beans.Tableau;

public class TableauxService {
	
	public List<Tableau> retournerTousLesTableaux(){
		TableauDAOImplem tableauDAOImplem = new TableauDAOImplem();
		return tableauDAOImplem.recpererTousLesTableaux();
	}
	
	public void ajouterTableau(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		String desc = request.getParameter("desc");
		Tableau tableau = new Tableau(nom, desc);
		TableauDAOImplem tableauDAOImplem = new TableauDAOImplem();
		tableauDAOImplem.ajouterTableau(tableau);
	}

}
