package day3;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day3 {

	private static File file;
	protected ArrayList<MulInstruction> validMulInstructions = new ArrayList<MulInstruction>();

	public Day3() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day3(File file) {
		validMulInstructions = new ArrayList<MulInstruction>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day3.file = file;
	}

	public void populateInput() {
		String input = FileUtility.convertFileToString(file);
		String remaining = input;
		do {			
			int pos = remaining.indexOf("mul(");
			if(pos==-1) { 
				break;
			}
			int comma = remaining.substring(pos).indexOf(",");
			int paren = remaining.substring(pos).indexOf(")");
			int left = -1;
			int right = -1;
			try {
				left = Integer.valueOf(remaining.substring(pos+4, comma+1));
				right = Integer.valueOf(remaining.substring(comma+2, paren+1));
			}catch (Exception e) {
				// Do nothing
			}
			if(left!=-1 && right!=-1) {
				validMulInstructions.add(new MulInstruction(left, right));
				remaining = remaining.substring(paren+1);
			} else {				
				remaining = remaining.substring(1);
			}
		} while (remaining.length()>0);
	}
	public ArrayList<MulInstruction> getValidMulInstructions() {
		return validMulInstructions;
	}
	
	public Long getSumOfAllMulInstructions() {
		long total = 0;
		for (MulInstruction mulInstruction : validMulInstructions) {
			total+= mulInstruction.getLeft() * mulInstruction.getRight();
		}
		return total;
	}
}
