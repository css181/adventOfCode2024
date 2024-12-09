package day10;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day10 {

	private static File file;
	protected ArrayList<Pojo> myList = new ArrayList<Pojo>();

	public Day10() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day10(File file) {
		myList = new ArrayList<Pojo>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day10.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
	}
}
