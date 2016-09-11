package br.com.ufs.webcrawler.enumeration;
/**
 * Tags 
 * @author Anne Caroline Melo Santos
 *
 */
public enum Tags {
	a("a"), span("span"), div ("div"), p("p");
	
	public String nome;
	
	Tags(String nomeTag){
		nome = nomeTag;
	}
}
