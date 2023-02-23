package fr.m2i.models;

public interface Berserker {
	
	/**
	 * Le combattant réduit les points de vie d'un autre combattant.
	 * @param victime Le combattant qui va subir les dégâts
	 */
	public void attaquer(Combattant victime);
}
