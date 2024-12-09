package day9;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day9Part1 {

	private Day9 day9;
	
	@BeforeEach
	public void setup() {
		day9 = new Day9(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<Block> expectedBlocks = new ArrayList<Block>();
		expectedBlocks.add(new Block(new ArrayList<Integer>(Arrays.asList(0,0)), 0));
		expectedBlocks.add(new Block(new ArrayList<Integer>(), 3));
		expectedBlocks.add(new Block(new ArrayList<Integer>(Arrays.asList(1,1,1)), 0));
		expectedBlocks.add(new Block(new ArrayList<Integer>(), 3));
		expectedBlocks.add(new Block(new ArrayList<Integer>(Arrays.asList(2)), 0));
		expectedBlocks.add(new Block(new ArrayList<Integer>(), 3));
		expectedBlocks.add(new Block(new ArrayList<Integer>(Arrays.asList(3,3,3)), 0));
		expectedBlocks.add(new Block(new ArrayList<Integer>(), 1));
		expectedBlocks.add(new Block(new ArrayList<Integer>(Arrays.asList(4,4)), 0));
		expectedBlocks.add(new Block(new ArrayList<Integer>(), 1));
		expectedBlocks.add(new Block(new ArrayList<Integer>(Arrays.asList(5,5,5,5)), 0));
		expectedBlocks.add(new Block(new ArrayList<Integer>(), 1));
		expectedBlocks.add(new Block(new ArrayList<Integer>(Arrays.asList(6,6,6,6)), 0));
		expectedBlocks.add(new Block(new ArrayList<Integer>(), 1));
		expectedBlocks.add(new Block(new ArrayList<Integer>(Arrays.asList(7,7,7)), 0));
		expectedBlocks.add(new Block(new ArrayList<Integer>(), 1));
		expectedBlocks.add(new Block(new ArrayList<Integer>(Arrays.asList(8,8,8,8)), 0));
		expectedBlocks.add(new Block(new ArrayList<Integer>(), 0));
		expectedBlocks.add(new Block(new ArrayList<Integer>(Arrays.asList(9,9)), 0));
		
		assertEquals(expectedBlocks, day9.getBlockList());
	}
	
	@Test
	void can_sort_blocks() throws Exception {
		ArrayList<Integer> expectedListAfterSort = new ArrayList<Integer>(Arrays.asList(0,0,9,9,8,1,1,1,8,8,8,2,7,7,7,3,3,3,6,4,4,6,5,5,5,5,6,6));
		assertEquals(expectedListAfterSort, day9.sortBlocks());
	}
	
	@Test
	void can_get_checksum_of_sorted_blocks() throws Exception {
		assertEquals(1928l, day9.getChecksumOfSortedBlocks());
	}
	
	@Test
	void part1_answer() throws Exception {
		day9 = new Day9();
//		System.out.println(day9.getChecksumOfSortedBlocks());
		assertEquals(6320029754031l, day9.getChecksumOfSortedBlocks());
	}
}
