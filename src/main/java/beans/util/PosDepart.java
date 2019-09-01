package beans.util;

import commun.Orientation;

/**
 * Cette classe représente la position de départ de la tondeuse
 * @author ibn
 *
 */

public class PosDepart {
	
	int x;
	int y;
	Orientation orientation;
	
	public PosDepart(int x, int y, Orientation orientation) {
		super();
		this.x = x;
		this.y = y;
		this.orientation = orientation;
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
	public Orientation getOrientation() {
		return orientation;
	}
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	

}
