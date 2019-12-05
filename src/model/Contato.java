package model;

public class Contato {
	private String nome, ende, bairro, cidade, uf, caoAdotado;
	public int id, num, telefone;
	public int setId;

	public Contato() {
	}

	public Contato(int id, String nome, int telefone, String ende, int num, String bairro, String cidade, String uf,
			String caoAdotado) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.ende = ende;
		this.num = num;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.caoAdotado = caoAdotado;
	}

	public Contato(String nome, int telefone, String ende, int num, String bairro, String cidade, String uf,
			String caoAdotado) {
		this.nome = nome;
		this.telefone = telefone;
		this.ende = ende;
		this.num = num;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.caoAdotado = caoAdotado;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnde() {
		return ende;
	}

	public void setEnde(String ende) {
		this.ende = ende;
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

	public String getCaoAdotado() {
		return caoAdotado;
	}

	public void setCaoAdotado(String caoAdotado) {
		this.caoAdotado = caoAdotado;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
