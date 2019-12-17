package com.LabApp.bdd;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.LabApp.Beans.Facture;
import com.LabApp.Beans.Patient;

public class listeFacturesbdd {
private Connection connexion;


Date d1 = new Date(2000-11-21); 
	
	public List<Facture> GetFactures ( HttpServletRequest request ) {
		List<Facture> factures = new ArrayList<Facture>();
		
	    Statement statement = null;
	    ResultSet resultat = null;
	    loadDatabase();
	    try {
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();

	        /* Exécution d'une requête de lecture */
	       resultat = statement.executeQuery( "Select * from patient, facture where idPatient = Patient_idPatient" );
	        
	       
	 
	        /* Récupération des données du résultat de la requête de lecture */
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
	            
	           
	           Facture facture = new Facture();
	           facture.setIdFacture(idFacture);
	           facture.setDateF(date);
	           facture.setTotalF(total);
	           facture.setPatient(patient);
	           
	           factures.add(facture);
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
	
	    return factures;
	}
	
	public List<Facture> GetFacturesSearch ( HttpServletRequest request, String nom ) {
		List<Facture> factures = new ArrayList<Facture>();
	    Statement statement = null;
	    ResultSet resultat = null;
	    loadDatabase();
	    try {
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();

	        /* Exécution d'une requête de lecture */
	       resultat = statement.executeQuery( "Select * from patient, facture where idPatient = Patient_idPatient and patient.name = '"+nom+"' " );
	        
	       
	 
	        /* Récupération des données du résultat de la requête de lecture */
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
	            
	           
	           Facture facture = new Facture();
	           facture.setIdFacture(idFacture);
	           facture.setDateF(date);
	           facture.setTotalF(total);
	           facture.setPatient(patient);
	           
	           factures.add(facture);
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
	
	    return factures;
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
