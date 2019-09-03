package laTondeuse.Main;

import java.io.IOException;
import java.util.Scanner;

import config.InstructionsRegister;

public class Main {

	public static void main(String[] args) {

		InstructionsRegister instructionsRegister = new InstructionsRegister();
		Scanner keyboard = new Scanner(System.in);
		Scanner keyboard2 = new Scanner(System.in);
		boolean stillRunning = true;

		System.out.println("Bonjour veuillez choisir une option:");




		while(stillRunning) {

			
				System.out.println("	1 -> Lire une série d'instruction d'un fichier");
				System.out.println("	0 -> exit");
				int choix = keyboard.nextInt();


				switch (choix) {

				case 0:
					stillRunning = false;
					break;
				case 1:
					try {
						System.out.println("Entrez le path du fichier avec le format correspondant");
						String path = keyboard2.nextLine();
						instructionsRegister.executeFromFile(path);

					} catch(java.util.NoSuchElementException e) {
						System.err.println("Le fichier est mal généré LigneN = position de la tondeuse \n LigneN+1 = les instructions");

					} catch(java.lang.IllegalArgumentException e) {
						System.err.println("Erreur dans le fichier: Une instruction non reconnu [N,E,W,S] pour les orientations géographiques , [D,G,A] pour les instructions");

					} catch(IOException e) {
						System.err.println("Erreur de lecture du fichier ");

					} 
					break;

				default:
					System.out.println("Votre choix n'est pas référencé");
					break;
				}

				System.out.println("\n\nRejouer?");

			
		}


		keyboard.close();
		keyboard2.close();

	}

}
