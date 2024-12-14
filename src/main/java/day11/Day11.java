package day11;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import utilities.FileUtility;
import utilities.Node;

public class Day11 {

	private static File file;
	protected Node firstNode;
	public long nodeCount;
	public HashMap<StoneKey, Long> stoneKeyToAnswer = new HashMap<StoneKey, Long>();

	public Day11() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day11(File file) {
		firstNode = null;
		nodeCount = 0;
		stoneKeyToAnswer = new HashMap<StoneKey, Long>();
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
	
	public void blink6Times() {
		blinkXTimes(6);
	}
	
	public void blink25Times() {
//		for(int x=0; x<25; x++) {
//			blink();
//		}
		blinkXTimes(25);
	}
	public void blink75Times() {
		blinkXTimes(75);
	}
	private void blinkXTimes(int times) {
		Node curNode = firstNode;
		nodeCount=0;
		stoneKeyToAnswer = new HashMap<StoneKey, Long>();
		do {
			long answer = performBlinkForStoneValue(curNode.getValue(), 0, times, stoneKeyToAnswer);
			nodeCount+= answer;
//			System.out.println("Answer for " + curNode.getValue() + ", is " + answer + " for " + times + " times");
			curNode = curNode.getNext();
		} while (curNode!=null);
	}
	
	public long performBlinkForStoneValue(long value, int step, int last, HashMap<StoneKey, Long> cache) {
		if(step==last) {
			return 1;
		}
		StoneKey key = new StoneKey(value, step);
		if(value==0) {
			if(cache.get(key)!=null) {
				return cache.get(key);
			}
			long answer = performBlinkForStoneValue(1, step+1, last, cache);
			cache.put(key, answer);
			return answer;
		}
		else if(hasEvenNumberOfDigits(value)) {
			if(cache.get(key)!=null) {
				return cache.get(key);
			}
			String curValueString = String.valueOf(value);
			String leftHalf = curValueString.substring(0, curValueString.length()/2);
			String rightHalf = curValueString.substring(curValueString.length()/2);
			long answer = performBlinkForStoneValue(Long.valueOf(leftHalf), step+1, last, cache) + 
					performBlinkForStoneValue(Long.valueOf(rightHalf), step+1, last, cache);
			cache.put(key, answer);
			return answer;
		} else {
			if(cache.get(key)!=null) {
				return cache.get(key);
			}
			long answer = performBlinkForStoneValue(value * 2024, step+1, last, cache);
			cache.put(key, answer);
			return answer;
		}
	}
}
