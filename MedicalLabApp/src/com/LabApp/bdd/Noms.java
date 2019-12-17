package com.LabApp.bdd;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.LabApp.Beans.Utilisateur;

import java.sql.Connection;


public class Noms {
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	public List<Utilisateur> GetUsers ( HttpServletRequest request ) {
	    /* Chargement du driver JDBC pour MySQL */
	    try {
	        
	        Class.forName( "com.mysql.jdbc.Driver" );
	        
	    } catch ( ClassNotFoundException e ) {
	        
	    }

	    /* Connexion � la base de donn�es */
	    String url = "jdbc:mysql://localhost:3306/mydb";
	    String utilisateur = "root";
	    String motDePasse = "";
	    Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	    try {
	        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
	        
	        /* Cr�ation de l'objet g�rant les requ�tes */
	        statement = connexion.createStatement();

	        /* Ex�cution d'une requ�te de lecture */
	        resultat = statement.executeQuery( "SELECT Name, Surname FROM Utilisateur;" );
	 
	        /* R�cup�ration des donn�es du r�sultat de la requ�te de lecture */
	        while ( resultat.next() ) {
	            String nomUtilisateur = resultat.getString( "Name" );
	            String surname = resultat.getString( "Surname" );
	            
	            Utilisateur user = new Utilisateur();
	            user.setNom(nomUtilisateur);
	            user.setPr�nom(surname);
	            
	            utilisateurs.add(user);
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

	    return utilisateurs;
	}
}

