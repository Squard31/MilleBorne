package testsFonctionnels;

import cartes.*;
import jeu.*;

public class Testjeu {
	
	public static void main(String[] args) {
		
		Jeu jeu = new Jeu();
		Sabot sabot = jeu.getSabot();
		
		System.out.println("Pioche des 20 premières cartes");
		
		for (int i = 0 ; i < 20 && !sabot.estVide() ; i++) {
			Carte carte = sabot.piocher();
			System.out.println((i+1) + " " + carte);
		}
		
		int cpt = 0;
		
		while(!sabot.estVide()) {
			sabot.piocher();
			cpt++;
		}
		
		System.out.println("Nombre de carte piochées : " + cpt);
		System.out.println("Sabot vide : " + sabot.estVide());
	}
}
