package config;


import java.util.List;

import beans.Pelouse;
import beans.Tondeuse;
import commun.Instructions;


/**
 * Cette classe est responsable sur l'ordonnancement des instructions à executer pour chaque Tondeuse sur une Pelouse
 * @author ibn
 *
 */
public class Ordonnanceur {
	
	public Ordonnanceur() {
		super();
	}
	
	// Execute la serie d'instructions
	public void execute(Pelouse pelouse , List<Instructions> instructions) {
		
		instructions.forEach(instr -> {
			System.out.println("initialisation d'une nouvelle tondeuse");
			new Tondeuse(instr, pelouse).execute();
		});
		
	}
	
	
	
}
