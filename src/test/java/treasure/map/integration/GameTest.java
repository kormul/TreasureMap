package treasure.map.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
		Adventurer adventurer = new Adventurer("Alric", 5, 6, Orientation.East, "AAG");
		game.addAdventurer(adventurer);
		assertTrue(game.getMap() != null);
		assertTrue(game.getAdventurers().size() == 1);
		Adventurer adventurer2 = new Adventurer("Fred", 8, 7, Orientation.South, "DAG");
		game.addAdventurer(adventurer2);
		assertTrue(game.getAdventurers().size() == 2);
	}
	
	@Test
	public void Play_ValidInputNoTreasure_MethodSuccess() {
		Game game = new Game(new Map(18,30));
		Adventurer adventurer = new Adventurer("Alric", 5, 6, Orientation.East, "AAG");
		game.addAdventurer(adventurer);
		Adventurer adventurer2 = new Adventurer("Fred", 8, 7, Orientation.South, "DAG");
		game.addAdventurer(adventurer2);
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

		Adventurer adventurer = new Adventurer("Alric", 1, 0, Orientation.South, "AADAGAGAAGAA");
		game.addAdventurer(adventurer);
		game.play();
		System.out.println(game.getAdventurers().get(0).getNbTreasure());
		assertTrue(game.getAdventurers().get(0).getNbTreasure() == 2);

	}
}
