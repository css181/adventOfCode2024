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
	public int walk(boolean replaceWithX) {
		if(map.getDirection()==Map.GUARD_DIRECTION.UP) {
			int col = map.getGuardSpot().getX();
			for(int row=map.getGuardSpot().getY(); row>=1; row--) {
				if(isUnobstructed(row-1,col)) {
					map.moveGuard(row-1, col, replaceWithX);
				} else {
					turn();
					return -1;//stop walking because you ran into an obstruction
				}
			}
		} else if(map.getDirection()==Map.GUARD_DIRECTION.RIGHT) {
			int row = map.getGuardSpot().getY();
			for(int col=map.getGuardSpot().getX(); col<map.getArea().get(row).size()-1; col++) {
				if(isUnobstructed(row,col+1)) {
					map.moveGuard(row,col+1, replaceWithX);
				} else {
					turn();
					return -1;//stop walking because you ran into an obstruction
				}
			}
		} else if(map.getDirection()==Map.GUARD_DIRECTION.DOWN) {
			int col = map.getGuardSpot().getX();
			for(int row=map.getGuardSpot().getY(); row<map.getArea().size()-1; row++) {
				if(isUnobstructed(row+1,col)) {
					map.moveGuard(row+1, col, replaceWithX);
				} else {
					turn();
					return -1;//stop walking because you ran into an obstruction
				}
			}
		} else if(map.getDirection()==Map.GUARD_DIRECTION.LEFT) {
			int row = map.getGuardSpot().getY();
			for(int col=map.getGuardSpot().getX(); col>=1; col--) {
				if(isUnobstructed(row,col-1)) {
					map.moveGuard(row,col-1, replaceWithX);
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
	
	public int walkUntilOut() {
		int totalWalks = 0;
		int result;
		do {
			result = walk(true);
			totalWalks++;
		} while (result!=0);
		return totalWalks;
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
	
	public int walkUntilOutOrPerformXwalks(int maxWalks) {
		int totalWalks = 0;
		int result;
		do {
			result = walk(false);
			totalWalks++;
		} while (result!=0 && totalWalks<maxWalks);
		return totalWalks;
	}
	public Integer bruteForceHowManyObstructionsCauseInfiniteLoops() {
		int row=0;
		int col=0;
		int totalNewObstructionOptions = 0;
		do {
			//if we can add an obstacle in the current spot, do it and see if it causes an infinite loop.
			if(map.getArea().get(row).get(col)=='.') {
				map.updateArea(row, col, '#');
				if(walkUntilOutOrPerformXwalks(1000)==1000) {
					totalNewObstructionOptions++; //we walked for 1k walks, this is probably infinite loop.
				}
				
				//revert the map back
				populateInput();
			}
			
			
			//go to the next location in the area.
			col++;
			if(col>=map.getArea().get(row).size()) {
				col=0;
				row++;
			}
		} while (row<map.getArea().size());
		return totalNewObstructionOptions;
	}
	
}
