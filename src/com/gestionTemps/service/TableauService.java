package com.gestionTemps.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gestionTemps.beans.Liste;
import com.gestionTemps.beans.Marque;
import com.gestionTemps.beans.Tableau;
import com.gestionTemps.beans.TableauCommit;
import com.gestionTemps.beans.Tache;

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
	
	public List<Tache> retournerToutesLesTachesDuTableau(Long tableauID){
		ListeDAOImpl listeDAOImpl = new ListeDAOImpl();
		List<Liste> listes = retournerListesDuTableau(tableauID);
		List<Tache> taches = new ArrayList<Tache>();
		for (Liste liste : listes) 
			taches.addAll(listeDAOImpl.recupereToutesLesTachesDeLaListe(liste.getIdListe()));
		return taches;
	}
	
	public List<Marque> retournerToutesLesMarquesDuTableau(Long tableauID){
		List<Tache> taches = retournerToutesLesTachesDuTableau(tableauID);
		TacheDAOImpl tacheDAOImpl = new TacheDAOImpl();
		List<Marque> marques = new ArrayList<Marque>();
		for (Tache tache : taches) {
			marques.addAll(tacheDAOImpl.recupererToutesLesMarquesDeLaTache(tache.getIdTache()));
		}
		return marques;
	}

}
