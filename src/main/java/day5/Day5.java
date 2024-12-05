package day5;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;

import utilities.FileUtility;

public class Day5 {

	private static File file;
	private static File file2;
	protected ArrayList<OrderRule> orderRuleList = new ArrayList<OrderRule>();
	protected ArrayList<ArrayList<Integer>> updatePageLists = new ArrayList<ArrayList<Integer>>();

	public Day5() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		URL fileName2 = getClass().getResource("Input2.txt");
		file2 = new File(fileName2.getPath());
		populateInput();
	}
	public Day5(File file, File file2) {
		orderRuleList = new ArrayList<OrderRule>();
		updatePageLists = new ArrayList<ArrayList<Integer>>();
		setFileToUse(file, file2);
		populateInput();
	}

	protected void setFileToUse(File file, File file2) {
		Day5.file = file;
		Day5.file2 = file2;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			orderRuleList.add(new OrderRule(line));
		}
		updatePageLists = FileUtility.convertFileOfIntListsToListOfIntList(file2, ",");
	}
	
	public boolean isListInOrder(ArrayList<Integer> pages) {
		ArrayList<Integer> printedPages = new ArrayList<Integer>();
		printedPages.add(pages.get(0));
		for(int x=1; x<pages.size(); x++) {
			for (OrderRule orderRule : orderRuleList) {
				if(orderRule.getBeforePage()==pages.get(x) && printedPages.contains(orderRule.getAfterPage())) {
					return false;
				}
			}
			printedPages.add(pages.get(x));
		}
		return true;
	}
	
	public Long getSumOfMiddleNumberOfEachValidUpdatePageList() {
		long total = 0;
		for (ArrayList<Integer> pageList : updatePageLists) {
			if(isListInOrder(pageList)) {
				total+=getMiddleNumber(pageList);
			}
		}
		return total;
	}
	private long getMiddleNumber(ArrayList<Integer> pageList) {
		return pageList.get((pageList.size()-1)/2);
	}
}
