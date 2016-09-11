package br.com.ufs.webcrawler.interfaces;

import br.com.ufs.webcrawler.model.Formulario;
/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */
public interface ExtratorInterface {

	/*
	 * Métodos que obrigatoriamente devem ser implementados pela Classe que
	 * implementar esta Interface
	 */
	public void extrairTecnologias(String url);

	public Formulario extrairInformacoesHospital(String url);

	public void extrairAcessibilidade(String url);
	
	public void extrairRedesSociais(String url);

}		
