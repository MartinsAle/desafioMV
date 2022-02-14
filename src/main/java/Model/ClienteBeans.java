package Model;

public class ClienteBeans {
	private String idCli;
	private String tipoPessoa;
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private String dataCriado;
	
	public ClienteBeans() {
		super();
	}

	public ClienteBeans(String idCli, String tipoPessoa, String cpf, String nome, String telefone, String email,
			String dataCriado) {
		super();
		this.idCli = idCli;
		this.tipoPessoa = tipoPessoa;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataCriado = dataCriado;
	}

	public String getIdCli() {
		return idCli;
	}

	public void setIdCli(String idCli) {
		this.idCli = idCli;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataCriado() {
		return dataCriado;
	}

	public void setDataCriado(String dataCriado) {
		this.dataCriado = dataCriado;
	}
	
	
}
