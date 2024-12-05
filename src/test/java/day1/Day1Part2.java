package day1;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day1Part2 {

	private Day1 day1;
	
	@BeforeEach
	public void setup() {
		day1 = new Day1(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void can_calculate_num_of_times_X_is_in_rightList() {
		assertEquals(3, day1.numOfTimesNumIsInRightList(3));
		assertEquals(1, day1.numOfTimesNumIsInRightList(4));
		assertEquals(0, day1.numOfTimesNumIsInRightList(2));
		assertEquals(0, day1.numOfTimesNumIsInRightList(1));
	}
	
	@Test
	void total_sample_similarity_scrore_is_31() throws Exception {
		assertEquals(31, day1.getTotalSimilarityScore());
	}
	
	@Test
	void part2_answer() throws Exception {
		day1 = new Day1();
		System.out.println(day1.getTotalSimilarityScore());
	}
}
