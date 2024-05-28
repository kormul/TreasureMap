package treasure.map;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			List<String> file = ReadFile.instruction("Entree.txt");
			Game.initGame(file);
			Game.game.play();
			Game a = Game.game;
			System.out.println(Game.game.getAdventurers().get(0).getNbTreasure());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
