<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pat-br">
<head>
<meta charset="utf-8">
<title>Controle Financeiro</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div>
			<h1>Criar nova conta</h1>
			<a href="index.html" class="btn-info btn rounded">Home</a> <a
				href="main" class="btn-info btn rounded">Listar</a>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<form name="frmConta" action="conta-insert">
					<h2>Dados da Conta</h2>
					<div class="form-group">
						<input type="hidden" name="idcli"
							placeholder="Saldo Inicial" class="form-control" value="<%out.println(request.getParameter("idcli")); %>" />
					</div>
					<div class="form-group">
						<input type="text" name="saldo_inicial" placeholder="Saldo Inicial"
							class="form-control" />
					</div>
					<div class="form-group">
						<input type="text" name="mov_credito"
							placeholder="Movimentação de Crédito" class="form-control" />
					</div>
					<div class="form-group">
						<input type="text" name="mov_debito"
							placeholder="Movimentação de Débito" class="form-control" />
					</div>
					<div>
						<input type="submit" value="Criar" class="btn-info btn rounded" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>