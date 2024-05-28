package treasure.map;

public enum Orientation {

	North, East, South, West;
	
	public Orientation left() {
        return values()[(this.ordinal() - 1 + values().length) % values().length];
	}   
	
	public Orientation right() {
        return values()[(this.ordinal() +1) % values().length];
	}    
}
