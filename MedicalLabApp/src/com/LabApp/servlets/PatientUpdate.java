package com.LabApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class PatientUpdate
 */
@WebServlet("/patients/update")
public class PatientUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE          = "/WEB-INF/PatientUpdate.jsp";
	public int id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientUpdate() {
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
	  
	            String sql="UPDATE `mydb`.`patient` SET `idPatient` = ?, `name` = ?, `surname` = ?,"
	            		+ " `age` = ?, `gender` = ?, `Location` = ?, "
	            		+ "`Email_Address` = ?, `Mobile_number` = ?, `Groupage` = ? "
	            		+ "WHERE `patient`.`idPatient` = "+ id;
	            st = con.prepareStatement(sql);
	  
	            st.setInt(1, Integer.valueOf(request.getParameter("id")));  
	            st.setString(2, request.getParameter("name")); 
	            st.setString(3, request.getParameter("surname")); 
	            st.setInt(4, Integer.valueOf(request.getParameter("age"))); 
	            st.setString(5, request.getParameter("gender"));
	            st.setString(6, request.getParameter("location"));
	            st.setString(7, request.getParameter("email"));
	            st.setString(8, request.getParameter("phone"));
	            st.setString(9, request.getParameter("groupage"));
	         
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
