package com.gestionTemps.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestionTemps.beans.Liste;
import com.gestionTemps.beans.Tableau;
import com.gestionTemps.service.TableauService;

@WebServlet("/Tableau")
public class TableauServl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TableauService tableauService = new TableauService();
       
    public TableauServl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tableau t = tableauService.retournerTableau(request);
		List<Liste> l = tableauService.retournerListesDuTableau(t.getIdTableau());
		request.setAttribute("tableau", t);
		request.setAttribute("listes", l);
		this.getServletContext().getRequestDispatcher("/WEB-INF/tableau.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tableauService.ajouterListeDansLeTableau(request);
		doGet(request, response);
	}

}
