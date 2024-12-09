package day6;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day6Part2 {

	private Day6 day6;
	
	@BeforeEach
	public void setup() {
		day6 = new Day6(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test
	void can_get_total_number_of_walks_to_get_out_should_be_11() throws Exception {
		assertEquals(11, day6.walkUntilOut());
	}
	
	@Test
	void can_get_total_number_of_walks_to_get_out_should_be_165_for_real_input() throws Exception {
		day6 = new Day6();
		assertEquals(165, day6.walkUntilOut());
	}
	
	@Test
	void can_use_brute_force_to_see_how_many_places_can_add_obstructions_for_infinite_loops() throws Exception {
		assertEquals(6, day6.bruteForceHowManyObstructionsCauseInfiniteLoops());
	}

	//TODO: Better ways of doing this:
		//1) Look for the pattern that would cause an infinite loop.  It will always create some kind of rectangle
		//2) Keep track of which direction you walk on every square.  If you ever are on the same square going in the same direction, that's an infinite loop.
	
	@Test
	void part2_answer() throws Exception {
		day6 = new Day6();
//		System.out.println(day6.bruteForceHowManyObstructionsCauseInfiniteLoops());
		assertEquals(1946, day6.bruteForceHowManyObstructionsCauseInfiniteLoops());
	}
}
