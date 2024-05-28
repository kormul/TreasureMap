package treasure.map;

import java.util.ArrayList;
import java.util.List;

import treasure.map.Map.Cell;

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
	
	public static void initGame(List<String> instruction) {
		
		
		String line = instruction.get(0);
		if(line.startsWith("C"))
		{
			String[] data = line.split("-");
			if(data.length!=3) {
				throw new IllegalArgumentException("Donnée Invalide");
			}
			new Game(new Map(Integer.parseInt(data[1]), Integer.parseInt(data[2])));
		}
		else {
			throw new IllegalArgumentException("Le fichie ne commence pas par la taille de la carte !");
		}
		
		for(int i = 1 ; i<instruction.size(); i++) {
			
			line = instruction.get(i);
			String[] data = line.split("-");

			switch(data[0]) {
				case "M":
					if(data.length!=3) {
						throw new IllegalArgumentException("Donnée Invalide");
					}
					Game.game.map.addMontain(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
					break;
				case "T":
					if(data.length!=4) {
						throw new IllegalArgumentException("Donnée Invalide");
					}
					Game.game.map.addTreasure(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
					break;
				case "A":
					if(data.length!=6) {
						throw new IllegalArgumentException("Donnée Invalide");
					}
					new Adventurer(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Orientation.fromString(data[4]), data[5]);
					break;
				default:
					throw new IllegalArgumentException("Donnée Inconnue");
			}
			
		}
		
	}

	public static String resultat() {
		
		String res = "";
		res += "C - "+game.map.getPlan().length+" - "+game.map.getPlan()[0].length+"\n";
		for(int i = 0; i< game.map.getPlan().length; i++) {
			for(int j = 0; j<game.map.getPlan()[i].length; j++) {
				if(game.map.getPlan()[i][j].isMontain()) {
					res += "M - "+i+" - "+j+"\n";
				}
			}
		}
		
		for(int i = 0; i< game.map.getPlan().length; i++) {
			for(int j = 0; j<game.map.getPlan()[i].length; j++) {
				if(game.map.getPlan()[i][j].getNbTreasure()>0) {
					res += "T - "+i+" - "+j+" - "+game.map.getPlan()[i][j].getNbTreasure()+"\n";
				}
			}
		}
		
		for(Adventurer adventurer : game.getAdventurers()){
			res += "A - "+adventurer.getName()+" - "+adventurer.getPositionX()+" - "+adventurer.getPositionY()+" - "+adventurer.getOrientation().toString().substring(0, 1)+" - "+adventurer.getNbTreasure()+"\n";

		}
		
		return res;
	}
	
}
