package com.LabApp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LabApp.bdd.TestModel;
/**
 * Servlet implementation class ListeTest
 */
@WebServlet("/tests")
public class ListeTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USERS = "tests";
    public static final String VUE          = "/WEB-INF/testlist.jsp"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//récupérer la datasource du plug-in dans un attribut
		TestModel test = new TestModel();
		 request.setAttribute( ATT_USERS, test.GetTest(request) );

	        /* Transmission vers la page en charge de l'affichage des résultats */
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
