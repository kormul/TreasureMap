package treasure.map;

public enum Orientation {

	North, East, South, West;
	
	public Orientation left() {
        return values()[(this.ordinal() - 1 + values().length) % values().length];
	}   
	
	public Orientation right() {
        return values()[(this.ordinal() +1) % values().length];
	}   
	
	public static Orientation fromString(String prefix) {
        switch (prefix) {
            case "N":
                return North;
            case "E":
                return East;
            case "S":
                return South;
            case "W":
                return West;
            default:
                throw new IllegalArgumentException("Valeur non valide : " + prefix);
        }
    }
}
