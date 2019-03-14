<%@page import="br.senai.sp.cfp127.model.Compromisso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.senai.sp.cfp127.model.Usuario"%>
<%
	Usuario usuario = new Usuario();
	usuario = (Usuario) session.getAttribute("usuario");
	
	Compromisso compromisso = new Compromisso();
	compromisso = (Compromisso) session.getAttribute("compromisso");
	session.removeAttribute("compromisso");
	if (usuario == null) {
		response.sendRedirect("login.html");
	} else {
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<%@ include file = "ico.jsp"%>
<meta charset="UTF-8">
<title>Editar Compromisso</title>
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
				
				<%@ include file = "painelUsuario.jsp"%>
				
				<div class="card mt-4">
			
					<%@ include file = "menu.html"%>
				</div>
			</div>
			<div class="col-md-8">
				<div class="card">
					<div class="card-header bg-info">
						<h5 class="text-white">Atualizar Contato</h5>
					</div>
					<div class="card-body">

						<div class="card">
							<form id="usuario" action="AtualizarCompromissoServlet" method="get">
								<div class="card-header"></div>
								<div class="card-body">
									<div class="alert-warning">
										<ul id="mensagens-erro">
										</ul>
									</div>
									<!-- Linha 1 -->
									<div>
										<ul id="erros"></ul>
									</div>
									<div class="row form-group">

										<div class="col-md-6">
										<input type="text" name="txt-cod" value="<%=compromisso.getCodCompromisso()%>" hidden="true">
											<label for="txt-titulo">*Titulo:</label>
											<input class="form-control" type="text" name="txt-titulo" id="txt-titulo" value="<%=compromisso.getTituloCompromisso() %>">
										</div>
										<div class="col-md-6">
											<label for="txt-data">*Data:</label>
											<input class="form-control" type="date" name="txt-data" id="txt-data"  value="<%=compromisso.getDataCompromisso()%>">
										</div>
										<!-- Linha 2 -->
										<div class="col-md-3">
											<label for="txt-horaInicio">*Início:</label>
											<input class="form-control" type="time" name="txt-horaInicio" id="horaInicio"  value="<%=compromisso.getHoraInicio()%>">
										</div>
										<div class="col-md-3">
											<label for="txt-horaFim">*Fim:</label>
											<input class="form-control" type="time" name="txt-horaFim" id="txt-horaFim"  value="<%=compromisso.getHoraFim()%>">
										</div>
										<div class="col-md-6">
											<label for=""cmb-prioridade"">*Prioridade:</label>
											<select class="form-control" name="cmb-prioridade" id="cmb-prioridade">
    											<option value="-1">Escolha um nível de Prioridade</option>
    											<%if(compromisso.getNivelPrioridade() == 0) { %>
    												<option value="0" selected>Alta</option>
    												<option value="1">Média</option>
    												<option value="2">Baixa</option>
    											<%}else if(compromisso.getNivelPrioridade() == 1) { %>
    												<option value="0">Alta</option>
    												<option value="1" selected>Média</option>
    												<option value="2">Baixa</option>
    											<%}else if(compromisso.getNivelPrioridade() == 2) { %>
    												<option value="0">Alta</option>
    												<option value="1">Média</option>
    												<option value="2" selected>Baixa</option>
    											<%}%>
											</select>
										</div>
										<div class="col-md-6">
											<label for="cmb-status">*Status:</label>
											<select class="form-control" name="cmb-status" id="cmb-status">
    											<option value="-1">Escolha um status</option>
    											<%if(compromisso.getStatus() == 0) { %>
    												<option value="0" selected>Em andamento</option>
    												<option value="1">Cancelado</option>
    												<option value="2">Concluido</option>
    											<%}else if(compromisso.getStatus() == 1) { %>
    												<option value="0" >Em andamento</option>
    												<option value="1" selected>Cancelado</option>
    												<option value="2">Concluido</option>
    											<%}else if(compromisso.getStatus() == 2) { %>
    												<option value="0">Em andamento</option>
    												<option value="1">Cancelado</option>
    												<option value="2" selected>Concluido</option>
    											<%}%>
											</select>
										</div>
										<div class="col-md-6">
											<label for="txt-descricao">*Descrição</label>
											<textarea name="txt-descricao" id="txt-descricao" class="form-control h-75" rows="3"><%= compromisso.getDescricaoCompromisso()%></textarea>
										</div>
									</div>

								</div>
								<div class="card-footer">
									<button class="btn btn-success" id="bt-criar">Atualizar Contato</button>
									<a href="compromissos.jsp" class="btn btn-danger">Cancelar</a>
								</div>
							</form>
						</div>
					</div>
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
