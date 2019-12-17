package com.LabApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LabApp.bdd.DatabaseConnection;

/**
 * Servlet implementation class PatientAdd
 */
@WebServlet("/patients/add")
public class PatientAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String VUE          = "/WEB-INF/PatientAdd.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientAdd() {
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
                   .prepareStatement("INSERT INTO `mydb`.`patient` (`idPatient`, `name`, `surname`, `age`, `gender`, `Location`, `Email_Address`, `Mobile_number`, `groupage`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);"); 
  
            // For the first parameter, 
            // get the data using request object 
            // sets the data to st pointer 
            st.setInt(1, Integer.valueOf(request.getParameter("id")));  
            st.setString(2, request.getParameter("name")); 
            st.setString(3, request.getParameter("surname")); 
            st.setInt(4, Integer.valueOf(request.getParameter("age"))); 
            st.setString(5, request.getParameter("gender"));
            st.setString(6, request.getParameter("location"));
            st.setString(7, request.getParameter("email"));
            st.setString(8, request.getParameter("phone"));
            st.setString(9, request.getParameter("groupage"));
            
  
            // Execute the insert command using executeUpdate() 
            // to make changes in database 
            st.executeUpdate(); 
  
            // Close all the connections 
            st.close(); 
            con.close(); 
  
            response.sendRedirect("/MedicalLaboratoryApp/patients");
            return;
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );	
	}

}
