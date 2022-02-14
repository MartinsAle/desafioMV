package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ContasDAO {
	Conexao cn = new Conexao();

//	CRUD CREATE
	public void inserirConta(ContaBeans conta) {
		String seq = "select contas_seq.nextval from sys.dual";
		String create = "insert into contas(idcon, idcli, mov_credito, mov_debito, saldo_inicial, saldo_final, data_criado) values(?,?,?,?,?,?,?)";
		try {
			Connection con = cn.conectar();
			PreparedStatement pstq = con.prepareStatement(seq);
			ResultSet rs = pstq.executeQuery();
			String idcon = new String();
			if (rs.next()) {
				idcon = rs.getString(1);
			}
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, idcon);
			pst.setString(2, conta.getIdCli());
			pst.setString(3, conta.getMovCredito());
			pst.setString(4, conta.getMovDebito());
			pst.setString(5, conta.getSaldoInicial());
			pst.setString(6, conta.getSaldoFinal());
			pst.setString(7, conta.getDataCriado());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	CRUD READ
	public ArrayList<ContaBeans> listarContas() {
		ArrayList<ContaBeans> contas = new ArrayList<>();
		String read = "select * from contas order by idcon";
		try {
			Connection con = cn.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idcon = rs.getString(1);
				String idcli = rs.getString(2);
				String mov_credito = rs.getString(3);
				String mov_debito = rs.getString(4);
				String saldo_inicial = rs.getString(5);
				String saldo_final = rs.getString(6);
				String data_criado = rs.getString(7);
				contas.add(new ContaBeans(idcon, idcli, mov_credito, mov_debito, saldo_inicial, saldo_final, data_criado));
			}
			con.close();
			return contas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

//	CRUD UPDATE
	public void selecionarConta(ContaBeans contas) {
		String read2 = "select * from contas where idcon = ?";
		try {
			Connection con = cn.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contas.getIdCon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contas.setIdCon(rs.getString(1));
				contas.setIdCli(rs.getString(2));
				contas.setMovCredito(rs.getString(3));
				contas.setMovDebito(rs.getString(4));
				contas.setSaldoInicial(rs.getString(5));
				contas.setSaldoFinal(rs.getString(6));
				contas.setDataCriado(rs.getString(7));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alterarConta(ContaBeans contas) {
		String update = "update contas set mov_credito=?, mov_debito=?, saldo_inicial=?, saldo_final=?, data_criado=? where idcon = ?";
		try {
			Connection con = cn.conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contas.getMovCredito());
			pst.setString(2, contas.getMovDebito());
			pst.setString(3, contas.getSaldoInicial());
			pst.setString(4, contas.getSaldoFinal());
			pst.setString(5, contas.getDataCriado());
			pst.setString(6, contas.getIdCon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	CRUD DELETE
	public void deletarConta(ContaBeans conta) {
		String delete = "delete from contas where idcon=?";
		try {
			Connection con = cn.conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, conta.getIdCon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
