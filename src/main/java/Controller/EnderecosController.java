package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.EnderecoBeans;
import Model.EnderecosDAO;

@WebServlet(urlPatterns = { "/EnderecoController", "/endereco-main", "/endereco-insert", "/endereco-select",
		"/endereco-update", "/endereco-delete" })
public class EnderecosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EnderecosDAO dao = new EnderecosDAO();
	EnderecoBeans endereco = new EnderecoBeans();

	public EnderecosController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/endereco-main")) {
			enderecos(request, response);
		} else if (action.equals("/endereco-insert")) {
			novoEndereco(request, response);
		} else if (action.equals("/select")) {
			listarEndereco(request, response);
		} else if (action.equals("/endereco-update")) {
			editarEndereco(request, response);
		} else if (action.equals("/endereco-delete")) {
			removerEndereco(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void enderecos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<EnderecoBeans> lista = dao.listarEnderecos();
		request.setAttribute("enderecos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("enderecos.jsp");
		rd.forward(request, response);
	}

	protected void novoEndereco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcli = request.getParameter("idcli");
		endereco.setIdEnd(idcli);
		dao.selecionarEndereco(endereco);
		endereco.setIdCli(idcli);
		endereco.setRua(request.getParameter("rua"));
		endereco.setNumero(request.getParameter("numero"));
		endereco.setComplemento(request.getParameter("complemento"));
		endereco.setBairro(request.getParameter("bairro"));
		endereco.setBairro(request.getParameter("cidade"));
		endereco.setBairro(request.getParameter("uf"));
		endereco.setBairro(request.getParameter("cep"));
		dao.inserirEndereco(endereco);
		response.sendRedirect("endereco-main");
	}

	protected void listarEndereco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcli = request.getParameter("idcli");
		endereco.setIdEnd(idcli);
		dao.selecionarEndereco(endereco);
		request.setAttribute("idcli", endereco.getIdCli());
		request.setAttribute("rua", endereco.getRua());
		request.setAttribute("numero", endereco.getNumero());
		request.setAttribute("complemento", endereco.getComplemento());
		request.setAttribute("bairro", endereco.getBairro());
		request.setAttribute("cidade", endereco.getCidade());
		request.setAttribute("uf", endereco.getUf());
		request.setAttribute("cep", endereco.getCep());
		RequestDispatcher rd = request.getRequestDispatcher("editar-endereco.jsp");
		rd.forward(request, response);
	}

	protected void editarEndereco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		endereco.setIdEnd(request.getParameter("idEnd"));
		endereco.setRua(request.getParameter("rua"));
		endereco.setNumero(request.getParameter("numero"));
		endereco.setComplemento(request.getParameter("complemento"));
		endereco.setBairro(request.getParameter("bairro"));
		endereco.setCidade(request.getParameter("cidade"));
		endereco.setUf(request.getParameter("uf"));
		endereco.setCep(request.getParameter("cep"));
		dao.alterarEndereco(endereco);
		response.sendRedirect("endereco-main");
	}

	protected void removerEndereco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idend = request.getParameter("idend");
		endereco.setIdEnd(idend);
		dao.deletarEndereco(endereco);
		response.sendRedirect("endereco-main");
	}

}
