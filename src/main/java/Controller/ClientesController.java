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

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Model.ClienteBeans;
import Model.ClientesDAO;
import Model.ContaBeans;

@WebServlet(urlPatterns = { "/ClientesController", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class ClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientesDAO dao = new ClientesDAO();
	ClienteBeans cliente = new ClienteBeans();
	ContaBeans conta = new ContaBeans();

	public ClientesController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			clientes(request, response);
		} else if (action.equals("/insert")) {
			novoCliente(request, response);
		} else if (action.equals("/select")) {
			listarCliente(request, response);
		} else if (action.equals("/update")) {
			editarCliente(request, response);
		} else if (action.equals("/delete")) {
			removerCliente(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void clientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ClienteBeans> lista = dao.listarClientes();
		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("clientes.jsp");
		rd.forward(request, response);
	}

	protected void novoCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = new Date();
		cliente.setTipoPessoa(request.getParameter("tipo_pessoa"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setTelefone(request.getParameter("fone"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setDataCriado(sdf1.format(dt));

		dao.inserirCliente(cliente);
		response.sendRedirect("main");
	}

	protected void listarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcli = request.getParameter("idcli");
		cliente.setIdCli(idcli);
		dao.selecionarCliente(cliente);
		request.setAttribute("idcli", cliente.getIdCli());
		request.setAttribute("tipo_pessoa", cliente.getTipoPessoa());
		request.setAttribute("cpf", cliente.getCpf());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("telefone", cliente.getTelefone());
		request.setAttribute("email", cliente.getEmail());
		RequestDispatcher rd = request.getRequestDispatcher("editar-cliente.jsp");
		rd.forward(request, response);
	}

	protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cliente.setIdCli(request.getParameter("idcli"));
		cliente.setTipoPessoa(request.getParameter("tipo_pessoa"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setTelefone(request.getParameter("fone"));
		cliente.setEmail(request.getParameter("email"));
		dao.alterarCliente(cliente);
		response.sendRedirect("main");
	}

	protected void removerCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcli = request.getParameter("idcli");
		cliente.setIdCli(idcli);
		dao.deletarCliente(cliente);
		response.sendRedirect("main");
	}

	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Relatório de saldo de todos os clientes:"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Cliente"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Cliente desde"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Saldo em"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Valor"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			ArrayList<ClienteBeans> lista = dao.listarClientes();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getDataCriado());
				tabela.addCell(lista.get(i).getDataCriado());
				tabela.addCell("");
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}

}
