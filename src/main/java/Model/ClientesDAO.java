package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class ClientesDAO {
	Conexao cn = new Conexao();

//	CRUD CREATE
	public void inserirCliente(ClienteBeans cliente) {
		OracleCallableStatement params = null;
		Connection con = cn.conectar();
		try {
			params = (OracleCallableStatement) con
					.prepareCall("BEGIN C##DEVELOPER.PCK_CLIENTE.CADASTRARCLIENTE(:1,:2,:3,:4,:5); END;");
			params.setString(1, cliente.getTipoPessoa());
			params.setString(2, cliente.getCpf());
			params.setString(3, cliente.getNome());
			params.setString(4, cliente.getTelefone());
			params.setString(5, cliente.getEmail());
			params.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	CRUD READ
	public ArrayList<ClienteBeans> listarClientes() {
		OracleCallableStatement params = null;
		Connection con = cn.conectar();
		ArrayList<ClienteBeans> clientes = new ArrayList<>();
		try {
			params = (OracleCallableStatement) con
					.prepareCall("BEGIN C##DEVELOPER.PCK_CLIENTE.LISTARCLIENTES(:1); END;");
			params.registerOutParameter(1, OracleTypes.CURSOR);
			params.execute();
			ResultSet rs = params.getCursor(1);
			while (rs.next()) {
				String idcli = rs.getString(1);
				String tipo_pessoa = rs.getString(2);
				String cpf = rs.getString(3);
				String nome = rs.getString(4);
				String telefone = rs.getString(5);
				String email = rs.getString(6);
				String data_criado = rs.getString(7);
				clientes.add(new ClienteBeans(idcli, tipo_pessoa, cpf, nome, telefone, email, data_criado));
			}
			con.close();
			return clientes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

//	CRUD UPDATE
	public void selecionarCliente(ClienteBeans clientes) {
		String read2 = "select * from clientes where idcli = ?";
		try {
			Connection con = cn.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, clientes.getIdCli());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				clientes.setIdCli(rs.getString(1));
				clientes.setTipoPessoa(rs.getString(2));
				clientes.setCpf(rs.getString(3));
				clientes.setNome(rs.getString(4));
				clientes.setTelefone(rs.getString(5));
				clientes.setEmail(rs.getString(6));
				clientes.setDataCriado(rs.getString(7));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alterarCliente(ClienteBeans clientes) {
		String update = "update clientes set cpf=?, nome=?, telefone=?, email=? where idcli = ?";
		try {
			Connection con = cn.conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, clientes.getCpf());
			pst.setString(2, clientes.getNome());
			pst.setString(3, clientes.getTelefone());
			pst.setString(4, clientes.getEmail());
			pst.setString(5, clientes.getIdCli());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	CRUD DELETE
	public void deletarCliente(ClienteBeans cliente) {
		String delete = "delete from clientes where idcli=?";
		try {
			Connection con = cn.conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, cliente.getIdCli());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
