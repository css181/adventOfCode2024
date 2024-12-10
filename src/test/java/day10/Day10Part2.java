package day10;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day10Part2 {

	private Day10 day10;
	
	@BeforeEach
	public void setup() {
		day10 = new Day10(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	
	@Test
	void verify_scores_of_all_sample_trailheads_when_we_count_every_path_to_each_9() throws Exception {
		ArrayList<Integer> expectedScores = new ArrayList<Integer>(Arrays.asList(20, 24, 10, 4, 1, 4, 5, 8, 5));
		
		assertEquals(expectedScores, day10.calculateTrailheadScoresAllowingMultiplePaths());
	}
	
	@Test
	void verify_sum_of_all_scores_from_sample_trailheads_is_36() throws Exception {
		assertEquals(81, day10.getSumOfAllTrailheadScoresAllowingMultiplePaths());
	}
	
	@Test
	void part2_answer() throws Exception {
		day10 = new Day10();
		System.out.println(day10.getSumOfAllTrailheadScoresAllowingMultiplePaths());
	}
}
