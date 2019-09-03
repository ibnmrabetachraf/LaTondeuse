package io;


import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import beans.util.DimensionPelouse;
import beans.util.PosDepart;
import commun.Controle;
import commun.IO;
import commun.Instructions;
import commun.Orientation;
import io.vavr.Tuple2;

class IOTest {

	DimensionPelouse dimensionPelouse ;
	List<Instructions> instructions;

	@BeforeEach
	void setUp() {
		Tuple2<DimensionPelouse, List<Instructions>> dimensionAndInstruction = null;
		try {
			dimensionAndInstruction = IO.getFileContent("src/test/resources/IO/fileForTest.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		dimensionPelouse =  dimensionAndInstruction._1;
		instructions= dimensionAndInstruction._2;
	}

	@Test
	void testGetFileContent() {
		assertThrows(IOException.class, () -> IO.getFileContent("src/test/resources/IO/azerty.txt"),"le fichier n'existe pas une exception doit être lancé");
		assertThrows(IllegalArgumentException.class, () -> IO.getFileContent("src/test/resources/IO/fileForTestFake.txt"),"Les Orientations ne sont pas bonne, une exception doit être lancé");
	}

	@Test
	void testPelouseDimensionExtracted() {

		//Test pour la dimension de la pelouse
		assertEquals(1,dimensionPelouse.getX(), "La dimension des abscisses pour la pelouse n'est pas correct");
		assertEquals(2, dimensionPelouse.getY(), "La dimension des ordonnées pour la pelouse n'est pas correct");
	}

	@Test
	void testInsructionsExtracted() {
		// Test les instructions
		// Chaque instruction représente une tondeuse donc c'est le nombre de Tondeuse à initier par l'odrdonnanceur
		List<Instructions> listExcepted = new ArrayList<Instructions>();
		listExcepted.add(new Instructions(new PosDepart(2, 3, Orientation.N), io.vavr.collection.List.of(Controle.G,Controle.A,Controle.G)));

		//test si on va instancier 2 Tondeuse par l'ordonanceur 
		assertEquals(2, instructions.size(),"le nombre d'element d'instructions n'est pas égale à 2");

		//test si chaque Instruction correspond au fichier d'entrée
		assertThat(instructions.get(0).getMouvements(), hasItems(Controle.G,Controle.A,Controle.G));
		assertThat(instructions.get(0).getPosDepart().getX(), is(2));
		assertThat(instructions.get(0).getPosDepart().getY(), is(3));
		assertThat(instructions.get(0).getPosDepart().getOrientation(), is(Orientation.N));
		
		assertThat(instructions.get(1).getMouvements(), hasItems(Controle.A,Controle.A,Controle.G));
		assertThat(instructions.get(1).getPosDepart().getX(), is(1));
		assertThat(instructions.get(1).getPosDepart().getY(), is(5));
		assertThat(instructions.get(1).getPosDepart().getOrientation(), is(Orientation.N));
	}

}
