<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	String email = request.getParameter("email");
	String senha = request.getParameter("senha");

	int resposta = Integer.parseInt(email) + Integer.parseInt(senha);

%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%= email %><br>
	<%= senha %><br>
	<h2>Resposta: <%= resposta %></h2><br>
	<h1> Eu sou um Html!</h1>
</body>
</html>