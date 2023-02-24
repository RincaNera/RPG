package fr.m2i.models;

import fr.m2i.exceptions.DeadException;

public interface Berserker {
	
	/**
	 * Le combattant réduit les points de vie d'un autre combattant.
	 * @param victime Le combattant qui va subir les dégâts
	 * @throws DeadException 
	 */
	public void attaquer(Combattant victime) throws DeadException;
}
