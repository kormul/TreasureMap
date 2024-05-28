package treasure.map;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		try {
			System.out.println("Chargement du Fichier");
			List<String> file = ReadFile.instruction("Entree.txt");
			System.out.println("Initialisation du Jeu");
			Game.initGame(file);
			System.out.println("Démarrage du Jeu");
			Game.game.play();
			System.out.println("Fin du Jeu, génération du résultat");
			String res = Game.resultat();
			System.out.println("Resultat : "+ res);
			System.out.println("Sauvegarde du résultat");
			SaveFile.saveFile(res);
			System.out.println("Fin");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
