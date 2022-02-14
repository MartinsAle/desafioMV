package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EnderecosDAO {
	Conexao cn = new Conexao();

	public void inserirEndereco(EnderecoBeans endereco) {
		String seq = "select enderecos_seq.nextval from sys.dual";
		String create = "insert into enderecos(idend, idcli, rua, numero, complemento, bairro, cidade, uf, cep) values(?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = cn.conectar();
			PreparedStatement pstq = con.prepareStatement(seq);
			ResultSet rs = pstq.executeQuery();
			String idend = new String();
			if (rs.next()) {
				idend = rs.getString(1);
			}
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, idend);
			pst.setString(2, endereco.getIdCli());
			pst.setString(3, endereco.getRua());
			pst.setString(4, endereco.getNumero());
			pst.setString(5, endereco.getComplemento());
			pst.setString(6, endereco.getBairro());
			pst.setString(7, endereco.getCidade());
			pst.setString(8, endereco.getUf());
			pst.setString(9, endereco.getCep());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<EnderecoBeans> listarEnderecos() {
		ArrayList<EnderecoBeans> enderecos = new ArrayList<>();
		String read = "select * from enderecos order by idend";
		try {
			Connection con = cn.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idend = rs.getString(1);
				String idcli = rs.getString(2);
				String rua = rs.getString(3);
				String numero = rs.getString(4);
				String complemento = rs.getString(5);
				String bairro = rs.getString(6);
				String cidade = rs.getString(7);
				String uf = rs.getString(8);
				String cep = rs.getString(9);
				enderecos.add(new EnderecoBeans(idend, idcli, rua, numero, complemento, bairro, cidade, uf, cep));
			}
			con.close();
			return enderecos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void selecionarEndereco(EnderecoBeans enderecos) {
		String read2 = "select * from enderecos where idcli = ?";
		try {
			Connection con = cn.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, enderecos.getIdEnd());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				enderecos.setIdEnd(rs.getString(1));
				enderecos.setIdCli(rs.getString(2));
				enderecos.setRua(rs.getString(3));
				enderecos.setNumero(rs.getString(4));
				enderecos.setComplemento(rs.getString(5));
				enderecos.setBairro(rs.getString(6));
				enderecos.setCidade(rs.getString(7));
				enderecos.setUf(rs.getString(8));
				enderecos.setCep(rs.getString(9));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alterarEndereco(EnderecoBeans enderecos) {
		String update = "update enderecos set rua=?, numero=?, complemento=?, bairro=?, cidade=?, uf=?, cep=? where idend = ?";
		try {
			Connection con = cn.conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, enderecos.getRua());
			pst.setString(2, enderecos.getNumero());
			pst.setString(3, enderecos.getComplemento());
			pst.setString(4, enderecos.getBairro());
			pst.setString(4, enderecos.getCidade());
			pst.setString(4, enderecos.getUf());
			pst.setString(4, enderecos.getCep());
			pst.setString(5, enderecos.getIdEnd());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deletarEndereco(EnderecoBeans endereco) {
		String delete = "delete from enderecos where idend=?";
		try {
			Connection con = cn.conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, endereco.getIdEnd());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
