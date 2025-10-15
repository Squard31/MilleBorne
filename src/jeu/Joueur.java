package jeu;

import java.util.Objects;

import cartes.*;

public class Joueur {
	
	private String nom;
	private ZoneDeJeu zone;
	private MainJoueur main;
	
	public Joueur (String nom) {
		this.nom = nom;
		this.zone = new ZoneDeJeu();
		this.main = new MainJoueur();
	}
	
	public ZoneDeJeu getZoneDeJeu() {
		return zone;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Joueur j = (Joueur) obj;
		return Objects.equals(nom, j.nom);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}
	
	@Override 
	public String toString() {
		return nom;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		
	}

}
