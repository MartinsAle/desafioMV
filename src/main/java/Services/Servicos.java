package Services;

import Controller.ClientesController;
import Model.ClienteBeans;
import Model.ClientesDAO;
import Model.ContaBeans;
import Model.ContasDAO;

public class Servicos {
	ClientesController clientes = new ClientesController();
	ContasDAO daoConta = new ContasDAO();
	ClientesDAO dao = new ClientesDAO();
//	ClienteBeans cliente = new ClienteBeans();
	
	public void abrirConta(ClienteBeans cliente, ContaBeans conta) {
		dao.inserirCliente(cliente);
		daoConta.inserirConta(conta);
	}
}
