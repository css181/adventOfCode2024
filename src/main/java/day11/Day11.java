package day11;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;
import utilities.Node;

public class Day11 {

	private static File file;
	protected Node firstNode;
	public long nodeCount;

	public Day11() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day11(File file) {
		firstNode = null;
		nodeCount = 0;
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day11.file = file;
	}

	public void populateInput() {
		ArrayList<ArrayList<Integer>> inputLines = FileUtility.convertFileOfIntListsToListOfIntList(file, " ");
		ArrayList<Integer> nodeValues = inputLines.get(0); //There's only 1 list in this input
		Node nextNode = null;
		for(int x=nodeValues.size()-1; x>=0; x--) {
			Node newNode = new Node(nodeValues.get(x), nextNode);
			nextNode = newNode;
			nodeCount++;
		}
		firstNode = nextNode;
	}
	
	public void blink() {
		Node curNode = firstNode;
		Node nextNode;
		do {
			nextNode = curNode.getNext();
			if(curNode.getValue()==0) {
				curNode.setValue(1);
			}
			else if(hasEvenNumberOfDigits(curNode.getValue())) {
				splitInto2Nodes(curNode, nextNode);
			} else {
				curNode.setValue(curNode.getValue() * 2024l);
			}
			
			curNode = nextNode;
		} while (nextNode!=null);
	}
	
	private boolean hasEvenNumberOfDigits(long value) {
		int numDigits = (int) Math.floor(Math.log10(Math.abs(value))) + 1;
		return (numDigits%2==0);
	}
	private void splitInto2Nodes(Node curNode, Node nextNode) {
		String curValueString = String.valueOf(curNode.getValue());
		String leftHalf = curValueString.substring(0, curValueString.length()/2);
		String rightHalf = curValueString.substring(curValueString.length()/2);
		
		Node newNode = new Node(Long.valueOf(rightHalf), nextNode);
		curNode.setValue(Long.valueOf(leftHalf));
		curNode.setNext(newNode);
		nodeCount++;
	}
	
	public void blink25Times() {
		for(int x=0; x<25; x++) {
			blink();
		}
	}
}
