package com.gestionTemps.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestionTemps.beans.Liste;
import com.gestionTemps.beans.Tache;
import com.gestionTemps.service.ListeDAOImpl;

@WebServlet("/ListeServl")
public class ListeServl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListeServl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListeDAOImpl listeDAOImpl = new ListeDAOImpl();
		Long listeID = Long.parseLong(request.getParameter("id"));
		Liste liste = listeDAOImpl.recupererListe(listeID);
		List<Tache> taches = listeDAOImpl.recupereToutesLesTachesDeLaListe(listeID);
		request.setAttribute("liste", liste);
		request.setAttribute("taches", taches);
		this.getServletContext().getRequestDispatcher("/WEB-INF/liste.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// `nom_tache`, `description_tache`, `date_creation`, `date_limite`, `priorite`, `liste_id`
		String nomTache = request.getParameter("nom");
		String descriptionTache = request.getParameter("desc");
		Date dateDeCreationDeTache = new Date();
		Date dateLimiteDeTache = null;
		try {
			dateLimiteDeTache = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int priorite = Integer.parseInt(request.getParameter("priorite"));
		Long listeID = Long.parseLong(request.getParameter("id"));
		Tache tache = new Tache(nomTache, descriptionTache, dateDeCreationDeTache, dateLimiteDeTache, priorite, listeID);
		ListeDAOImpl listeDAOImpl = new ListeDAOImpl();
		listeDAOImpl.ajouterTacheDansListe(tache);
		doGet(request, response);
	}

}
