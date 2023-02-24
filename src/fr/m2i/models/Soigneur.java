package fr.m2i.models;

import fr.m2i.exceptions.DeadException;

public class Soigneur extends Combattant implements Healer {
	
	public Soigneur(String nom, String prenom, String race) {
		super(nom, prenom, race, 70, 150, 70);
	}
	
	@Override
	public void crier() {
		System.out.println("Loué soit le Soleil !");
	}

	@Override
	public void action(Combattant victime) throws DeadException {
		if(this.getPtsVie() <=0) {
			throw new DeadException(String.format("%s est déjà mort !", this.getPrenom()));
		}
		soigner();
	}

	@Override
	public void soigner() {
		System.out.println(String.format("%s se soigne 20 pts de vie !", this.getPrenom()));
		this.setPtsVie(this.getPtsVie() + 20);
	}
		
}
