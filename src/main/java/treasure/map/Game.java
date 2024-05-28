package treasure.map;

import java.util.List;

public class Game {
	
	public static Game game;
	
	private Map map;
	private List<Adventurer> adventurers;
	
	public Game(Map map, List<Adventurer> adventurers) {
		this.map = map;
		this.adventurers = adventurers;
		Game.game = this;
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

	public void setMap(Map map) {
		this.map = map;
	}

	public List<Adventurer> getAdventurers() {
		return adventurers;
	}

	public void setAdventurers(List<Adventurer> adventurers) {
		this.adventurers = adventurers;
	}

	
	
}
