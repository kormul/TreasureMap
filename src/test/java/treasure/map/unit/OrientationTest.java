package treasure.map.unit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import treasure.map.Orientation;

public class OrientationTest {
	
	@Test
	public void Left_ValidInput_MethodSuccess() {
		
		Orientation or = Orientation.North;
		or = or.left();
		
		assertTrue(or.equals(Orientation.West));
		
		or = or.left();
		assertTrue(or.equals(Orientation.South));
		
		or = or.left();
		assertTrue(or.equals(Orientation.East));
		
		or = or.left();
		assertTrue(or.equals(Orientation.North));
		
		or = or.left();
		assertTrue(or.equals(Orientation.West));
	}
	
	@Test
	public void Right_ValidInput_MethodSuccess() {
		
		Orientation or = Orientation.North;
		or = or.right();
		
		assertTrue(or.equals(Orientation.East));
		
		or = or.right();
		assertTrue(or.equals(Orientation.South));
		
		or = or.right();
		assertTrue(or.equals(Orientation.West));
		
		or = or.right();
		assertTrue(or.equals(Orientation.North));
		
		or = or.right();
		assertTrue(or.equals(Orientation.East));
	}


}
