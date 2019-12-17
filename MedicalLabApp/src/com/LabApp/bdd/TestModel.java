package com.LabApp.bdd;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import com.LabApp.Beans.Test;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.Statement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class TestModel {
private Connection connexion;
    
	
	public List<Test> GetTest ( HttpServletRequest request ) {
		List<Test> tests= new ArrayList<Test>();
	    Statement statement = null;
	    ResultSet resultat = null;
	    loadDatabase();
	    try {
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();

	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery( "SELECT * FROM `test`" );
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	        	int id =  resultat.getInt( "idTest" );
	            String name = resultat.getString( "Name" );
	            String Unit = resultat.getString( "Unit" );
	           String Cost = resultat.getString( "Cost" );
	         String Normal_range = resultat.getString("Normal_ range");
	         String Lower_range = resultat.getString( "Lower_range" );
	         String Upper_range = resultat.getString( "Upper_range" );
	          String Notes = resultat.getString( "Notes" );
	           
	           
	            
	            
	            Test test = new Test();
	          test.setCost(Cost);
	         test.setUnit(Unit);
	          test.setIdTest(id);
	          test.setLower_range(Lower_range);
	          test.setName(name);
	         
	          test.setNormal_range(Normal_range);
	          test.setNotes(Notes);
	          test.setUpper_range(Upper_range);
	     
	           
	            tests.add(test);
	        	
	        }
	    } catch ( SQLException e ) {
	      
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
	     
	        if ( connexion != null ) {
	            try {
	                connexion.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	    }
	
	    return tests;
	}
	
	private void loadDatabase() {
		 try {
		        
		        Class.forName( "com.mysql.jdbc.Driver" );
		        
		    } catch ( ClassNotFoundException e ) {
		        
		    }
		 String url = "jdbc:mysql://localhost:3306/mydb";
		    String utilisateur = "root";
		    String motDePasse = "";
		 try {
		        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );}
	 catch ( SQLException e ) {
	      
    }

	}

}