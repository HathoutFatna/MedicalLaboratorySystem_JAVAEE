package com.LabApp.Beans;
import java.util.Date;

public class Facture {
         private int idFacture;
         private Date DateF;
         private int TotalF;
         private Patient patient;
		public int getIdFacture() {
			return idFacture;
		}
		public void setIdFacture(int idFacture) {
			this.idFacture = idFacture;
		}
		public Date getDateF() {
			return DateF;
		}
		public void setDateF(Date dateF) {
			DateF = dateF;
		}
		public int getTotalF() {
			return TotalF;
		}
		public void setTotalF(int totalF) {
			TotalF = totalF;
		}
		public Patient getPatient() {
			return patient;
		}
		public void setPatient(Patient patient) {
			this.patient = patient;
		}
	
         
         
         
         
         
}
