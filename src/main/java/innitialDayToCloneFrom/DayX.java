package innitialDayToCloneFrom;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class DayX {

	private static File file;
	private ArrayList<Pojo> games;
	public ArrayList<Pojo> getGames() {
		return games;
	}

	public DayX() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		DayX.file = file;
	}

	public void populateInput() {
		games = new ArrayList<Pojo>();
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			games.add(new Pojo(line));
		}
	}

}
