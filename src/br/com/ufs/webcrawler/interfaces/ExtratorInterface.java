package br.com.ufs.webcrawler.interfaces;

public interface ExtratorInterface {

	/*
	 * Métodos que obrigatoriamente devem ser implementados pela Classe que
	 * implementar esta Interface
	 */
	public void extrairTecnologias(String url);

	public void extrairInformacoesHospital(String url);

	public void extrairAcessibilidade(String url);
}		
