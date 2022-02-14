/**
 * Confirmação de exclusão de contato
 */
 
 function confirmar(idcli){
	let resposta = confirm("Confirmar a exclusão deste cliente?")
	if(resposta === true){
		window.location.href = "delete?idcli=" + idcli
	}
}