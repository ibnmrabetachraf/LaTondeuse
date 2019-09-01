package beans;

import beans.util.DimensionPelouse;

public class Pelouse {

	private int longueur; // représenté par x
	private int largeur; // représenté par y


	public Pelouse(DimensionPelouse dimensionPelouse) {
		super();
		this.longueur = dimensionPelouse.getX();
		this.largeur = dimensionPelouse.getY();
	}

	/**
	 * Check si le pas suivant sera dans les dimensions de la pelouse
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean moveTo(int x, int y) {
		return (x <= this.longueur && y <= this.largeur); 
	}

	/**
	 * 
	 * Getters et setters
	 */
	
	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

}
