package innitialDayToCloneFrom;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

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
	public void sortBothlists() {
		Collections.sort(leftList);
		Collections.sort(rightList);
	}
	public Long diffOfListsAtIndex(int index) {
		sortBothlists();
		return Math.abs(leftList.get(index) - rightList.get(index));
	}

	public Long totalDistanceBetweenBothFullLists() {
		long total = 0;
		for (int x=0; x<leftList.size(); x++) {
			total+= diffOfListsAtIndex(x);
		}
		return total;
	}

	public Integer numOfTimesNumIsInRightList(long number) {
		int total = 0;
		for (Long elem : rightList) {
			if(elem==number) { total++; }
		}
		return total;
	}
	public Long getTotalSimilarityScore() {
		long total = 0;
		for (Long elem : leftList) {
			total+=(elem * numOfTimesNumIsInRightList(elem));
		}
		return total;
	}
}
