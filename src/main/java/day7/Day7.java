package day7;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day7 {

	private static File file;
	protected ArrayList<Equation> equasions = new ArrayList<Equation>();
	protected ArrayList<Long> rightList = new ArrayList<Long>();

	public Day7() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day7(File file) {
		equasions = new ArrayList<Equation>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day7.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			equasions.add(new Equation(line));
		}
	}
	public ArrayList<Equation> getEquasions() {
		return equasions;
	}
	public long getSumOfAllEqualsOfValidEquasions() {
		long sum = 0;
		for (Equation equation : equasions) {
			if(equation.isValid()) {
				sum+=equation.getEquals();
			}
		}
		return sum;
	}
}
