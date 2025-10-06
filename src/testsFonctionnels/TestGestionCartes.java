package testsFonctionnels;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import cartes.*;
import utils.GestionCartes;

public class TestGestionCartes {

	public static void main(String[] args) {
		testMelangeAvecJeuDeCartes();
		System.out.println("\n" + "=".repeat(60) + "\n");
		testRassemblementAvecEntiers();
		System.out.println("\n" + "=".repeat(60) + "\n");
		testRassemblementAvecJeuDeCartes();
	}

	// Test du mélange avec le jeu de cartes

	private static void testMelangeAvecJeuDeCartes() {
		System.out.println("### Test Mélange avec Jeu de Cartes ###\n");

		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();

		for (Carte carte : jeu.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}

		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);

		System.out.println("Liste originale (premiers éléments) :");
		afficherDebut(listeCartes, 10);

		System.out.println("\nMélange de la liste...");
		listeCartes = GestionCartes.melanger(listeCartes);

		System.out.println("\nListe mélangée (premiers éléments) :");
		afficherDebut(listeCartes, 10);

		boolean melangeOk = GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes);
		System.out.println("\nliste mélangée sans erreur ? " + (melangeOk ? "✅ true" : "❌ false"));

		System.out.println("\nListe rassemblée (premiers éléments) :");
		afficherDebut(listeCartes, 20);

		boolean rassemblementOk = GestionCartes.verifierRassemblement(listeCartes);
		System.out.println("\nliste rassemblée sans erreur ? " + (rassemblementOk ? "✅ true" : "❌ false"));
	}

	// Test du rassemblement avec des listes d'entiers

	private static void testRassemblementAvecEntiers() {
		System.out.println("### Test Rassemblement avec Entiers ###\n");

		// Test avec liste vide
		List<Integer> listeVide = new ArrayList<>();
		testRassemblement("[]", listeVide);

		// Test avec [1;1;2;1;3]
		List<Integer> liste1 = new ArrayList<>();
		liste1.add(1);
		liste1.add(1);
		liste1.add(2);
		liste1.add(1);
		liste1.add(3);
		testRassemblement("[1;1;2;1;3]", liste1);

		// Test avec [1;4;3;2]
		List<Integer> liste2 = new ArrayList<>();
		liste2.add(1);
		liste2.add(4);
		liste2.add(3);
		liste2.add(2);
		testRassemblement("[1;4;3;2]", liste2);

		// Test avec [1;1;2;3;1]
		List<Integer> liste3 = new ArrayList<>();
		liste3.add(1);
		liste3.add(1);
		liste3.add(2);
		liste3.add(3);
		liste3.add(1);
		testRassemblement("[1;1;2;3;1]", liste3);
	}

	// Test du rassemblement avec le jeu de cartes (version détaillée)

	private static void testRassemblementAvecJeuDeCartes() {
		System.out.println("### Test Rassemblement détaillé avec Jeu de Cartes ###\n");

		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();

		for (Carte carte : jeu.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}

		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);

		System.out.println("Avant mélange - Liste rassemblée ? " + GestionCartes.verifierRassemblement(listeCartes));

		listeCartes = GestionCartes.melanger(listeCartes);
		System.out.println("Après mélange - Liste rassemblée ? " + GestionCartes.verifierRassemblement(listeCartes));

		listeCartes = GestionCartes.rassembler(listeCartes);
		System.out.println(
				"Après rassemblement - Liste rassemblée ? " + GestionCartes.verifierRassemblement(listeCartes));
	}

	// Teste le rassemblement pour une liste donnée

	private static <E> void testRassemblement(String nom, List<E> liste) {
		System.out.println("Test avec " + nom + " :");
		System.out.println("  Liste originale : " + liste);

		boolean avantRassemblement = GestionCartes.verifierRassemblement(liste);
		System.out.println("  Déjà rassemblée ? " + avantRassemblement);

		List<E> listeRassemblee = GestionCartes.rassembler(liste);
		System.out.println("  Après rassemblement : " + listeRassemblee);

		boolean apresRassemblement = GestionCartes.verifierRassemblement(listeRassemblee);
		System.out.println("  Rassemblement OK ? " + (apresRassemblement ? "✅ true" : "❌ false"));
		System.out.println();
	}

	// Affiche les n premiers éléments d'une liste

	private static <E> void afficherDebut(List<E> liste, int n) {
		int count = 0;
		for (E element : liste) {
			if (count >= n)
				break;
			System.out.println("  " + element);
			count++;
		}
		if (liste.size() > n) {
			System.out.println("  ... (" + (liste.size() - n) + " éléments supplémentaires)");
		}
	}
}