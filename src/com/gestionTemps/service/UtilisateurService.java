package com.gestionTemps.service;

import javax.servlet.http.HttpServletRequest;

import com.gestionTemps.beans.Utilisateur;

public class UtilisateurService {
	
	private UtilisateurDOAImpl utilisateurDOAImpl = new UtilisateurDOAImpl();
	
	public boolean estEmailValide(String email) {
		return utilisateurDOAImpl.emailEstValide(email);
	}
	
	public Long verifierIdentifiant(HttpServletRequest request) throws Exception {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		Utilisateur utilisateur = utilisateurDOAImpl.recupererUtilisateur(email, pass);
		if(utilisateur != null)
			return utilisateur.getIdUtilisateur();
		else
			return new Long(-1);
	}

}
