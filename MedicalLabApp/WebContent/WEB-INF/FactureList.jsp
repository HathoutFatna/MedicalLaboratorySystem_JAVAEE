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
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

</head>
<body>

<%@ include file="navbar.jsp" %>

<!-- Page content holder -->
<div class="page-content p-5" id="content">
  <!-- Toggle button -->

<div class="container" style="margin-left: 200px;">
<div class="col-md-6 col-md-offset-3">     
<div class="row">
<form role="form" id="form-buscar" method="get" action="/MedicalLaboratoryApp/factures/search">
<div class="form-group">
<div class="input-group">
<input id="1" class="form-control" type="text" name="nom" placeholder="Nom du patient ..." required style=" width: 400px;"/>
<span class="input-group-btn">
<button class="btn btn-primary" type="submit">
<i class="fa fa-search" aria-hidden="true"></i>
</button>
</span>
</div>
</div>
</form>
</div>            
</div>
</div>

 <a href="/MedicalLaboratoryApp/factures/add"> <button type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4 float-right"><i class="fa fa-plus mr-2"></i><small class="text-uppercase font-weight-bold">Nouvelle facture</small></button>
  </a>
  <!-- Demo content -->
  <h3 class="display-4 text-white">Liste des factures</h3><br/>
  <table class="table table-striped table-hover bg-white " >
  <thead>
   
    <tr>
      <th scope="col">Id Facture</th>
      <th scope="col">Nom Patient</th>
      <th scope="col">Prénom Patient</th>
      <th scope="col">Date</th>
            <th scope="col">Prix Total</th>
              <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${ factures }" var="facture" varStatus="boucle">
    <tr>
      <th scope="row">${ facture.idFacture }</th>
      <td>${ facture.patient.name }</td>
      <td>${ facture.patient.surname }</td>
      <td>${ facture.dateF }</td>
      <td>${ facture.totalF }</td>
       <td>
    
  <a href="/MedicalLaboratoryApp/factures/exportPDF?id=${ facture.idFacture }"><button type="button" class="btn btn-danger btn-sm"><i class="fa fa-file"></i></button></a> 
  <a href="/MedicalLaboratoryApp/factures/update?id=${ facture.idFacture }"><button type="button" class="btn btn-secondary btn-sm"><i class="fa fa-edit"></i></button></a> 
     <a href="/MedicalLaboratoryApp/factures/delete?id=${ facture.idFacture }"><button class="btn btn-primary btn-sm"><i class="fa fa-trash"></i></button>
    
    </td>
    
  
    </tr>
    </c:forEach>
  </tbody>
</table>
<!-- End demo content -->
</body>
</html>