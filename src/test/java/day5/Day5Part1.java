package day5;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day5Part1 {

	private Day5 day5;
	
	@BeforeEach
	public void setup() {
		day5 = new Day5(new File(getClass().getResource("SampleInput.txt").getPath()), new File(getClass().getResource("SampleInput2.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<OrderRule> expectedOrderRuleList = new ArrayList<OrderRule>();
		ArrayList<ArrayList<Integer>> expectedUpdatePageLists = new ArrayList<ArrayList<Integer>>();
		expectedOrderRuleList.add(new OrderRule("47|53"));
		expectedOrderRuleList.add(new OrderRule("97|13"));
		expectedOrderRuleList.add(new OrderRule("97|61"));
		expectedOrderRuleList.add(new OrderRule("97|47"));
		expectedOrderRuleList.add(new OrderRule("75|29"));
		expectedOrderRuleList.add(new OrderRule("61|13"));
		expectedOrderRuleList.add(new OrderRule("75|53"));
		expectedOrderRuleList.add(new OrderRule("29|13"));
		expectedOrderRuleList.add(new OrderRule("97|29"));
		expectedOrderRuleList.add(new OrderRule("53|29"));
		expectedOrderRuleList.add(new OrderRule("61|53"));
		expectedOrderRuleList.add(new OrderRule("97|53"));
		expectedOrderRuleList.add(new OrderRule("61|29"));
		expectedOrderRuleList.add(new OrderRule("47|13"));
		expectedOrderRuleList.add(new OrderRule("75|47"));
		expectedOrderRuleList.add(new OrderRule("97|75"));
		expectedOrderRuleList.add(new OrderRule("47|61"));
		expectedOrderRuleList.add(new OrderRule("75|61"));
		expectedOrderRuleList.add(new OrderRule("47|29"));
		expectedOrderRuleList.add(new OrderRule("75|13"));
		expectedOrderRuleList.add(new OrderRule("53|13"));
		
		expectedUpdatePageLists.add(new ArrayList<>(Arrays.asList(75,47,61,53,29)));
		expectedUpdatePageLists.add(new ArrayList<>(Arrays.asList(97,61,53,29,13)));
		expectedUpdatePageLists.add(new ArrayList<>(Arrays.asList(75,29,13)));
		expectedUpdatePageLists.add(new ArrayList<>(Arrays.asList(75,97,47,61,53)));
		expectedUpdatePageLists.add(new ArrayList<>(Arrays.asList(61,13,29)));
		expectedUpdatePageLists.add(new ArrayList<>(Arrays.asList(97,13,75,29,47)));
		
		assertEquals(expectedOrderRuleList, day5.orderRuleList);
		assertEquals(expectedUpdatePageLists, day5.updatePageLists);
	}
	
	@Test
	void can_validate_updatePageList_is_in_order() throws Exception {
		assertTrue(day5.isListInOrder(day5.updatePageLists.get(0)));
		assertTrue(day5.isListInOrder(day5.updatePageLists.get(1)));
		assertTrue(day5.isListInOrder(day5.updatePageLists.get(2)));
		assertFalse(day5.isListInOrder(day5.updatePageLists.get(3)));
		assertFalse(day5.isListInOrder(day5.updatePageLists.get(4)));
		assertFalse(day5.isListInOrder(day5.updatePageLists.get(5)));
	}
	
	@Test
	void can_get_middle_number_in_each_valid_updatePageList() throws Exception {
		assertEquals(143, day5.getSumOfMiddleNumberOfEachValidUpdatePageList());
	}
	
	@Test
	void part1_answer() throws Exception {
		day5 = new Day5();
//		System.out.println(day5.getSumOfMiddleNumberOfEachValidUpdatePageList());
		assertEquals(5713, day5.getSumOfMiddleNumberOfEachValidUpdatePageList());
	}
}
