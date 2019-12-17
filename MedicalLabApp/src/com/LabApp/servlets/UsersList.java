package com.LabApp.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LabApp.Beans.Utilisateur;
import com.LabApp.bdd.Noms;

/**
 * Servlet implementation class UsersList
 */
@WebServlet("/UsersList")
public class UsersList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String ATT_USERS = "users";
	    public static final String VUE          = "/WEB-INF/UsersList.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Noms test = new Noms();
	        List<Utilisateur> users = test.GetUsers( request );

	        /* Enregistrement de la liste des messages dans l'objet requête */
	        request.setAttribute( ATT_USERS, users );

	        /* Transmission vers la page en charge de l'affichage des résultats */
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
