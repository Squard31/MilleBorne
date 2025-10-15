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

	// Test du melange avec le jeu de cartes

	private static void testMelangeAvecJeuDeCartes() {
		System.out.println("### Test Melange avec Jeu de Cartes ###\n");

		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();

		for (Carte carte : jeu.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}

		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);

		System.out.println("Liste originale (premiers elements) :");
		afficherDebut(listeCartes, 10);

		System.out.println("\nMelange de la liste...");
		listeCartes = GestionCartes.melanger(listeCartes);

		System.out.println("\n Liste melangee (premiers elements) :");
		afficherDebut(listeCartes, 10);

		boolean melangeOk = GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes);
		System.out.println("\nliste melangee sans erreur ? " + (melangeOk ? "âœ… true" : "â�Œ false"));

		System.out.println("\nListe rassemblee (premiers elements) :");
		afficherDebut(listeCartes, 20);

		boolean rassemblementOk = GestionCartes.verifierRassemblement(listeCartes);
		System.out.println("\n liste rassemblee sans erreur ? " + (rassemblementOk ? "âœ… true" : "â�Œ false"));
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

	// Test du rassemblement avec le jeu de cartes (version dÃ©taillÃ©e)

	private static void testRassemblementAvecJeuDeCartes() {
		System.out.println("### Test Rassemblement detaille avec Jeu de Cartes ###\n");

		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();

		for (Carte carte : jeu.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}

		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);

		System.out.println("Avant melange - Liste rassemblee ? " + GestionCartes.verifierRassemblement(listeCartes));

		listeCartes = GestionCartes.melanger(listeCartes);
		System.out.println("Apres melange - Liste rassemblee ? " + GestionCartes.verifierRassemblement(listeCartes));

		listeCartes = GestionCartes.rassembler(listeCartes);
		System.out.println(
				"Apres rassemblement - Liste rassemblee ? " + GestionCartes.verifierRassemblement(listeCartes));
	}

	// Teste le rassemblement pour une liste donnee

	private static <E> void testRassemblement(String nom, List<E> liste) {
		System.out.println("Test avec " + nom + " :");
		System.out.println("  Liste originale : " + liste);

		boolean avantRassemblement = GestionCartes.verifierRassemblement(liste);
		System.out.println("  Deja  rassemblee ? " + avantRassemblement);

		List<E> listeRassemblee = GestionCartes.rassembler(liste);
		System.out.println("  Apres rassemblement : " + listeRassemblee);

		boolean apresRassemblement = GestionCartes.verifierRassemblement(listeRassemblee);
		System.out.println("  Rassemblement OK ? " + (apresRassemblement ? "âœ… true" : "â�Œ false"));
		System.out.println();
	}

	// Affiche les n premiers elements d'une liste

	private static <E> void afficherDebut(List<E> liste, int n) {
		int count = 0;
		for (E element : liste) {
			if (count >= n)
				break;
			System.out.println("  " + element);
			count++;
		}
		if (liste.size() > n) {
			System.out.println("(" + (liste.size() - n) + " elements supplementaires)");
		}
	}
}