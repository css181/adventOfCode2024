package day14;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Coordinate;

public class Day14Part1 {

	private Day14 day14;
	
	@BeforeEach
	public void setup() {
		day14 = new Day14(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<Robot> expectedRobots = new ArrayList<Robot>();
		expectedRobots.add(new Robot(new Coordinate(0, 4), new Coordinate(3, -3)));
		expectedRobots.add(new Robot(new Coordinate(6, 3), new Coordinate(-1, -3)));
		expectedRobots.add(new Robot(new Coordinate(10, 3), new Coordinate(-1, 2)));
		expectedRobots.add(new Robot(new Coordinate(2, 0), new Coordinate(2, -1)));
		expectedRobots.add(new Robot(new Coordinate(0, 0), new Coordinate(1, 3)));
		expectedRobots.add(new Robot(new Coordinate(3, 0), new Coordinate(-2, -2)));
		expectedRobots.add(new Robot(new Coordinate(7, 6), new Coordinate(-1, -3)));
		expectedRobots.add(new Robot(new Coordinate(3, 0), new Coordinate(-1, -2)));
		expectedRobots.add(new Robot(new Coordinate(9, 3), new Coordinate(2, 3)));
		expectedRobots.add(new Robot(new Coordinate(7, 3), new Coordinate(-1, 2)));
		expectedRobots.add(new Robot(new Coordinate(2, 4), new Coordinate(2, -3)));
		expectedRobots.add(new Robot(new Coordinate(9, 5), new Coordinate(-3, -3)));
		
		assertEquals(expectedRobots, day14.robots);
	}
	
	@Test
	void robots_can_move() throws Exception {
		Robot robot = new Robot(new Coordinate(4, 4), new Coordinate(1, -2));
		
		robot.move();
		assertEquals(robot.getPosition(), new Coordinate(5, 2));
		
		robot.move();
		assertEquals(robot.getPosition(), new Coordinate(6, 0));
	}
	
	@Test
	void robot_can_teleport_when_moving_horizontal_off_map() throws Exception {
		assertEquals(11, Day14.maxCols);
		assertEquals(7, Day14.maxRows);

		Robot robot = new Robot(new Coordinate(10, 4), new Coordinate(2, 0));
		robot.move();
		assertEquals(robot.getPosition(), new Coordinate(1, 4));
		
		robot = new Robot(new Coordinate(1, 4), new Coordinate(-2, 0));
		robot.move();
		assertEquals(robot.getPosition(), new Coordinate(10, 4));
	}
	@Test
	void robot_can_teleport_when_moving_vertical_off_map() throws Exception {
		assertEquals(11, Day14.maxCols);
		assertEquals(7, Day14.maxRows);

		Robot robot = new Robot(new Coordinate(3, 5), new Coordinate(0, 4));
		robot.move();
		assertEquals(robot.getPosition(), new Coordinate(3, 2));
		
		robot = new Robot(new Coordinate(4, 1), new Coordinate(0, -3));
		robot.move();
		assertEquals(robot.getPosition(), new Coordinate(4, 5));
	}
	
	@Test
	void after_100_moves_of_all_robots_verify_map() throws Exception {
		String expectedMap = "" +
			  "......2..1.\n"
			+ "...........\n"
			+ "1..........\n"
			+ ".11........\n"
			+ ".....1.....\n"
			+ "...12......\n"
			+ ".1....1....\n";
		
		day14.moveTimes(100);
		assertEquals(expectedMap, day14.getMap().toString());
	}
	
	@Test
	void after_100_moves_verify_counts_per_quartile() throws Exception {
		day14.moveTimes(100);
		ArrayList<Integer> expectedQuartiles = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 1));
		assertEquals(expectedQuartiles, day14.getRobotsInQuartiles());
	}
	
	@Test
	void verify_safety_factor_is_multiplying_all_quartiles() throws Exception {
		day14.moveTimes(100);
		assertEquals(12, day14.getSafetyFactor());
	}
	
	@Test
	void part1_answer() throws Exception {
		day14 = new Day14();
		assertEquals(101, Day14.maxCols);
		assertEquals(103, Day14.maxRows);
		day14.moveTimes(100);
//		System.out.println(day14.getSafetyFactor());
		assertEquals(225648864, day14.getSafetyFactor());
	}
}
