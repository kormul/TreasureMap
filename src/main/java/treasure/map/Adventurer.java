package treasure.map;

public class Adventurer {
	
	private String name;
	
	private int positionX;
	
	private int positionY;

	private Orientation orientation;
	
	private int nbTreasure;

	private String sequence;
	
	public Adventurer(String name, int x, int y, Orientation orientation, String sequence) {
		
		this.name = name;
		this.positionX = x;
		this.positionY = y;
		this.orientation = orientation;
		this.sequence = sequence;
		this.nbTreasure = 0;
		Game.game.getMap().addAdventurer(x, y);
		Game.game.addAdventurer(this);
	}
	
	public boolean nextSequence(int tour) {
		if(tour < 0 || tour>=sequence.length()) {
			return false;
		}
		switch(sequence.charAt(tour)){
			case 'A':
				int res;
				switch(orientation) {
					case North:
						res = Game.game.getMap().moveAdventurer(positionX, positionY, positionX, positionY-1);
						if(res >= 0) {
							this.positionY = positionY-1;
						}
						break;
					case East:
						res = Game.game.getMap().moveAdventurer(positionX, positionY, positionX+1, positionY);
						if(res >= 0) {
							this.positionX = positionX+1;
						}
						break;
					case South:
						res = Game.game.getMap().moveAdventurer(positionX, positionY, positionX, positionY+1);
						if(res >= 0) {
							this.positionY = positionY+1;
						}
						break;
					case West:
						res = Game.game.getMap().moveAdventurer(positionX, positionY, positionX-1, positionY);
						if(res >= 0) {
							this.positionX = positionX-1;
						}
						break;
					default:
						throw new IllegalStateException("Instruction impossible à executer !");
				}
				if(res > 0) {
					this.nbTreasure++;
				}
				break;
			case 'G':
				orientation = orientation.left();
				break;
			case 'D':
				orientation = orientation.right();
				break;
			default:
				throw new IllegalStateException("Instruction impossible à executer !");
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public int getPositionX() {
		return positionX;
	}


	public int getPositionY() {
		return positionY;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public int getNbTreasure() {
		return nbTreasure;
	}

	public String getSequence() {
		return sequence;
	}

	
}
