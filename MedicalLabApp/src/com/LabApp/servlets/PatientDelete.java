package com.LabApp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LabApp.Beans.Patient;
import com.LabApp.bdd.DatabaseConnection;

/**
 * Servlet implementation class PatientDelete
 */
@WebServlet("/patients/delete")
public class PatientDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE          = "/WEB-INF/PatientDelete.jsp";
	public int id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = Integer.valueOf(request.getParameter("id"));
		request.setAttribute("id", id);
		
		Statement statement = null;
		ResultSet resultat = null;
		 Connection con = null;
		 Patient patient = new Patient();
		
		try { 
			  
            // Initialize the database 
            con = DatabaseConnection.initializeDatabase(); 
  
            statement=con.createStatement();
            String sql ="select * from patient where idPatient="+id;
            resultat = statement.executeQuery(sql);
  
            while ( resultat.next() ) {
	        	//int id =  resultat.getInt( "idPatient" );
	            String name = resultat.getString( "name" );
	            String surname = resultat.getString("surname");
	            String gender = resultat.getString( "gender" );
	           int age = resultat.getInt("age");
	            String Location = resultat.getString( "Location" );
	          String email = resultat.getString( "Email_Address" );
	            String phone = resultat.getString( "Mobile_number" );
	            String groupage = resultat.getString( "groupage" );
	            
	            
	            patient.setId(id);
	            patient.setName(name);
	           patient.setSurname(surname);
	           
	            patient.setGender(gender);
	             patient.setAge(age);
	            patient.setLocation(Location);
	            patient.setEmail(email);
	            patient.setPhone(phone);
	            patient.setGroupage(groupage);
	            
            }
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } finally {
	        
	        if ( resultat != null ) {
	            try {
	                resultat.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	      
	        if ( statement != null ) {
	            try {
	                statement.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	     
	        if ( con != null ) {
	            try {
	                con.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	    }
		request.setAttribute("patient", patient);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement st = null;
		 Connection con = null;
		
			try { 
				  
	            // Initialize the database 
	            con = DatabaseConnection.initializeDatabase(); 
	  
	            String sql="DELETE FROM `mydb`.`patient` WHERE `patient`.`idPatient` = "+ id;
	            st = con.prepareStatement(sql);
	  
	         
	            st.executeUpdate(); 
	  
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
