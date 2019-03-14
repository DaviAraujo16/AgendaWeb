<%@page import="br.senai.sp.cfp127.model.Contato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senai.sp.cfp127.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.senai.sp.cfp127.model.Usuario" %>	
<%
	Usuario usuario = new Usuario();
	// Converter uma string em um objeto do tipo usuario (casting)
	usuario = (Usuario) session.getAttribute("usuario");
	
	ContatoDao dao = new ContatoDao();
	ArrayList<Contato> contatos = new ArrayList<>();
	
	contatos = dao.getContatos(usuario.getCod());
	
	if (usuario == null){
		response.sendRedirect("login.html");
	}else{
	%>
	<!DOCTYPE html>
<html>
<head>
<%@ include file = "ico.jsp"%>
<link rel="stylesheet" href="css/bootstrap.css">
<meta charset="UTF-8">
<title>Agenda Eletrônica - Contatos</title>
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
						<div class="row">
							<div class="col-md-9">
								<h5 class="text-white">Meus Contatos</h5>

							</div>
							<div class="col-md-3">
								<a href="cadastroContato.jsp" class="btn btn-success"> Novo Contato </a>
							</div>
						</div>
					</div>
					<div class="card-body">
						<table class="table table-sm table-hover">
							<thead>
								<tr>
									<th>Cód.</th>
									<th>Nome</th>
									<th>E-mail</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							<%for (Contato c: contatos){%>
							
								<tr>
									<td><strong><%=String.format("%04d", c.getCodContato())%></strong></td>
									<td>
										<a href="ExibirContatoServlet?cod_contato=<%=c.getCodContato()%>">
											<%= c.getNome()%>
										</a>
									</td>
									<td><%= c.getEmail()%></td>
									<td>
										<a href="confirmacao.jsp?cod_contato=<%=c.getCodContato()%>&nome=<%=c.getNome()%>">
											<img src="imagens/trash20.png">
										</a>
									</td>
								</tr>
								
								
							<%}%>	
							</tbody>
						</table>
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
