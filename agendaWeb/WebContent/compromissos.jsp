<%@page import="br.senai.sp.cfp127.dao.CompromissoDao"%>
<%@page import="br.senai.sp.cfp127.model.Compromisso"%>
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
	
	CompromissoDao dao = new CompromissoDao();
	ArrayList<Compromisso> compromissos = new ArrayList<>();
	
	int status = 0;
	
	if (request.getParameter("status") != null){
		status = Integer.parseInt(request.getParameter("status"));
	}
	
	compromissos = dao.getCompromissos(usuario.getCod(), status);
	
	if (usuario == null){
		response.sendRedirect("login.html");
	}else{
	%>
	<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<meta charset="UTF-8">
<title>Insert title here</title>
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
					<%@ include file ="painelUsuario.jsp"%>
				</div>
				<div class="card mt-4">
					<%@ include file = "menu.html"%>
				</div>
			</div>
			<div class="col-md-8">
				<div class="card">
					<div class="card-header bg-info">
						<div class="row">
							<div class="col-md-8">
								<h5 class="text-white">Meus Compromisso</h5>

							</div>
							<div class="col-md-3">
								<a href="cadastroCompromisso.jsp" class="btn btn-success"> Novo Compromisso </a>
							</div>
						</div>
					</div>
					<div class="col-md-4 mt-4">
						<strong><label for="txt-nascimento" class="text-info">*Status:</label></strong>
						<select class="form-control" name="status" id="status" onchange="selecionarStatus()">
    						<option value="0"<%= status == 0 ? "selected" : "" %>>Em andamento</option>
    						<option value="1" <%= status == 1 ? "selected" : "" %>>Cancelado</option>
    						<option value="2" <%= status == 2 ? "selected" : "" %>>Concluido</option>
						</select>
					</div>
					<div class="card-body">
						<table class="table table-sm table-hover">
							<thead>
								<tr>
									<th>Cód.</th>
									<th>Titulo</th>
									<th>Data</th>
									<th>Prioridade</th>
									<th></th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							<%for (Compromisso c: compromissos){%>
							
								<tr>
									<td><strong><%=String.format("%04d", c.getCodCompromisso())%></strong></td>
									<td>
										<a href="ExibirCompromissoServlet?cod_compromisso=<%=c.getCodCompromisso()%>">
											<%= c.getTituloCompromisso()%>
										</a>
									</td>
									<td>
										<%=ModificaData.dataPort(c.getDataCompromisso())%>
									</td>
									<td><%if(c.getNivelPrioridade() == 0){%>
											Alto
										<%}else if(c.getNivelPrioridade() == 1){%>
											Médio
										<%}else if(c.getNivelPrioridade() == 2){%>
											Baixo
										<%}%>	
									</td>
									<td>
										<a href="ModificarStatusServlet?cod_compromisso=<%=c.getCodCompromisso()%>&status=1">
											<img src="imagens/cancelar.png" alt="Cancelado" title="Cancelado">
										</a>
									</td>
									<td>
										<a href="ModificarStatusServlet?cod_compromisso=<%=c.getCodCompromisso()%>&status=0">
											<img src="imagens/andamento.png" alt="Em andamento" title="Em andamento">
										</a>
									</td>
									<td>
										<a href="ModificarStatusServlet?cod_compromisso=<%=c.getCodCompromisso()%>&status=2">
											<img src="imagens/concluido.png" alt="Concluído" title="Concluído">
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
	
	<script>
		function selecionarStatus(){
			var op = document.querySelector("#status")
			if(op.value == 0){
				window.location.href = "compromissos.jsp?status=0"
			}if(op.value == 1){
				window.location.href = "compromissos.jsp?status=1"
			}if(op.value == 2){
				window.location.href = "compromissos.jsp?status=2"
			}
		}	
	</script>
</body>
</html>
<%}%>
