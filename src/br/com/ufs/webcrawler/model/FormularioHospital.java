package br.com.ufs.webcrawler.model;

public class FormularioHospital {
	
	int codigo;
	Formulario formulario;
	Hospital hospital;
	
	//-----------------------------Getters And Setters----------------------
	
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
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
}
