
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
<title>Patients</title>
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
  <h3 class="display-4 text-white">Modifier le patient ${ patient.id }</h3><br/>
    
<form method="post" >
   <div class="form-group row">
    <label for="id" class="col-sm-2 col-form-label">Id Patient</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control"  name="id" value="${ patient.id }">
    </div>
  </div>
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Nom</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="name" value="${ patient.name }">
    </div>
  </div>
  <div class="form-group row">
    <label for="surname" class="col-sm-2 col-form-label">Prénom</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="surname" value="${ patient.surname }">
    </div>
  </div>
  <div class="form-group row">
    <label for="age" class="col-sm-2 col-form-label">Age</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="age" value="${ patient.age }">
    </div>
  </div>
  <div class="form-group row">
    <label for="gender" class="col-sm-2 col-form-label">Sexe</label>
    <div class="col-sm-10">
      <select name="gender" class="form-control" value="${ patient.gender }">
         <option value="Femme">Femme</option>
         <option value="Homme">Homme</option>
       </select>
    </div>
  </div>
  <div class="form-group row">
    <label for="location" class="col-sm-2 col-form-label">Adresse</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="location" value="${ patient.location }">
    </div>
  </div>
  <div class="form-group row">
    <label for="email" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="email" value="${ patient.email }">
    </div>
  </div>
  <div class="form-group row">
    <label for="phone" class="col-sm-2 col-form-label">Mobile</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="phone" value="${ patient.phone }">
    </div>
  </div>
  <div class="form-group row">
    <label for="gender" class="col-sm-2 col-form-label">Groupage</label>
    <div class="col-sm-10">
      <select name="groupage" class="form-control" value="${ patient.groupage }">
         <option value="O+">O+</option>
         <option value="O-">O-</option>
         <option value="AB+">AB+</option>
         <option value="AB-">AB-</option>
         <option value="A+">A+</option>
         <option value="A-">A-</option>
         <option value="B+">B+</option>
         <option value="B-">B-</option>
       </select>
    </div>
  </div>
 
   
   <button type="submit" class="btn btn-primary">Enregistrer</button>
  <a href="/MedicalLaboratoryApp/patients"><button type="button" class="btn btn-secondary">Annuler</button></a> 
   
  
</form>

</div>
</body>
</html>