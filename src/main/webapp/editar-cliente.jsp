<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Controle Financeiro</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>Editar cliente</h1>
		<a href="index.html" class="btn-info btn rounded">Home</a> <a
			href="main" class="btn-info btn rounded">Listar</a>
		<form name="frmCliente" action="update">
			<table class="table">
				<tr class="form-group">
					<td><input type="hidden" name="idcli" class="form-control"
						readonly value="<%out.print(request.getAttribute("idcli"));%>" /></td>
				</tr>
				<tr class="form-group">
					<td><input type="text" name="tipo_pessoa" class="form-control"
						value="<%out.print(request.getAttribute("tipo_pessoa"));%>" /></td>	
				</tr>
				<tr class="form-group">
					<td><input type="text" name="cpf" class="form-control"
						value="<%out.print(request.getAttribute("cpf"));%>" /></td>
				</tr>
				<tr class="form-group">
					<td><input type="text" name="nome" class="form-control"
						value="<%out.print(request.getAttribute("nome"));%>" /></td>
				</tr>
				<tr class="form-group">
					<td><input type="text" name="fone" class="form-control"
						value="<%out.print(request.getAttribute("telefone"));%>" /></td>
				</tr>
				<tr class="form-group">
					<td><input type="text" name="email" class="form-control"
						value="<%out.print(request.getAttribute("email"));%>" /></td>
				</tr>
			</table>
			<input type="button" value="Salvar" class="btn-info btn rounded"
				onclick=validar() />
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
	<script src="scripts/validador.js"></script>
</body>
</html>