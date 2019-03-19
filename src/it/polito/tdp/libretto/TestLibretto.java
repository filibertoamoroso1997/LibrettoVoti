package it.polito.tdp.libretto;

import java.util.*;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto libr = new Libretto();
		libr.add(new Voto(30, "Analisi 1", LocalDate.of(2017, 1, 15)));
		libr.add(new Voto(21, "Analisi 2", LocalDate.of(2018, 1, 25)));
		libr.add(new Voto(25, "Fisica 1", LocalDate.of(2017, 6, 10)));
		libr.add(new Voto(28, "Fisica 2", LocalDate.of(2018, 9, 3)));
		libr.add(new Voto(18, "Geometria", LocalDate.of(2017, 9, 1)));
		libr.add(new Voto(20, "Economia", LocalDate.of(2018, 1, 28)));
		libr.add(new Voto(25, "Ricerca Operativa", LocalDate.of(2018, 6, 5)));
		libr.add(new Voto(24, "Complementi di economia", LocalDate.of(2018, 2, 15)));
		libr.add(new Voto(25, "Logistica", LocalDate.of(2019, 2, 1)));
		libr.add(new Voto(27, "Programmazione a oggetti", LocalDate.of(2019, 1, 25)));
		
		
		List<Voto> venticinque = libr.cercaVoti(25);
		System.out.println(venticinque);
		
		Voto a1 = libr.cercaEsame("Analisi 1");
		Voto a3 = libr.cercaEsame("Analisi 3");
		System.out.println(a1);
		System.out.println(a3);
		
		Voto giusto = new Voto(18, "Geometria", LocalDate.now());
		Voto sbagliato =  new Voto(28, "Geometria", LocalDate.now());
		Voto mancante = new Voto(30, "Merendine", LocalDate.now());
		System.out.format("Il voto %s � %s\n", giusto.toString(), libr.esisteGiaVoto(giusto));
		System.out.format("Il voto %s � %s\n", sbagliato.toString(), libr.esisteGiaVoto(sbagliato));
		System.out.format("Il voto %s � %s\n", mancante.toString(), libr.esisteGiaVoto(mancante));

		System.out.format("Il voto %s � in conflitto %s\n", giusto.toString(), libr.votoConflitto(giusto));
		System.out.format("Il voto %s � in conflitto %s\n", sbagliato.toString(), libr.votoConflitto(sbagliato));
		System.out.format("Il voto %s � in conflitto %s\n", mancante.toString(), libr.votoConflitto(mancante));
		
		libr.add(giusto);
		libr.add(sbagliato);
		libr.add(mancante);
		System.out.println(libr.toString());
		
		Libretto migliore = libr.librettoMigliorato();
		
		System.out.println("Miglioro il libretto");
		
		System.out.println(libr.toString());
		System.out.println(migliore.toString());
		
		migliore.cancellaVotiScarsi();
		System.out.println(migliore.toString());
		
	}

}
