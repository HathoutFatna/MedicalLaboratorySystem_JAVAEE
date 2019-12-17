package com.LabApp.bdd;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.LabApp.Beans.Patient;

public class listePatientsbdd {
	private Connection connexion;
    
	
	public List<Patient> GetPatients ( HttpServletRequest request ) {
		List<Patient> patients = new ArrayList<Patient>();
	    Statement statement = null;
	    ResultSet resultat = null;
	    loadDatabase();
	    try {
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();

	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery( "SELECT idPatient, name, surname, age, gender, Location, Email_Address,Mobile_number, groupage FROM patient;" );
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
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
	            
	            patients.add(patient);
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

	    return patients;
	}
	
	public List<Patient> GetPatientsSearch ( HttpServletRequest request, String nom ) {
		List<Patient> patients = new ArrayList<Patient>();
	    Statement statement = null;
	    ResultSet resultat = null;
	    loadDatabase();
	    try {
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();

	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery( "SELECT * FROM `patient` WHERE `name` LIKE '"+nom+"' ");
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
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
	            
	            patients.add(patient);
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

	    return patients;
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
	/*public void ajouterPatient(Patient patient) {
		loadDatabase();
		try {
		PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO patient(idPatient, name, surname, age, gender, Location, Email_address, Mobile_number) VALUES (?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, patient.getId());
		preparedStatement.setString(2, patient.getName());
		preparedStatement.setString(3, patient.getSurname());
		preparedStatement.setInt(4, patient.getAge());
		preparedStatement.setString(5, patient.getGender());
		preparedStatement.setString(6, patient.getLocation());
		preparedStatement.setString(7, patient.getEmail());
		preparedStatement.setString(8, patient.getPhone());
		
		preparedStatement.executeUpdate();		}
		catch (SQLException e){
			e.printStackTrace();
			
		}
	}*/
	
	
	
}
