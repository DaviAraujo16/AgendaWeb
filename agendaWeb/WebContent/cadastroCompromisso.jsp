<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.senai.sp.cfp127.model.Usuario"%>
<%
	Usuario usuario = new Usuario();
	// Converter uma string em um objeto do tipo usuario (casting)
	usuario = (Usuario) session.getAttribute("usuario");
	if (usuario == null) {
		response.sendRedirect("login.html");
	} else {
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
				
				<%@ include file = "painelUsuario.jsp"%>
				
				<div class="card mt-4">
			
					<%@ include file = "menu.html"%>
				</div>
			</div>
			<div class="col-md-8">
				<div class="card">
					<div class="card-header bg-info">
						<h5 class="text-white">Cadastrar Contato</h5>
					</div>
					<div class="card-body">

						<div class="card">
							<form id="usuario" action="CriarContatoServlet" method="get">
								<div class="card-header">Cadastro</div>
								<div class="card-body">
									<div class="alert-warning">
										<ul id="mensagens-erro">
										</ul>
									</div>
									<!-- Linha 1 -->
									<div class="row">
										<div class="col-md-12">
											<h6 class="text-primary  mt-1 mb-2">Dados Pessoais</h6>
										</div>
									</div>
									<div>
										<ul id="erros"></ul>
									</div>
									<div class="row form-group">

										<div class="col-md-4">
											<label for="txt-titulo">*Titulo:</label>
											<input class="form-control" type="text" name="txt-titulo" id="txt-titulo">
										</div>
										<div class="col-md-4">
											<label for="txt-data">*Data:</label>
											<input class="form-control" type="date" name="txt-data" id="txt-data">
										</div>
										<div class="col-md-4">
											<label for="txt-horaInicio">*Início:</label>
											<input class="form-control" type="time" name="txt-horaInicio" id="horaInicio">
										</div>
										<!-- Linha 2 -->
										<div class="col-md-12">
											<h6 class="text-primary  mt-4 mb-2">Dados de acesso:</h6>
											<br>
										</div>

										<div class="col-md-2">
											<label for="txt-horaFim">*Fim:</label>
											<input class="form-control" type="time" name="txt-horaFim" id="txt-horaFim">
										</div>
										<div class="col-md-4">
											<label for="txt-nascimento">*Prioridade:</label>
											<select class="form-control" name="cmb-prioridade" id="cmb-prioridade">
    											<option value="-1">Nivel Prioridade</option>
    											<option value="0">Alta</option>
    											<option value="1">Média</option>
    											<option value="2">Baixa</option>
											</select>
										</div>
										<div class="col-md-6">
											<label for="txt-descricao">*Descrição</label>
											<textarea type="date" name="txt-descricao" id="txt-descricao" class="form-control" rows="2"></textarea>
										</div>
									</div>
								</div>
								<div class="card-footer">
									<button class="btn btn-success" id="bt-criar">Criar novo Compromisso</button>
									<a href="compromissos.jsp" class="btn btn-danger">Cancelar</a>
								</div>
							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%
	}
%>	
