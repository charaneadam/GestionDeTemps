package com.gestionTemps.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gestionTemps.beans.Marque;
import com.gestionTemps.beans.Tache;

public class TacheService {
	
	private TacheDAOImpl tacheDAOImpl = new TacheDAOImpl();
	
	private Tache retournerTache(Long tacheID) {
		return tacheDAOImpl.recupererTache(tacheID);
	}
	
	public Tache retournerTache(HttpServletRequest request) {
		Long tacheID = Long.parseLong(request.getParameter("id"));
		return retournerTache(tacheID);
	}
	
	public List<Marque> retournerTouesLesMarquesDeLaTache(Long tacheID) {
		return tacheDAOImpl.recupererToutesLesMarquesDeLaTache(tacheID);
	}

	public void ajouterMarqueALaTache(HttpServletRequest request) {
		String nomMarque = request.getParameter("nom");
		Long tacheID = Long.parseLong(request.getParameter("id"));
		Marque marque = new Marque(nomMarque);
		tacheDAOImpl.ajouterMarqueDansTache(tacheID, marque);
	}
	
}
