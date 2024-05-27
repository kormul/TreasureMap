package treasure.map;

public class Map {
	
	private Cell[][] plan; 
	
	public Map(int x, int y) {
		plan = new Cell[y][x];
		
		for(int i = 0; i< plan.length; i++) {
			for(int j = 0; j<plan[i].length; j++) {
				plan[i][j] = new Cell();
			}
		}
	}
	
	public boolean addMontain(int x, int y) {
		if(y<plan.length && x<plan[y].length) {
			if(!plan[y][x].isMontain && plan[y][x].nbTreasure == 0) {
				plan[y][x].isMontain = true;
			}
		}
		return false;
	}
	
	public boolean addTreasure(int x, int y, int nbTreasure) {
		if(y<plan.length && x<plan[y].length) {
			if(!plan[y][x].isMontain) {
				plan[y][x].nbTreasure += nbTreasure;
			}
		}
		return false;
	}
	
	public boolean isMontain(int x, int y) {
		if(y<plan.length && x<plan[y].length) {
			if(plan[y][x].isMontain) {
				return true;
			}
		}
		return false;
	}
	
	public boolean removeIfTreasure(int x, int y) {
		if(y<plan.length && x<plan[y].length) {
			if(!plan[y][x].isMontain) {
				plan[y][x].nbTreasure--;
			}
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