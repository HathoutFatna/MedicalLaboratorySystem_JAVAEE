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
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
</head>
<body>

<%@ include file="navbar.jsp" %>

<!-- Page content holder -->
<div class="page-content p-5" id="content">
  <!-- Demo content -->
  <h3 class="display-4 text-white">Modifier le test ${ test.idTest }</h3><br/>
  <form method="post" >
   <div class="form-group row">
    <label for="id" class="col-sm-2 col-form-label">Id test</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control"  name="idTest"  value="${  test.idTest }">
    </div>
  </div>
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Nom</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="Name" value="${  test.name }">
    </div>
  </div>
  <div class="form-group row">
    <label for="surname" class="col-sm-2 col-form-label">Unité</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="Unit" value="${  test.unit }">
    </div>
  </div>
  <div class="form-group row">
    <label for="gender" class="col-sm-2 col-form-label">Prix</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="Cost" value="${  test.cost }">
    </div>
  </div>
  <div class="form-group row">
    <label for="location" class="col-sm-2 col-form-label">Valeur normale</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="Normal_range" value="${  test.normal_range }">
    </div>
  </div>
  <div class="form-group row">
    <label for="email" class="col-sm-2 col-form-label">Valeur minimale</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="Lower_range" value="${  test.lower_range }">
    </div>
  </div>
  <div class="form-group row">
    <label for="phone" class="col-sm-2 col-form-label">Valeur maximale</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="Upper_range" value="${  test.upper_range }">
    </div>
  </div>
 
   <div class="form-group row">
    <label for="phone" class="col-sm-2 col-form-label">Notes</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" name="Notes" value="${  test.notes }">
    </div>
  </div>
   <button type="submit" class="btn btn-primary">Enregistrer</button>
  <a href="/MedicalLaboratoryApp/tests"><button type="button" class="btn btn-secondary">Annuler</button></a> 
   
  
</form>

</div>
<!-- End demo content -->
</body>
</html>