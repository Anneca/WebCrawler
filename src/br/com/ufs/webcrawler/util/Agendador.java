package br.com.ufs.webcrawler.util;

import java.util.TimerTask;

import br.com.ufs.webcrawler.principal.Main;
/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */
public class Agendador extends TimerTask {
	
	Main principal;

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		principal = new Main();
		// Chamando a classe principal
		principal.main(null);
		System.out.println("Executou");
	}
}
