package br.com.ufs.webcrawler.model;

public class FormularioRedesSociais {

	int codigo;
	Formulario formulario;
	RedeSocial redeSocial;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public RedeSocial getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(RedeSocial redeSocial) {
		this.redeSocial = redeSocial;
	}

}
