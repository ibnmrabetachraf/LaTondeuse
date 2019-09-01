package beans;

import commun.Instructions;

public class Tondeuse {


	private final Instructions instructionRegister;
	private final Gps gps;
	private Pelouse pelouse;

	/**
	 * 
	 * @param instructionRegister les instructions à executer
	 * @param pelouse Sur la quelle on se déplace
	 */
	public Tondeuse(Instructions instructionRegister, Pelouse pelouse) {

		this.instructionRegister = instructionRegister;
		this.gps = new Gps(instructionRegister , pelouse);
	}

	/**
	 * Activer la tondeuse pour exécuter les instructions passés
	 */
	public void execute() {

		System.out.println("actually i'm in : " + gps.toString());
		this.instructionRegister.getMouvements().forEach(instruction -> {
			System.out.print("instruction:: "+instruction+" --> ");
			instruction.execute(this);
			System.out.println("End of instruction: " + gps.toString());
		});
		System.out.println("voici ma pos final :: " + gps.toString());
	}

	public void goDroite() {
		this.gps.goDroite();
	}

	public void goGauche() {
		this.gps.goGauche();
	}

	public void avancer() {
		this.gps.avancer();
	}

	public Pelouse getPelouse() {
		return pelouse;
	}

	public void setPelouse(Pelouse pelouse) {
		this.pelouse = pelouse;
	}

	public Instructions getInstructionRegister() {
		return instructionRegister;
	}

	public Gps getGps() {
		return gps;
	}
	
	


}
