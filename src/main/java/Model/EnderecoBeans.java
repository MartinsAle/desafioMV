package Model;

public class EnderecoBeans {
	private String idEnd;
	private String idCli;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;

	public EnderecoBeans() {
		super();
	}

	public EnderecoBeans(String idEnd, String idCli, String rua, String numero, String complemento, String bairro,
			String cidade, String uf, String cep) {
		super();
		this.idEnd = idEnd;
		this.idCli = idCli;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public String getIdEnd() {
		return idEnd;
	}

	public void setIdEnd(String idEnd) {
		this.idEnd = idEnd;
	}

	public String getIdCli() {
		return idCli;
	}

	public void setIdCli(String idCli) {
		this.idCli = idCli;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
