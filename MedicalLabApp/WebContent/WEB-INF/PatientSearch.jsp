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
  <!-- Toggle button -->
  <c:if test="${!empty nom }">
    <p>  <c:out value="Salut ${ nom }"></c:out></p>
  </c:if>
   <form method="get" action="/MedicalLaboratoryApp/patients/search">
  <p>
      <label for="nom"> Nom :</label>
     <input type="text" id="nom" name="nom" />
  </p>
  <input type="submit" />
  </form>  
  
  
 <a href="/MedicalLaboratoryApp/patients/add"> <button type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4 float-right"><i class="fa fa-plus mr-2"></i><small class="text-uppercase font-weight-bold">Nouveau Patient</small></button>
  </a>
  <!-- Demo content -->
  <h3 class="display-4 text-white">Liste des patients</h3><br/>
  <table class="table table-striped table-hover bg-white " >
  <thead>
   
    <tr>
      <th scope="col">Id patient</th>
      <th scope="col">Nom</th>
      <th scope="col">Prénom</th>
      <th scope="col">Genre</th>
            <th scope="col">Age</th>
            <th scope="col">Adresse</th>
            <th scope="col">Email</th>
            <th scope="col">Mobile</th>
            <th scope="col">Groupage</th>
              <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${ patients }" var="patient" varStatus="boucle">
    <tr>
      <th scope="row">${ patient.id }</th>
      <td>${ patient.name }</td>
      <td>${ patient.surname }</td>
      <td>${ patient.gender }</td>
      <td>${ patient.age }</td>
      <td>${ patient.location }</td>
      <td>${ patient.email }</td>
      <td>${ patient.phone }</td>
      <td>${ patient.groupage }</td>
       <td>
    
  
  <a href="/MedicalLaboratoryApp/patients/update?id=${ patient.id }"><button type="button" class="btn btn-secondary btn-sm"><i class="fa fa-edit"></i></button></a> 
     <a href="/MedicalLaboratoryApp/patients/delete?id=${ patient.id }"><button class="btn btn-primary btn-sm"><i class="fa fa-trash"></i></button>
    
    </td>
    
  
    </tr>
    </c:forEach>
  </tbody>
</table>
<!-- End demo content -->
</body>
</html>