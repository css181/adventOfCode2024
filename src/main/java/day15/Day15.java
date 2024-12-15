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

	public Day15() {
		URL fileName = getClass().getResource("Input.txt");
		URL fileName2 = getClass().getResource("Instructions.txt");
		file = new File(fileName.getPath());
		intructions = new File(fileName2.getPath());
		populateInput();
		instructionPos = 0;
	}
	public Day15(File file, File instructionFile) {
		instructionsList = new ArrayList<Directions>();
		setFileToUse(file, instructionFile);
		populateInput();
		instructionPos = 0;
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
	
	public Integer getDistanceFromRobot(char c, Directions dir) {
		int row = (int) robotPosition.getY();
		int col = (int) robotPosition.getX();
		switch (dir) {
		case UP:
			while (row>0) {
				row--;
				if(map.getArea().get(row).get(col)==c) {
					return (int) (robotPosition.getY()-row);
				}
			}
			break;
		case DOWN:
			while (row<map.getArea().size()-1) {
				row++;
				if(map.getArea().get(row).get(col)==c) {
					return (int) (row-robotPosition.getY());
				}
			}
			break;
		case LEFT:
			while (col>0) {
				col--;
				if(map.getArea().get(row).get(col)==c) {
					return (int) (robotPosition.getX()-col);
				}
			}
			break;
		case RIGHT:
			while (col<map.getArea().get(row).size()-1) {
				col++;
				if(map.getArea().get(row).get(col)==c) {
					return (int) (col-robotPosition.getX());
				}
			}
			break;
		default:
			throw new RuntimeException("Invalid Instruction Dir: " + dir);
		}
		return Integer.MAX_VALUE;
	}
	
	public boolean canMove(Directions dir) {
		return (getDistanceFromRobot('.', dir)<getDistanceFromRobot('#', dir));
	}
	
	public void moveNext() {
		Directions curDir = instructionsList.get(instructionPos);
		int row = (int) robotPosition.getY();
		int col = (int) robotPosition.getX();
		if(canMove(curDir)) {
			int nextDotAway = getDistanceFromRobot('.', curDir);
			switch (curDir) {
			case UP:
				for(int x=row-nextDotAway; x<row; x++) {
					map.updateArea(x, col, map.getArea().get(x+1).get(col));
				}
				map.updateArea(row, col, '.');//Prior robot space is now free
				robotPosition = new Coordinate(col, row-1);
				break;
			case DOWN:
				for(int x=row+nextDotAway; x>row; x--) {
					map.updateArea(x, col, map.getArea().get(x-1).get(col));
				}
				map.updateArea(row, col, '.');//Prior robot space is now free
				robotPosition = new Coordinate(col, row+1);
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
	}
	
	public void moveAll() {
		for(int x=0; x<instructionsList.size(); x++) {
			moveNext();
		}
	}
	
	public long calculateGPS_sum() {
		long sum = 0;
		for(int row=0; row<map.getArea().size(); row++) {
			for(int col=0; col<map.getArea().get(row).size(); col++) {
				if(map.getArea().get(row).get(col)=='O') {
					sum+=getGPS(row, col);
				}
			}
		}
		return sum;
	}
	
	private long getGPS(int row, int col) {
		return 100*row + col;
	}
}
