package com.gestionTemps.service;

import java.util.ArrayList;
import java.util.Date;
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
		return tableauDAOImplem.recupererToutesLesTachesDuTableau(tableauID);
	}
	
	public List<Marque> retournerToutesLesMarquesDuTableau(Long tableauID){
		List<Tache> taches = retournerToutesLesTachesDuTableau(tableauID);
		TacheDAOImpl tacheDAOImpl = new TacheDAOImpl();
		List<Marque> marques = new ArrayList<Marque>();
		for (Tache tache : taches) {
			System.out.println(tache.getIdTache());
			marques.addAll(tacheDAOImpl.recupererToutesLesMarquesDeLaTache(tache.getIdTache()));
		}
		return marques;
	}
	
	public Date getStartDate(List<Tache> taches) {
		if(taches.isEmpty()) return null;
		Date ans = taches.get(0).getDateDeCreationDeTache();
		for (Tache tache : taches) {
			if(ans.compareTo(tache.getDateDeCreationDeTache()) > 0)
				ans = tache.getDateDeCreationDeTache();
		}
		return ans;
	}
	
	public Date getEndDate(List<Tache> taches) {
		if(taches.isEmpty()) return null;
		Date ans = taches.get(0).getDateLimiteDeTache();
		for (Tache tache : taches) {
			if(ans.compareTo(tache.getDateLimiteDeTache()) < 0)
				ans = tache.getDateLimiteDeTache();
		}
		return ans;
	}
	
	public int getHighPriorityCount(List<Tache> taches) {
		int ans = 0;
		for (Tache tache : taches) {
			if(tache.getPriorite() >= 3) ans++;
		}
		return ans;
	}
	
	public int getLowPriorityCount(List<Tache> taches) {
		int ans = 0;
		for (Tache tache : taches) {
			if(tache.getPriorite() <= 1) ans++;
		}
		return ans;
	}
	
	public int getNormalPriorityCount(List<Tache> taches) {
		int ans = 0;
		for (Tache tache : taches) {
			if(tache.getPriorite() == 2) ans++;
		}
		return ans;
	}

}
