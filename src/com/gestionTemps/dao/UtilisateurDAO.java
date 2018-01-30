package com.gestionTemps.dao;

import com.gestionTemps.beans.Utilisateur;

public interface UtilisateurDAO {
	
	public Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
	public void supprimerUtilisateur(Long idUtilisateur);
	public Utilisateur recupererUtilisateur(Long idUtilisateur);

}
