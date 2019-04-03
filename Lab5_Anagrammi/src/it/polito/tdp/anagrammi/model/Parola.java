package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parola {
	
	private Map<Character, Integer> listaCompleta;
	private String parola;
	private List<Character> lista;
	private int size;
	
	public Parola (String parola) {
		listaCompleta = new HashMap<Character, Integer>();
		
		for (char c : parola.toCharArray()) {
			if (!listaCompleta.containsKey(c)) 
				this.listaCompleta.put(c, 1);
			else 
				this.listaCompleta.put(c, listaCompleta.get(c)+1);
		}
		
		lista = new ArrayList<Character>();
		this.size = parola.length();
		this.parola = parola;
	}

	public List<Character> getLista() {
		return lista;
	}

	public void setLista(List<Character> parola) {
		this.lista = parola;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public Parola clone() {
		Parola p = new Parola(this.parola);
		p.lista = new ArrayList<>(this.lista);
		return p;	
	}

	public void add(char c) {
		lista.add(c);
	}

	public void remove(char c) {
		Character t = c;
		lista.remove(t);
	}

	public boolean possoInserire(char c) {
		int num =0;
		
		for (char ca : lista) {
			if (ca == c) 
				num++;
		}
		
		if (this.listaCompleta.get(c) <= num)
			return false;
		
		return true;
	}
	
	public String toString () {
		String s = "";
		for (char c : lista) {
			s += c;
		}
		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parola other = (Parola) obj;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
