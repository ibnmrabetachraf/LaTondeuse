package laTondeuse.Main;

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

			try {
				System.out.println("	1 -> Lire une série d'instruction d'un fichier");
				System.out.println("	0 -> exit");
				int choix = keyboard.nextInt();


				switch (choix) {

				case 0:
					stillRunning = false;
					break;
				case 1:

					System.out.println("Entrez le path du fichier avec le format correspondant");
					String path = keyboard2.nextLine();
					instructionsRegister.executeFromFile(path);
					break;

				default:
					System.out.println("Votre choix n'est pas référencé");
					break;
				}

				System.out.println("\n\nRejouer?");

			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("\n\nRejouer?");
				continue;
			}
		}


		keyboard.close();
		keyboard2.close();

	}

}
