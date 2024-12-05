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
	void can_verify_total_safe_with_dampener_is_4() {
		assertEquals(4, day2.totalSafeWithDampenerReports());
	}
	
	@Test
	void part2_answer() throws Exception {
		day2 = new Day2();
		System.out.println(day2.totalSafeWithDampenerReports());
	}
}
