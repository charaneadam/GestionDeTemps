package com.gestionTemps.dao;

import com.gestionTemps.beans.Tableau;

public interface TableauDAO {
	
	public Tableau ajouterTableau(Tableau t);
	public void supprimerTableau(Long tableauID);

}
