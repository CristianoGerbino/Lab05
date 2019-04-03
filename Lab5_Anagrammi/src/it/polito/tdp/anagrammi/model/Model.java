package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {
	
	Set<Parola> soluzioniCorrette;
	Set<Parola> soluzioniErrate;
	
	public void genera (String parola) {
		
		Parola parziale = new Parola(parola);
		this.soluzioniCorrette = new HashSet<Parola>();
		this.soluzioniErrate = new HashSet<Parola>();
		this.cerca(parziale, 0);
	}

	private void cerca(Parola parziale, int L) {
		
		//Ultima iterazione
		if (L == parziale.getSize()) {
			if (esisteParola(parziale)) {
				soluzioniCorrette.add(parziale.clone());
			}
				else
					soluzioniErrate.add(parziale.clone());
		return;
		}
		
		
		for (char c : parziale.getParola().toCharArray()) {
			
			if (parziale.possoInserire(c)) {
				parziale.add(c);
				
				cerca (parziale, L+1);
				
				parziale.remove(c);
			}
		}
	}

	private boolean esisteParola(Parola parziale) {
		ParolaDAO dao = new ParolaDAO();
		return dao.esisteParola(parziale);
	}
}
