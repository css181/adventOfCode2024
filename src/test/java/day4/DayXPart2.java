package day4;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DayXPart2 {

	private Day4 day4;
	
	@BeforeEach
	public void setup() {
		day4 = new Day4(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_MAS_xs_is_9() {
		assertEquals(9, day4.getTotalMAS_X_Finds());
	}
	
	@Test
	void part2_answer() throws Exception {
		day4 = new Day4();
		System.out.println(day4.getTotalMAS_X_Finds());
	}
}
