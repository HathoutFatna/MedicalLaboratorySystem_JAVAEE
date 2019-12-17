<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<style>
     <%@ include file="login/vendor/bootstrap/css/bootstrap.min.css"%>
      <%@ include file="login/fonts/font-awesome-4.7.0/css/font-awesome.min.css"%>
       <%@ include file="login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css"%>
        <%@ include file="login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css"%>
         <%@ include file="login/vendor/animate/animate.css"%>
          <%@ include file="login/vendor/css-hamburgers/hamburgers.min.css"%>
           <%@ include file="login/vendor/animsition/css/animsition.min.css"%>
            <%@ include file="login/vendor/select2/select2.min.css"%>
             <%@ include file="login/vendor/daterangepicker/daterangepicker.css"%>
              <%@ include file="login/css/util.css"%>
               <%@ include file="login/css/main.css"%>
    
</style>
<head>
<link rel="icon" href="https://www.med.tn/img/labo.png">
	<title>E-LBORATORY</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body background="login/images/bg-01.jpg">
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title" style="background-image: url(https://www.lexmed.com/Content/themes/lexmed/img/pages/medical/laboratory.jpg);">
					<span class="login100-form-title-1">
						Bienvenue au e-laboratory
					</span>
				</div>


				<form id="resetForm" method ="post" class="login100-form validate-form">
					<div class="wrap-input100 validate-input m-b-26" >
						<span class="label-input100">Email</span>
						<input class="input100" type="text" name="username" placeholder="Entrer votre adresse mail">
						<span class="focus-input100"></span>
					</div>

					
					</div>

					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">
							Envoyer mon nouveau mot de passe
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
 
    $(document).ready(function() {
        $("#resetForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                }      
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                }
            }
        });
 
    });
</script>
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>