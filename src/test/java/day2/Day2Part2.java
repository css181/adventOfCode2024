package day2;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day2Part2 {

	private Day2 day2;
	
	@BeforeEach
	public void setup() {
		day2 = new Day2(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void can_calculate_num_of_times_X_is_in_rightList() {
//		assertEquals(3, day2.numOfTimesNumIsInRightList(3));
//		assertEquals(1, day2.numOfTimesNumIsInRightList(4));
//		assertEquals(0, day2.numOfTimesNumIsInRightList(2));
//		assertEquals(0, day2.numOfTimesNumIsInRightList(1));
	}
	
	@Test
	void part2_answer() throws Exception {
		day2 = new Day2();
//		System.out.println(day2.getTotalSimilarityScore());
	}
}
