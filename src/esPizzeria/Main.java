package esPizzeria;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Archivio obj = new Archivio();
		obj.initializeListaIngredienti();
		int menu = 0;
		do {
			System.out.println("0. Termina programma");
			System.out.println("1. Inserisci una pizza");
			System.out.println("2. Trova pizze senza un ingrediente specificato da te");
			System.out.println("3. Visualizza pizze con costo maggiore rispetto a ciò che hai inserito");
			System.out.println("4. Trova gli ingredienti di una pizza specificata da te");
			System.out.println("5. Visualizza la lista di Pizze Super");
			System.out.println("6. Visualizza la pizza più economica");

			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 0:
				System.out.println("Programma terminato con successo!");
				System.exit(0);
				break;
			case 1:
				
				obj.inserisciNuovaPizza();
				System.out.println("");
				break;

			case 2:
				obj.trovaPizzeSenzaIngrediente();
				System.out.println("");
				break;

			case 3:
				obj.pizzeCostose();
				System.out.println("");
				break;
				
			case 4:
				obj.trovaPizza();
				System.out.println("");
				break;
				
			case 5:
				obj.contaPizze();
				System.out.println("");
				break;
				
			case 6:
				obj.pizzaEconomica();
				System.out.println("");
				break;

			default:
				System.out.println("Scelta errata. Riprova.");
				System.out.println("");
				break;
			}
		} while (menu != 0);
		
		sc.close();
	}

}
