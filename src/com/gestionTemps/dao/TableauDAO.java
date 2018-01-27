package com.gestionTemps.dao;

import java.util.List;

import com.gestionTemps.beans.Liste;
import com.gestionTemps.beans.Tableau;

public interface TableauDAO {
	
	public Tableau ajouterTableau(Tableau tableau);
	public void supprimerTableau(Long tableauID);
	public void ajouterListeAuTableau(Liste liste);
	public void supprimerListeDuTableau(Long listID);
	public List<Tableau> recpererTousLesTableaux();

}
