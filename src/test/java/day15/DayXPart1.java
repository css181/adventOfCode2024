package day15;


import static org.junit.jupiter.api.Assertions.*;
import static day15.Directions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Coordinate;

public class DayXPart1 {

	private Day15 day15;
	
	@BeforeEach
	public void setup() {
		day15 = new Day15(new File(getClass().getResource("SimpleInput.txt").getPath()), 
						new File(getClass().getResource("SimpleInstructions.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		String expectedMap = "" +
		  "########\n"
		+ "#..O.O.#\n"
		+ "##@.O..#\n"
		+ "#...O..#\n"
		+ "#.#.O..#\n"
		+ "#...O..#\n"
		+ "#......#\n"
		+ "########\n";
		ArrayList<Directions> expectedInstructions = 
				new ArrayList<Directions>(Arrays.asList(LEFT, UP, UP, RIGHT, RIGHT, RIGHT, DOWN, DOWN, LEFT, DOWN, RIGHT, RIGHT, DOWN, LEFT, LEFT));
		Coordinate expectedRobot = new Coordinate(2, 2);
		
		assertEquals(expectedMap, day15.map.toString());
		assertEquals(expectedInstructions, day15.instructionsList);
		assertEquals(expectedRobot, day15.robotPosition);
	}
	
	@Test
	void verify_next_char_in_direction_is_x_away() throws Exception {
		assertEquals(1, day15.getDistanceFromRobot('.', UP));
		assertEquals(2, day15.getDistanceFromRobot('#', UP));
		assertEquals(1, day15.getDistanceFromRobot('.', DOWN));
		assertEquals(2, day15.getDistanceFromRobot('#', DOWN));
		assertEquals(Integer.MAX_VALUE, day15.getDistanceFromRobot('.', LEFT));
		assertEquals(1, day15.getDistanceFromRobot('#', LEFT));
		assertEquals(1, day15.getDistanceFromRobot('.', RIGHT));
		assertEquals(5, day15.getDistanceFromRobot('#', RIGHT));
	}
	
	@Test
	void can_move_if_dot_is_closer_to_robot_than_wall() throws Exception {
		assertTrue(day15.canMove(DOWN));
		assertTrue(day15.canMove(UP));
		assertTrue(day15.canMove(RIGHT));
		assertFalse(day15.canMove(LEFT));
	}
	
	@Test
	void verify_after_1_move() throws Exception {
		String expectedMap = "" +
				  "########\n"
				+ "#..O.O.#\n"
				+ "##@.O..#\n"
				+ "#...O..#\n"
				+ "#.#.O..#\n"
				+ "#...O..#\n"
				+ "#......#\n"
				+ "########\n";

		day15.moveNext();

		assertEquals(expectedMap, day15.map.toString());
	}

	@Test
	void verify_after_2_moves() throws Exception {
		String expectedMap = "" +
				  "########\n"
				+ "#.@O.O.#\n"
				+ "##..O..#\n"
				+ "#...O..#\n"
				+ "#.#.O..#\n"
				+ "#...O..#\n"
				+ "#......#\n"
				+ "########\n";

		day15.moveNext();
		day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}

	@Test
	void verify_after_3_moves() throws Exception {
		String expectedMap = "" +
				  "########\n"
				+ "#.@O.O.#\n"
				+ "##..O..#\n"
				+ "#...O..#\n"
				+ "#.#.O..#\n"
				+ "#...O..#\n"
				+ "#......#\n"
				+ "########\n";

		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void verify_after_4_moves() throws Exception {
		String expectedMap = "" +
				  "########\n"
				+ "#..@OO.#\n"
				+ "##..O..#\n"
				+ "#...O..#\n"
				+ "#.#.O..#\n"
				+ "#...O..#\n"
				+ "#......#\n"
				+ "########\n";

		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void verify_after_5_moves() throws Exception {
		String expectedMap = "" +
				  "########\n"
				+ "#...@OO#\n"
				+ "##..O..#\n"
				+ "#...O..#\n"
				+ "#.#.O..#\n"
				+ "#...O..#\n"
				+ "#......#\n"
				+ "########\n";

		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void verify_after_6_moves() throws Exception {
		String expectedMap = "" +
				  "########\n"
				+ "#...@OO#\n"
				+ "##..O..#\n"
				+ "#...O..#\n"
				+ "#.#.O..#\n"
				+ "#...O..#\n"
				+ "#......#\n"
				+ "########\n";

		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void verify_after_7_moves() throws Exception {
		String expectedMap = "" +
				    "########\n"
				  + "#....OO#\n"
				  + "##..@..#\n"
				  + "#...O..#\n"
				  + "#.#.O..#\n"
				  + "#...O..#\n"
				  + "#...O..#\n"
				  + "########\n";

		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void verify_after_8_moves() throws Exception {
		String expectedMap = "" +
				    "########\n"
				  + "#....OO#\n"
				  + "##..@..#\n"
				  + "#...O..#\n"
				  + "#.#.O..#\n"
				  + "#...O..#\n"
				  + "#...O..#\n"
				  + "########\n";

		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void verify_after_9_moves() throws Exception {
		String expectedMap = "" +
				    "########\n"
				  + "#....OO#\n"
				  + "##.@...#\n"
				  + "#...O..#\n"
				  + "#.#.O..#\n"
				  + "#...O..#\n"
				  + "#...O..#\n"
				  + "########\n";

		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void verify_after_10_moves() throws Exception {
		String expectedMap = "" +
				    "########\n"
				  + "#....OO#\n"
				  + "##.....#\n"
				  + "#..@O..#\n"
				  + "#.#.O..#\n"
				  + "#...O..#\n"
				  + "#...O..#\n"
				  + "########\n";

		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void verify_after_11_moves() throws Exception {
		String expectedMap = "" +
				    "########\n"
				  + "#....OO#\n"
				  + "##.....#\n"
				  + "#...@O.#\n"
				  + "#.#.O..#\n"
				  + "#...O..#\n"
				  + "#...O..#\n"
				  + "########\n";

		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void verify_after_12_moves() throws Exception {
		String expectedMap = "" +
				    "########\n"
				  + "#....OO#\n"
				  + "##.....#\n"
				  + "#....@O#\n"
				  + "#.#.O..#\n"
				  + "#...O..#\n"
				  + "#...O..#\n"
				  + "########\n";

		for(int x=0; x<12; x++)
			day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void verify_after_13_moves() throws Exception {
		String expectedMap = "" +
				    "########\n"
				  + "#....OO#\n"
				  + "##.....#\n"
				  + "#.....O#\n"
				  + "#.#.O@.#\n"
				  + "#...O..#\n"
				  + "#...O..#\n"
				  + "########\n";

		for(int x=0; x<13; x++)
			day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void verify_after_14_moves() throws Exception {
		String expectedMap = "" +
				    "########\n"
				  + "#....OO#\n"
				  + "##.....#\n"
				  + "#.....O#\n"
				  + "#.#O@..#\n"
				  + "#...O..#\n"
				  + "#...O..#\n"
				  + "########\n";

		for(int x=0; x<14; x++)
			day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void verify_after_15_moves() throws Exception {
		String expectedMap = "" +
				    "########\n"
				  + "#....OO#\n"
				  + "##.....#\n"
				  + "#.....O#\n"
				  + "#.#O@..#\n"
				  + "#...O..#\n"
				  + "#...O..#\n"
				  + "########\n";

		for(int x=0; x<15; x++)
			day15.moveNext();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	
	@Test
	void verify_all_moves_for_bigger_sample() throws Exception {
		day15 = new Day15(new File(getClass().getResource("SampleInput.txt").getPath()), 
				new File(getClass().getResource("SampleInstructions.txt").getPath()));
		String expectedMap = "" +
				  "##########\n"
				+ "#.O.O.OOO#\n"
				+ "#........#\n"
				+ "#OO......#\n"
				+ "#OO@.....#\n"
				+ "#O#.....O#\n"
				+ "#O.....OO#\n"
				+ "#O.....OO#\n"
				+ "#OO....OO#\n"
				+ "##########\n";
		day15.moveAll();
		assertEquals(expectedMap, day15.map.toString());
	}
	
	@Test
	void verify_sum_of_simple_gps_is_2028() throws Exception {
		day15.moveAll();
		assertEquals(2028, day15.calculateGPS_sum());
	}
	@Test
	void verify_sum_of_sample_gps_is_10092() throws Exception {
		day15 = new Day15(new File(getClass().getResource("SampleInput.txt").getPath()), 
				new File(getClass().getResource("SampleInstructions.txt").getPath()));
		day15.moveAll();
		assertEquals(10092, day15.calculateGPS_sum());
	}
	
	@Test
	void part1_answer() throws Exception {
		day15 = new Day15();
		day15.moveAll();
//		System.out.println(day15.calculateGPS_sum());
		assertEquals(1495147, day15.calculateGPS_sum());
	}
}
