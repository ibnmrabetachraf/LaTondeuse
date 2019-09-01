package beans;

/**
 * Classe représente la position actuel de la tondeuse
 * @author ibn
 *
 */
public class Cellule {

	private int actualX;
	private int actualY;
	
	
	public Cellule(int actualX, int actualY) {
		super();
		this.actualX = actualX;
		this.actualY = actualY;
	}
	
	public void avancer(int nextX, int nextY ) {
		this.actualX = nextX;
		this.actualY = nextY;
	}
	
	public int getActualX() {
		return actualX;
	}

	public void setActualX(int actualX) {
		this.actualX = actualX;
	}

	public int getActualY() {
		return actualY;
	}

	public void setActualY(int actualY) {
		this.actualY = actualY;
	}

	@Override
	public String toString() {
		return "actualX: " + actualX + ", actualY: " + actualY;
	}
	
	
	
	
}
