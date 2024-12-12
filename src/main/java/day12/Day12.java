package day12;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import utilities.Coordinate;
import utilities.FileUtility;
import utilities.Map;

public class Day12 {

	private static File file;
	public Map map;
	public HashMap<String, HashSet<Coordinate>> regions;
	
	public Day12() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
		regions = new HashMap<String, HashSet<Coordinate>>();
	}
	public Day12(File file) {
		setFileToUse(file);
		populateInput();
		regions = new HashMap<String, HashSet<Coordinate>>();
	}

	protected void setFileToUse(File file) {
		Day12.file = file;
	}

	public void populateInput() {
		map = new Map(FileUtility.convertFileToCharacterArray(file));
	}
	
	public void calculateRegions() {
		ArrayList<ArrayList<Character>> area = map.getArea();
		for(int row=0; row<area.size(); row++) {
			for(int col=0; col<area.get(row).size(); col++) {
				Coordinate curCoordinate = new Coordinate(col, row);
				char curChar = area.get(row).get(col);
				if(notInAnyRegion(curCoordinate)) {
					HashSet<Coordinate> region = getCorrectRegion(curChar, curCoordinate);
					addAllConnectedToRegion(curChar, curCoordinate.getY(), curCoordinate.getX(), region);
				}
			}
		}
	}
	private void addAllConnectedToRegion(char curChar, int row, int col, HashSet<Coordinate> region) {
		if((row<0) || (row>=map.getArea().size()) || (col<0) || (col>=map.getArea().get(row).size())) {
			return;
		}
		Coordinate curCoordinate = new Coordinate(col, row);
		for (Coordinate regionCoord : region) {
			if(regionCoord.equals(curCoordinate)) {
				return;
			}
		}
		if(map.getArea().get(row).get(col)!=curChar) {
			return;
		}
		region.add(curCoordinate);
		//left
		addAllConnectedToRegion(curChar, row, col-1, region);
		//right
		addAllConnectedToRegion(curChar, row, col+1, region);
		//up
		addAllConnectedToRegion(curChar, row+1, col, region);
		//down
		addAllConnectedToRegion(curChar, row-1, col, region);
	}
	
	private boolean notInAnyRegion(Coordinate test) {
		for (Entry<String, HashSet<Coordinate>> entry : regions.entrySet()) {
			for (Coordinate coord : entry.getValue()) {
				if(test.equals(coord)) {
					return false;
				}
			}
		}
		return true;
	}

	private HashSet<Coordinate> getCorrectRegion(char curChar, Coordinate curCoordinate) {
		int numOfCurChar = 1;
		do {
			HashSet<Coordinate> curSet = regions.get(curChar+String.valueOf(numOfCurChar));
			String key = curChar+String.valueOf(numOfCurChar);
			if(curSet==null) {
				HashSet<Coordinate> newSet = new HashSet<Coordinate>();
				regions.put(key, newSet);
				return newSet;
			} else {
				if(isConnectedToAnyCoordinateInSet(curCoordinate, curSet)) {
					return regions.get(key);
				}
				else {
					numOfCurChar++;
					continue;//to next numOfCurChar
				}
			}
		} while(numOfCurChar<100);//Arbitrary cutoff.  Assume we don't have more than 100 of the same letter in different regions
		return null;//Should never get here.
	}
	private boolean isConnectedToAnyCoordinateInSet(Coordinate cur, HashSet<Coordinate> curSet) {
		for (Coordinate coordinate : curSet) {
			if(coordinate.equals(new Coordinate(cur.getX()-1, cur.getY())) ||
					coordinate.equals(new Coordinate(cur.getX()+1, cur.getY())) ||
					coordinate.equals(new Coordinate(cur.getX(), cur.getY()-1)) ||
					coordinate.equals(new Coordinate(cur.getX(), cur.getY()+1))) {
				return true;
			}
		}
		return false;
	}
	
	public Integer getAreaOfRegion(HashSet<Coordinate> hashSet) {
		return hashSet.size();
	}
	public Integer getPerimeterOfRegion(HashSet<Coordinate> hashSet) {
		int perimeter = 0;
		for (Coordinate coordinate : hashSet) {
			perimeter+=4;
			for (Coordinate trial : hashSet) {
				if(trial.equals(new Coordinate(coordinate.getX()-1, coordinate.getY()))) {
					perimeter-=2;
				}
				if(trial.equals(new Coordinate(coordinate.getX(), coordinate.getY()-1))) {
					perimeter-=2;
				}
			}
		}
		return perimeter;
	}
	public Long calculateCost() {
		calculateRegions();
		long cost = 0;
		for (Entry<String, HashSet<Coordinate>> entry : regions.entrySet()) {
			cost+= getAreaOfRegion(entry.getValue()) * getPerimeterOfRegion(entry.getValue());
		}
		return cost;
	}
}
