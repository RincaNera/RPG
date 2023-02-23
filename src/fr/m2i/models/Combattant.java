package fr.m2i.models;

public abstract class Combattant {
	private final String nom;
	private final String prenom;
	private final String race;

	private int ptsVie;
	private int ptsMana;
	
	private final int ptsVieMax;
	
	public int getPtsVie() {
		return ptsVie;
	}
	public void setPtsVie(int ptsVie) {
		if (ptsVie > this.ptsVieMax) {
			this.ptsVie = this.ptsVieMax;
		} else {
			this.ptsVie = ptsVie;
		}
	}
	
	public int getPtsMana() {
		return ptsMana;
	}
	public void setPtsMana(int ptsMana) {
		this.ptsMana = ptsMana;
	}

	public int getPtsVieMax() {
		return ptsVieMax;
	}
	
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	public String getRace() {
		return race;
	}

	public Combattant() {
		this("Au bataillon", "Inconnu", "humain", 100, 0, 100);
	}
	
	public Combattant(String nom, String prenom) {
		this(nom, prenom, "humain", 100, 0, 100);
	}
	
	public Combattant(String nom, String prenom, String race, int ptsVie, int ptsMana, int ptsVieMax) {
		this.nom = nom;
		this.prenom = prenom;
		this.race = race;
		this.ptsVie = ptsVie;
		this.ptsMana = ptsMana;
		this.ptsVieMax = ptsVieMax;
	}

	/**
	 * Fait crier un combattant.
	 */
	public abstract void crier();
	
	/**
	 * Fait agir le combattant sur un autre combattant.
	 * @param cible Le combattant qui va subir l'action
	 */
	public abstract void action(Combattant cible);
	
	/**
	 * Réduit les points de vie du combattant.
	 * @param degats Le montant de points de vie à déduire
	 */
	public void subir(int degats) {
		System.out.println(String.format("%s subit %d points de dégâts !", this.getPrenom(), degats));
		this.ptsVie -= degats;
		System.out.println(String.format("%s a %d points de vie.", this.getPrenom(), this.getPtsVie()));
		if (this.ptsVie <= 0) {
			System.out.println(String.format("%s est mort !", this.prenom));
		}
	}
	
	/**
	 * Affiche les stats globales du combattant.
	 */
	public void status() {
		System.out.println(String.format("Nom : %s", this.nom));
		System.out.println(String.format("Prénom : %s", this.prenom));
		System.out.println(String.format("Points de vie : %d", this.ptsVie));
		System.out.println(String.format("Points de mana : %d", this.ptsMana));
	}
}
