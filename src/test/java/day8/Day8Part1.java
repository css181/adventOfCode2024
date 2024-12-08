package day8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Coordinate;
import utilities.Map;

public class Day8Part1 {

	private Day8 day8;
	
	@BeforeEach
	public void setup() {
		day8 = new Day8(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<ArrayList<Character>> expectedArea = new ArrayList<ArrayList<Character>>();
		expectedArea.add(new ArrayList<Character> (Arrays.asList('.','.','.','.','.','.','.','.','.','.','.','.')));
		expectedArea.add(new ArrayList<Character> (Arrays.asList('.','.','.','.','.','.','.','.','0','.','.','.')));
		expectedArea.add(new ArrayList<Character> (Arrays.asList('.','.','.','.','.','0','.','.','.','.','.','.')));
		expectedArea.add(new ArrayList<Character> (Arrays.asList('.','.','.','.','.','.','.','0','.','.','.','.')));
		expectedArea.add(new ArrayList<Character> (Arrays.asList('.','.','.','.','0','.','.','.','.','.','.','.')));
		expectedArea.add(new ArrayList<Character> (Arrays.asList('.','.','.','.','.','.','A','.','.','.','.','.')));
		expectedArea.add(new ArrayList<Character> (Arrays.asList('.','.','.','.','.','.','.','.','.','.','.','.')));
		expectedArea.add(new ArrayList<Character> (Arrays.asList('.','.','.','.','.','.','.','.','.','.','.','.')));
		expectedArea.add(new ArrayList<Character> (Arrays.asList('.','.','.','.','.','.','.','.','A','.','.','.')));
		expectedArea.add(new ArrayList<Character> (Arrays.asList('.','.','.','.','.','.','.','.','.','A','.','.')));
		expectedArea.add(new ArrayList<Character> (Arrays.asList('.','.','.','.','.','.','.','.','.','.','.','.')));
		expectedArea.add(new ArrayList<Character> (Arrays.asList('.','.','.','.','.','.','.','.','.','.','.','.')));
		FrequencyMap expectedMap = new FrequencyMap(expectedArea);
		
		assertEquals(expectedMap, day8.map);
	}
	
	@Test
	void verify_unique_list_of_frequencies() throws Exception {
		ArrayList<Character> expectedFrequencies = new ArrayList<Character>();
		expectedFrequencies.add('0');
		expectedFrequencies.add('A');
		
		assertEquals(expectedFrequencies, day8.map.getUniqueFrequencies());
	}
	
	@Test
	void can_get_distance_between_bigger_and_smaller_coordinate() throws Exception {
		Coordinate coordA = new Coordinate(9, 5);
		Coordinate coordB = new Coordinate(5, 3);
		
		assertEquals(new Coordinate(4, 2), coordA.getDistanceFrom(coordB));
	}
	@Test
	void can_get_distance_between_smaller_and_bigger_coordinate() throws Exception {
		Coordinate coordA = new Coordinate(5, 3);
		Coordinate coordB = new Coordinate(9, 5);
		
		assertEquals(new Coordinate(4, 2), coordA.getDistanceFrom(coordB));
	}
	
	@Test
	void can_fill_antinodes_list_from_map_with_all_15() throws Exception {
		ArrayList<Antinode> expectedAntinodes = new ArrayList<Antinode>();
		expectedAntinodes.add(new Antinode(new Coordinate(6, 0), '0'));
		expectedAntinodes.add(new Antinode(new Coordinate(11, 0), '0'));
		expectedAntinodes.add(new Antinode(new Coordinate(3, 1), '0'));
		expectedAntinodes.add(new Antinode(new Coordinate(3, 1), 'A')); //Note: (3,1) is an antinode for both 0 and A, giving us 15 total.
		expectedAntinodes.add(new Antinode(new Coordinate(4, 2), 'A'));
		expectedAntinodes.add(new Antinode(new Coordinate(10, 2), '0'));
		expectedAntinodes.add(new Antinode(new Coordinate(2, 3), '0'));
		expectedAntinodes.add(new Antinode(new Coordinate(9, 4), '0'));
		expectedAntinodes.add(new Antinode(new Coordinate(6, 5), '0'));
		expectedAntinodes.add(new Antinode(new Coordinate(1, 5), '0'));
		expectedAntinodes.add(new Antinode(new Coordinate(3, 6), '0'));
		expectedAntinodes.add(new Antinode(new Coordinate(0, 7), '0'));
		expectedAntinodes.add(new Antinode(new Coordinate(7, 7), 'A'));
		expectedAntinodes.add(new Antinode(new Coordinate(10, 10), 'A'));
		expectedAntinodes.add(new Antinode(new Coordinate(10, 11), 'A'));
		
		day8.fillAntinodesList();
		
		for (Antinode antinode : day8.antinodes) {
			assertTrue(expectedAntinodes.contains(antinode), "Antinode: " + antinode);
		}
		assertEquals(expectedAntinodes.size(), day8.antinodes.size());
		for (Antinode antinode : expectedAntinodes) {
			assertTrue(day8.antinodes.contains(antinode));
		}
	}
	
	@Test
	void after_filling_then_deDuping_antinodes_sample_should_have_14() throws Exception {
		day8.fillAntinodesList();
		day8.deDupeAntinodesList();
		
		assertEquals(14, day8.antinodes.size());
	}
	
	@Test
	void part1_answer() throws Exception {
		day8 = new Day8();
		day8.fillAntinodesList();
		day8.deDupeAntinodesList();
//		System.out.println(day8.antinodes.size());
		assertEquals(332, day8.antinodes.size());
	}
	
	@Test
	void map_in_utils_can_create_a_new_map_area_by_strings() throws Exception {
		String inputLines = "" + 
				"............\n" +
				"........0...\n" +
				".....0......\n" +
				".......0....\n" +
				"....0.......\n" +
				"......A.....\n" +
				"............\n" +
				"............\n" +
				"........A...\n" +
				".........A..\n" +
				"............\n" +
				"............";
		Map map = new utilities.Map(inputLines, "\n");
		
		assertEquals(inputLines+"\n", map.toString());
	}
}
