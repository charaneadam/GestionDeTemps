package com.gestionTemps.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestionTemps.beans.Liste;
import com.gestionTemps.service.TableauDAOImplem;

@WebServlet("/Tableau")
public class TableauServl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TableauServl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TableauDAOImplem tableauDAOImplem = new TableauDAOImplem();
		Long tableauID = Long.parseLong(request.getParameter("id"));
		com.gestionTemps.beans.Tableau t = tableauDAOImplem.recupererTableau(tableauID);
		request.setAttribute("tableau", t);
		request.setAttribute("listes", tableauDAOImplem.recupererToutesLesListesDuTableau(tableauID));
		this.getServletContext().getRequestDispatcher("/WEB-INF/tableau.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String desc = request.getParameter("desc");
		Long id = Long.parseLong(request.getParameter("id"));
		Liste liste = new Liste(nom, desc, id);
		TableauDAOImplem tableauDAOImplem = new TableauDAOImplem();
		tableauDAOImplem.ajouterListeAuTableau(liste);
		doGet(request, response);
	}

}
