package day8;

import utilities.Coordinate;

public class Antinode {

	private Coordinate coordinate;
	private Character frequency;
	
	public Antinode(Coordinate coordinate, Character frequency) {
		this.coordinate = coordinate;
		this.frequency = frequency;
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}
	public Character getFrequency() {
		return frequency;
	}
	
	@Override
	public String toString() {
		String print = "{" + coordinate + " ~ " + frequency + "}";
		return print;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Antinode)) { return false; }
        Antinode other = (Antinode) obj;

        if(!this.coordinate.equals(other.coordinate)) { return false; }
        if(!this.frequency.equals(other.frequency)) { return false; }
        
        return true;
    }
    
}

