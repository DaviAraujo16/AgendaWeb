<%@page import="br.senai.sp.cfp127.dao.CompromissoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@page import="br.senai.sp.cfp127.utils.ModificaData"%>
<%@ page import="br.senai.sp.cfp127.model.Usuario" %>	
<%
	Usuario usuario = new Usuario();
	// Converter uma string em um objeto do tipo usuario (casting)
	usuario = (Usuario) session.getAttribute("usuario");
	
	CompromissoDao dao = new CompromissoDao();
	ArrayList<Compromisso> compromissos = new ArrayList<>();
	
	int status = 3;
	
	compromissos = dao.getDescricao(usuario.getCod(), status);
	
	if (usuario == null){
		response.sendRedirect("login.html");
	}else{
	%>
	<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link href="imagens/favicon.png" rel="shortcut icon" type="image/x-icon">
<meta charset="UTF-8">
<title>Agenda Eletr�nica - Home</title>
</head>
<body class="bg-dark">
	<!-- Cabe�alho -->
	<div class="bg-info text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-1">
					<img src="imagens/agenda64.png">
				</div>
				<div class="col-md-11">
					<h1>Agenda Eletr�nica</h1>
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
					<div class="card-body">
						<div class="card-deck">
						  <div class="card bg-danger text-white">
						  	<div class="card-header">
						  		<h5 class="card-title">Card title</h5>
						  	</div>
						    <div class="card-body">
						      <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
						    </div>
						    <div class="card-footer">
						      <small class="text-muted">Last updated 3 mins ago</small>
						    </div>
						  </div>
						  <div class="card bg-danger text-white">
						  	<div class="card-header">
						  		<h5 class="card-title">Card title</h5>
						  	</div>
						    <div class="card-body">
						      <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
						    </div>
						    <div class="card-footer">
						      <small class="text-muted">Last updated 3 mins ago</small>
						    </div>
						  </div>
						  <div class="card bg-danger text-white">
						  	<div class="card-header">
						  		<h5 class="card-title">Card title</h5>
						  	</div>
						    <div class="card-body">
						      <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
						    </div>
						    <div class="card-footer">
						      <small class="text-muted">Last updated 3 mins ago</small>
						    </div>
						  </div>
						</div>			
					</div>
					<div class="card-footer"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
	<%	
	}
	%>
