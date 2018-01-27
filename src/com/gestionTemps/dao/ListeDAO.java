package com.gestionTemps.dao;

import java.util.List;

import com.gestionTemps.beans.Liste;
import com.gestionTemps.beans.Tache;

public interface ListeDAO {
	
	public Liste ajouterListe(Liste liste);
	public void supprimerListe(Long listeID);
	public void ajouterTacheDansListe(Tache tache);
	public void supprimerTacheDeListe(Long tacheID);
	public List<Liste> recupererToutesLesListes();

}
