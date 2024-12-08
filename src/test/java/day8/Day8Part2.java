package day8;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day8Part2 {

	private Day8 day8;
	@BeforeEach
	public void setup() {
		day8 = new Day8(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void after_adding_antinodes_for_every_multiple_of_distance_of_antennas_sample_has_34() {
		day8.fillAntinodesListForAllMultipleDistancesWithinMap();
		day8.deDupeAntinodesList();
//		System.out.println(day8.printAntinodesInMap());
		assertEquals(34, day8.antinodes.size());
	}
	
	@Test
	void part2_answer() throws Exception {
		day8 = new Day8();
		day8.fillAntinodesListForAllMultipleDistancesWithinMap();
		day8.deDupeAntinodesList();
//		System.out.println(day8.antinodes.size());
		assertEquals(1174, day8.antinodes.size());
	}
}
