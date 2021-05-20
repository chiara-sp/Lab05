package it.polito.tdp.anagrammi.model;

import java.util.Set;

public class TestModel {
	public static void main(String[] args) {
      
		Model model= new Model();
		
		Set<String> an = model.calcolaAnagrammi("art");
		
		for(String s: an) {
			System.out.println(s+" "+ model.isCorretto(s));
		}
    }

}
