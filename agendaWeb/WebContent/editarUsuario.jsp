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
						<h5 class="text-white">Editar Usuário</h5>
					</div>
					<div class="card-body">

						<div class="card">
							<form id="usuario" action="UsuarioServlet" method="post">
								<div class="card-header">????</div>
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

										<div class="col-md-5">
											<input type="text" name="txt-cod" value="<%= usuario.getCod()%>" hidden="true">
											<label for="txt-nome">*Nome:</label> <input
												class="form-control" type="text" name="txt-nome"
												id="txt-nome" value="<%=usuario.getNome()%>">
										</div>
										<div class="col-md-4">
											<label for="txt-nascimento">*Dt.Nascimento:</label> <input
												class="form-control" type="date" name="txt-nascimento"
												id="txt-nascimento" value="<%= usuario.getDtNascimento()%>">
										</div>
										<div class="col-md-3">
											<label for="txt-sexo">*Sexo:</label> <select
												class="form-control" name="txt-sexo" id="txt-sexo">
												<option>Selecione</option>
												<option <%=usuario.getSexo().equals("F") ? "selected" : ""%>>Feminino</option>
												<option <%=usuario.getSexo().equals("M") ? "selected" : ""%>>Masculino</option>
											</select>
										</div>
										<!-- Linha 2 -->
										<div class="col-md-12">
											<h6 class="text-primary  mt-4 mb-4">Dados de acesso:</h6>
											<br>
										</div>

										<div class="col-md-6">
											<label for="txt-email">*E-mail:</label> <input
												class="form-control" type="email" name="txt-email"
												id="txt-email" value="<%=usuario.getEmail()%>">
										</div>
										<div class="col-md-3">
											<label for="txt-senha1">*Senha:</label> <input
												class="form-control" type="password" name="txt-senha1"
												id="txt-senha1">
										</div>
										<div class="col-md-3">
											<label for="txt-senha2">*Confirmar Senha:</label> <input
												class="form-control" type="password" name="txt-senha2"
												id="txt-senha2">
										</div>

									</div>

								</div>
								<div class="card-footer">
									<button class="btn btn-success" id="bt-criar">Atualizar os dados</button>
									<a href="login.html" class=" btn btn-danger">Cancelar</a>
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
