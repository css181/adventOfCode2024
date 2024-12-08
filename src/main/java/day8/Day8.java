package day8;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.Coordinate;
import utilities.FileUtility;

public class Day8 {

	private static File file;
	protected Map map;
	protected ArrayList<Antinode> antinodes;
	
	public Day8() {
		antinodes = new ArrayList<Antinode>();
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day8(File file) {
		antinodes = new ArrayList<Antinode>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day8.file = file;
	}

	public void populateInput() {
		map = new Map(FileUtility.convertFileToCharacterArray(file));
	}
	
	public void fillAntinodesList() {
		for (Character frequency : map.getUniqueFrequencies()) {
			ArrayList<Coordinate> allSpotsWithCurFrequency = getAllSpotsWithFrequency(frequency);
			for (Coordinate spotWithCurFrequency : allSpotsWithCurFrequency) {
				for(int spotIndex=0; spotIndex<allSpotsWithCurFrequency.size(); spotIndex++) {
					if(spotWithCurFrequency.equals(allSpotsWithCurFrequency.get(spotIndex))) {
						break; //we can't compare a spot with itself.
					}
					addTwoPotentialAntinodesForSpots(spotWithCurFrequency, allSpotsWithCurFrequency.get(spotIndex), frequency);
				}
			}
		}
	}
	private ArrayList<Coordinate> getAllSpotsWithFrequency(Character frequency) {
		ArrayList<Coordinate> spots = new ArrayList<Coordinate>();
		for(int row=0; row<map.getArea().size(); row++) {
			for(int col=0; col<map.getArea().get(row).size(); col++) {
				if(map.getArea().get(row).get(col)== frequency) {
					spots.add(new Coordinate(col, row));
				}
			}
		}
		return spots;
	}

	private void addTwoPotentialAntinodesForSpots(Coordinate coordA, Coordinate coordB, Character frequency) {
		Coordinate difference = coordA.getDistanceFrom(coordB);
		Coordinate smallerAntinode;
		Coordinate largerAntinode;
		if(coordA.getX() > coordB.getX()) {
			//aX>bX
			if(coordA.getY() > coordB.getY()) {
				//aX>bX & aY>bY
				smallerAntinode = new Coordinate(coordB.getX() - difference.getX(), coordB.getY() - difference.getY());
				largerAntinode = new Coordinate(coordA.getX() + difference.getX(), coordA.getY() + difference.getY());
			} else {
				//aX>bX & aY<bY
				smallerAntinode = new Coordinate(coordB.getX() - difference.getX(), coordB.getY() + difference.getY());
				largerAntinode = new Coordinate(coordA.getX() + difference.getX(), coordA.getY() - difference.getY());
			}
		} else {
			//aX<bX
			if(coordA.getY() > coordB.getY()) {
				//aX<bX & aY>bY
				smallerAntinode = new Coordinate(coordB.getX() + difference.getX(), coordB.getY() - difference.getY());
				largerAntinode = new Coordinate(coordA.getX() - difference.getX(), coordA.getY() + difference.getY());
			} else {
				//aX<bX & aY<bY
				smallerAntinode = new Coordinate(coordB.getX() + difference.getX(), coordB.getY() + difference.getY());
				largerAntinode = new Coordinate(coordA.getX() - difference.getX(), coordA.getY() - difference.getY());
			}
		}
		if(isWithinMap(smallerAntinode)) {
			antinodes.add(new Antinode(smallerAntinode, frequency));
		}
		if(isWithinMap(largerAntinode)) {
			antinodes.add(new Antinode(largerAntinode, frequency));
		}
	}
	
	private boolean isWithinMap(Coordinate coordinate) {
		return (coordinate.getX() >= 0) && (coordinate.getX() < map.getArea().get(0).size()) && //All rows are same size, so we can cheat and use 0 row for all.
				(coordinate.getY() >= 0) && (coordinate.getY() < map.getArea().size());
	}
	
	public void deDupeAntinodesList() {
		ArrayList<Coordinate> uniqueAntinodeCoordinates = new ArrayList<Coordinate>();
		ArrayList<Antinode> antinodesToRemove = new ArrayList<Antinode>();
		for (Antinode antinode : antinodes) {
			if(uniqueAntinodeCoordinates.contains(antinode.getCoordinate())) {
				antinodesToRemove.add(antinode);
			} else {
				uniqueAntinodeCoordinates.add(antinode.getCoordinate());
			}
		}
		for (Antinode toRemove : antinodesToRemove) {
			antinodes.remove(toRemove);
		}
	}
}
