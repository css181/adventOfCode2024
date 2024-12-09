package day9;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day9 {

	private static File file;
	private String unsortedBlocks = "";

	public Day9() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day9(File file) {
		unsortedBlocks = "";
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day9.file = file;
	}

	public void populateInput() {
		String input = FileUtility.convertFileToString(file);
		ArrayList<Integer> inputNums = new ArrayList<Integer>();
		for (Character number : input.toCharArray()) {
			inputNums.add(Integer.valueOf(String.valueOf(number)));
		}
		int id=0;
		for (int index=0; index<inputNums.size(); index++) {
			int num = inputNums.get(index);
			if(index%2==0) {
				for(int x=0; x<num; x++) {
					unsortedBlocks+=String.valueOf(id);
				}
				id++;
			} else {
				for(int x=0; x<num; x++) {
					unsortedBlocks+=".";
				}
			}
		}
	}
	
	public String getUnsortedBlocks() {
		return unsortedBlocks;
	}
	
	public String sortBlocks() {
		String sorted = unsortedBlocks;
		char[] charList = unsortedBlocks.toCharArray();
		int replacedIndex = 0;
		for(int index=charList.length-1; index>replacedIndex; index--) {
			char curChar = charList[index];
			replacedIndex = sorted.indexOf('.');
			if(curChar!='.' && replacedIndex<index) {
				sorted = sorted.replaceFirst("\\.", String.valueOf(curChar));
				char[] newCharArray = sorted.toCharArray();
				newCharArray[index] = '.';
				sorted = String.valueOf(newCharArray);
			}
		}
		return sorted;
	}
	
	public Long getChecksumOfSortedBlocks() {
		long total = 0;
		String sorted = sortBlocks();
		System.out.println("Sorted:");
		char[] charList = sorted.toCharArray();
		for(long x=0; x<charList.length; x++) {
			if(charList[(int) x]=='.') {
				break;//we got to end of the sorted list of numbers
			}
			System.out.println("total: " + total);
			System.out.println("adding: " + x + " * " + Long.valueOf(String.valueOf(charList[(int) x])));
			total+= x * Long.valueOf(String.valueOf(charList[(int) x]));
		}
		return total;
	}
}
