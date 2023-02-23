package fr.m2i.domain;

import fr.m2i.models.Combattant;
import fr.m2i.models.Guerrier;
import fr.m2i.models.Mage;
import fr.m2i.models.Soigneur;

public class Start {

	public static void main(String[] args) {
		// Instancie 5 combattants
		Combattant[] combattants = {
				new Guerrier("Hurlenfer", "Garrosh"),
				new Mage("Proudmore", "Jaina"),
				new Soigneur("Wrynn", "Anduin"),
				new Guerrier("Barbe-de-Bronze", "Magni"),
				new Mage("Haut-Soleil", "Kael'Thas")
		};
		
		// Choisit les deux combattants qui vont se battre
		Combattant[] duelistes = choixCombattants(combattants);

		// Les deux combattants de battent
		Combattant vainqueur = combat(duelistes[0], duelistes[1], 20);
		
		// Affiche le vainqueur
		afficherVainqueur(vainqueur);
	}
	
	/**
	 * Choisit deux combattants parmi une liste de combattants.
	 * @param combattants Une liste de combattants
	 * @return Deux combattants
	 */
	public static Combattant[] choixCombattants(Combattant[] combattants) {
		Combattant[] duelistes = new Combattant[2];
		int premier = (int)(Math.random() * combattants.length);
		int deuxieme = -1;
		do {
			deuxieme = (int)(Math.random() * combattants.length);
		} while (deuxieme == premier);
		
		duelistes[0] = combattants[premier];
		duelistes[1] = combattants[deuxieme];
		return duelistes;
	}
	
	/**
	 * Fait se combattre deux combattants.
	 * 
	 * Les deux combattants se battent jusqu'à ce qu'un des deux n'ait plus de points de vie
	 * ou pendant 20 tours maximums. Le premier combattant choisit commence.
	 * 
	 * @param combattant1 Le premier combattant
	 * @param combattant2 Le deuxième combattant
	 * @param toursMax Le nombre de tour maximum
	 * @return Le combattant qui a le plus de points de vie à la fin du combat
	 */
	public static Combattant combat(Combattant combattant1, Combattant combattant2, int toursMax) {
		System.out.println(String.format("%s vs %s !", combattant1.getPrenom(), combattant2.getPrenom()));
		int tour = 0;
		while (combattant1.getPtsVie() > 0 && combattant2.getPtsVie() > 0 && tour < toursMax) {
			if (tour % 2 == 0) {
				combattant1.action(combattant2);
			} else {
				combattant2.action(combattant1);
			}
			tour++;
		}
		return combattant1.getPtsVie() > 0 ? combattant1 : combattant2;
	}
	
	/**
	 * Affiche le vainqueur du combat.
	 * @param vainqueur Le combattant qui a remporté la victoire
	 */
	public static void afficherVainqueur(Combattant vainqueur) {
		System.out.println(String.format("%s a gagné !", vainqueur.getPrenom()));
	}
	
	/*
	// Autre façon de faire agir les combattants avec un instanceof
	public static void action(Combattant combattant, Combattant victime) {
		if (combattant instanceof Guerrier) {
			((Guerrier) combattant).attaquer(victime);
		} else if (combattant instanceof Soigneur) {
			((Soigneur) combattant).soigner();
		} else if (combattant instanceof Mage) {
			if (combattant.getPtsVie() > combattant.getPtsVieMax() / 2) {
				((Mage) combattant).attaquer(victime);
			} else {
				((Mage) combattant).soigner();
			}
		}
	}
	*/

}
