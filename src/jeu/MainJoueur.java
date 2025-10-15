package jeu;

import cartes.*;
import java.util.ArrayList;
import java.util.List;

public class MainJoueur {
	
	private List<Carte> listeCarte;
	
	public MainJoueur() {
		this.listeCarte = new ArrayList<>();
	}
	
	public void prendre(Carte carte) {
		listeCarte.add(carte);
	}
	
	public void jouer(Carte carte) {
		assert listeCarte.contains(carte);
		listeCarte.remove(carte);
	}
	
	public List<Carte> getListeCarte(){
		return listeCarte;
	}
	
	@Override
	public String toString() {
		
		StringBuilder main = new StringBuilder();
		
		for (Carte carte : listeCarte) {
			main.append(carte).append("");
		}
		return main.toString().trim();
	}

}
