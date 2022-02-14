package Model;

public class ContaBeans {
	private String idCon;
	private String idCli;
	private String movCredito;
	private String movDebito;
	private String saldoInicial;
	private String saldoFinal;
	private String dataCriado;

	public ContaBeans() {
		super();
	}

	public ContaBeans(String idCon, String idCli, String movCredito, String movDebito, String saldoInicial,
			String saldoFinal, String dataCriado) {
		super();
		this.idCon = idCon;
		this.idCli = idCli;
		this.movCredito = movCredito;
		this.movDebito = movDebito;
		this.saldoInicial = saldoInicial;
		this.saldoFinal = saldoFinal;
		this.dataCriado = dataCriado;
	}

	public String getIdCon() {
		return idCon;
	}

	public void setIdCon(String idCon) {
		this.idCon = idCon;
	}

	public String getIdCli() {
		return idCli;
	}

	public void setIdCli(String idCli) {
		this.idCli = idCli;
	}

	public String getMovCredito() {
		return movCredito;
	}

	public void setMovCredito(String movCredito) {
		this.movCredito = movCredito;
	}

	public String getMovDebito() {
		return movDebito;
	}

	public void setMovDebito(String movDebito) {
		this.movDebito = movDebito;
	}

	public String getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(String saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public String getSaldoFinal() {
		return saldoFinal;
	}

	public void setSaldoFinal(String saldoFinal) {
		this.saldoFinal = saldoFinal;
	}

	public String getDataCriado() {
		return dataCriado;
	}

	public void setDataCriado(String dataCriado) {
		this.dataCriado = dataCriado;
	}

}
