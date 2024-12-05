package innitialDayToCloneFrom;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class DayX {

	private static File file;
	protected ArrayList<Long> leftList = new ArrayList<Long>();
	protected ArrayList<Long> rightList = new ArrayList<Long>();

	public DayX() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public DayX(File file) {
		leftList = new ArrayList<Long>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		DayX.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			long leftInput = Long.valueOf(line.substring(0, line.indexOf(" ")));
			long rightInput = Long.valueOf(line.substring(line.indexOf(" ")+1));
			leftList.add(leftInput);
			rightList.add(rightInput);
		}
	}
}
