<!DOCTYPE html>
<%@page import="br.senai.sp.cfp127.model.Usuario"%>
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
		
	<div class="container mt-5" style="width:900px;">
		<div class="card">
			<div class="card-header">
				<div class="row align-items-center">
					<div class="col-md-1">
						<img src="imagens/apagar.png">
					</div>
					<div class="col-md-11">
						<h3 class="text-danger" id="titulo">Apagar Contato</h3>
					</div>
				</div>
			</div>
				<div class="card-body">
					<p><h3 class="text-danger">Você confirma a exclusão desse Contato?</h3></p>
					<p>O contato <%=request.getParameter("nome")%> está preste a ser apagado.</p>
					<p> Se você realmente deseja apaga-lo clique em Excluir Contato</p>	
				</div>
				<div class="card-footer">
					<a href="ExcluirContatoServlet?cod_contato=<%=request.getParameter("cod_contato")%>&nome=<%=request.getParameter("nome")%>">
					<button class="btn btn-danger">Excluir Contato</button>
					</a>
					<a href="contatos.jsp">
						<button class="btn" id="bt-criar">Cancelar</button>
					</a>
		
				</div>	
		</div>
	</div>
</body>
</html>