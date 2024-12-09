package day9;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DayXPart1 {

	private Day9 day9;
	
	@BeforeEach
	public void setup() {
		day9 = new Day9(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		String expectedUnsortedBlocks = "00...111...2...333.44.5555.6666.777.888899";
		
		assertEquals(expectedUnsortedBlocks, day9.getUnsortedBlocks());
	}
	
	@Test
	void can_sort_blocks() throws Exception {
		String expectedSortedBlocks = "0099811188827773336446555566..............";
		assertEquals(expectedSortedBlocks, day9.sortBlocks());
	}
	
	@Test
	void can_get_checksum_of_sorted_blocks() throws Exception {
		assertEquals(1928l, day9.getChecksumOfSortedBlocks());
	}
	
	@Test
	void part1_answer() throws Exception {
		day9 = new Day9();
		System.out.println(day9.getChecksumOfSortedBlocks());
		//90192861055 is too low
	}
}
