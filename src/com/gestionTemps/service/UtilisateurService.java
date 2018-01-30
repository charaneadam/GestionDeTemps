package com.gestionTemps.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestionTemps.beans.Utilisateur;

public class UtilisateurService {
	
	private UtilisateurDOAImpl utilisateurDOAImpl = new UtilisateurDOAImpl();
	
	public boolean estEmailValide(String email) {
		return utilisateurDOAImpl.emailEstValide(email);
	}
	
	public HttpServletResponse verifierIdentifiant(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		Utilisateur utilisateur = utilisateurDOAImpl.recupererUtilisateur(email, pass);
		if(utilisateur != null)
			response.sendRedirect("/tableaux?id="+utilisateur.getIdUtilisateur());
		else
			response.sendRedirect("/index");
		return response;
	}

}
