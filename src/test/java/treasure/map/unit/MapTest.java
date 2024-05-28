package treasure.map.unit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import treasure.map.Map;

public class MapTest {

	@Test
	public void Map_IntegerXLessThanOne_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(0, 50);
		});
		
		assertTrue(exception.getMessage().equals("La carte dois faire au minimum 1*1"));
	}
	
	@Test
	public void Map_IntegerYLessThanOne_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(50, 0);
		});
		
		assertTrue(exception.getMessage().equals("La carte dois faire au minimum 1*1"));
	}
	
	@Test
	public void Map_IntegerXAndYLessThanOne_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(0, 0);
		});
		
		assertTrue(exception.getMessage().equals("La carte dois faire au minimum 1*1"));
	}
	
	@Test
	public void Map_ValideInput_ConstructSuccess() {
		Map map = new Map(50, 50);
		assertNotNull(map);
	}
	
	@Test
	public void AddMontain_InputXOutsideMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addMontain(25, 6);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
		
	}
	
	@Test
	public void AddMontain_InputYOutsideMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addMontain(5, 60);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddMontain_InputXAndYOutsideMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addMontain(-5, 12);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddMontain_InputXNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addMontain(2, -1);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddMontain_InputYNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addMontain(-5, -8);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddMontain_InputXAndYNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addMontain(25, 40);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddMontain_CellIsAlreadyMountain_ThrowsException() {
		
		Exception exception = assertThrows(IllegalStateException.class, () -> {
			Map map = new Map(18,15);
			map.addMontain(15, 12);
			map.addMontain(15, 12);
			
		});
		
		assertTrue(exception.getMessage().equals("Une montagne est déjà existante à cette endroit"));
	}
	
	@Test
	public void AddMontain_TreasureInThisCell_ThrowsException() {
		Exception exception = assertThrows(IllegalStateException.class, () -> {
			Map map = new Map(18,15);
			map.addTreasure(15, 12, 3);
			map.addMontain(15, 12);

		});
		
		assertTrue(exception.getMessage().equals("Des trésors sont présent à cette endroit"));
	}
	
	@Test
	public void AddMontain_ValidInput_MethodSuccess() {
		
		Map map = new Map(18,15);
		assertFalse(map.isMontain(15, 12));
		map.addMontain(15, 12);
		assertTrue(map.isMontain(15, 12));
		
	}
	
	@Test
	public void AddMontain_MaxInput_MethodSuccess() {
		
		Map map = new Map(18,15);
		assertFalse(map.isMontain(17, 14));
		map.addMontain(17, 14);
		assertTrue(map.isMontain(17, 14));
		
	}
	
	@Test
	public void AddMontain_MinInput_MethodSuccess() {
		
		Map map = new Map(18,15);
		assertFalse(map.isMontain(0, 0));
		map.addMontain(0, 0);
		assertTrue(map.isMontain(0, 0));
		
	}
	
	@Test
	public void AddTreasure_InputXOutsideMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addTreasure(50, 4, 1);
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddTreasure_InputYOutsideMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addTreasure(1, 40, 1);
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddTreasure_InputXAndYOutsideMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addTreasure(50, 58, 1);
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddTreasure_InputXNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addTreasure(2, -1, 2);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddTreasure_InputYNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addTreasure(-5, -8, 2);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddTreasure_InputXAndYNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addTreasure(-25, -40, 2);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddTreasure_MontainIsAlreadyPresent_ThrowsException() {
		
		Exception exception = assertThrows(IllegalStateException.class, () -> {
			Map map = new Map(18,15);
			map.addMontain(12, 8);
			map.addTreasure(12, 8, 1);
		});
		
		assertTrue(exception.getMessage().equals("Une montagne est existante a cette endroit"));
	}
	
	@Test
	public void AddTreasure_ValidInputAndOneTreasure_MethodSuccess() {
		
		Map map = new Map(18,15);
		map.addTreasure(12, 8, 1);
		assertTrue(map.removeIfTreasure(12, 8));
		assertFalse(map.removeIfTreasure(12, 8));

	}
	
	@Test
	public void AddTreasure_ValidInputAndManyTreasure_MethodSuccess() {
		
		Map map = new Map(18,15);
		map.addTreasure(12, 8, 3);
		assertTrue(map.removeIfTreasure(12, 8));
		assertTrue(map.removeIfTreasure(12, 8));
		assertTrue(map.removeIfTreasure(12, 8));
		assertFalse(map.removeIfTreasure(12, 8));

	}
	
	@Test
	public void AddTreasure_MaxInput_MethodSuccess() {
		
		Map map = new Map(18,15);
		map.addTreasure(17, 14, 1);
		assertTrue(map.removeIfTreasure(17, 14));
		assertFalse(map.removeIfTreasure(17, 14));

	}
	
	@Test
	public void AddTreasure_MinInput_MethodSuccess() {
		
		Map map = new Map(18,15);
		map.addTreasure(0, 0, 1);
		assertTrue(map.removeIfTreasure(0, 0));
		assertFalse(map.removeIfTreasure(0, 0));

	}
	
	
	
	@Test
	public void IsMontain_InputXOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.isMontain(48, 5);

		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void IsMontain_InputYOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.isMontain(4, 25);

		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void IsMontain_InputXAndYOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.isMontain(48, 50);

		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void IsMontain_InputXNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.isMontain(-2, 1);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void IsMontain_InputYNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.isMontain(5, -8);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void IsMontain_InputXAndYNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.isMontain(-25, -40);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void IsMontain_ValidInput_MethodSuccessReturnTrue() {
		
		Map map = new Map(18,15);
		map.addMontain(8, 4);
		boolean res = map.isMontain(8, 4);
	
		assertTrue(res);
	}
	
	@Test
	public void IsMontain_ValidInput_MethodSuccessReturnFalse() {
		
		Map map = new Map(18,15);
		map.addMontain(8, 4);
		boolean res = map.isMontain(3,2);
	
		assertFalse(res);
	}
	
	@Test
	public void RemoveIfTreasure_InputXOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.removeIfTreasure(25, 8);

		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void RemoveIfTreasure_InputYOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.removeIfTreasure(8, 25);

		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void RemoveIfTreasure_InputXAndYOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.removeIfTreasure(25, 80);

		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void RemoveIfTreasure_InputXNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.removeIfTreasure(-2, 1);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void RemoveIfTreasure_InputYNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.removeIfTreasure(5, -8);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void RemoveIfTreasure_InputXAndYNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.removeIfTreasure(-25, -40);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void RemoveIfTreasure_ValidInputNobodyTreasure_MethodeSucess() {
		Map map = new Map(18,15);
		boolean res = map.removeIfTreasure(2, 8);
		assertFalse(res);
	}
	
	@Test
	public void RemoveIfTreasure_ValidInputMontainCell_MethodeSucess() {
		Map map = new Map(18,15);
		map.addMontain(2, 8);
		boolean res = map.removeIfTreasure(2, 8);
		assertFalse(res);
	}
	
	@Test
	public void RemoveIfTreasure_ValidInputOneTreasure_MethodeSucess() {
		Map map = new Map(18,15);
		map.addTreasure(2, 8, 1);
		boolean res = map.removeIfTreasure(2, 8);
		assertTrue(res);
		res = map.removeIfTreasure(2, 8);
		assertFalse(res);
	}
	
	@Test
	public void RemoveIfTreasure_ValidInputManyTreasure_MethodeSucess() {
		Map map = new Map(18,15);
		map.addTreasure(2, 8, 3);
		boolean res = map.removeIfTreasure(2, 8);
		assertTrue(res);
		res = map.removeIfTreasure(2, 8);
		assertTrue(res);
		res = map.removeIfTreasure(2, 8);
		assertTrue(res);
		res = map.removeIfTreasure(2, 8);
		assertFalse(res);
	}
	
	@Test
	public void MoveAdventurer_InputXOldOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.moveAdventurer(50, 2, 6, 6);
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void MoveAdventurer_InputYOldOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.moveAdventurer(3, 20, 6, 6);
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void MoveAdventurer_InputXOldAndYOldOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.moveAdventurer(50, 20, 6, 6);
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void MoveAdventurer_InputXOldNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.moveAdventurer(-5, 2, 6, 6);			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void MoveAdventurer_InputYOldNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.moveAdventurer(5, -2, 6, 6);			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void MoveAdventurer_InputXOldAndYOldNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.moveAdventurer(-6, -8, 6, 6);			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void MoveAdventurer_InputXNewOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.moveAdventurer(8, 2, 64, 6);
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void MoveAdventurer_InputYNewOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.moveAdventurer(8, 2, 6, 61);
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void MoveAdventurer_InputXNewAndYNewOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.moveAdventurer(8, 2, 26, 36);
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void MoveAdventurer_InputXNewNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.moveAdventurer(8, 2, -6, 6);
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void MoveAdventurer_InputYNewNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.moveAdventurer(8, 2, 6, -6);
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void MoveAdventurer_InputXNewAndYNewNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.moveAdventurer(8, 2, -6, -6);
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void MoveAdventurer_InputNobdyAdventurerIsPresent_ThrowsException() {
		
		Exception exception = assertThrows(IllegalStateException.class, () -> {
			Map map = new Map(18,15);
			map.moveAdventurer(5, 2, 6, 2);
		});
		
		assertTrue(exception.getMessage().equals("Personne n'est présent a ses coordonnées"));
	}
	
	@Test
	public void MoveAdventurer_InputMontainIsPresent_MethodSucess() {
		
		Map map = new Map(18,15);
		map.addAdventurer(8, 2);
		map.addMontain(8, 3);
		int res = map.moveAdventurer(8, 2, 8, 3);
		
		assertTrue(res == -1);
	}
	
	@Test
	public void MoveAdventurer_InputOtherPlayerIsPresent_MethodSucess() {
		
		Map map = new Map(18,15);
		map.addAdventurer(8, 2);
		map.addAdventurer(8, 3);
		int res = map.moveAdventurer(8, 2, 8, 3);
			
		assertTrue(res == -1);
	}
	
	@Test
	public void MoveAdventurer_InputNobodyTreasure_MethodSucess() {
		
		Map map = new Map(18,15);
		map.addAdventurer(8, 2);
		int res = map.moveAdventurer(8, 2, 8, 3);	
		
		assertTrue(res == 0);
	}
	
	@Test
	public void MoveAdventurer_InputOneTreasureIsPresent_MethodSucess() {
		
		Map map = new Map(18,15);
		map.addAdventurer(8, 2);
		map.addTreasure(8, 3, 1);
		int res = map.moveAdventurer(8, 2, 8, 3);		
		
		assertTrue(res == 1);
	}
	
	@Test
	public void MoveAdventurer_InputManyTreasureIsPresent_MethodSucess() {
		
		Map map = new Map(18,15);
		map.addAdventurer(8, 2);
		map.addTreasure(8, 3, 4);
		int res = map.moveAdventurer(8, 2, 8, 3);
			
		assertTrue(res == 1);
	}
	
	@Test
	public void AddAdventurer_InputXOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addAdventurer(50, 12);

		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddAdventurer_InputYOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addAdventurer(5, 120);

		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddAdventurer_InputXAndYOutsideMap_ThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addAdventurer(50, 52);

		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddAdventurer_InputXNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addAdventurer(-5, 5);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddAdventurer_InputYNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addAdventurer(5, -8);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddAdventurer_InputXAndYNegativeMap_ThrowsException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Map map = new Map(18,15);
			map.addAdventurer(-25, -40);
			
		});
		
		assertTrue(exception.getMessage().equals("Donnée en dehors de la carte"));
	}
	
	@Test
	public void AddAdventurer_InputMontainIsPresent_ThrowsException() {
		
		Exception exception = assertThrows(IllegalStateException.class, () -> {
			Map map = new Map(18,15);
			map.addMontain(2, 5);
			map.addAdventurer(2, 5);
			
		});
		
		assertTrue(exception.getMessage().equals("Une montagne est presente a ces coordonees"));
	}
	
	@Test
	public void AddAdventurer_InputValid_MethodSuccess() {
		Map map = new Map(18,15);
		map.addAdventurer(2, 5);
			
	}
	
}
