<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Aluno</title>
<link rel="icon" href="imagens/student.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Aluno</h1>
	<form name="formAluno" action="updateAluno">
		<table>
			<tr>
				<td><input type="text" name="id" readonly value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="turma" value="<%out.print(request.getAttribute("turma"));%>"></td>
			</tr>
		</table>
		<input class="Botao1" type="button" value="salvar" onclick="validar()">
	</form>
	<script src="scripts/validadorAluno.js"></script>
</body>
</html>