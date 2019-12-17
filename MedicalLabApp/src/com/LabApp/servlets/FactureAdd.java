package com.LabApp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LabApp.bdd.DatabaseConnection;

/**
 * Servlet implementation class FactureAdd
 */
@WebServlet("/factures/add")
public class FactureAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String VUE          = "/WEB-INF/FactureAdd.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FactureAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			  
            // Initialize the database 
            Connection con = DatabaseConnection.initializeDatabase(); 
  
            // Create a SQL query to insert data into demo table 
            // demo table consists of two columns, so two '?' is used 
            PreparedStatement st = con 
                   .prepareStatement("INSERT INTO `mydb`.`facture` (`idFacture`, `DateF`, `Total`, `Patient_idPatient`, `Utilisateur_idUtilisateur`) VALUES (?, ?, ?, ?, NULL);"); 
  
            // For the first parameter, 
            // get the data using request object 
            // sets the data to st pointer 
            st.setInt(1, Integer.valueOf(request.getParameter("idFacture")));  
            st.setDate(2, Date.valueOf(request.getParameter("DateF"))); 
            st.setInt(3, Integer.valueOf(request.getParameter("Total"))); 
            st.setInt(4, Integer.valueOf(request.getParameter("Patient_idPatient"))); 

            // Execute the insert command using executeUpdate() 
            // to make changes in database 
            st.executeUpdate(); 
  
            // Close all the connections 
            st.close(); 
            con.close(); 
  
            response.sendRedirect("/MedicalLaboratoryApp/factures");
            return;
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );	
	}

}
