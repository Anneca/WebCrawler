package br.com.ufs.webcrawler.util;

import java.util.Date;
import java.util.TimerTask;

public class Agendador extends TimerTask {
	
	Date instanteAtual;

	@Override
	public void run() {
		instanteAtual = new Date();
		System.out.println(instanteAtual);
	}
}