package com.github.daniloruizdasilva.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * Classe Utils de utilitários 
 * @author Danilo Ruiz
 * @version 1.0
 */
public class Utils {
	
	/**
	 * Método para validar data informada
	 * 
	 * @author Danilo Ruiz
	 * @version 1.0
	 * @param dataInformada - Data informada
	 * @return true = válida, false = não válida
	 */
	public static boolean isDataValida(String dataInformada) {

	    try {
	    	
			dataInformada = dataInformada.replace("'","");

			DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("MM-dd-yyyy");

			// converte String para LocalDate
			LocalDate.parse(dataInformada, formatoData);
	        return true;
	    } catch (DateTimeParseException e) {
	       return false;
	    } 
	}

	/**
	 * Método para verificar se a data informada cai em um Sábado ou Domingo
	 * 
	 * @author Danilo Ruiz
	 * @version 1.0
	 * @param dataInformada - Data informada
	 * @return true = Fim de semana, false = Dia útil
	 */
	public static boolean isFimDeSemana(LocalDate dataInformada) {
		DayOfWeek diaDaSemana = dataInformada.getDayOfWeek();
		return diaDaSemana == DayOfWeek.SATURDAY || diaDaSemana == DayOfWeek.SUNDAY;
	}

	/**
	 * Método para verificar se a data informada cai em um Sábado ou Domingo
	 * @param dataInformada - Data informada
	 * @return true = Fim de semana, false = Dia útil
	 */
	public static boolean isFimDeSemana(String dataInformada) {
		
		dataInformada = dataInformada.replace("'","");

		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("MM-dd-yyyy");

		// converte String para LocalDate
		LocalDate ld = LocalDate.parse(dataInformada, formatoData);

		DayOfWeek diaDaSemana = ld.getDayOfWeek();
		return diaDaSemana == DayOfWeek.SATURDAY || diaDaSemana == DayOfWeek.SUNDAY;
	}

	/**
	 * Método para retornar o último dia útil anterior a data informada
	 * @param dataInformada - Data informada
	 * @return Último dia útil anterior a data informada
	 */
	public static LocalDate getUtilAnterior(String dataInformada) {

    	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    	
    	//converte String para LocalDate
    	LocalDate ld = LocalDate.parse(dataInformada, formatoData);
    	
    	LocalDate primeiraDataUtilAnterior = ld;
    	primeiraDataUtilAnterior = primeiraDataUtilAnterior.minusDays(1);
    	
    	//Enquanto a data cair em um final de semana subtrai um dia 
    	while (isFimDeSemana(primeiraDataUtilAnterior)) {
    		
    		primeiraDataUtilAnterior = primeiraDataUtilAnterior.minusDays(1);
    	}
     	  
    	return primeiraDataUtilAnterior;

	}

}
