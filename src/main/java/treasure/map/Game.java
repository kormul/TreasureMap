package treasure.map;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	public static Game game;
	
	private Map map;
	private List<Adventurer> adventurers;
	
	public Game(Map map) {
		this.map = map;
		this.adventurers = new ArrayList<>();
		Game.game = this;
	}
	
	public void addAdventurer(Adventurer adventurer) {
		adventurers.add(adventurer);
	}
	
	public void play() {
		boolean notAllPlayersfinishedGame = true;
		int tour= 0;
		while(notAllPlayersfinishedGame) {
			notAllPlayersfinishedGame = false;
			for(Adventurer adventurer : adventurers) {
				boolean res = adventurer.nextSequence(tour);
				if(res == true){
					notAllPlayersfinishedGame = true;
				}
			}
			tour++;
		}
	}

	public Map getMap() {
		return map;
	}

	public List<Adventurer> getAdventurers() {
		return adventurers;
	}
}
