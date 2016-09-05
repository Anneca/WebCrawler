package br.com.ufs.webcrawler.model;

public class FormularioTecnologia {
	
	int codigo;
	Formulario formulario;
	Tecnologia tecnologia;
	
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
	public Tecnologia getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}
	
	
}
