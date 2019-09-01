package beans;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import beans.util.DimensionPelouse;

class PelouseTest {
	
	Pelouse pelouse;
	
	@BeforeEach
	public void onSetUp() {
		this.pelouse = new Pelouse(new DimensionPelouse(2, 5));
	}

	@Test
	public void testMoveTo() {
		assertTrue("[2,4] ⊂ [2,5]" , pelouse.moveTo(2, 4));
		assertTrue("[2,5] ⊂ [2,5]" ,pelouse.moveTo(2, 5));
		assertFalse("[3,4] ⊄ [2,5]",pelouse.moveTo(3, 4));
		assertFalse("[1,9] ⊄ [2,5]",pelouse.moveTo(1, 9));
		assertFalse("[5,9] ⊄ [2,5]",pelouse.moveTo(5, 9));
	}

}
