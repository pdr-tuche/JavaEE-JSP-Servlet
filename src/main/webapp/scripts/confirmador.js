/**
 * confirmacao de exclusao
 * @param id
 */

 function confirmar(id){
	 let resposta = confirm("confirma a exclusao deste contato ?")
	 if(resposta === true){
		 //alert("turma de id =" + id + " foi excluido")
		 window.location.href="delete?id=" + id
	 }
 }