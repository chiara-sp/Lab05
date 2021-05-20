package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.dao.AnagrammaDAO;

public class Model {

	AnagrammaDAO dao = new AnagrammaDAO();
	
	public Set<String> calcolaAnagrammi(String parola){
		
		Set<String> anagrammi= new HashSet<>();
		String parziale="";
		cerca(parziale,parola,0,anagrammi);
		return anagrammi;
	}

	private void cerca(String parziale, String lettere, int livello, Set<String> anagrammi) {
		
		//caso terminale
		if(livello==lettere.length()) {
			anagrammi.add(parziale);
		}else {
			for(int pos=0;pos<lettere.length();pos++) {
				if(charCounter(parziale,lettere.charAt(pos))<charCounter(lettere, lettere.charAt(pos))) {
				parziale+= lettere.charAt(pos);
				cerca(parziale,lettere,livello+1,anagrammi);
				parziale= parziale.substring(0,parziale.length()-1);
				}
			}
		}
		
		//ricorsivo 
		
	}

	private int charCounter(String parziale, char charAt) {
		int count=0;
		for(int i=0; i<parziale.length();i++) {
			if(parziale.charAt(i)==charAt)
				count++;
		}
		return count;
	}
	
	public boolean isCorretto(String anagramma) {
		return dao.isCorretto(anagramma);
	}
}
