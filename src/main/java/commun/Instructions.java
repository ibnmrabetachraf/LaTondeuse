package commun;


import beans.util.PosDepart;
import io.vavr.collection.List;

/**
 * Classe représente les instructions à executer
 * @author ibn
 *
 */
public class Instructions {
	
	private PosDepart posDepart;
	private List<Controle> mouvements;
	
	/**
	 * 
	 * @param posDepart La position de départ
	 * @param mouvements List de controle à executer
	 */
	public Instructions(PosDepart posDepart, List<Controle> mouvements) {
		super();
		this.posDepart = posDepart;
		this.mouvements = mouvements;
		
	}
	
	public PosDepart getPosDepart() {
		return posDepart;
	}
	public void setPosDepart(PosDepart posDepart) {
		this.posDepart = posDepart;
	}
	public List<Controle> getMouvements() {
		return mouvements;
	}
	public void setMouvements(List<Controle> mouvements) {
		this.mouvements = mouvements;
	}

	@Override
	public String toString() {
		return "InstructionRegister [posDepart=" + posDepart + ", mouvements=" + mouvements + "]";
	}
	
	


}
