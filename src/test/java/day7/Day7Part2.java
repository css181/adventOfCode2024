package day7;


import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day7Part2 {

	private Day7 day7;
	
	@BeforeEach
	public void setup() {
		day7 = new Day7(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void can_calculate_num_of_times_X_is_in_rightList() {
//		assertEquals(3, dayX.numOfTimesNumIsInRightList(3));
//		assertEquals(1, dayX.numOfTimesNumIsInRightList(4));
//		assertEquals(0, dayX.numOfTimesNumIsInRightList(2));
//		assertEquals(0, dayX.numOfTimesNumIsInRightList(1));
	}
	
	@Test
	void part2_answer() throws Exception {
		day7 = new Day7();
//		System.out.println(dayX.getAnswer());
	}
}
