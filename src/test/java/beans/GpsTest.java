package beans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import beans.util.DimensionPelouse;
import beans.util.PosDepart;
import commun.Controle;
import commun.Instructions;
import commun.Orientation;
import io.vavr.collection.List;

class GpsTest {
	
	Gps gps;
	
	@BeforeEach
	public void onSetUp() {
		Instructions instructions = new Instructions(new PosDepart(1, 2, Orientation.N), List.of(Controle.A,Controle.A,Controle.D));
		Pelouse pelouse = new Pelouse(new DimensionPelouse(2,3));
		gps = new Gps(instructions, pelouse);
	}
	
	@Test
	void testPositionDeDepart() {
		assertEquals(this.gps.getCellule().getActualX(),1,"X de la pos de départ n'est correct");
		assertEquals(this.gps.getCellule().getActualY(),2,"Y de la pos de départ n'est correct");
		assertEquals(this.gps.getOrientation(),Orientation.N,"L'orientation n'est correct");
	}

	@Test
	void testGoDroite() {
		// On test une rotation 360° vers la droite
		this.gps.goDroite();
		assertEquals(this.gps.getCellule().getActualX(),1,"X de la pos n'est correct");
		assertEquals(this.gps.getCellule().getActualY(),2,"Y de la pos n'est correct");
		assertEquals(Orientation.E,this.gps.getOrientation(),"L'orientation n'est correct");
		this.gps.goDroite();
		assertEquals(Orientation.S,this.gps.getOrientation(),"L'orientation n'est correct");
		this.gps.goDroite();
		assertEquals(Orientation.W,this.gps.getOrientation(),"L'orientation n'est correct");
		this.gps.goDroite();
		assertEquals(Orientation.N,this.gps.getOrientation(),"L'orientation n'est correct");
		
		
	}

	@Test
	void testGoGauche() {
		// On test une rotation 360° vers la gauche
		this.gps.goGauche();
		assertEquals(this.gps.getCellule().getActualX(),1,"X de la pos n'est correct");
		assertEquals(this.gps.getCellule().getActualY(),2,"Y de la pos n'est correct");
		assertEquals(Orientation.W,this.gps.getOrientation(),"L'orientation n'est correct");
		this.gps.goGauche();
		assertEquals(Orientation.S,this.gps.getOrientation(),"L'orientation n'est correct");
		this.gps.goGauche();
		assertEquals(Orientation.E,this.gps.getOrientation(),"L'orientation n'est correct");
		this.gps.goGauche();
		assertEquals(Orientation.N,this.gps.getOrientation(),"L'orientation n'est correct");
	}

	@Test
	void testAvancer() {
		//On test le changement de position jusqu'à arriver au bord de la pelouse
		this.gps.avancer();
		assertEquals(1,this.gps.getCellule().getActualX(),"X de la pos n'est correct");
		assertEquals(3,this.gps.getCellule().getActualY(),2,"Y de la pos n'est correct");
		assertEquals(Orientation.N,this.gps.getOrientation(),"L'orientation n'est correct");
		this.gps.avancer();
		assertEquals(1,this.gps.getCellule().getActualX(),"X de la pos n'est correct");
		assertEquals(3,this.gps.getCellule().getActualY(),2,"Y de la pos n'est correct");
		assertEquals(Orientation.N,this.gps.getOrientation(),"L'orientation n'est correct");
		
	}

}
