package day6;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Coordinate;

public class Day6Part1 {

	private Day6 day6;
	
	@BeforeEach
	public void setup() {
		day6 = new Day6(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<ArrayList<Character>> expectedArea = new ArrayList<ArrayList<Character>>();
		expectedArea.add(new ArrayList<>(Arrays.asList('.','.','.','.','#','.','.','.','.','.')));
		expectedArea.add(new ArrayList<>(Arrays.asList('.','.','.','.','.','.','.','.','.','#')));
		expectedArea.add(new ArrayList<>(Arrays.asList('.','.','.','.','.','.','.','.','.','.')));
		expectedArea.add(new ArrayList<>(Arrays.asList('.','.','#','.','.','.','.','.','.','.')));
		expectedArea.add(new ArrayList<>(Arrays.asList('.','.','.','.','.','.','.','#','.','.')));
		expectedArea.add(new ArrayList<>(Arrays.asList('.','.','.','.','.','.','.','.','.','.')));
		expectedArea.add(new ArrayList<>(Arrays.asList('.','#','.','.','^','.','.','.','.','.')));
		expectedArea.add(new ArrayList<>(Arrays.asList('.','.','.','.','.','.','.','.','#','.')));
		expectedArea.add(new ArrayList<>(Arrays.asList('#','.','.','.','.','.','.','.','.','.')));
		expectedArea.add(new ArrayList<>(Arrays.asList('.','.','.','.','.','.','#','.','.','.')));
		
		assertEquals(expectedArea, day6.map.getArea());
	}
	
	@Test
	void guard_spot_can_be_identified_as_4_6() throws Exception {
		Coordinate expectedGuardSpot = new Coordinate(4, 6);
		assertEquals(expectedGuardSpot, day6.map.getGuardSpot());
	}
	
	@Test
	void guard_can_walk_up_leaving_Xs_in_his_wake() throws Exception {
		day6.walk();
		String expectedMap = "";
		expectedMap+=
			"....#.....\n" +
			"....>....#\n" +
			"....X.....\n" +
			"..#.X.....\n" +
			"....X..#..\n" +
			"....X.....\n" +
			".#..X.....\n" +
			"........#.\n" +
			"#.........\n" +
			"......#...\n";
		
		assertEquals(expectedMap.toString(), day6.map.toString());
	}
	
	@Test
	void after_turning_the_direction_and_image_of_the_guard_changes() throws Exception {
		Map map = day6.map;
		Coordinate guardSpot = map.getGuardSpot();
		assertEquals(Map.GUARD_DIRECTION.UP, day6.map.getDirection());
		assertEquals('^', map.getArea().get(guardSpot.getY()).get(guardSpot.getX()));
		
		day6.turn();
		assertEquals(Map.GUARD_DIRECTION.RIGHT, day6.map.getDirection());
		assertEquals('>', map.getArea().get(guardSpot.getY()).get(guardSpot.getX()));

		day6.turn();
		assertEquals(Map.GUARD_DIRECTION.DOWN, day6.map.getDirection());
		assertEquals('V', map.getArea().get(guardSpot.getY()).get(guardSpot.getX()));

		day6.turn();
		assertEquals(Map.GUARD_DIRECTION.LEFT, day6.map.getDirection());
		assertEquals('<', map.getArea().get(guardSpot.getY()).get(guardSpot.getX()));
	}
	
	@Test
	void guard_can_walk_right_leaving_Xs_in_his_wake() throws Exception {
		day6.walk();//up
		day6.walk();//right
		String expectedMap = "";
		expectedMap+=
			"....#.....\n" +
			"....XXXXV#\n" +
			"....X.....\n" +
			"..#.X.....\n" +
			"....X..#..\n" +
			"....X.....\n" +
			".#..X.....\n" +
			"........#.\n" +
			"#.........\n" +
			"......#...\n";
		
		assertEquals(expectedMap.toString(), day6.map.toString());
	}

	@Test
	void guard_can_walk_down_leaving_Xs_in_his_wake() throws Exception {
		day6.walk();//up
		day6.walk();//right
		day6.walk();//down
		String expectedMap = "";
		expectedMap+=
			"....#.....\n" +
			"....XXXXX#\n" +
			"....X...X.\n" +
			"..#.X...X.\n" +
			"....X..#X.\n" +
			"....X...X.\n" +
			".#..X...<.\n" +
			"........#.\n" +
			"#.........\n" +
			"......#...\n";
		
		assertEquals(expectedMap.toString(), day6.map.toString());
	}
	
	@Test
	void guard_can_walk_left_leaving_Xs_in_his_wake() throws Exception {
		day6.walk();//up
		day6.walk();//right
		day6.walk();//down
		day6.walk();//left
		String expectedMap = "";
		expectedMap+=
			"....#.....\n" +
			"....XXXXX#\n" +
			"....X...X.\n" +
			"..#.X...X.\n" +
			"....X..#X.\n" +
			"....X...X.\n" +
			".#^XXXXXX.\n" +
			"........#.\n" +
			"#.........\n" +
			"......#...\n";
		
		assertEquals(expectedMap.toString(), day6.map.toString());
	}
	
	@Test
	void guard_can_walk_until_they_get_out_of_the_area() throws Exception {
		day6.walkUntilOut();
		String expectedMap = "";
		expectedMap+=
			"....#.....\n" +
			"....XXXXX#\n" +
			"....X...X.\n" +
			"..#.X...X.\n" +
			"..XXXXX#X.\n" +
			"..X.X.X.X.\n" +
			".#XXXXXXX.\n" +
			".XXXXXXX#.\n" +
			"#XXXXXXX..\n" +
			"......#V..\n";
		
		assertEquals(expectedMap.toString(), day6.map.toString());
	}
	
	@Test
	void verify_guard_was_in_41_distinct_places_for_sample() throws Exception {
		day6.walkUntilOut();
		assertEquals(41, day6.getDistinctGuardPlaces());
	}
	
	@Test
	void part1_answer() throws Exception {
		day6 = new Day6();
		day6.walkUntilOut();
//		System.out.println(day6.getDistinctGuardPlaces());
		assertEquals(5444, day6.getDistinctGuardPlaces());
	}
}
