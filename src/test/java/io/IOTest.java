package io;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import beans.util.DimensionPelouse;
import beans.util.PosDepart;
import commun.Controle;
import commun.IO;
import commun.Instructions;
import commun.Orientation;
import io.vavr.Tuple2;

class IOTest {

	@Test
	void testGetFileContent() {
		
		Tuple2<DimensionPelouse, List<Instructions>> dimensionAndInstruction = IO.getFileContent("src/test/resources/IO/fileForTest.txt");
		
		DimensionPelouse dimensionPelouse =  dimensionAndInstruction._1;
		List<Instructions> instructions= dimensionAndInstruction._2;
				
		//Test pour la dimension de la pelouse
		assertEquals(1,dimensionPelouse.getX(), "La dimension des abscisses pour la pelouse n'est pas correct");
		assertEquals(2, dimensionPelouse.getY(), "La dimension des ordonnées pour la pelouse n'est pas correct");
		
		// Test les instructions
		// Chaque instruction représente une tondeuse donc c'est le nombre de Tondeuse à initier par l'odrdonnanceur
		List<Instructions> listExcepted = new ArrayList<Instructions>();
		listExcepted.add(new Instructions(new PosDepart(2, 3, Orientation.N), io.vavr.collection.List.of(Controle.G,Controle.A,Controle.G)));
		
		assertEquals(2, instructions.size(),"le nombre d'element d'instructions n'est pas égale à 2");
		
		
	}
	
}
