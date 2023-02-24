package fr.m2i.models;

import fr.m2i.exceptions.DeadException;

public class Guerrier extends Combattant implements Berserker {
	
	public Guerrier(String nom, String prenom, String race) {
		super(nom, prenom, race, 150, 50, 150);
	}
	
	@Override
	public void crier() {
		System.out.println("Ounga Bounga !");
	}
	
	@Override
	public void action(Combattant victime) throws DeadException {
		if(this.getPtsVie() <=0) {
			throw new DeadException(String.format("%s est déjà mort !", this.getPrenom()));
		}
		attaquer(victime);
	}

	@Override
	public void attaquer(Combattant victime) throws DeadException {
		crier();
			victime.subir(25);
	}
	
}
