package beans;

import commun.Instructions;
import commun.Orientation;

/**
 * Cette classe représente le composant GPS dans la tondeuse qui gère les déplacements de la tondeuse
 * @author ibn
 *
 */
public class Gps {
	
	private Orientation orientation;
	private Cellule cellule;
	private Pelouse pelouse;
	
	/**
	 * 
	 * @param : instructionRegister les instructions à accéder
	 * @param pelouse : Sur la quelle on se déplace
	 */
	public Gps(Instructions instructionRegister, Pelouse pelouse) {
		super();
		this.orientation = instructionRegister.getPosDepart().getOrientation();
		this.cellule = new Cellule(instructionRegister.getPosDepart().getX(), instructionRegister.getPosDepart().getY());
		this.pelouse = pelouse;
	}
	
	/**
	 * Tourne vers la droite
	 */
	public void goDroite() {
		this.orientation = this.orientation.goRight();
	}
	
	/**
	 * tourne vers la gauche
	 */
	public void goGauche() {
		this.orientation = this.orientation.goLeft();
	}
	
	/**
	 * avancer d'une case
	 */
	public void avancer(){
		int nextX = cellule.getActualX() + orientation.getX();
		int nextY = cellule.getActualY() + orientation.getY();
		
		if(this.pelouse.moveTo(nextX, nextY)) {
			cellule.avancer(nextX, nextY);
		}
		
	}	
	
	/**
	 * 
	 * Getters et setters
	 */
	
	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Cellule getCellule() {
		return cellule;
	}

	public void setCellule(Cellule cellule) {
		this.cellule = cellule;
	}

	public Pelouse getPelouse() {
		return pelouse;
	}

	public void setPelouse(Pelouse pelouse) {
		this.pelouse = pelouse;
	}

	@Override
	public String toString() {
		return "orientation: " + orientation + ", cellule: " + cellule;
	}

	
	
	
	

}
