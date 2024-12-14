package day10;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.Coordinate;
import utilities.FileUtility;

public class Day10 {

	private static File file;
	protected ArrayList<ArrayList<Integer>> topograph = new ArrayList<ArrayList<Integer>>();
	public ArrayList<Coordinate> trailheads = new ArrayList<Coordinate>();

	public Day10() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day10(File file) {
		topograph = new ArrayList<ArrayList<Integer>>();
		trailheads = new ArrayList<Coordinate>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day10.file = file;
	}

	public void populateInput() {
		topograph = FileUtility.convertFileToIntListOfLists(file);
		for(int row=0; row<topograph.size(); row++) {
			for(int col=0; col<topograph.get(row).size(); col++) {
				if(topograph.get(row).get(col) == 0) {
					trailheads.add(new Coordinate(col, row));
				}
			}
		}
	}
	public ArrayList<Integer> calculateTrailheadScores() {
		ArrayList<Integer> scores = new ArrayList<Integer>();
		ArrayList<Coordinate> alreadyAdded9Coordinates;
		for (Coordinate trailhead : trailheads) {
			alreadyAdded9Coordinates = new ArrayList<Coordinate>(); //If there are multiple paths to the same 9 coordinate, only add that coordinate once
			scores.add( 
					isValidTrailToA9(0, (int)trailhead.getY()-1, (int)trailhead.getX(), alreadyAdded9Coordinates) +
					isValidTrailToA9(0, (int)trailhead.getY()+1, (int)trailhead.getX(), alreadyAdded9Coordinates) +
					isValidTrailToA9(0, (int)trailhead.getY(), (int)trailhead.getX()-1, alreadyAdded9Coordinates) +
					isValidTrailToA9(0, (int)trailhead.getY(), (int)trailhead.getX()+1, alreadyAdded9Coordinates)
			);
		}
		return scores;
	}
	
	private Integer isValidTrailToA9(int priorHeight, int row, int col, ArrayList<Coordinate> alreadyAdded9Coordinates) {
		if(alreadyAdded9Coordinates.contains(new Coordinate(col, row))) {
			//we already added this 9, we can't add it again (even if we got here via another path
			return 0;
		}
		if(row<0 || row>=topograph.size()) {
			return 0;
		}
		if(col<0 || col>=topograph.get(row).size()) {
			return 0;
		}
		int curHeight = topograph.get(row).get(col);
		if(curHeight != priorHeight+1) {
			return 0;
		}
		if(curHeight == 9) {
			alreadyAdded9Coordinates.add(new Coordinate(col, row));
			return 1;
		}
		return 	isValidTrailToA9(curHeight, row-1, col, alreadyAdded9Coordinates) +
				isValidTrailToA9(curHeight, row+1, col, alreadyAdded9Coordinates) +
				isValidTrailToA9(curHeight, row, col-1, alreadyAdded9Coordinates) +
				isValidTrailToA9(curHeight, row, col+1, alreadyAdded9Coordinates);
	}
	
	public int getSumOfAllTrailheadScores() {
		int sum = 0;
		for (int score : calculateTrailheadScores()) {
			sum+=score;
		}
		return sum;
	}
	
	
	
	public ArrayList<Integer> calculateTrailheadScoresAllowingMultiplePaths() {
		ArrayList<Integer> scores = new ArrayList<Integer>();
		for (Coordinate trailhead : trailheads) {
			scores.add( 
					isValidTrailToA9AllowingMultiplePaths(0, (int)trailhead.getY()-1, (int)trailhead.getX()) +
					isValidTrailToA9AllowingMultiplePaths(0, (int)trailhead.getY()+1, (int)trailhead.getX()) +
					isValidTrailToA9AllowingMultiplePaths(0, (int)trailhead.getY(), (int)trailhead.getX()-1) +
					isValidTrailToA9AllowingMultiplePaths(0, (int)trailhead.getY(), (int)trailhead.getX()+1)
			);
		}
		return scores;
	}
	private int isValidTrailToA9AllowingMultiplePaths(int priorHeight, int row, int col) {
		if(row<0 || row>=topograph.size()) {
			return 0;
		}
		if(col<0 || col>=topograph.get(row).size()) {
			return 0;
		}
		int curHeight = topograph.get(row).get(col);
		if(curHeight != priorHeight+1) {
			return 0;
		}
		if(curHeight == 9) {
			return 1;
		}
		return 	isValidTrailToA9AllowingMultiplePaths(curHeight, row-1, col) +
				isValidTrailToA9AllowingMultiplePaths(curHeight, row+1, col) +
				isValidTrailToA9AllowingMultiplePaths(curHeight, row, col-1) +
				isValidTrailToA9AllowingMultiplePaths(curHeight, row, col+1);
	}
	public Integer getSumOfAllTrailheadScoresAllowingMultiplePaths() {
		int sum = 0;
		for (int score : calculateTrailheadScoresAllowingMultiplePaths()) {
			sum+=score;
		}
		return sum;
	}
}
