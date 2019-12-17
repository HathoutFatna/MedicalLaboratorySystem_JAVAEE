package com.LabApp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LabApp.bdd.listePatientsbdd;

/**
 * Servlet implementation class PatientSearch
 */
@WebServlet("/patients/search")
public class PatientSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  public static final String VUE          = "/WEB-INF/PatientSearch.jsp";
	  public String nom;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   nom = request.getParameter("nom");
		  request.setAttribute("nom", nom);
		  
		  listePatientsbdd test = new listePatientsbdd();
			 request.setAttribute( "patients", test.GetPatientsSearch(request, nom) );

				
		        /* Transmission vers la page en charge de l'affichage des résultats */
		        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
