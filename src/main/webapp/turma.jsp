<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("turmas");
/*for (int i =0; i<lista.size(); i++){
	out.println(lista.get(i).getId());
	out.println(lista.get(i).getNome());
	out.println(lista.get(i).getTurno());
}*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Turmas existentes</title>
<link rel="icon" href="imagens/student.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Turmas existentes</h1>
	<a href="novo.html" class="Botao1">nova turma</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>id</th>
				<th>turno</th>
				<th>turma</th>
				<th>Opcoes</th>
			</tr>
		
		</thead>
		<tbody>
			<%for (int i=0; i<lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getId()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getTurno()%></td>
					<td><a href="select?id=<%=lista.get(i).getId()%>" class="Botao1">Editar</a>
					<td><a href="javascript:confirmar(<%=lista.get(i).getId()%>)" class="Botao1">Excluir</a>
				</tr>
			<%} %>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>