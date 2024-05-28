package treasure.map;

public class Map {
	
	private Cell[][] plan; 
	
	public Map(int x, int y) {
		
		if(x <= 0 || y<= 0) {
			throw new IllegalArgumentException("La carte dois faire au minimum 1*1");
		}
		plan = new Cell[y][x];
		
		for(int i = 0; i< plan.length; i++) {
			for(int j = 0; j<plan[i].length; j++) {
				plan[i][j] = new Cell();
			}
		}
	}
	
	public void addMontain(int x, int y) {
		if(y<plan.length && x<plan[y].length) {
			if(!plan[y][x].isMontain) {
				if(plan[y][x].nbTreasure == 0) {
					plan[y][x].isMontain = true;
				}
				else {
					throw new IllegalStateException("Des trésors sont présent à cette endroit");
				}
			}
			else {
				throw new IllegalStateException("Une montagne est déjà existante à cette endroit");
			}
			
		}
		else {
			throw new IllegalArgumentException("Donnée en dehors de la carte");
		}
	}
	
	public void addTreasure(int x, int y, int nbTreasure) {
		if(y<plan.length && x<plan[y].length) {
			if(!plan[y][x].isMontain) {
				plan[y][x].nbTreasure += nbTreasure;
			}
			else {
				throw new IllegalStateException("Une montagne est existante a cette endroit");
			}
		}
		else {
			throw new IllegalArgumentException("Donnée en dehors de la carte");
		}
	}
	
	public boolean isMontain(int x, int y) {
		if(y<plan.length && x<plan[y].length) {
			if(plan[y][x].isMontain) {
				return true;
			}
		}
		else {
			throw new IllegalArgumentException("Donnée en dehors de la carte");
		}
		return false;
	}
	
	public boolean removeIfTreasure(int x, int y) {
		if(y<plan.length && x<plan[y].length) {
			if(!plan[y][x].isMontain && plan[y][x].nbTreasure>0) {
				plan[y][x].nbTreasure--;
				return true;
			}
		}
		else {
			throw new IllegalArgumentException("Donnée en dehors de la carte");
		}
		return false;
	}
	
	
	class Cell {
		
		private int nbTreasure;
		
		private boolean isMontain;

		public Cell() {
			this.nbTreasure = 0;
			this.isMontain = false;
		}
	}

}