package com.gestionTemps.dao;

import java.util.List;

import com.gestionTemps.beans.Liste;
import com.gestionTemps.beans.Tableau;
import com.gestionTemps.beans.TableauCommit;

public interface TableauDAO {
	
	public Tableau ajouterTableau(Tableau tableau);
	public void supprimerTableau(Long tableauID);
	public void ajouterListeAuTableau(Liste liste);
	public void supprimerListeDuTableau(Long listID);
	public Tableau recupererTableau(Long tableauID);
	public List<Liste> recupererToutesLesListesDuTableau(Long tableauID);
	public List<TableauCommit> recupererToutesLesCommitesDuTableau(Long tableauID);
	List<Tableau> recpererTousLesTableaux();

}
