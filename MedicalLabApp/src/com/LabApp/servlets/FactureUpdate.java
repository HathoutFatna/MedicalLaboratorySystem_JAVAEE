package com.LabApp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LabApp.Beans.Facture;
import com.LabApp.Beans.Patient;
import com.LabApp.bdd.DatabaseConnection;

/**
 * Servlet implementation class FactureUpdate
 */
@WebServlet("/factures/update")
public class FactureUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE          = "/WEB-INF/FactureUpdate.jsp";
	public int id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FactureUpdate() {
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
		 Facture facture = new Facture();
		
		try { 
			  
            // Initialize the database 
            con = DatabaseConnection.initializeDatabase(); 
  
            statement=con.createStatement();
            String sql ="Select * from patient, facture where idPatient = Patient_idPatient and facture.idFacture ="+id;
            resultat = statement.executeQuery(sql);
  
            while ( resultat.next() ) {
            	int idFacture =  resultat.getInt( "idFacture" );
	            Date date = resultat.getDate("DateF");
	            int total = resultat.getInt("Total");
	            
	            int id =  resultat.getInt( "idPatient" );
	            String name = resultat.getString( "name" );
	            String surname = resultat.getString("surname");
	            String gender = resultat.getString( "gender" );
	           int age = resultat.getInt("age");
	            String Location = resultat.getString( "Location" );
	          String email = resultat.getString( "Email_Address" );
	            String phone = resultat.getString( "Mobile_number" );
	            String groupage = resultat.getString( "groupage" );
	            
	            Patient patient = new Patient();
	            patient.setId(id);
	            patient.setName(name);
	           patient.setSurname(surname);
	            patient.setGender(gender);
	             patient.setAge(age);
	            patient.setLocation(Location);
	            patient.setEmail(email);
	            patient.setPhone(phone);
	            patient.setGroupage(groupage);
	            
	           facture.setIdFacture(idFacture);
	           facture.setDateF(date);
	           facture.setTotalF(total);
	           facture.setPatient(patient);
	            
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
		request.setAttribute("facture", facture);
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
	  
	            String sql="UPDATE `mydb`.`facture` SET `idFacture` = ?, `DateF` = ?, `Total` = ?,"
	            		+ " `Patient_idPatient` = ? "
	            		+ "WHERE `facture`.`idFacture` = "+ id;
	            st = con.prepareStatement(sql);
	  
	            st.setInt(1, Integer.valueOf(request.getParameter("idFacture")));  
	            st.setDate(2, Date.valueOf(request.getParameter("DateF"))); 
	            st.setInt(3, Integer.valueOf(request.getParameter("Total"))); 
	            st.setInt(4, Integer.valueOf(request.getParameter("Patient_idPatient")));
	         
	            st.executeUpdate(); 
	  
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
