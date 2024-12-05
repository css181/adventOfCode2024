package day2;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day2 {

	private static File file;
	protected ArrayList<Report> reports = new ArrayList<Report>();

	public Day2() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day2(File file) {
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day2.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			int fistSpace = line.indexOf(" ");
			int firstNum = Integer.valueOf(line.substring(0, fistSpace));
			int secondNum = Integer.valueOf(line.substring(fistSpace + 1, line.indexOf(" ", fistSpace + 1)));
			if(firstNum < secondNum) {
				reports.add(new ReportIncreasing(line));
			} else {
				reports.add(new ReportDecreasing(line));
			}
		}
	}
	
	
	public ArrayList<Report> getReports() {
		return reports;
	}
	
	public int totalSafeReports() {
		int total = 0;
		for (Report report : reports) {
			if(report.isSafe()) { total++;}
		}
		return total;
	}
}
