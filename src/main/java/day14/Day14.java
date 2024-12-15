package day14;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.Coordinate;
import utilities.FileUtility;
import utilities.Map;

public class Day14 {

	private static File file;
	protected ArrayList<Robot> robots = new ArrayList<Robot>();
	public static int maxRows;
	public static int maxCols;
	private Map map;

	public Day14() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		maxRows = 103;
		maxCols = 101;
		populateInput();
	}
	public Day14(File file) {
		robots = new ArrayList<Robot>();
		setFileToUse(file);
		maxRows = 7;
		maxCols = 11;
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day14.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			robots.add(new Robot(line));
		}
	}
	
	public void moveTimes(int i) {
		for(int x=0; x<i; x++) {
			for (Robot robot : robots) {
				robot.move();
			}
		}
//		System.out.println("Robot Positions after " + i + " moves");
//		for (Robot robot : robots) {
//			System.out.println(robot.getPosition());
//		}
		setupMap();
	}
	
	private void setupMap() {
		ArrayList<ArrayList<Character>> area = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> curRow;
		for(int row=0; row<maxRows; row++) {
			curRow = new ArrayList<Character>();
			for(int col=0; col<maxCols; col++) {
				int botsAtPos = 0;
				for (Robot robot : robots) {
					if(robot.getPosition().equals(new Coordinate(col, row))) {
						botsAtPos++;
					}
				}
				if(botsAtPos==0) {
					curRow.add('.');
				} else {
					curRow.add((String.valueOf(botsAtPos)).toCharArray()[0]);
				}
			}
			area.add(curRow);
		}
		map = new Map(area);
	}
	
	public Map getMap() {
		return map;
	}
	
	public ArrayList<Integer> getRobotsInQuartiles() {
		ArrayList<Integer> quartiles = new ArrayList<Integer>();
		quartiles.add(0);
		quartiles.add(0);
		quartiles.add(0);
		quartiles.add(0);
		
		for (Robot robot : robots) {
			int curQuartile = robot.getQuartile();
			if(curQuartile!=-1) {
				quartiles.set(curQuartile, quartiles.get(curQuartile)+1);
			}
		}
		return quartiles;
	}
	
	public Long getSafetyFactor() {
		long total = 1;
		ArrayList<Integer> quartiles = getRobotsInQuartiles();
		for (Integer integer : quartiles) {
			total*=integer;
		}
		return total;
	}
}
