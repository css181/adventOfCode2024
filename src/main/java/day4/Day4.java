package day4;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import utilities.Coordinate;
import utilities.FileUtility;

public class Day4 {

	private static File file;
	protected ArrayList<ArrayList<Character>> puzzle = new ArrayList<ArrayList<Character>>();

	public Day4() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day4(File file) {
		puzzle = new ArrayList<ArrayList<Character>>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day4.file = file;
	}

	public void populateInput() {
		puzzle = FileUtility.convertFileToCharacterArray(file);
	}
	public Integer getTotalSearches(char c, char d, char e, char f) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Integer getTotalHorizontalFindsInPuzzle(ArrayList<Character> searchWord) {
		int total = 0;
		for(int row = 0; row<puzzle.size(); row++) {
			for(int col = 0; col<=puzzle.get(row).size() - searchWord.size(); col++) {
				if(isWordFoundHorizontal(row, col, searchWord)) {
					total++;
				}
			}
		}
		return total;
	}
	private boolean isWordFoundHorizontal(int row, int col, ArrayList<Character> searchWord) {
		int charNum = 0;
		for (Character character : searchWord) {
			if(puzzle.get(row).get(col+charNum)!=character) {
				return false;
			}
			charNum++;
		}
		return true;
	}

	public Integer getTotalVerticalFindsInPuzzle(ArrayList<Character> searchWord) {
		int total = 0;
		for(int row = 0; row<=puzzle.size() - searchWord.size(); row++) {
			for(int col = 0; col<puzzle.get(row).size(); col++) {
				if(isWordFoundVertical(row, col, searchWord)) {
					total++;
				}
			}
		}
		return total;
	}
	private boolean isWordFoundVertical(int row, int col, ArrayList<Character> searchWord) {
		int charNum = 0;
		for (Character character : searchWord) {
			if(puzzle.get(row+charNum).get(col)!=character) {
				return false;
			}
			charNum++;
		}
		return true;
	}
	
	public Integer getTotalDiagonalDownFindsInPuzzle(ArrayList<Character> searchWord) {
		int total = 0;
		for(int row = 0; row<=puzzle.size() - searchWord.size(); row++) {
			for(int col = 0; col<=puzzle.get(row).size() - searchWord.size(); col++) {
				if(isWordFoundDiagonalDown(row, col, searchWord)) {
					total++;
				}
			}
		}
		return total;
	}
	private boolean isWordFoundDiagonalDown(int row, int col, ArrayList<Character> searchWord) {
		int charNum = 0;
		for (Character character : searchWord) {
			if(puzzle.get(row+charNum).get(col+charNum)!=character) {
				return false;
			}
			charNum++;
		}
		return true;
	}

	public Integer getTotalDiagonalUpFindsInPuzzle(ArrayList<Character> searchWord) {
		int total = 0;
		for(int row = searchWord.size()-1; row<puzzle.size(); row++) {
			for(int col = 0; col<=puzzle.get(row).size() - searchWord.size(); col++) {
				if(isWordFoundDiagonalUp(row, col, searchWord)) {
					total++;
				}
			}
		}
		return total;
	}
	private boolean isWordFoundDiagonalUp(int row, int col, ArrayList<Character> searchWord) {
		int charNum = 0;
		for (Character character : searchWord) {
			if(puzzle.get(row-charNum).get(col+charNum)!=character) {
				return false;
			}
			charNum++;
		}
		return true;
	}
	
	public Integer getAllTotalFinds() {
		int total = 0;
		total+=getTotalVerticalFindsInPuzzle(new ArrayList<>(Arrays.asList('X','M','A','S')));
		total+=getTotalVerticalFindsInPuzzle(new ArrayList<>(Arrays.asList('S','A','M','X')));
		total+=getTotalHorizontalFindsInPuzzle(new ArrayList<>(Arrays.asList('X','M','A','S')));
		total+=getTotalHorizontalFindsInPuzzle(new ArrayList<>(Arrays.asList('S','A','M','X')));
		total+=getTotalDiagonalDownFindsInPuzzle(new ArrayList<>(Arrays.asList('X','M','A','S')));
		total+=getTotalDiagonalDownFindsInPuzzle(new ArrayList<>(Arrays.asList('S','A','M','X')));
		total+=getTotalDiagonalUpFindsInPuzzle(new ArrayList<>(Arrays.asList('X','M','A','S')));
		total+=getTotalDiagonalUpFindsInPuzzle(new ArrayList<>(Arrays.asList('S','A','M','X')));
		return total;
	}
	
	public Integer getTotalMAS_X_Finds() {
		int total = 0;
		ArrayList<Coordinate> coords = new ArrayList<Coordinate>();
		for(int row = 1; row<puzzle.size()-1; row++) {
			for(int col = 1; col<puzzle.get(row).size() - 1; col++) {
				if(puzzle.get(row).get(col)=='A') {
					if(isMAS_X(row,col)) {
						total++;
						coords.add(new Coordinate(row+1, col+1));
					}
				}
			}
		}
		return total;
	}
	private boolean isMAS_X(int rowOfA, int colOfA) {
		if(puzzle.get(rowOfA-1).get(colOfA-1)=='M') {
			return (puzzle.get(rowOfA-1).get(colOfA+1)=='M' &&
					puzzle.get(rowOfA+1).get(colOfA-1)=='S' &&
					puzzle.get(rowOfA+1).get(colOfA+1)=='S') ||
					(puzzle.get(rowOfA-1).get(colOfA+1)=='S' &&
					puzzle.get(rowOfA+1).get(colOfA-1)=='M' &&
					puzzle.get(rowOfA+1).get(colOfA+1)=='S');
		} else if(puzzle.get(rowOfA-1).get(colOfA-1)=='S') {
			return (puzzle.get(rowOfA-1).get(colOfA+1)=='S' &&
					puzzle.get(rowOfA+1).get(colOfA-1)=='M' &&
					puzzle.get(rowOfA+1).get(colOfA+1)=='M') ||
					(puzzle.get(rowOfA-1).get(colOfA+1)=='M' &&
					puzzle.get(rowOfA+1).get(colOfA-1)=='S' &&
					puzzle.get(rowOfA+1).get(colOfA+1)=='M');
		}
		return false;
	}
}
