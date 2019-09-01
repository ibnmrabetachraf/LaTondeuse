package config;

import java.util.List;

import beans.Pelouse;
import beans.util.DimensionPelouse;
import commun.IO;
import commun.Instructions;
import io.vavr.Tuple2;

/**
 * Classe représente l'API pour le client 
 * @author ibn
 *
 */
public class InstructionsRegister {
	
	Ordonnanceur ordonnanceur;
	
	public InstructionsRegister() {
		this.ordonnanceur = new Ordonnanceur();
	}
	
	/**
	 * Prend en entrée le fichier contenant les séries d'instruction
	 * @param path
	 */
	public void executeFromFile(String path) {
		
		Tuple2<DimensionPelouse, List<Instructions>> dimensionAndInstruction = readFromFile(path);
		
		//Initialise la Pelouse
		Pelouse pelouse = new Pelouse(dimensionAndInstruction._1);
		
		//Passe à l'ordonnance les series à executer sur une pelouse
		this.ordonnanceur.execute(pelouse, dimensionAndInstruction._2);
		
	}

	/**
	 * lit le fichier en utilisant IO
	 * @param path
	 * @return
	 */
	private Tuple2<DimensionPelouse, List<Instructions>> readFromFile(String path) {
		return IO.getFileContent(path);	
	}
	
	
	
	
	
}
