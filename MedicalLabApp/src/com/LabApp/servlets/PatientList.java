package com.LabApp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LabApp.Beans.Patient;
import com.LabApp.bdd.listePatientsbdd;

/**
 * Servlet implementation class PatientList
 */
@WebServlet("/patients")
public class PatientList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USERS = "patients";
    public static final String VUE          = "/WEB-INF/PatientList.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 listePatientsbdd test = new listePatientsbdd();
		 request.setAttribute( ATT_USERS, test.GetPatients(request) );

			
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
