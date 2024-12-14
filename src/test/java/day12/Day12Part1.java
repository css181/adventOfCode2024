package day12;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Map;

public class Day12Part1 {

	private Day12 day12;
	
	@BeforeEach
	public void setup() {
		day12 = new Day12(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		String input = "RRRRIICCFF\n"
				+ "RRRRIICCCF\n"
				+ "VVRRRCCFFF\n"
				+ "VVRCCCJFFF\n"
				+ "VVVVCJJCFE\n"
				+ "VVIVCCJJEE\n"
				+ "VVIIICJJEE\n"
				+ "MIIIIIJJEE\n"
				+ "MIIISIJEEE\n"
				+ "MMMISSJEEE";
		Map expectedMap = new Map(input, "\n");
		
		assertEquals(expectedMap, day12.map);
	}
	
	@Test
	void can_get_all_regions() throws Exception {
		day12.calculateRegions();
		
		assertEquals(11, day12.regions.size());
	}

	@Test
	void can_get_areas_for_all_regions() throws Exception {
		day12.calculateRegions();
		assertEquals(12, day12.getAreaOfRegion(day12.regions.get("R1")));
		assertEquals(4, day12.getAreaOfRegion(day12.regions.get("I1")));
		assertEquals(14, day12.getAreaOfRegion(day12.regions.get("C1")));
		assertEquals(10, day12.getAreaOfRegion(day12.regions.get("F1")));
		assertEquals(13, day12.getAreaOfRegion(day12.regions.get("V1")));
		assertEquals(11, day12.getAreaOfRegion(day12.regions.get("J1")));
		assertEquals(1, day12.getAreaOfRegion(day12.regions.get("C2")));
		assertEquals(13, day12.getAreaOfRegion(day12.regions.get("E1")));
		assertEquals(14, day12.getAreaOfRegion(day12.regions.get("I2")));
		assertEquals(5, day12.getAreaOfRegion(day12.regions.get("M1")));
		assertEquals(3, day12.getAreaOfRegion(day12.regions.get("S1")));
	}
	
	@Test
	void can_get_perimeters_for_all_regions() throws Exception {
		day12.calculateRegions();
		assertEquals(18, day12.getPerimeterOfRegion(day12.regions.get("R1")));
		assertEquals(8, day12.getPerimeterOfRegion(day12.regions.get("I1")));
		assertEquals(28, day12.getPerimeterOfRegion(day12.regions.get("C1")));
		assertEquals(18, day12.getPerimeterOfRegion(day12.regions.get("F1")));
		assertEquals(20, day12.getPerimeterOfRegion(day12.regions.get("V1")));
		assertEquals(20, day12.getPerimeterOfRegion(day12.regions.get("J1")));
		assertEquals(4, day12.getPerimeterOfRegion(day12.regions.get("C2")));
		assertEquals(18, day12.getPerimeterOfRegion(day12.regions.get("E1")));
		assertEquals(22, day12.getPerimeterOfRegion(day12.regions.get("I2")));
		assertEquals(12, day12.getPerimeterOfRegion(day12.regions.get("M1")));
		assertEquals(8, day12.getPerimeterOfRegion(day12.regions.get("S1")));
	}

	@Test
	void verify_total_cost_of_sample_is_1930() throws Exception {
		assertEquals(1930, day12.calculateCost());
	}
//	@Test
	void part1_answer() throws Exception {
		day12 = new Day12();
//		System.out.println(day12.calculateCost());
		assertEquals(1363484, day12.calculateCost());
	}
}
