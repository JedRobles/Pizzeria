package esPizzeria;

import java.util.ArrayList;

public class Pizza {

	private String nome;
	private float prezzo;
	private ArrayList<String> listaIngredienti;
	
	public Pizza(String nome, ArrayList<String> listaIngredienti, float prezzo) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.listaIngredienti = listaIngredienti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public ArrayList<String> getListaIngredienti() {
		return listaIngredienti;
	}

	public void setListaIngredienti(ArrayList<String> listaIngredienti) {
		this.listaIngredienti = listaIngredienti;
	}

	@Override
	public String toString() {
		if (getClass().equals(esPizzeria.Pizza.class)) {
		return "Pizza: " + nome + ", prezzo: " + prezzo + ", lista degli ingredienti: " + listaIngredienti;
		}
		else {
			return "Pizza Super: " + nome + ", prezzo: " + prezzo + ", lista degli ingredienti: " + listaIngredienti;
		}
	}
}
