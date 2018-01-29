package com.gestionTemps.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestionTemps.beans.Marque;
import com.gestionTemps.beans.Tache;
import com.gestionTemps.service.TacheDAOImpl;

@WebServlet("/TacheServl")
public class TacheServl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TacheServl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TacheDAOImpl tacheDAOImpl = new TacheDAOImpl();
		Long tacheID = Long.parseLong(request.getParameter("id"));
		Tache tache = tacheDAOImpl.recupererTache(tacheID);
		request.setAttribute("tache", tache);
		List<Marque> marques = tacheDAOImpl.recupererToutesLesMarquesDeLaTache(tacheID);
		request.setAttribute("marques", marques);
		this.getServletContext().getRequestDispatcher("/WEB-INF/tache.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomMarque = request.getParameter("nom");
		Long tacheID = Long.parseLong(request.getParameter("id"));
		Marque marque = new Marque(nomMarque);
		TacheDAOImpl tacheDAOImpl = new TacheDAOImpl();
		tacheDAOImpl.ajouterMarqueDansTache(tacheID, marque);
		doGet(request, response);
	}

}
