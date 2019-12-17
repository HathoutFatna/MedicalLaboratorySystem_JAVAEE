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

import com.LabApp.Beans.Test;
import com.LabApp.bdd.DatabaseConnection;

/**
 * Servlet implementation class TestDelete
 */
@WebServlet("/tests/delete")
public class TestDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE          = "/WEB-INF/TestDelete.jsp";
	public int id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDelete() {
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
		 Test test = new Test();
		
		try { 
			  
            // Initialize the database 
            con = DatabaseConnection.initializeDatabase(); 
  
            statement=con.createStatement();
            String sql ="select * from test where idTest="+id;
            resultat = statement.executeQuery(sql);
  
            while ( resultat.next() ) {
            	String name = resultat.getString( "Name" );
	            String Unit = resultat.getString( "Unit" );
	           String Cost = resultat.getString( "Cost" );
	         String Normal_range = resultat.getString("Normal_ range");
	         String Lower_range = resultat.getString( "Lower_range" );
	         String Upper_range = resultat.getString( "Upper_range" );
	          String Notes = resultat.getString( "Notes" );
	           
	           
	            
	          test.setCost(Cost);
	         test.setUnit(Unit);
	          test.setIdTest(id);
	          test.setLower_range(Lower_range);
	          test.setName(name);
	         
	          test.setNormal_range(Normal_range);
	          test.setNotes(Notes);
	          test.setUpper_range(Upper_range);
	     
	            
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
		request.setAttribute("test", test);
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
	  
	            String sql="DELETE FROM `mydb`.`test` WHERE `test`.`idTest` = "+ id;
	            st = con.prepareStatement(sql);
	  
	         
	            st.executeUpdate(); 
	  
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
