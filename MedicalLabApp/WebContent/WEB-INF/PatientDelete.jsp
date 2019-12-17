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
  <h5 class="display-4 text-white">Supprimer le patient ${ patient.id }</h5><br/>
  <form method="post" >
 <div >
	<div >
		<div >
			
			<div >
				<p>Êtes vous sûr de vouloir supprimer ce patient ?</p>
			</div>
			<div>
				
				<button type="submit" class="btn btn-danger">Delete</button>
				<a href="/MedicalLaboratoryApp/patients"><button type="button" class="btn btn-info" >Cancel</button></a>
			</div>
		</div>
	</div>
</div> 
</form>
</div>
<!-- End demo content -->
</body>
</html>