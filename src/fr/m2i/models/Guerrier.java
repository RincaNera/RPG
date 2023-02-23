package fr.m2i.models;

public class Guerrier extends Combattant implements Berserker {
	
	public Guerrier(String nom, String prenom) {
		super(nom, prenom, 150, 50, 150);
	}
	
	@Override
	public void crier() {
		System.out.println("Ounga Bounga !");
	}
	
	@Override
	public void action(Combattant victime) {
		attaquer(victime);
	}

	@Override
	public void attaquer(Combattant victime) {
		crier();
		victime.subir(25);
	}
	
}
