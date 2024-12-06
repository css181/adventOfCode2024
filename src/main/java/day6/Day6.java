package day6;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import day6.Map.GUARD_DIRECTION;
import utilities.Coordinate;
import utilities.FileUtility;

public class Day6 {

	private static File file;
	protected Map map;

	public Day6() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day6(File file) {
		map = new Map(new ArrayList<ArrayList<Character>>());
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day6.file = file;
	}

	public void populateInput() {
		map = new Map(FileUtility.convertFileToCharacterArray(file));
	}
	
	//returns -1 if we walk into an obstruction.  
	//returns 0 if we walk out of the area.
	public int walk() {
		if(map.getDirection()==Map.GUARD_DIRECTION.UP) {
			int col = map.getGuardSpot().getX();
			for(int row=map.getGuardSpot().getY(); row>=1; row--) {
				if(isUnobstructed(row-1,col)) {
					map.moveGuard(row-1, col);
				} else {
					turn();
					return -1;//stop walking because you ran into an obstruction
				}
			}
		} else if(map.getDirection()==Map.GUARD_DIRECTION.RIGHT) {
			int row = map.getGuardSpot().getY();
			for(int col=map.getGuardSpot().getX(); col<map.getArea().get(row).size()-1; col++) {
				if(isUnobstructed(row,col+1)) {
					map.moveGuard(row,col+1);
				} else {
					turn();
					return -1;//stop walking because you ran into an obstruction
				}
			}
		} else if(map.getDirection()==Map.GUARD_DIRECTION.DOWN) {
			int col = map.getGuardSpot().getX();
			for(int row=map.getGuardSpot().getY(); row<map.getArea().size()-1; row++) {
				if(isUnobstructed(row+1,col)) {
					map.moveGuard(row+1, col);
				} else {
					turn();
					return -1;//stop walking because you ran into an obstruction
				}
			}
		} else if(map.getDirection()==Map.GUARD_DIRECTION.LEFT) {
			int row = map.getGuardSpot().getY();
			for(int col=map.getGuardSpot().getX(); col>=1; col--) {
				if(isUnobstructed(row,col-1)) {
					map.moveGuard(row,col-1);
				} else {
					turn();
					return -1;//stop walking because you ran into an obstruction
				}
			}
		} else {
			System.err.println("INVALID direction. Must be UP, DOWN, LEFT, or RIGHT.");
		}
		return 0;
	}
	private boolean isUnobstructed(int row, int col) {
		return map.getArea().get(row).get(col)!='#';
	}
	
	public void turn() {
		Coordinate guardSpot = map.getGuardSpot();
		switch (map.getDirection()) {
		case UP:
			map.setDirection(GUARD_DIRECTION.RIGHT);
			map.getArea().get(guardSpot.getY()).set(guardSpot.getX(), '>');
			break;
		case RIGHT:
			map.setDirection(GUARD_DIRECTION.DOWN);
			map.getArea().get(guardSpot.getY()).set(guardSpot.getX(), 'V');
			break;
		case DOWN:
			map.setDirection(GUARD_DIRECTION.LEFT);
			map.getArea().get(guardSpot.getY()).set(guardSpot.getX(), '<');
			break;
		case LEFT:
			map.setDirection(GUARD_DIRECTION.UP);
			map.getArea().get(guardSpot.getY()).set(guardSpot.getX(), '^');
			break;
		default:
			System.err.println("INVALID direction. Must be UP, DOWN, LEFT, or RIGHT.");
			break;
		}
	}
	
	public void walkUntilOut() {
		int result;
		do {
			result = walk();
		} while (result!=0);
	}
	public Integer getDistinctGuardPlaces() {
		int total = 0;
		for(int row=0; row<map.getArea().size(); row++) {
			for(int col=0; col<map.getArea().get(row).size(); col++) {
				if(map.getArea().get(row).get(col)=='X') {
					total++;
				}
			}
		}
		total++;//for the last place the guard is in.  We're leaving them in the map and not moving out of it so we can easily see where they exit.
		return total;
	}
}
