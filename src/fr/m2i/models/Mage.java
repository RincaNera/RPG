package fr.m2i.models;

public class Mage extends Combattant implements Berserker, Healer {
	
	public Mage(String nom, String prenom, String race) {
		super(nom, prenom, race, 100, 100, 100);
	}
	
	@Override
	public void crier() {
		System.out.println("EXPLOSION !");
	}

	@Override
	public void soigner() {
		System.out.println(String.format("%s se soigne 10 pts de vie !", this.getPrenom()));
		this.setPtsVie(this.getPtsVie() + 10);
	}

	@Override
	public void action(Combattant cible) {
		if (getPtsVie() > getPtsVieMax() / 2) {
			attaquer(cible);
		} else {
			soigner();
		}
	}

	@Override
	public void attaquer(Combattant victime) {
		crier();
		victime.subir(15);
	}
	
	
}
