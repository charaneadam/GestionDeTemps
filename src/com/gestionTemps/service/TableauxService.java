package com.gestionTemps.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.gestionTemps.beans.Liste;
import com.gestionTemps.beans.Tableau;
import com.gestionTemps.beans.Tache;

public class TableauxService {
	
	private TableauDAOImplem tableauDAOImplem = new TableauDAOImplem();
	
	public List<Tableau> retournerTousLesTableaux(){
		ListeDAOImpl listeDAOImpl = new ListeDAOImpl();
		TacheDAOImpl tacheDAOImpl = new TacheDAOImpl();
		List<Tableau> tableaux = tableauDAOImplem.recpererTousLesTableaux();
		for (Tableau tableau : tableaux) {
			List<Liste> listes = new ArrayList<Liste>(tableauDAOImplem.recupererToutesLesListesDuTableau(tableau.getIdTableau()));
			tableau.setNombreDesListesDansLeTableau(listes.size());
			Set<Long> listes_id = new HashSet<Long>();

			for (Liste liste : listes) {
				List<Tache> taches = new ArrayList<Tache>(listeDAOImpl.recupereToutesLesTachesDeLaListe(liste.getIdListe()));

				for (Tache tache : taches) {
					listes_id.addAll(tacheDAOImpl.recupererToutesLesMarquesIDDeLaTache(tache.getIdTache()));
				}
			}
			if(listes_id.isEmpty())
				tableau.setNbrTags(0);
			else 
				tableau.setNbrTags(listes_id.size());
		}
		return tableaux;
	}
	
	public void ajouterTableau(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		String desc = request.getParameter("desc");
		Tableau tableau = new Tableau(nom, desc);
		tableauDAOImplem.ajouterTableau(tableau);
	}
	
	public void supprimerTableau(HttpServletRequest request) {
		tableauDAOImplem = new TableauDAOImplem();
		tableauDAOImplem.supprimerTableau(Long.parseLong(request.getParameter("id")));
	}

}
