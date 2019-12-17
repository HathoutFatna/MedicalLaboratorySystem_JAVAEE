package com.LabApp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LabApp.Beans.Facture;
import com.LabApp.Beans.Patient;
import com.LabApp.bdd.DatabaseConnection;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.geometry.Pos;

/**
 * Servlet implementation class FacturePDF
 */
@WebServlet("/factures/exportPDF")
public class FacturePDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturePDF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = Integer.valueOf(request.getParameter("id"));	
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

        Document document = new Document();
        try {
            /* setup http header */
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", " inline; filename=report.pdf");
 
            /* generate PDF document */
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
 
            document.addTitle("Facture N "+facture.getIdFacture());
            
            Paragraph p1 = new Paragraph("Facture N "+facture.getIdFacture());
            p1.setSpacingAfter(8);
            p1.setAlignment(20);
            document.add(p1);
 
            Paragraph p = new Paragraph("Patient : "+facture.getPatient().getName()+" "+facture.getPatient().getSurname());
            p.setSpacingAfter(8);
            document.add(p);
 
            p = new Paragraph(facture.getDateF().toString());
            p.setSpacingAfter(8);
            document.add(p);
 
            Paragraph p2 = new Paragraph("Prix total à payer : "+facture.getTotalF()+" DA");
            p2.setSpacingAfter(8);
            document.add(p2);
          
        } catch (DocumentException de) {
            // Wrap inside a ServletException
            throw new ServletException(de);
        }
 
        document.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
