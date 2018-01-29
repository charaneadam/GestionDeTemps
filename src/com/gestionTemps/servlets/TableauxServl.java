package com.gestionTemps.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestionTemps.beans.Tableau;
import com.gestionTemps.service.TableauDAOImplem;

@WebServlet("/Tableaux")
public class TableauxServl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TableauxServl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TableauDAOImplem tableauDAOImplem = new TableauDAOImplem();
		request.setAttribute("tableaux", tableauDAOImplem.recpererTousLesTableaux());
		this.getServletContext().getRequestDispatcher("/WEB-INF/tableaux.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String desc = request.getParameter("desc");
		Tableau tableau = new Tableau(nom, desc);
		TableauDAOImplem tableauDAOImplem = new TableauDAOImplem();
		tableauDAOImplem.ajouterTableau(tableau);
		doGet(request, response);
	}

}
