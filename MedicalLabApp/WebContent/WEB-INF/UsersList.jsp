
<%@ page pageEncoding="ISO-8859-1"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Utilisateurs</title>
</head>
<body>
  <h1>Liste des utilisateurs</h1>

        <c:forEach items="${ users }" var="user" varStatus="boucle">
            <p>${ boucle.count }. ${ user.nom } </p>
        </c:forEach>
</body>
</html>