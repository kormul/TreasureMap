package treasure.map.unit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import treasure.map.Game;
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
	
	@Test
	public void FromString_ValidInput_MethodSuccess() {
		
		Orientation or = Orientation.fromString("E");
		assertTrue(or.equals(Orientation.East));
		
		or = Orientation.fromString("S");
		assertTrue(or.equals(Orientation.South));
		
		or = Orientation.fromString("W");
		assertTrue(or.equals(Orientation.West));
		
		or = Orientation.fromString("N");
		assertTrue(or.equals(Orientation.North));
	}
	
	@Test
	public void FromString_InputError_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Orientation or = Orientation.fromString("G");
		});
		
		assertTrue(exception.getMessage().equals("Valeur non valide : G"));
	}


}
