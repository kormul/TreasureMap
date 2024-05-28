package treasure.map;

public class Map {
	
	private Cell[][] plan; 
	
	public Map(int x, int y) {
		
		if(x <= 0 || y<= 0) {
			throw new IllegalArgumentException("La carte dois faire au minimum 1*1");
		}
		plan = new Cell[x][y];
		
		for(int i = 0; i< plan.length; i++) {
			for(int j = 0; j<plan[i].length; j++) {
				plan[i][j] = new Cell();
			}
		}
	}
	
	public void addMontain(int x, int y) {
		if(x<plan.length && x>=0 && y>=0 && y<plan[x].length) {
			if(!plan[x][y].isMontain) {
				if(plan[x][y].nbTreasure == 0) {
					plan[x][y].isMontain = true;
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
		if(x<plan.length && x>=0 && y>=0 && y<plan[x].length) {
			if(!plan[x][y].isMontain) {
				plan[x][y].nbTreasure += nbTreasure;
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
		if(x<plan.length && x>=0 && y>=0 && y<plan[x].length) {
			if(plan[x][y].isMontain) {
				return true;
			}
		}
		else {
			throw new IllegalArgumentException("Donnée en dehors de la carte");
		}
		return false;
	}
	
	public boolean removeIfTreasure(int x, int y) {
		if(x<plan.length && x>=0 && y>=0 && y<plan[x].length) {
			if(!plan[x][y].isMontain && plan[x][y].nbTreasure>0) {
				plan[x][y].nbTreasure--;
				return true;
			}
		}
		else {
			throw new IllegalArgumentException("Donnée en dehors de la carte");
		}
		return false;
	}
	
	public int moveAdventurer(int oldX, int oldY, int newX, int newY) {

		if(oldX<plan.length && oldX>=0 && oldY>=0 && oldY<plan[oldX].length) {
			if(newX<plan.length  && newX>=0 && newY>=0&& newY<plan[newX].length) {
				if(plan[oldX][oldY].adventurerIsPresent) {
					if(!isMontain(newX, newY) && !plan[newX][newY].adventurerIsPresent) {
						plan[oldX][oldY].adventurerIsPresent = false;
						plan[newX][newY].adventurerIsPresent = true;

						if(removeIfTreasure(newX, newY)) {
							return 1;
						}
						return 0;
					}
				}
				else {
					throw new IllegalStateException("Personne n'est présent a ses coordonnées");
				}
			}else {
				throw new IllegalArgumentException("Donnée en dehors de la carte");
			}
		}else {
			throw new IllegalArgumentException("Donnée en dehors de la carte");
		}
		
		return -1;
	}
	
	public void addAdventurer(int x, int y) {
		if(x<plan.length && x>=0 && y>=0 && y<plan[x].length) {
			if(!plan[x][y].isMontain) {
				plan[x][y].adventurerIsPresent = true;
			}
			else {
				throw new IllegalStateException("Une montagne est presente a ces coordonees");
			}
			
		}
		else {
			throw new IllegalArgumentException("Donnée en dehors de la carte");
		}
	}
	
	public Cell[][] getPlan() {
		return plan;
	}

	class Cell {
		
		private int nbTreasure;
		
		private boolean isMontain;
		
		private boolean adventurerIsPresent;

		public Cell() {
			this.nbTreasure = 0;
			this.isMontain = false;
		}

		public int getNbTreasure() {
			return nbTreasure;
		}

		public boolean isMontain() {
			return isMontain;
		}
	}

}