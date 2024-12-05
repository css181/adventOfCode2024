package day1;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class NumbersFromInputLines {

	private static File file;
	private ArrayList<ArrayList<Character>> inputLines;
	public ArrayList<ArrayList<Character>> getInputLines() {
		return inputLines;
	}

	private ArrayList<Integer> firstNumbers;
	public ArrayList<Integer> getFirstNumbers() {
		return firstNumbers;
	}

	private ArrayList<Integer> lastNumbers;
	public ArrayList<Integer> getLastNumbers() {
		return lastNumbers;
	}

	private ArrayList<Integer> twoDigitNumbers;
	public ArrayList<Integer> getTwoDigitNumbers() {
		return twoDigitNumbers;
	}
	
	public NumbersFromInputLines() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		NumbersFromInputLines.file = file;
	}

	public void populateInput() {
		this.inputLines = FileUtility.convertFileToCharacterArray(file);
		this.firstNumbers = new ArrayList<>();
		this.lastNumbers = new ArrayList<>();
		this.twoDigitNumbers = new ArrayList<>();
	}

	public void calculateFirstNumbers() {
		for (ArrayList<Character> charList : inputLines) {
			for (int pos = 0; pos < charList.size(); pos++) {
				if (!Character.isAlphabetic(charList.get(pos))) {
					int num = Character.getNumericValue(charList.get(pos));
					firstNumbers.add(num);
					break;
				}
			}
		}
	}
	public void calculateFirstNumbersPart2() {
		for (ArrayList<Character> charList : inputLines) {
			for (int pos = 0; pos < charList.size(); pos++) {
				if (!Character.isAlphabetic(charList.get(pos))) {
					int num = Character.getNumericValue(charList.get(pos));
					firstNumbers.add(num);
					break;
				}
				String next5 = getUpToNext5Chars(charList, pos); 
				int num = getStartStringAsNumber(next5);
				if(num!=-1) {
					firstNumbers.add(num);
					break;
				}
			}
		}
	}

	private String getUpToNext5Chars(ArrayList<Character> charList, int pos) {
		String returnVal = "";
		int count =0;
		for(;pos<charList.size() && count<5; pos++) {
			returnVal+=charList.get(pos);
			count++;
		}
		return returnVal;
	}

	private int getStartStringAsNumber(String next5) {
		if(next5.startsWith("one")) {
			return 1;
		}
		if(next5.startsWith("two")) {
			return 2;
		}
		if(next5.startsWith("three")) {
			return 3;
		}
		if(next5.startsWith("four")) {
			return 4;
		}
		if(next5.startsWith("five")) {
			return 5;
		}
		if(next5.startsWith("six")) {
			return 6;
		}
		if(next5.startsWith("seven")) {
			return 7;
		}
		if(next5.startsWith("eight")) {
			return 8;
		}
		if(next5.startsWith("nine")) {
			return 9;
		}
		return -1;
	}

	public void calculateLastNumbers() {
		for (ArrayList<Character> charList : inputLines) {
			for (int pos = charList.size()-1; pos >=0; pos--) {
				if (!Character.isAlphabetic(charList.get(pos))) {
					int num = Character.getNumericValue(charList.get(pos));
					lastNumbers.add(num);
					break;
				}
			}
		}
	}
	public void calculateLastNumbersPart2() {
		for (ArrayList<Character> charList : inputLines) {
			for (int pos = charList.size()-1; pos >=0; pos--) {
				if (!Character.isAlphabetic(charList.get(pos))) {
					int num = Character.getNumericValue(charList.get(pos));
					lastNumbers.add(num);
					break;
				}
				String last5 = getUpToLast5Chars(charList, pos); 
				int num = getEndStringAsNumber(last5);
				if(num!=-1) {
					lastNumbers.add(num);
					break;
				}
			}
		}
	}

	private String getUpToLast5Chars(ArrayList<Character> charList, int pos) {
		String returnVal = "";
		int remaining;
		if(pos>=4) {
			remaining=5;
		} else {
			remaining=pos;
		}
		for(int cur=pos-remaining+1; cur<charList.size() && remaining>0; remaining--) {
			returnVal+=charList.get(cur);
			cur++;
		}
		return returnVal;
	}

	private int getEndStringAsNumber(String last5) {
		if(last5.endsWith("one")) {
			return 1;
		}
		if(last5.endsWith("two")) {
			return 2;
		}
		if(last5.endsWith("three")) {
			return 3;
		}
		if(last5.endsWith("four")) {
			return 4;
		}
		if(last5.endsWith("five")) {
			return 5;
		}
		if(last5.endsWith("six")) {
			return 6;
		}
		if(last5.endsWith("seven")) {
			return 7;
		}
		if(last5.endsWith("eight")) {
			return 8;
		}
		if(last5.endsWith("nine")) {
			return 9;
		}
		return -1;
	}

	public void calculateTwoDigitNumbers() {
		calculateFirstNumbers();
		calculateLastNumbers();
		getTwoDigitNumsFromLists();
	}
	public void calculateTwoDigitNumbersPart2() {
		calculateFirstNumbersPart2();
		calculateLastNumbersPart2();
		getTwoDigitNumsFromLists();
	}

	private void getTwoDigitNumsFromLists() {
		if(firstNumbers.size()!=lastNumbers.size()) {
			throw new RuntimeException("Invalid sizes of lists");
		}
		for (int pos=0; pos<firstNumbers.size(); pos++) {
			String number = firstNumbers.get(pos).toString() + lastNumbers.get(pos).toString();
			twoDigitNumbers.add(Integer.valueOf(number));
		}
	}

	public long addAllTwoDigitNumbers() {
		calculateTwoDigitNumbers();
		return sumUpList();
	}
	public long addAllTwoDigitNumbersPart2() {
		calculateTwoDigitNumbersPart2();
		return sumUpList();
	}

	private long sumUpList() {
		long sum = 0;
		for (Integer twoDigitNum : twoDigitNumbers) {
			sum+=twoDigitNum;
		}
		return sum;
	}
}
