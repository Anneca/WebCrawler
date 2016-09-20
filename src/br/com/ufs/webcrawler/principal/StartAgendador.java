package br.com.ufs.webcrawler.principal;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;

import br.com.ufs.webcrawler.util.Agendador;
/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */
public class StartAgendador {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Data do dia corrente
		Calendar dataIni = new GregorianCalendar();

		// Seta a data inicial para o dia seguinte, ou seja, a próxima 00hs
		dataIni.add(Calendar.DAY_OF_MONTH, 1);// 1 dia após a data corrente

		// Seta a hora = 00:00 (Meia noite)
		dataIni.set(Calendar.HOUR_OF_DAY, 0);
		dataIni.set(Calendar.MINUTE, 0);
		dataIni.set(Calendar.SECOND, 0);

		// Instancia o timer
		Timer timer = new Timer();

		// Intervalo para executar a classe novamente
		// 86400 = qtd segundos em 24hs
		long periodo = 86400 * 1000;
		
		// Agenda a tarefa
		timer.scheduleAtFixedRate(new Agendador(), dataIni.getTime(), periodo);
		//timer.scheduleAtFixedRate(new Agendador(), new Date(System.currentTimeMillis()), 60000);
	}

}
