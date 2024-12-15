package day15;

import static day15.Directions.DOWN;
import static day15.Directions.LEFT;
import static day15.Directions.RIGHT;
import static day15.Directions.UP;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.Coordinate;
import utilities.FileUtility;
import utilities.Map;

public class Day15 {

	private static File file;
	private static File intructions;
	protected ArrayList<Directions> instructionsList = new ArrayList<Directions>();
	private int instructionPos;
	public Map map;
	public Coordinate robotPosition;
	int totalWalls;

	public Day15() {
		URL fileName = getClass().getResource("Input.txt");
		URL fileName2 = getClass().getResource("Instructions.txt");
		file = new File(fileName.getPath());
		intructions = new File(fileName2.getPath());
		populateInput();
		instructionPos = 0;
		totalWalls = 0;
	}
	public Day15(File file, File instructionFile) {
		instructionsList = new ArrayList<Directions>();
		setFileToUse(file, instructionFile);
		populateInput();
		instructionPos = 0;
		totalWalls = 0;
	}

	protected void setFileToUse(File file, File instructionFile) {
		Day15.file = file;
		Day15.intructions = instructionFile;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		String allLines = "";
		int row =0;
		for (String line : inputLines) {
			allLines+=line +"~";
			if(line.contains("@")) {
				robotPosition = new Coordinate(row, line.indexOf("@"));
			}
			row++;
		}
		allLines = allLines.substring(0, allLines.length()-1);
		map = new Map(allLines, "~");
		ArrayList<Character> instructionCharList = FileUtility.convertFileToCharacters(intructions);
		for (Character curChar : instructionCharList) {
			if(curChar=='^') {
				instructionsList.add(UP);
			}else if(curChar=='v') {
				instructionsList.add(DOWN);
			}else if(curChar=='>') {
				instructionsList.add(RIGHT);
			}else if(curChar=='<') {
				instructionsList.add(LEFT);
			}else {
				throw new RuntimeException("Invalid Instruction Char: " + curChar);
			}
		}
	}
	
	public Integer getDistanceFromPoint(int row, int col, char c, Directions dir) {
		int count = 0;
		switch (dir) {
		case UP:
			while (row>0) {
				row--;
				count++;
				if(map.getArea().get(row).get(col)==c) {
					return count;
				}
			}
			break;
		case DOWN:
			while (row<map.getArea().size()-1) {
				row++;
				count++;
				if(map.getArea().get(row).get(col)==c) {
					return count;
				}
			}
			break;
		case LEFT:
			while (col>0) {
				col--;
				count++;
				if(map.getArea().get(row).get(col)==c) {
					return count;
				}
			}
			break;
		case RIGHT:
			while (col<map.getArea().get(row).size()-1) {
				col++;
				count++;
				if(map.getArea().get(row).get(col)==c) {
					return count;
				}
			}
			break;
		default:
			throw new RuntimeException("Invalid Instruction Dir: " + dir);
		}
		return Integer.MAX_VALUE;
	}
	
	public Integer getDistanceFromRobot(char c, Directions dir) {
		return getDistanceFromPoint((int)robotPosition.getY(), (int)robotPosition.getX(), c, dir);
	}
	
	public boolean canMove(Directions dir) {
		return (getDistanceFromRobot('.', dir)<getDistanceFromRobot('#', dir));
	}
	
	public void moveNext() {
		Directions curDir = instructionsList.get(instructionPos);
//		System.out.println("Moving: " + curDir);
		String prior = map.toString();
		int row = (int) robotPosition.getY();
		int col = (int) robotPosition.getX();
		if(canMove(curDir)) {
			int nextDotAway = getDistanceFromRobot('.', curDir);
			switch (curDir) {
			case UP:
				if(map.getArea().get(row-1).get(col)=='[') {
					if(performBlockMoveUpOnLeft(row-1, col)) {						
						map.updateArea(row-1, col, '@');
						map.updateArea(row-1, col+1, '.');
						map.updateArea(row, col, '.');//Prior robot space is now free
						robotPosition = new Coordinate(col, row-1);
					}
				} else if(map.getArea().get(row-1).get(col)==']') {
					if(performBlockMoveUpOnRight(row-1, col)) {						
						map.updateArea(row-1, col-1, '.');
						map.updateArea(row-1, col, '@');
						map.updateArea(row, col, '.');//Prior robot space is now free
						robotPosition = new Coordinate(col, row-1);
					}
				}else {
					for(int x=row-nextDotAway; x<row; x++) {
						map.updateArea(x, col, map.getArea().get(x+1).get(col));
					}
					map.updateArea(row, col, '.');//Prior robot space is now free
					robotPosition = new Coordinate(col, row-1);
				}
				break;
			case DOWN:
				if(map.getArea().get(row+1).get(col)=='[') {
					if(performBlockMoveDownOnLeft(row+1, col)) {						
						map.updateArea(row+1, col, '@');
						map.updateArea(row+1, col+1, '.');
						map.updateArea(row, col, '.');//Prior robot space is now free
						robotPosition = new Coordinate(col, row+1);
					}
				} else if(map.getArea().get(row+1).get(col)==']') {
					if(performBlockMoveDownOnRight(row+1, col)) {						
						map.updateArea(row+1, col-1, '.');
						map.updateArea(row+1, col, '@');
						map.updateArea(row, col, '.');//Prior robot space is now free
						robotPosition = new Coordinate(col, row+1);
					}
				}else {
					for(int x=row+nextDotAway; x>row; x--) {
						map.updateArea(x, col, map.getArea().get(x-1).get(col));
					}
					map.updateArea(row, col, '.');//Prior robot space is now free
					robotPosition = new Coordinate(col, row+1);
				}
				break;
			case LEFT:
				for(int x=col-nextDotAway; x<col; x++) {
					map.updateArea(row, x, map.getArea().get(row).get(x+1));
				}
				map.updateArea(row, col, '.');//Prior robot space is now free
				robotPosition = new Coordinate(col-1, row);
				break;
			case RIGHT:
				for(int x=col+nextDotAway; x>col; x--) {
					map.updateArea(row, x, map.getArea().get(row).get(x-1));
				}
				map.updateArea(row, col, '.');//Prior robot space is now free
				robotPosition = new Coordinate(col+1, row);
				break;
			default:
				break;
			}
		}
		instructionPos++;
//		System.out.println(map);
		if(map.toString().contains("[.") || map.toString().contains(".]") || 
				map.toString().contains("]]") ||  map.toString().contains("[[") ||
				isWallMissing()) {
			System.out.println("We have an issue!");
			System.out.println("Prior:");
			System.out.println(prior);
			System.out.println("Then moving: " + curDir);
			System.err.println(map);
			System.out.println("End");
		}
	}
	
	private boolean isWallMissing() {
		int curWallCount = 0;
		for(int y=0; y<map.getArea().size(); y++) {
			for(int x=0; x<map.getArea().get(y).size(); x++) {
				char curChar = map.getArea().get(y).get(x);
				if(curChar=='#') {
					curWallCount++;
				}
			}
		}
		return curWallCount!=totalWalls;
	}
	private boolean performBlockMoveUpOnLeft(int row, int col) {
		boolean shouldUpdate = true;
		if(row>0) {			
			if((map.getArea().get(row-1).get(col)=='#') || (map.getArea().get(row-1).get(col+1)=='#')) {
				return false;
			}
			if(map.getArea().get(row-1).get(col)=='[') {
				shouldUpdate = shouldUpdate && performBlockMoveUpOnLeft(row-1, col);
			} else if(map.getArea().get(row-1).get(col)==']') {
				shouldUpdate = shouldUpdate && performBlockMoveUpOnRight(row-1, col);
			}
			if(map.getArea().get(row-1).get(col+1)=='[') {
				shouldUpdate = shouldUpdate && performBlockMoveUpOnLeft(row-1, col+1);
			} else if(map.getArea().get(row-1).get(col+1)==']') {
				shouldUpdate = shouldUpdate && performBlockMoveUpOnRight(row-1, col+1);
			}
			if(shouldUpdate) {				
				map.updateArea(row-1, col, '[');
				map.updateArea(row-1, col+1, ']');
				map.updateArea(row, col, '.');
				map.updateArea(row, col+1, '.');
				return true;
			}
		}
		return false;
	}
	private boolean performBlockMoveUpOnRight(int row, int col) {
		boolean shouldUpdate = true;
		if(row>0) {			
			if((map.getArea().get(row-1).get(col)=='#') || (map.getArea().get(row-1).get(col-1)=='#')) {
				return false;
			}		
			if(map.getArea().get(row-1).get(col)=='[') {
				shouldUpdate = shouldUpdate && performBlockMoveUpOnLeft(row-1, col);
			} else if(map.getArea().get(row-1).get(col)==']') {
				shouldUpdate = shouldUpdate && performBlockMoveUpOnRight(row-1, col);
			}
			if(map.getArea().get(row-1).get(col-1)=='[') {
				shouldUpdate = shouldUpdate && performBlockMoveUpOnLeft(row-1, col-1);
			} else if(map.getArea().get(row-1).get(col-1)==']') {
				shouldUpdate = shouldUpdate && performBlockMoveUpOnRight(row-1, col-1);
			}
			if(shouldUpdate) {					
				map.updateArea(row-1, col, ']');
				map.updateArea(row-1, col-1, '[');
				map.updateArea(row, col, '.');
				map.updateArea(row, col-1, '.');
				return true;
			}
		}
		return false;
	}

	private boolean performBlockMoveDownOnLeft(int row, int col) {
		boolean shouldUpdate = true;
		if(row<map.getArea().size()-1) {				
			if((map.getArea().get(row+1).get(col)=='#') || (map.getArea().get(row+1).get(col+1)=='#')) {
				return false;
			}
			if(map.getArea().get(row+1).get(col)=='[') {
				shouldUpdate = shouldUpdate && performBlockMoveDownOnLeft(row+1, col);
			} else if(map.getArea().get(row+1).get(col)==']') {
				shouldUpdate = shouldUpdate && performBlockMoveDownOnRight(row+1, col);
			}
			if(map.getArea().get(row+1).get(col+1)=='[') {
				shouldUpdate = shouldUpdate && performBlockMoveDownOnLeft(row+1, col+1);
			} else if(map.getArea().get(row+1).get(col+1)==']') {
				shouldUpdate = shouldUpdate && performBlockMoveDownOnRight(row+1, col+1);
			}
			if(shouldUpdate) {					
				map.updateArea(row+1, col, '[');
				map.updateArea(row+1, col+1, ']');
				map.updateArea(row, col, '.');
				map.updateArea(row, col+1, '.');
				return true;
			}
		}
		return false;
	}
	private boolean performBlockMoveDownOnRight(int row, int col) {
		boolean shouldUpdate = true;
		if(row<map.getArea().size()-1) {				
			if((map.getArea().get(row+1).get(col)=='#') || (map.getArea().get(row+1).get(col-1)=='#')) {
				return false;
			}			
			if(map.getArea().get(row+1).get(col)=='[') {
				shouldUpdate = shouldUpdate && performBlockMoveDownOnLeft(row+1, col);
			} else if(map.getArea().get(row+1).get(col)==']') {
				shouldUpdate = shouldUpdate && performBlockMoveDownOnRight(row+1, col);
			}
			if(map.getArea().get(row+1).get(col-1)=='[') {
				shouldUpdate = shouldUpdate && performBlockMoveDownOnLeft(row+1, col-1);
			} else if(map.getArea().get(row+1).get(col-1)==']') {
				shouldUpdate = shouldUpdate && performBlockMoveDownOnRight(row+1, col-1);
			}
			if(shouldUpdate) {				
				map.updateArea(row+1, col, ']');
				map.updateArea(row+1, col-1, '[');
				map.updateArea(row, col, '.');
				map.updateArea(row, col-1, '.');
				return true;
			}
		}
		return false;
	}
	
	public void moveAll() {
		for(int x=0; x<instructionsList.size(); x++) {
			System.out.println("Move " + x + "/" + instructionsList.size());
			moveNext();
		}
	}
	
	public long calculateGPS_sum() {
		long sum = 0;
		for(int row=0; row<map.getArea().size(); row++) {
			for(int col=0; col<map.getArea().get(row).size(); col++) {
				if(map.getArea().get(row).get(col)=='O' || map.getArea().get(row).get(col)=='[') {
					sum+=getGPS(row, col);
				}
			}
		}
		return sum;
	}
	
	private long getGPS(int row, int col) {
		return 100*row + col;
	}
	
	public void adjustMapForPart2() {
		ArrayList<ArrayList<Character>> newArea = new ArrayList<ArrayList<Character>>();
		for(int row=0; row<map.getArea().size(); row++) {
			ArrayList<Character> newRow = new ArrayList<Character>();
			for(int col=0; col<map.getArea().get(row).size(); col++) {
				char curChar = map.getArea().get(row).get(col);
				if(curChar=='#') {
					newRow.add('#');
					newRow.add('#');
					totalWalls+=2;
				}
				else if(curChar=='O') {
					newRow.add('[');
					newRow.add(']');
				}
				else if(curChar=='.') {
					newRow.add('.');
					newRow.add('.');
				}
				else if(curChar=='@') {
					newRow.add('@');
					newRow.add('.');
				}
				else {
					throw new RuntimeException("Invalid map char: " + curChar);
				}
			}
			newArea.add(newRow);
		}
		map.setArea(newArea);
		assignRobot();
	}
	
	public void assignRobot() {
		for(int row=0; row<map.getArea().size(); row++) {
			for(int col=0; col<map.getArea().get(row).size(); col++) {
				char curChar = map.getArea().get(row).get(col);
				if(curChar=='@') {
					robotPosition = new Coordinate(col, row);
				}
			}
		}
	}
	
	public boolean canMove(int row, int col, Directions dir) {
		char curChar;
		if(dir==LEFT || dir==RIGHT) {
			return canMove(dir);
		} else {
			if(dir==UP) {
				curChar = map.getArea().get(row-1).get(col);
			}else {
				curChar = map.getArea().get(row+1).get(col);
			}
		}
		
		if(curChar=='.') {
			return true;
		}
		if(curChar=='#') {
			return false;
		}
		if(curChar=='[') {
			if(dir==UP) {
				return canMove(row-1, col, dir) && canMove(row-1, col+1, dir);
			} else {
				return canMove(row+1, col, dir) && canMove(row+1, col+1, dir);
			}
		} else if(curChar==']') {
			if(dir==UP) {
				return canMove(row-1, col, dir) && canMove(row-1, col-1, dir);
			} else {
				return canMove(row+1, col, dir) && canMove(row+1, col-1, dir);
			}
		} else {
			throw new RuntimeException("Invalid curChar: " + curChar);
		}
	}
	
}
