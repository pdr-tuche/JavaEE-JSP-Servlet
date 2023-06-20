/**
 * validacao de form
 */

function validar(){
	let nome = formTurma.nome.value
	let turno = formTurma.turno.value
	
	if (nome === ""){
		alert("Preencha o campo nome da turma")
		formTurma.nome.focus()
		return false
	} else if(turno === ""){
		alert("Preencha o campo turno da turma")
		formTurma.turno.focus()
		return false
	}else {
		document.forms['formTurma'].submit()
	}
}