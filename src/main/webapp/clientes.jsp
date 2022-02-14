<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="Model.ClienteBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<ClienteBeans> lista = (ArrayList<ClienteBeans>) request.getAttribute("clientes");
%>
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
		<h1>Controle Financeiro - Clientes</h1>
		<a href="index.html" class="btn-info btn rounded">Home</a>
		<a href="novo-cliente.html" class="btn-info btn rounded">Novo Cliente</a>
		<a href="report" class="btn-success btn rounded">Relatório de Saldo - Clientes</a>
		<table class="table">
			<thead>
				<th>ID</th>
				<th>TIPO CONTA</th>
				<th>CPF</th>
				<th>NOME</th>
				<th>TELEFONE</th>
				<th>EMAIL</th>
				<th>ENDERECO</th>
				<th>CONTA</th>
				<th>AÇÕES</th>
			</thead>
			<tbody>
			<%for (int i = 0; i <lista.size(); i++){ %>
			<tr>
				<td><%= lista.get(i).getIdCli() %></td>
				<td><%= lista.get(i).getTipoPessoa() %></td>
				<td><%= lista.get(i).getCpf() %></td>
				<td><%= lista.get(i).getNome() %></td>
				<td><%= lista.get(i).getTelefone() %></td>
				<td><%= lista.get(i).getEmail() %></td>
				<td><a href="novo-endereco.html?idcli=<%=lista.get(i).getIdCli()%>"
						class="btn-success btn rounded" style="margin-right: 20px;">Cadastrar</a><a href="endereco-select?idcli=<%=lista.get(i).getIdCli() %>" class="btn-info btn rounded">Editar</a></td>
				<td><a href="nova-conta.jsp?idcli=<%=lista.get(i).getIdCli() %>" class="btn-success btn rounded">Criar Conta</a></td>
				<td><a href="select?idcli=<%=lista.get(i).getIdCli() %>" class="btn-info btn rounded">Editar</a></td>
				<td><a href="javascript: confirmar(<%=lista.get(i).getIdCli() %>)" class="btn-danger btn rounded">Excluir</a></td>
			</tr>
			<%} %>
			</tbody>
		</table>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
		<script src="scripts/confirmador.js"></script>	
	</div>
</body>
</html>