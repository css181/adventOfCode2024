package day6;

import java.util.ArrayList;

import utilities.Coordinate;

public class Map {

	public enum GUARD_DIRECTION {UP, DOWN, LEFT, RIGHT};
	private ArrayList<ArrayList<Character>> area = new ArrayList<ArrayList<Character>>();
	private Coordinate guardSpot;
	private GUARD_DIRECTION direction = GUARD_DIRECTION.UP;
	
	public Map(ArrayList<ArrayList<Character>> area) {
		this.area = area;
		for(int row=0; row<area.size(); row++) {
			for(int col=0; col<area.get(row).size(); col++) {
				if(area.get(row).get(col)=='^') {
					guardSpot = new Coordinate(col, row);
				}
			}
		}
	}
	public ArrayList<ArrayList<Character>> getArea() {
		return area;
	}
	public void setArea(ArrayList<ArrayList<Character>> area) {
		this.area = area;
	}
	public void updateArea(int row, int col, Character newChar) {
		this.area.get(row).set(col, newChar);
	}
	public Coordinate getGuardSpot() {
		return guardSpot;
	}
	public GUARD_DIRECTION getDirection() {
		return direction;
	}
	public void setDirection(GUARD_DIRECTION direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		String print = "";
		for(int row=0; row<area.size(); row++) {
			for(int col=0; col<area.get(row).size(); col++) {
				print+=area.get(row).get(col);
			}
			print+="\n";
		}
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

        if(!(obj instanceof Map)) { return false; }
        Map other = (Map) obj;

        if(this.toString() != other.toString()) { return false; }
        
        return true;
    }
    
    
	public void moveGuard(int row, int col, boolean replaceWithX) {
		Character curGuardChar = area.get((int)guardSpot.getY()).get((int)guardSpot.getX());
		//Re-assign the current spot to an X
		ArrayList<Character> curGuardRow = area.get((int)guardSpot.getY());
		if(replaceWithX) {curGuardRow.set((int)guardSpot.getX(), 'X'); }
		
		//Move the Guard spot
		guardSpot = new Coordinate(col, row);
		
		//Re-assign the new Guard spot with ^
		curGuardRow = area.get((int)guardSpot.getY());
		curGuardRow.set((int)guardSpot.getX(), curGuardChar);
	}

}

