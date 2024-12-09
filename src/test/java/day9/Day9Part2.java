package day9;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day9Part2 {

	private Day9 day9;
	
	@BeforeEach
	public void setup() {
		day9 = new Day9(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	

	@Test
	void can_sort_blocks() throws Exception {
		ArrayList<Integer> expectedListAfterSort = 
				new ArrayList<Integer>(Arrays.asList(0,0,9,9,2,1,1,1,7,7,7,0,4,4,0,3,3,3,0,0,0,0,5,5,5,5,0,6,6,6,6,0,0,0,0,0,8,8,8,8,0,0)); 
		assertEquals(expectedListAfterSort, day9.sortBlocksKeepingFilesTogether());
	}
	
	@Test
	void can_get_checksum_of_sorted_blocks() throws Exception {
		assertEquals(2858l, day9.getChecksumOfSortedBlocksByFullFiles());
	}
	
	@Test
	void part2_answer() throws Exception {
		day9 = new Day9();
//		System.out.println(day9.getChecksumOfSortedBlocksByFullFiles());
		assertEquals(6347435485773l, day9.getChecksumOfSortedBlocksByFullFiles());
	}
}
