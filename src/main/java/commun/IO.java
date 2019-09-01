package commun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import beans.util.DimensionPelouse;
import beans.util.PosDepart;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;

/**
 * Class responsable des lectures d'un fichier
 * @author ibn
 *
 */
public class IO {

	/**
	 * fonction lit un fichier et renvoit son contenu sous format d'un tuple de 2 : 
	 * @param pathToFile
	 * @return les dimensions de la pelouse et une liste d'instruction pour chaque tondeuse
	 */
	public static Tuple2<DimensionPelouse,java.util.List<Instructions>> getFileContent(String pathToFile) {

		Path path = Paths.get(pathToFile);
		String dimension;
		DimensionPelouse dimensionPelouse = null ;
		java.util.List<Instructions> content = new ArrayList<Instructions>();

		try {
			java.util.List<String> fileContent = Files.readAllLines(path);
			
			if(fileContent.isEmpty()) {
				throw new RuntimeException("le fichier est vide");
			}
			
			// On construit la'objet DimensionPelouse
			dimension = getDimension(fileContent);
			String[] pelouse = dimension.split(" ");
			dimensionPelouse = new DimensionPelouse(Integer.valueOf(pelouse[0]),Integer.valueOf(pelouse[1]));

			Iterator<String> it = fileContent.iterator();

			/**
			 * on parcours les lignes du fichiers 
			 * et construit au fur et à mesure des Objets Instruction 
			 * contenant une pos de depart et la suite d'instruction pour chaque Tondeuse
			 */
			while(it.hasNext()) {
				String posDeDepart = it.next();
				String instr = it.next();

				content.add(new Instructions(getInitialPos(posDeDepart), getMouvementssAsList(instr)));

			}
			
		} catch(java.util.NoSuchElementException e) {
			System.err.println("Le fichier est mal généré LigneN = position de la tondeuse \n LigneN+1 = les instructions");

		} catch(java.lang.IllegalArgumentException e) {
			System.err.println("Erreur dans le fichier: Une instruction non reconnu [N,E,W,S] pour les orientations géographiques , [D,G,A] pour les instructions");
			throw new RuntimeException(e);

		} catch(java.nio.file.NoSuchFileException e) {
			System.err.println("Ce fichier n'existe pas " +pathToFile);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return Tuple.of(dimensionPelouse,content);
	}

	/**
	 * Renvoie la première ligne du fichier qui contient les dimensions de la pelouse
	 * et le supprime de la list des contents
	 * @param contentFromFile
	 * @return
	 */
	private static String getDimension(java.util.List<String> contentFromFile) {

		String el = contentFromFile.get(0);
		contentFromFile.remove(0);
		return el;
	}

	/**
	 * Lit une série d'instruction représenté dans un String et converti en une List de Controle
	 * @param mouvements
	 * @return
	 * @throws java.lang.IllegalArgumentException
	 */
	private static List<Controle> getMouvementssAsList(String mouvements) throws java.lang.IllegalArgumentException{
		return List.ofAll(mouvements.toCharArray()).map(c -> Controle.valueOf(c.toString()));
	}

	/**
	 * Converti la position de départ et son orientation représenté par un String en PosDepart
	 * @param initialPos
	 * @return
	 * @throws java.lang.IllegalArgumentException
	 */
	private static PosDepart getInitialPos(String initialPos) throws java.lang.IllegalArgumentException{

		String[] initPos = initialPos.split(" ");
		PosDepart posDepart = null;
		posDepart = new PosDepart(Integer.valueOf(initPos[0]), Integer.valueOf(initPos[1]) , Orientation.valueOf(initPos[2]));
		return posDepart;
	}


}
