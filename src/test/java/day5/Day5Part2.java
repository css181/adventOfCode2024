package day5;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day5Part2 {

	private Day5 day5;
	
	@BeforeEach
	public void setup() {
		day5 = new Day5(new File(getClass().getResource("SampleInput.txt").getPath()), new File(getClass().getResource("SampleInput2.txt").getPath()));
	}
	
	@Test 
	void can_get_the_list_of_unOrdered_updates() {
		ArrayList<ArrayList<Integer>> expectedUnorderedUpdatePageLists = new ArrayList<ArrayList<Integer>>();
		expectedUnorderedUpdatePageLists.add(new ArrayList<>(Arrays.asList(75,97,47,61,53)));
		expectedUnorderedUpdatePageLists.add(new ArrayList<>(Arrays.asList(61,13,29)));
		expectedUnorderedUpdatePageLists.add(new ArrayList<>(Arrays.asList(97,13,75,29,47)));
		
		assertEquals(expectedUnorderedUpdatePageLists, day5.getAllUnorderedPageLists());
	}
	
	@Test
	void can_correctly_order_pageLists() throws Exception {
		ArrayList<ArrayList<Integer>> expectedUnorderedUpdatePageLists = new ArrayList<ArrayList<Integer>>();
		expectedUnorderedUpdatePageLists.add(new ArrayList<>(Arrays.asList(97,75,47,61,53)));
		expectedUnorderedUpdatePageLists.add(new ArrayList<>(Arrays.asList(61,29,13)));
		expectedUnorderedUpdatePageLists.add(new ArrayList<>(Arrays.asList(97,75,47,29,13)));
		
		assertEquals(expectedUnorderedUpdatePageLists, day5.getAllFixedOrderedPageLists());
	}
	
	@Test
	void part2_answer() throws Exception {
		day5 = new Day5();
//		System.out.println(day5.getSumOfMiddleNumberOfEachPageListIn(day5.getAllFixedOrderedPageLists()));
		assertEquals(5180, day5.getSumOfMiddleNumberOfEachPageListIn(day5.getAllFixedOrderedPageLists()));
	}
}
