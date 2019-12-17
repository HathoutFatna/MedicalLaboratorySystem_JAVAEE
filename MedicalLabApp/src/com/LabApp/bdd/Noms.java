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

	    /* Connexion à la base de données */
	    String url = "jdbc:mysql://localhost:3306/mydb";
	    String utilisateur = "root";
	    String motDePasse = "";
	    Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	    try {
	        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
	        
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();

	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery( "SELECT Name, Surname FROM Utilisateur;" );
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	            String nomUtilisateur = resultat.getString( "Name" );
	            String surname = resultat.getString( "Surname" );
	            
	            Utilisateur user = new Utilisateur();
	            user.setNom(nomUtilisateur);
	            user.setPrénom(surname);
	            
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

