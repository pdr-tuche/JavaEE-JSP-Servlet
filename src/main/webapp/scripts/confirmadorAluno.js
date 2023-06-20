/**
 * confirmacao de exclusao de aluno
 * @param id
 */

 function confirmar(id){
	 let resposta = confirm("confirma a exclusao deste Aluno ?")
	 if(resposta === true){
		 window.location.href="deleteAluno?id=" + id
	 }
 }