package day1;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day1Part1 {

	private Day1 day1;
	
	@BeforeEach
	public void setup() {
		day1 = new Day1(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void convertFileToArrayOfCharArrayTest() {
		ArrayList<Long> expectedLeftList = new ArrayList<Long>();
		ArrayList<Long> expectedRightList = new ArrayList<Long>();
		expectedLeftList.add(3l);
		expectedLeftList.add(4l);
		expectedLeftList.add(2l);
		expectedLeftList.add(1l);
		expectedLeftList.add(3l);
		expectedLeftList.add(3l);
		
		expectedRightList.add(4l);
		expectedRightList.add(3l);
		expectedRightList.add(5l);
		expectedRightList.add(3l);
		expectedRightList.add(9l);
		expectedRightList.add(3l);
		
		assertEquals(expectedLeftList, day1.leftList);
		assertEquals(expectedRightList, day1.rightList);
	}
	
	@Test
	void can_sort_lists() throws Exception {
		ArrayList<Long> expectedLeftList = new ArrayList<Long>();
		ArrayList<Long> expectedRightList = new ArrayList<Long>();
		expectedLeftList.add(1l);
		expectedLeftList.add(2l);
		expectedLeftList.add(3l);
		expectedLeftList.add(3l);
		expectedLeftList.add(3l);
		expectedLeftList.add(4l);
		
		expectedRightList.add(3l);
		expectedRightList.add(3l);
		expectedRightList.add(3l);
		expectedRightList.add(4l);
		expectedRightList.add(5l);
		expectedRightList.add(9l);
		
		day1.sortBothlists();
		
		assertEquals(expectedLeftList, day1.leftList);
		assertEquals(expectedRightList, day1.rightList);
	}
	
	@Test
	void can_verify_diff_of_first_elements_after_sorting_is_2() throws Exception {
		assertEquals(2, day1.diffOfListsAtIndex(0));
	}
	@Test
	void can_verify_diff_of_second_elements_after_sorting_is_1() throws Exception {
		assertEquals(1, day1.diffOfListsAtIndex(1));
	}
	@Test
	void can_verify_diff_of_third_elements_after_sorting_is_0() throws Exception {
		assertEquals(0, day1.diffOfListsAtIndex(2));
	}
	@Test
	void can_verify_diff_of_fourth_elements_after_sorting_is_1() throws Exception {
		assertEquals(1, day1.diffOfListsAtIndex(3));
	}
	@Test
	void can_verify_diff_of_fifth_elements_after_sorting_is_2() throws Exception {
		assertEquals(2, day1.diffOfListsAtIndex(4));
	}
	@Test
	void can_verify_diff_of_sixth_elements_after_sorting_is_4() throws Exception {
		assertEquals(5, day1.diffOfListsAtIndex(5));
	}

	@Test
	void total_distance_apart_for_all_indexes_is_11() throws Exception {
		assertEquals(11, day1.totalDistanceBetweenBothFullLists());
	}
	
	@Test
	void part1_answer() throws Exception {
		day1 = new Day1();
//		System.out.println(day1.totalDistanceBetweenBothFullLists());
	}
}
