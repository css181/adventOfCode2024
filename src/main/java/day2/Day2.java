package day2;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import utilities.FileUtility;

public class Day2 {

	private static File file;
	protected ArrayList<Report> reports;

	public Day2() {
		reports = new ArrayList<Report>();
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day2(File file) {
		reports = new ArrayList<Report>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day2.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		int x = 1;
		for (String line : inputLines) {
			int fistSpace = line.indexOf(" ");
			int firstNum = Integer.valueOf(line.substring(0, fistSpace));
			int secondNum = Integer.valueOf(line.substring(fistSpace + 1, line.indexOf(" ", fistSpace + 1)));
			if(firstNum < secondNum) {
				reports.add(new ReportIncreasing(x, line));
			} else {
				reports.add(new ReportDecreasing(x, line));
			}
			x++;
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
	
	public int totalSafeWithDampenerReports() {
		int total = 0;
		for (Report report : reports) {
			if(report.isSafe()) { 
				total++;
			}
			else {
				if(anyReportSubsetIsSafe(report)) { 
					total++; 
				}
			}
		}
		return total;
	}
	
	private boolean anyReportSubsetIsSafe(Report report) {
		ArrayList<Integer> originalLevels = report.getLevels();
		ArrayList<Integer> curLevels;
		for(int x=0; x<originalLevels.size(); x++) {
			curLevels = new ArrayList<Integer>(originalLevels);
			curLevels.remove(x);
			Report newReport;
			if(curLevels.get(0)<curLevels.get(1)) {
				newReport = new ReportIncreasing(report.id, curLevels);
			} else {
				newReport = new ReportDecreasing(report.id, curLevels);
			}
			if(newReport.isSafe()) {
				return true;
			}
		}
		return false;
	}
}
