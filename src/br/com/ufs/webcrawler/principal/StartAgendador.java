package br.com.ufs.webcrawler.principal;

import java.util.Timer;

import br.com.ufs.webcrawler.util.Agendador;

public class StartAgendador {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timer timer = new Timer();
		Agendador agendador = new Agendador();
		timer.schedule(agendador, 0, 1000);
		while (true) {
			System.out.println("Alerta de execução ...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
