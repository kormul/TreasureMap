package treasure.map;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			List<String> file = ReadFile.instruction("Entree.txt");
			Game.initGame(file);
			Game.game.play();
			String res = Game.resultat();
			SaveFile.saveFile(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
