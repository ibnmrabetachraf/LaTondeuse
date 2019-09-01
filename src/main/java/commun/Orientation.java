package commun;

import io.vavr.collection.List;

/**
 * 
 * @author ibn
 *
 * Pour Les Orientations N,E,S,W la trigonometrie est la science idéal pour calculer les coordonnées de chaque rotation
 * Un cours qui démontre la formule pour trouver les coordonnées d'un point après chaque rotation : https://www.youtube.com/watch?v=OYuoPTRVzxY
 * Si notre angle de rotation est toujours à 90° pour tourner à gauche ou -90° pour la droite
 * alors: (x1,y1) = (-y0,x0) pour la gauche
 * et (x1,y1) = (y0,-x0) pour la droite
 */

public enum Orientation {
	
	N(0,1), //Orientation vers le nord
	E(1,0), // Orientation vers l'est
	W(-1,0), // Orientation vers l'ouest
	S(0,-1); //Orientation vers le sud
	
	private Orientation(int x, int y) {
		this.x = x;
		this.y = y;
		
	}

	int x;
	int y;
	
	/**
	 * On tourne à gauche en passant à rotate (x,y) les coordonnées d'une rotation à 90°
	 * @return
	 */
	public Orientation goLeft() {
		return rotate(-y, x);
	}
	
	/**
	 * On tourne à droite en passant à rotate (x,y) les coordonnées d'une rotation à 90°
	 * @return
	 */
	public Orientation goRight() {
		return rotate(y, -x);
	}
	
	/**
	 * Renvoie l'orientation correspondante à x et y après une rotation
	 * @param x
	 * @param y
	 * @return
	 */
	private Orientation rotate(int x , int y ) {		
		return List.of(values()).find(element -> element.x == x && element.y == y).get();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
