package day14;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day14Part2 {

	private Day14 day14;
	
	@BeforeEach
	public void setup() {
		day14 = new Day14(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	
//	@Test //commenting because it takes too long to run.
	void part2_answer() throws Exception {
		day14 = new Day14();
//		System.out.println(day14.moveTimesUntilTree());
		day14.moveTimes(7847);
		assertTrue(day14.getMap().toString().contains("1111111"));
		System.out.println(day14.getMap());//Has a tree in it.
	}
}
