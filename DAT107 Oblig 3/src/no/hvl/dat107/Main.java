package no.hvl.dat107;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		AnsattDAO ansattDao = new AnsattDAO();
		Scanner sc = new Scanner(System.in);
		
		String userInput, userInput2, brukernavn, navn, etternavn, stilling, sjef, rolle = null;
		Integer lonn, avdelingA, ansattId, timer = null;
		LocalDate dato = null;
		boolean running = true;
		boolean erSjef = false;
		Ansatt ansatt = null;
		Avdeling avdeling = null;
		Prosjekt prosjekt = null;
		ProsjektDeltaker prosjektd = null;
		
		System.out.println("--------------------------------------------------");
		
		while (running) {
			System.out.println("A = Liste av ansatte");
			System.out.println("B = Sok etter ansatt med ansatt-ID");
			System.out.println("C = Sok etter ansatt med brukernavn");
			System.out.println("D = Endre stilling");
			
			userInput = sc.nextLine();
			
			switch (userInput) {
			case "A":
				ansattDao.skrivUtAlle();
				break;
			
			case "B":
				System.out.println("Skriv inn ID til ansatt");
				userInput = sc.nextLine();
				ansatt = ansattDao.finnAnsattMedId(Integer.parseInt(userInput));
				
				if (ansatt != null) {
					System.out.println(ansatt.toString());
				} else {
					System.out.println("Finnes ikke");
				}
				break;
			
			case "C":
				System.out.println("Skriv inn brukernavn");
				userInput = sc.nextLine();
				ansatt = ansattDao.finnAnsattMedBrukernavn(userInput);
				if (ansatt != null) {
					System.out.println(ansatt.toString());
				} else {
					System.out.println("Finnes ikke");
				}
				break;
			
			case "D":
				System.out.println("Skriv inn id");
				userInput = sc.nextLine();
				ansatt = ansattDao.finnAnsattMedId(Integer.parseInt(userInput));
				if(ansatt != null) {
					System.out.println("Skriv inn stilling");
					userInput2 = sc.nextLine();
					ansattDao.oppdaterStilling(userInput2, Integer.parseInt(userInput));
					System.out.println("Stilling har blitt endret til: " + userInput);
				} else {
					System.out.println("Finnes ikke");
				}
				break;
			}
			
		}
	}
	
}
