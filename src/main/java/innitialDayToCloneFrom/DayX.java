package innitialDayToCloneFrom;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class DayX {

	private static File file;
	protected ArrayList<Pojo> myList = new ArrayList<Pojo>();

	public DayX() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public DayX(File file) {
		myList = new ArrayList<Pojo>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		DayX.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
	}
}
