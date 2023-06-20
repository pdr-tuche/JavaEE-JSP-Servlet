<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Aluno"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Aluno> lista = (ArrayList<Aluno>) request.getAttribute("alunos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ALUNOS</title>
<link rel="icon" href="imagens/student.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>ALUNOS</h1>
	<a href="novoAluno.html" class="Botao1">nova aluno</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>matricula</th>
				<th>nome</th>
				<th>turma</th>
				<th>Opcoes</th>
			</tr>		
		</thead>
		<tbody>
			<%for (int i=0; i<lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getMatricula()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getTurma()%></td>
					<td><a href="selectAluno?id=<%=lista.get(i).getMatricula()%>" class="Botao1">Editar</a>
					<td><a href="javascript:confirmar(<%=lista.get(i).getMatricula()%>)" class="Botao1">Excluir</a>
				</tr>
			<%} %>
		</tbody>
	</table>
	<a href="index.html" class= "voltar">voltar</a>
	<script src="scripts/confirmadorAluno.js"></script>
</body>
</html>