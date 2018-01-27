package com.gestionTemps.dao;

import java.util.List;

import com.gestionTemps.beans.Marque;
import com.gestionTemps.beans.Tache;

public interface TacheDAO {
	
	public Tache ajouterTache(Tache tache);
	public void supprimerTache(Long tacheID);
	public void ajouterMarqueDansTache(Marque marque);
	public void supprimerMarqueDeTache(Long marqueID);
	public List<Tache> recupererToutesLesTaches();
	

}
