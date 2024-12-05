package day5;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DayXPart2 {

	private Day5 day5;
	
	@BeforeEach
	public void setup() {
		day5 = new Day5(new File(getClass().getResource("SampleInput.txt").getPath()), new File(getClass().getResource("SampleInput2.txt").getPath()));
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
		day5 = new Day5();
//		System.out.println(dayX.getAnswer());
	}
}
