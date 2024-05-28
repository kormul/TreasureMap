package treasure.map.integration;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import treasure.map.Adventurer;
import treasure.map.Game;
import treasure.map.Map;
import treasure.map.Orientation;

public class GameTest {
	
	@Test
	public void Game_ValidInput_MethodSuccess() {
		Game game = new Game(new Map(18,30));
		assertTrue(game.getMap() != null);
		assertTrue(game.getAdventurers().size() == 0);
	}

	@Test
	public void AddAdventurer_ValidInput_MethodSuccess() {
		Game game = new Game(new Map(18,30));
		new Adventurer("Alric", 5, 6, Orientation.East, "AAG");
		assertTrue(game.getMap() != null);
		assertTrue(game.getAdventurers().size() == 1);
		new Adventurer("Fred", 8, 7, Orientation.South, "DAG");
		assertTrue(game.getAdventurers().size() == 2);
	}
	
	@Test
	public void Play_ValidInputNoTreasure_MethodSuccess() {
		Game game = new Game(new Map(18,30));
		new Adventurer("Alric", 5, 6, Orientation.East, "AAG");
		new Adventurer("Fred", 8, 7, Orientation.South, "DAG");
		game.play();
		assertTrue(game.getAdventurers().get(0).getNbTreasure() == 0);
		assertTrue(game.getAdventurers().get(1).getNbTreasure() == 0);

	}
	
	@Test
	public void Play_ValidInputManyTreasure_MethodSuccess() {
		Game game = new Game(new Map(18,30));
		Game.game.getMap().addTreasure(1, 2, 1);
		Game.game.getMap().addTreasure(1, 2, 1);
		Game.game.getMap().addTreasure(2, 1, 1);

		new Adventurer("Alric", 1, 0, Orientation.South, "AADAGAGAAGAA");
		game.play();
		assertTrue(game.getAdventurers().get(0).getNbTreasure() == 2);

	}
	
	@Test
	public void InitGame_ValidCompleteData_MethodSuccess() {
		List<String> data= new ArrayList<>();
		data.add("C-15-20");
		data.add("M-5-4");
		data.add("T-3-2-1");
		data.add("A-Croft-1-2-S-AAGADAGA");
		Game.initGame(data);
		assertTrue(Game.game.getAdventurers().get(0).getName().equals("Croft"));
		assertTrue(Game.game.getAdventurers().get(0).getNbTreasure() == 0);
		assertTrue(Game.game.getAdventurers().get(0).getPositionX() == 1);
		assertTrue(Game.game.getAdventurers().get(0).getPositionY() == 2);
		assertTrue(Game.game.getAdventurers().get(0).getOrientation().equals(Orientation.South));
		assertTrue(Game.game.getAdventurers().get(0).getSequence().equals("AAGADAGA"));
	}
	
	@Test
	public void InitGame_FirstLineErreur_ThrowsException() {

		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			List<String> data= new ArrayList<>();
			data.add("M-15-20");
			data.add("C-5-4");
			data.add("T-3-2-1");
			data.add("A-Croft-1-2-S-AAGADAGA");
			Game.initGame(data);
		});
		
		assertTrue(exception.getMessage().equals("Le fichie ne commence pas par la taille de la carte !"));
	}
	
	@Test
	public void InitGame_FirstLineDataCorrupt_ThrowsException() {

		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			List<String> data= new ArrayList<>();
			data.add("C-15");
			data.add("M-5-4");
			data.add("T-3-2-1");
			data.add("A-Croft-1-2-S-AAGADAGA");
			Game.initGame(data);
		});
		
		assertTrue(exception.getMessage().equals("Donnée Invalide"));
	}
	
	@Test
	public void InitGame_MontainDataCorrupt_ThrowsException() {

		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			List<String> data= new ArrayList<>();
			data.add("C-15-30");
			data.add("M-4");
			data.add("T-3-2-1");
			data.add("A-Croft-1-2-S-AAGADAGA");
			Game.initGame(data);
		});
		
		assertTrue(exception.getMessage().equals("Donnée Invalide"));
	}
	
	@Test
	public void InitGame_TreasureDataCorrupt_ThrowsException() {

		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			List<String> data= new ArrayList<>();
			data.add("C-15-30");
			data.add("M-4-5");
			data.add("T-3");
			data.add("A-Croft-1-2-S-AAGADAGA");
			Game.initGame(data);
		});
		
		assertTrue(exception.getMessage().equals("Donnée Invalide"));
	}
	
	@Test
	public void InitGame_AdventurerDataCorrupt_ThrowsException() {

		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			List<String> data= new ArrayList<>();
			data.add("C-15-30");
			data.add("M-4-5");
			data.add("A-Croft-1-2");
			Game.initGame(data);
		});
		
		assertTrue(exception.getMessage().equals("Donnée Invalide"));
	}
	
	@Test
	public void InitGame_UnknowData_ThrowsException() {

		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			List<String> data= new ArrayList<>();
			data.add("C-15-30");
			data.add("G-4-5");
			data.add("A-Croft-1-2");
			Game.initGame(data);
		});
		
		assertTrue(exception.getMessage().equals("Donnée Inconnue"));
	}
	
	@Test
	public void Resultat_ValidData_MethodSuccess() {

		List<String> data= new ArrayList<>();
		data.add("C-3-4");
		data.add("M-1-0");
		data.add("M-2-1");
		data.add("T-0-3-2");
		data.add("T-1-3-3");
		data.add("A-Lara-1-1-S-AADADAGGA");
		Game.initGame(data);
		Game.game.play();
		String res = Game.resultat();
		assertTrue(res.equals("C - 3 - 4\n"
					+ "M - 1 - 0\n"
					+ "M - 2 - 1\n"
					+ "T - 1 - 3 - 2\n"
					+ "A - Lara - 0 - 3 - S - 3\n"));
	}
}
