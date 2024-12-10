package day10;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Coordinate;

public class Day10Part1 {

	private Day10 day10;
	
	@BeforeEach
	public void setup() {
		day10 = new Day10(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<ArrayList<Integer>> expectedTopograph = new ArrayList<ArrayList<Integer>>();
		expectedTopograph.add(new ArrayList<Integer>(Arrays.asList(8,9,0,1,0,1,2,3)));
		expectedTopograph.add(new ArrayList<Integer>(Arrays.asList(7,8,1,2,1,8,7,4)));
		expectedTopograph.add(new ArrayList<Integer>(Arrays.asList(8,7,4,3,0,9,6,5)));
		expectedTopograph.add(new ArrayList<Integer>(Arrays.asList(9,6,5,4,9,8,7,4)));
		expectedTopograph.add(new ArrayList<Integer>(Arrays.asList(4,5,6,7,8,9,0,3)));
		expectedTopograph.add(new ArrayList<Integer>(Arrays.asList(3,2,0,1,9,0,1,2)));
		expectedTopograph.add(new ArrayList<Integer>(Arrays.asList(0,1,3,2,9,8,0,1)));
		expectedTopograph.add(new ArrayList<Integer>(Arrays.asList(1,0,4,5,6,7,3,2)));
		
		assertEquals(expectedTopograph, day10.topograph);
	}
	
	@Test
	void can_identify_list_of_trailheads() throws Exception {
		ArrayList<Coordinate> expectedTrailheads = new ArrayList<Coordinate>();
		expectedTrailheads.add(new Coordinate(2, 0));
		expectedTrailheads.add(new Coordinate(4, 0));
		expectedTrailheads.add(new Coordinate(4, 2));
		expectedTrailheads.add(new Coordinate(6, 4));
		expectedTrailheads.add(new Coordinate(2, 5));
		expectedTrailheads.add(new Coordinate(5, 5));
		expectedTrailheads.add(new Coordinate(0, 6));
		expectedTrailheads.add(new Coordinate(6, 6));
		expectedTrailheads.add(new Coordinate(1, 7));
		
		assertEquals(expectedTrailheads, day10.trailheads);
	}
	
	@Test
	void verify_simpleInput_yeilds_1_trailhead_with_score_of_2() throws Exception {
		day10 = new Day10(new File(getClass().getResource("SimpleInput.txt").getPath()));
		assertEquals(Arrays.asList(new Coordinate(3, 0)), day10.trailheads);
		
		assertEquals(Arrays.asList(2), day10.calculateTrailheadScores());
	}
	
	@Test
	void verify_scores_of_all_sample_trailheads() throws Exception {
		ArrayList<Integer> expectedScores = new ArrayList<Integer>(Arrays.asList(5, 6, 5, 3, 1, 3, 5, 3, 5));
		
		assertEquals(expectedScores, day10.calculateTrailheadScores());
	}
	
	@Test
	void verify_sum_of_all_scores_from_sample_trailheads_is_36() throws Exception {
		assertEquals(36, day10.getSumOfAllTrailheadScores());
	}
	
	@Test
	void part1_answer() throws Exception {
		day10 = new Day10();
//		System.out.println(day10.getSumOfAllTrailheadScores());
		assertEquals(811, day10.getSumOfAllTrailheadScores());
	}
}
