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
<%@ include file = "ico.jsp"%>
<meta charset="UTF-8">
<title>Cadastrar Compromisso</title>
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
								<div class="card-header"></div>
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

										<div class="col-md-8">
											<label for="txt-nome">*Nome:</label>
											<input class="form-control" type="text" name="txt-nome" id="txt-nome">
										</div>
										<div class="col-md-4">
											<label for="txt-nascimento">*Telefone:</label>
											<input class="form-control" type="text" name="txt-telefone" id="txt-telefone">
										</div>
										<!-- Linha 2 -->
										<div class="col-md-12">
											<h6 class="text-primary  mt-4 mb-4">Dados de acesso:</h6>
											<br>
										</div>

										<div class="col-md-6">
											<label for="txt-email">*E-mail:</label> 
											<input class="form-control" type="email" name="txt-email" id="txt-email">
										</div>
										<div class="col-md-6">
											<label for="txt-senha1">*Endereço:</label>
											<input class="form-control" type="text" name="txt-endereco"id="txt-endereco">
										</div>
		
									</div>

								</div>
								<div class="card-footer">
									<button class="btn btn-success" id="bt-criar">Criar novo Contato</button>
									<a href="contatos.jsp" class="btn btn-danger">Cancelar</a>
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
