package beans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import beans.util.DimensionPelouse;
import beans.util.PosDepart;
import commun.Controle;
import commun.Instructions;
import commun.Orientation;
import io.vavr.collection.List;

class TondeuseTest {
	
	Tondeuse tondeuse;
	
	@BeforeEach
	public void onSetUp() {
		Instructions instructions = new Instructions(new PosDepart(1, 2, Orientation.N), List.of(Controle.A,Controle.A,Controle.D));
		Pelouse pelouse = new Pelouse(new DimensionPelouse(2,3));
		tondeuse = new Tondeuse(instructions, pelouse);
	}
	

	/**
	 * Test l'execution d'une série
	 * Test si le GPS répond au commande de la tondeuse
	 */
	@Test
	void testExecute() {
		tondeuse.execute();
		assertEquals(3, tondeuse.getGps().getCellule().getActualY(),"La tondeuse devrait être en (1,3,E)");
		assertEquals(1, tondeuse.getGps().getCellule().getActualX(),"La tondeuse devrait être en (1,3,E)");
		assertEquals(Orientation.E, tondeuse.getGps().getOrientation(),"La tondeuse devrait être en (1,3,E)");
	}

	@Test
	void testGoDroite() {
		tondeuse.goDroite();
		tondeuse.goDroite();
		assertEquals(Orientation.S, tondeuse.getGps().getOrientation(),"La tondeuse devrait être orienté vers le sud");
	}

	@Test
	void testGoGauche() {
		tondeuse.goGauche();
		tondeuse.goGauche();
		assertEquals(Orientation.S, tondeuse.getGps().getOrientation(),"La tondeuse devrait être orienté vers le sud");
	}

	@Test
	void testAvancer() {
		tondeuse.avancer();
		assertEquals(3, tondeuse.getGps().getCellule().getActualY(),"La tondeuse devrait être en (1,3,N)");
		assertEquals(1, tondeuse.getGps().getCellule().getActualX(),"La tondeuse devrait être en (1,3,N)");
		assertEquals(Orientation.N, tondeuse.getGps().getOrientation(),"La tondeuse devrait être en (1,3,N)");
	}

}
