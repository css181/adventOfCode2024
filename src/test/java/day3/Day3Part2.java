package day3;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day3Part2 {

	private Day3 day3;
	
	@BeforeEach
	public void setup() {
		day3 = new Day3(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void can_calculate_num_of_times_X_is_in_rightList() {
//		assertEquals(3, day3.numOfTimesNumIsInRightList(3));
//		assertEquals(1, day3.numOfTimesNumIsInRightList(4));
//		assertEquals(0, day3.numOfTimesNumIsInRightList(2));
//		assertEquals(0, day3.numOfTimesNumIsInRightList(1));
	}
	
	@Test
	void part2_answer() throws Exception {
		day3 = new Day3();
//		System.out.println(day3.getTotalSimilarityScore());
	}
}
