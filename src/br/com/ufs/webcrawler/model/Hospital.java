package br.com.ufs.webcrawler.model;

/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */

public class Hospital {

	String nome;
	int codigo;
	String url;
	Cidade cidade;
	Pais pais;
	String tipoOrganizacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getTipoOrganizacao() {
		return tipoOrganizacao;
	}

	public void setTipoOrganizacao(String tipoOrganizacao) {
		this.tipoOrganizacao = tipoOrganizacao;
	}

}
