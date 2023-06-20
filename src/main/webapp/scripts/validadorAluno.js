function validar(){
	let nome = formAluno.nome.value
	let turma = formAluno.turma.value
	
	if (nome === ""){
		alert("Preencha o campo nome do Aluno")
		formAluno.nome.focus()
		return false
	} else if(turma === ""){
		alert("Preencha o campo turma do Aluno")
		formAluno.turma.focus()
		return false
	}else {
		document.forms['formAluno'].submit()
	}
}