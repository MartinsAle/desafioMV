/**
 * 	Validação de formulario
 */
 function validar(){
	let nome = frmCliente.nome.value
	let fone = frmCliente.fone.value
	if(nome === ""){
		alert('Preencha o campo Nome')
		fromContato.nome.focus()
		return false
	}else if(fone === ""){
		alert('Preencha o campo Fone')
		fromContato.fone.focus()
		return false
	}else{
		document.forms["frmCliente"].submit()
		document.forms["frmEndereco"].submit()
	}
}