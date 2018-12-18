package esPizzeria;

import java.util.ArrayList;
import java.util.Scanner;

public class Archivio {

	Scanner sc = new Scanner(System.in);
	ArrayList<Pizza> listaPizze = new ArrayList<Pizza>();
	ArrayList<String> listaIngredienti = new ArrayList<String>();
	private static int count = 0;

	private String nomePizza;
	private String insIngredienti;
	private float prezzoPizza;
	boolean isPresent;
	
	private String ingredienteDaTogliere;

	private float prezzoImpostato;
	
	private String cercaPizza;
	
	public void initializeListaIngredienti() {

		String a = "Peperone";
		listaIngredienti.add(a);

		String b = "Prosciutto cotto";
		listaIngredienti.add(b);

		String c = "Prosciutto crudo";
		listaIngredienti.add(c);

		String d = "Funghi porcini";
		listaIngredienti.add(d);

		String e = "Parmigiano reggiano";
		listaIngredienti.add(e);

		String f = "Olive";
		listaIngredienti.add(f);

		String g = "Tonno";
		listaIngredienti.add(g);

		String i = "Salsiccie";
		listaIngredienti.add(i);

		String l = "Patatine";
		listaIngredienti.add(l);

		String m = "Mozzarella";
		listaIngredienti.add(m);
	}

	public void inserisciNuovaPizza() {
		ArrayList<String> listaIngredientiPerPizza = new ArrayList<String>();
			System.out.print("Nome della pizza: ");
			nomePizza = sc.nextLine();

			System.out.println("Ecco la lista degli ingredienti ");
			for (int i = 0; i < listaIngredienti.size(); i++) {
				System.out.println(listaIngredienti.get(i));
			}
			do {
				System.out.print("Scrivi ingrediente (lascia vuoto per terminare): ");
				insIngredienti = sc.nextLine();
				for (int j = 0; j < listaIngredienti.size(); j++) {
					if (insIngredienti.equalsIgnoreCase(listaIngredienti.get(j))) {
						listaIngredientiPerPizza.add(insIngredienti.toLowerCase());
						System.out.println("Ingrediente aggiunto! ");
					}
				}

			} while (!insIngredienti.equals(""));

			System.out.print("Prezzo (float): ");
			prezzoPizza = sc.nextFloat();
			sc.nextLine();

			if (listaIngredientiPerPizza.size() > 10) {
				Pizza a = new PizzaSuper(nomePizza, listaIngredientiPerPizza, prezzoPizza);
				listaPizze.add(a);
				count++;
				System.out.println("Pizza Super aggiunta! ");
			}
			else {
			Pizza p = new Pizza(nomePizza, listaIngredientiPerPizza, prezzoPizza);
			listaPizze.add(p);
			System.out.println("Pizza aggiunta!");
			}
	}

	public void trovaPizzeSenzaIngrediente() {
		boolean prova = false;
		do {
		System.out.print("Inserisci l'ingrediente da togliere: ");
		ingredienteDaTogliere = sc.nextLine();
		System.out.println("");
		for (int i = 0; i < listaPizze.size(); i++) {
			if (listaPizze.get(i).getListaIngredienti().contains(ingredienteDaTogliere.toLowerCase())) {
				prova = true;
			}
			else {
				prova = false;
				System.out.println(listaPizze.get(i));
			}
		}
		System.out.println("");
		System.out.println("Vuoi cercare senza un altro ingrediente (s/n) ?");
		}while(sc.nextLine().equalsIgnoreCase("s"));
	}

	public void pizzeCostose() {
		do {
		System.out.print("Inserisci il prezzo da cui partire (float): ");
		prezzoImpostato = sc.nextFloat();
		sc.nextLine();
		for (int i = 0; i < listaPizze.size(); i++) {
			if (listaPizze.get(i).getPrezzo() > prezzoImpostato) {
				System.out.println(listaPizze.get(i));
			}
		}
		System.out.println("");
		System.out.println("Vuoi cercare con un altro prezzo (s/n) ?");
		}while (sc.nextLine().equalsIgnoreCase("s"));
	}

	public void trovaPizza() {
		do {
		System.out.println("Ecco la lista dei nomi delle pizze");
		for (int i = 0; i < listaPizze.size(); i++) {
			System.out.println(listaPizze.get(i).getNome());
		}
		System.out.println("");
		System.out.print("Inserisci il nome della pizza di cui visualizzare gli ingredienti: ");
		cercaPizza = sc.nextLine();
		
		for (int j = 0; j < listaPizze.size(); j++) {
			if (listaPizze.get(j).getNome().equalsIgnoreCase(cercaPizza)) {
				System.out.println("Ecco la lista degli ingredienti della pizza: ");
				System.out.println(listaPizze.get(j).getListaIngredienti());
			}
		}
		System.out.println("");
		System.out.println("Vuoi cercare un'altra pizza (s/n) ?");
		}while(sc.nextLine().equalsIgnoreCase("s"));
	}

	public void contaPizze() {
		if (count > 0) {
		System.out.println("Ecco la lista di pizze Super: ");
		for (Pizza p : listaPizze) {
			if (p.getClass().equals(esPizzeria.PizzaSuper.class)) {
			System.out.println(p.toString());
			}
		}
		}
		else {
			System.out.println("Non ci sono pizze Super");
		}
	}

	public void pizzaEconomica() {
		Pizza p = null;
		float min = 1000;
		for (int i = 0; i < listaPizze.size(); i++) {
			if (listaPizze.get(i).getPrezzo() < min) {
				min = listaPizze.get(i).getPrezzo();
				p = listaPizze.get(i);
			}
		}
		System.out.println("Ecco la pizza più economica: " + p.toString());
	}
}
