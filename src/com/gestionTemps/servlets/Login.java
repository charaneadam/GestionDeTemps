package com.gestionTemps.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestionTemps.service.UtilisateurService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurService utilisateurService = new UtilisateurService();
		Long userID = new Long(-1L);
		System.out.println(request.getRequestURI());
		try {
			userID = utilisateurService.verifierIdentifiant(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userID == -1)
			response.sendRedirect("./");
		else response.sendRedirect("tableaux?id="+userID.toString());
	}

}
