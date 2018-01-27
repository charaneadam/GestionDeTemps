package com.gestionTemps.dao;

import java.util.List;

import com.gestionTemps.beans.Marque;
import com.gestionTemps.beans.Tache;

public interface MarqueDAO {
	
	public Marque ajouterMarque(Marque marque);
	public void supprimerMarque(Long marqueID);
	public void ajouterTacheDansMarque(Tache tache);
	public void supprimerTacheDeMarque(Long tacheID);
	public List<Marque> recupererToutesLesMarques();

}
