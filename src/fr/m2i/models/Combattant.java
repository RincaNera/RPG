package fr.m2i.models;

public abstract class Combattant {
	private final String nom;
	private final String prenom;
	
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

	public Combattant() {
		this("Au bataillon", "Inconnu", 100, 0, 100);
	}
	
	public Combattant(String nom, String prenom) {
		this(nom, prenom, 100, 0, 100);
	}
	
	public Combattant(String nom, String prenom, int ptsVie, int ptsMana, int ptsVieMax) {
		this.nom = nom;
		this.prenom = prenom;
		this.ptsVie = ptsVie;
		this.ptsMana = ptsMana;
		this.ptsVieMax = ptsVieMax;
	}

	public abstract void crier();
	
	public abstract void action(Combattant victime);
	
	public void subir(int degats) {
		System.out.println(String.format("%s subit %d points de dégâts !", this.getPrenom(), degats));
		this.ptsVie -= degats;
		System.out.println(String.format("%s a %d points de vie.", this.getPrenom(), this.getPtsVie()));
		if (this.ptsVie <= 0) {
			System.out.println(String.format("%s est mort !", this.prenom));
		}
	}
	
	public void status() {
		System.out.println(String.format("Nom : %s", this.nom));
		System.out.println(String.format("Prénom : %s", this.prenom));
		System.out.println(String.format("Points de vie : %d", this.ptsVie));
		System.out.println(String.format("Points de mana : %d", this.ptsMana));
	}
}
