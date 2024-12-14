package day12;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day12Part2 {

	private Day12 day12;
	
	@BeforeEach
	public void setup() {
		day12 = new Day12(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test
	void can_get_perimeters_for_all_regions() throws Exception {
		day12.calculateRegions();
		assertEquals(10, day12.getSidesOfRegion(day12.regions.get("R1")));
		assertEquals(4, day12.getSidesOfRegion(day12.regions.get("I1")));
		assertEquals(22, day12.getSidesOfRegion(day12.regions.get("C1")));
		assertEquals(12, day12.getSidesOfRegion(day12.regions.get("F1")));
		assertEquals(10, day12.getSidesOfRegion(day12.regions.get("V1")));
		assertEquals(12, day12.getSidesOfRegion(day12.regions.get("J1")));
		assertEquals(4, day12.getSidesOfRegion(day12.regions.get("C2")));
		assertEquals(8, day12.getSidesOfRegion(day12.regions.get("E1")));
		assertEquals(16, day12.getSidesOfRegion(day12.regions.get("I2")));
		assertEquals(6, day12.getSidesOfRegion(day12.regions.get("M1")));
		assertEquals(6, day12.getSidesOfRegion(day12.regions.get("S1")));
	}

	@Test
	void part2_answer() throws Exception {
		day12 = new Day12();
//		System.out.println(dayX.getAnswer()); around 850,000
	}
}
