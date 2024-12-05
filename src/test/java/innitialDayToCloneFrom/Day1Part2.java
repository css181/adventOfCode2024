package innitialDayToCloneFrom;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day1Part2 {

	private DayX dayX;
	
	@BeforeEach
	public void setup() {
		dayX = new DayX(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void can_calculate_num_of_times_X_is_in_rightList() {
		assertEquals(3, dayX.numOfTimesNumIsInRightList(3));
		assertEquals(1, dayX.numOfTimesNumIsInRightList(4));
		assertEquals(0, dayX.numOfTimesNumIsInRightList(2));
		assertEquals(0, dayX.numOfTimesNumIsInRightList(1));
	}
	
	@Test
	void total_sample_similarity_scrore_is_31() throws Exception {
		assertEquals(31, dayX.getTotalSimilarityScore());
	}
	
	@Test
	void part2_answer() throws Exception {
		dayX = new DayX();
		System.out.println(dayX.getTotalSimilarityScore());
	}
}
