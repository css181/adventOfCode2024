package day11;


import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day11Part2 {

	private Day11 day11;
	
	@BeforeEach
	public void setup() {
		day11 = new Day11(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test
	void part2_answer() throws Exception {
		day11 = new Day11();
		day11.blink75Times();
		System.out.println(day11.nodeCount);
	}
}
