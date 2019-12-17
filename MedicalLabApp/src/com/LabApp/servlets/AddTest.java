package com.LabApp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;


import com.LabApp.bdd.DatabaseConnection;
/**
 * Servlet implementation class AddTest
 */
@WebServlet("/tests/add")
public class AddTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE          = "/WEB-INF/testadd.jsp";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTest() {
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
                   .prepareStatement("INSERT INTO `mydb`.`test` (`idTest`, `Name`, `Unit`, `Cost`, `Normal_ range`, `Lower_range`,`Upper_range`,`Notes`,`Test_Category_idTest_Category`,`Utilisateur_idUtilisateur`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 1, NULL);"); 
  
            // For the first parameter, 
            // get the data using request object 
            // sets the data to st pointer 
            st.setInt(1, Integer.valueOf(request.getParameter("idTest")));  
            st.setString(2, request.getParameter("Name")); 
            st.setString(3, request.getParameter("Unit")); 
            st.setString(4, request.getParameter("Cost"));
            st.setString(5, request.getParameter("Normal_range"));
            st.setString(6, request.getParameter("Lower_range"));
            st.setString(7, request.getParameter("Upper_range"));
            st.setString(8, request.getParameter("Notes"));
           
           
  
            // Execute the insert command using executeUpdate() 
            // to make changes in database 
            st.executeUpdate(); 
  
            // Close all the connections 
            st.close(); 
            con.close(); 
  
            response.sendRedirect("/MedicalLaboratoryApp/tests");
            return;
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
