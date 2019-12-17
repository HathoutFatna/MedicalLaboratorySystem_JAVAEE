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
<title>tests</title>
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
<form role="form" id="form-buscar" method="get" action="/MedicalLaboratoryApp/tests/search">
<div class="form-group">
<div class="input-group">
<input id="1" class="form-control" type="text" name="nom" placeholder="Nom du test ..." required style=" width: 400px;"/>
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


 <a href="/MedicalLaboratoryApp/tests/add"> <button type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4 float-right"><i class="fa fa-plus mr-2"></i><small class="text-uppercase font-weight-bold">Nouveau test</small></button>
  </a>
  <!-- Demo content -->
  <h3 class="display-4 text-white">Liste des tests</h3><br/>
  <table class="table table-striped table-hover bg-white " >
  <thead>
   
    <tr>
      <th scope="col">Id test</th>
      <th scope="col">Nom</th>
        <th scope="col">Unité</th>
     <th scope="col">Prix</th>
            <th scope="col">Valeur normale</th>
            <th scope="col">Valeur maximale</th>
            <th scope="col">Valeur minimale</th>
            <th scope="col">Notes</th>
            
              <th scope="col">Action</th> 
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${ tests }" var="test" varStatus="boucle">
    <tr>
      <th scope="row">${ test.idTest }</th>
      <td>${ test.name }</td>
      <td>${ test.unit }</td>
      <td>${ test.cost }</td>
      <td>${ test.normal_range }</td>
      <td>${ test.lower_range }</td>
      <td>${ test.upper_range }</td>
      <td>${ test.notes}</td>
     
        <td>
    
  
  <a href="/MedicalLaboratoryApp/tests/update?id=${ test.idTest }"><button type="button" class="btn btn-secondary btn-sm"><i class="fa fa-edit"></i></button></a> 
     <a href="/MedicalLaboratoryApp/tests/delete?id=${ test.idTest }"><button class="btn btn-primary btn-sm"><i class="fa fa-trash"></i></button>
    
    </td>
    
      
    </tr>
    </c:forEach>
  </tbody>
</table>

</div>
<!-- End demo content -->
</body>
</html>