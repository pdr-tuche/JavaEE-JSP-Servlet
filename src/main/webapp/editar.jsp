<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>nova turma</title>
<link rel="icon" href="imagens/student.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar turma</h1>
	<form name="formTurma" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" readonly value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="turno" value="<%out.print(request.getAttribute("turno"));%>"></td>
			</tr>
		</table>
		<input class="Botao1" type="button" value="salvar" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>