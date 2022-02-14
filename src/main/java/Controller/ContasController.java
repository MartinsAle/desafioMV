package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ContaBeans;
import Model.ContasDAO;

@WebServlet(urlPatterns = { "/ContasController", "/conta-main", "/conta-insert", "/conta-select", "/conta-update",
		"/conta-delete", "/conta-report" })
public class ContasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContasDAO dao = new ContasDAO();
	ContaBeans conta = new ContaBeans();

	public ContasController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/conta-main")) {
			contas(request, response);
		} else if (action.equals("/conta-insert")) {
			novaConta(request, response);
		} else if (action.equals("/conta-select")) {
			listarConta(request, response);
		} else if (action.equals("/conta-update")) {
			editarConta(request, response);
		} else if (action.equals("/conta-delete")) {
			removerConta(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void contas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ContaBeans> lista = dao.listarContas();
		request.setAttribute("contas", lista);
		RequestDispatcher rd = request.getRequestDispatcher("clientes.jsp");
		rd.forward(request, response);
	}

	protected void novaConta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = new Date();
		conta.setIdCli(request.getParameter("idcli"));
		conta.setMovCredito(request.getParameter("mov_credito"));
		conta.setMovDebito(request.getParameter("mov_debito"));
		conta.setSaldoInicial(request.getParameter("saldo_inicial"));
		conta.setSaldoFinal(request.getParameter("saldo_final"));
		conta.setDataCriado(sdf1.format(dt));

		dao.inserirConta(conta);
		response.sendRedirect("nova-conta.jsp");
	}

	protected void listarConta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		conta.setIdCli(idcon);
		dao.selecionarConta(conta);
		request.setAttribute("idcon", conta.getIdCon());
		request.setAttribute("idcli", conta.getIdCli());
		request.setAttribute("mov_credito", conta.getMovCredito());
		request.setAttribute("mov_debito", conta.getMovDebito());
		request.setAttribute("saldo_inicial", conta.getSaldoInicial());
		request.setAttribute("saldo_final", conta.getSaldoFinal());
		RequestDispatcher rd = request.getRequestDispatcher("editar-conta.jsp");
		rd.forward(request, response);
	}

	protected void editarConta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = new Date();
		conta.setIdCon(request.getParameter("idcon"));
		conta.setIdCli(request.getParameter("cliente_id"));
		conta.setMovCredito(request.getParameter("mov_credito"));
		conta.setMovDebito(request.getParameter("mov_debito"));
		conta.setSaldoInicial(request.getParameter("saldo_inicial"));
		conta.setSaldoFinal(request.getParameter("saldo_final"));
		conta.setDataCriado(sdf1.format(dt));
		dao.alterarConta(conta);
		response.sendRedirect("clientes.jsp");
	}

	protected void removerConta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		conta.setIdCli(idcon);
		dao.deletarConta(conta);
		response.sendRedirect("clientes.jsp");
	}

}
