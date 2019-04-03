package it.polito.tdp.anagrammi.model;

public class TestModel {
	
	public static void main(String[] args) {
		Model m = new Model();
		m.genera("anna");
		
		for (Parola p : m.soluzioniCorrette) {
			System.out.println(p.toString());
		}
		
		
	}
}

	
