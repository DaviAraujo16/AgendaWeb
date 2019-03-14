<%@page import="br.senai.sp.cfp127.model.Compromisso"%>
<%@page import="br.senai.sp.cfp127.dao.CompromissoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>	
<%@page import="br.senai.sp.cfp127.utils.ModificaData"%>
<%@ page import="br.senai.sp.cfp127.model.Usuario" %>	
<%
	Usuario usuario = new Usuario();
	// Converter uma string em um objeto do tipo usuario (casting)
	usuario = (Usuario) session.getAttribute("usuario");
	
	CompromissoDao dao = new CompromissoDao();
	
	ArrayList<Compromisso> compromissos = new ArrayList<Compromisso>();
	
	int status = 3;
	
	compromissos = dao.getDescricao(usuario.getCod());
	
	if (usuario == null){
		response.sendRedirect("login.html");
	}else{
	%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<%@ include file = "ico.jsp"%>
<meta charset="UTF-8">
<title>Agenda Eletrônica - Home</title>
</head>
<body class="bg-dark">
	<!-- Cabeçalho -->
	<div class="bg-info text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-1">
					<img src="imagens/agenda64.png">
				</div>
				<div class="col-md-11">
					<h1>Agenda Eletrônica</h1>
					<h6>Contatos e Compromissos</h6>
				</div>
			</div>
		</div>
	</div>
	<!-- Corpo -->
	<div class="container mt-4 fluid">
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<%@ include file = "painelUsuario.jsp"%>
				</div>
				<div class="card mt-4">
					<%@ include file = "menu.html"%>
				</div>
			</div>
			<div class="col-md-8">
				<div class="card">
					<div class="card-header bg-info">
						<h5 class="text-white">Bem-vindo</h5>
					</div>
					<div class="card-body row">
						<%for (Compromisso c: compromissos){%>
						<div class="card-deck col-4 ml-2  text-white">
						  	<div class="card bg-danger">
						  		<div class="card-header">
						  			<h6 class="card-title"><%= c.getTituloCompromisso()%></h6>
						  		</div>
						    	<div class="card-body">
						      		<p class="card-text"><%=c.getDescricaoCompromisso()%></p>
						    	</div>
						   		<div class="card-footer text-white">
						      		<small class="text-white"><%=ModificaData.dataPort(c.getDataCompromisso())%></small>
						    	</div>
						 	</div>
						</div>
						<%}%>			
					</div>
					<div class="card-footer"></div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file = "footer.jsp"%>
	<script> document.body.style.zoom = "135%"</script>
	</body>
</html>
	<%	
	}
	%>
