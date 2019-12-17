<%@ page pageEncoding="ISO-8859-1"  %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<style>
     <%@ include file="css/acceuil.css"%>
     <%@ include file="css/bootstrap.min.css"%>
</style>
<script type="text/javascript"> <%@ include file="js/new.js"%></script>
<head>
<link rel="icon" href="https://www.med.tn/img/labo.png">
<meta charset="UTF-8">
<title>Factures</title>
<script type="text/javascript" src='js/new.js'> </script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/acceuil.css"/>
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>

<%@ include file="navbar.jsp" %>

<!-- Page content holder -->
<div class="page-content p-5" id="content">
  <!-- Demo content -->
  <h3 class="display-4 text-white">Modifier la facture ${ facture.idFacture }</h3><br/>
  <form method="post">
   <div class="form-group row">
    <label for="id" class="col-sm-2 col-form-label">Id Facture</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control"  name="idFacture" placeholder="Id Facture" value=${ facture.idFacture }>
    </div>
  </div>
 <div class="form-group row">
  <label for="example-date-input" class="col-2 col-form-label">Date</label>
  <div class="col-10">
    <input class="form-control" type="date" id="example-date-input" name="DateF" placeholder="Date" value=${ facture.dateF }>
  </div>
</div>
  <div class="form-group row">
    <label for="surname" class="col-sm-2 col-form-label">Prix Total</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="Total" placeholder="Prix DA" value=${ facture.totalF }>
    </div>
  </div>
  <div class="form-group row">
    <label for="age" class="col-sm-2 col-form-label">Id Patient</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="Patient_idPatient" placeholder="Id Patient" value=${ facture.patient.id }>
    </div>
  </div>
   
   <button type="submit" class="btn btn-primary">Enregistrer</button>
  <a href="/MedicalLaboratoryApp/factures"><button type="button" class="btn btn-secondary">Annuler</button></a> 
   
  
</form>

</div>
<!-- End demo content -->
</body>
</html>