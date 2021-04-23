package br.com.fiap.tds.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteData {

	public static void main(String[] args) {
		
		//Instanciar um objeto de dara com a data atual
		Calendar hoje = Calendar.getInstance(); //Data de hoje
		
		//Instanciar um objeto de data com uma data específica (entrega da challenge)
		Calendar challenge = new GregorianCalendar(2021, Calendar.MAY, 15);
		
		//Formatador de data
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		//Exibir a data
		System.out.println(formatador.format(hoje.getTime()));
		System.out.println(formatador.format(challenge.getTime()));
	}
}
