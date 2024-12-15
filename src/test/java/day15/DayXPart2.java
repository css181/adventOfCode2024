package day15;


import static org.junit.jupiter.api.Assertions.*;
import static day15.Directions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Map;

public class DayXPart2 {

	private Day15 day15;
	
	@BeforeEach
	public void setup() {
		day15 = new Day15(new File(getClass().getResource("SampleInput.txt").getPath()), 
				new File(getClass().getResource("SampleInstructions.txt").getPath()));
	}
	
	@Test 
	void verify_part2_input() {
		String expectedMap = "" +
				  "####################\n"
				+ "##....[]....[]..[]##\n"
				+ "##............[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##....[]@.....[]..##\n"
				+ "##[]##....[]......##\n"
				+ "##[]....[]....[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################\n";
		day15.adjustMapForPart2();
		
		assertEquals(expectedMap, day15.map.toString());
	}
	
	@Test
	void can_move_up_is_false_if_any_up_is_blocked() throws Exception {
		String expectedMap = "" +
				  "####################\n"
				+ "##....[]....[]..[]##\n"
				+ "##...[].......[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##....[].....[]..##\n"
				+ "##[]##.@..[]......##\n"
				+ "##[]....[]....[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################";
		day15.map = new Map(expectedMap, "\n");
		day15.assignRobot();
		assertFalse(day15.canMove((int)day15.robotPosition.getY(), (int)day15.robotPosition.getX(), UP));
	}
	@Test
	void can_move_up_is_true_if_all_up_is_free() throws Exception {
		String expectedMap = "" +
				  "####################\n"
				+ "##..........[]..[]##\n"
				+ "##...[].......[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##....[].....[]..##\n"
				+ "##[]##.@..[]......##\n"
				+ "##[]....[]....[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################";
		day15.map = new Map(expectedMap, "\n");
		day15.assignRobot();
		assertTrue(day15.canMove((int)day15.robotPosition.getY(), (int)day15.robotPosition.getX(), UP));
	}

	@Test
	void can_move_down_is_false_if_any_down_is_blocked() throws Exception {
		String expectedMap = "" +
				  "####################\n"
				+ "##....[]....[]..[]##\n"
				+ "##...[].......[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##....[]...@.[]..##\n"
				+ "##[]##....[]......##\n"
				+ "##[].....[]...[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################";
		day15.map = new Map(expectedMap, "\n");
		day15.assignRobot();
		assertFalse(day15.canMove((int)day15.robotPosition.getY(), (int)day15.robotPosition.getX(), DOWN));
	}
	@Test
	void can_move_down_is_true_if_all_down_is_free() throws Exception {
		String expectedMap = "" +
				  "####################\n"
				+ "##..........[]..[]##\n"
				+ "##...[].......[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##....[]...@.[]..##\n"
				+ "##[]##....[]......##\n"
				+ "##[]....[]....[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################";
		day15.map = new Map(expectedMap, "\n");
		day15.assignRobot();
		assertTrue(day15.canMove((int)day15.robotPosition.getY(), (int)day15.robotPosition.getX(), DOWN));
	}
	
	@Test
	void move_up_will_move_all_boxes_above() throws Exception {
		String startMap = "" +
				  "####################\n"
				+ "##..........[]..[]##\n"
				+ "##...[].......[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##....[].....[]...##\n"
				+ "##[]##.[].[]......##\n"
				+ "##[]...@[]....[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################";
		day15.map = new Map(startMap, "\n");
		day15.assignRobot();
		day15.instructionsList = new ArrayList<>(Arrays.asList(UP));
		day15.moveAll();
		
		String expectedMap = "" +
				  "####################\n"
				+ "##...[].....[]..[]##\n"
				+ "##....[]......[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##.....[]....[]...##\n"
				+ "##[]##.@..[]......##\n"
				+ "##[]....[]....[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################\n";
		assertEquals(expectedMap, day15.map.toString());
	}

	@Test
	void move_up_will_move_all_boxes_above2() throws Exception {
		String startMap = "" +
				  "####################\n"
				+ "##..........[]..[]##\n"
				+ "##.....[].....[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##....[].....[]...##\n"
				+ "##[]##.[].[]......##\n"
				+ "##[]....@[]...[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################";
		day15.map = new Map(startMap, "\n");
		day15.assignRobot();
		day15.instructionsList = new ArrayList<>(Arrays.asList(UP));
		day15.moveAll();
		
		String expectedMap = "" +
				  "####################\n"
				+ "##.....[]...[]..[]##\n"
				+ "##....[]......[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##.....[]....[]...##\n"
				+ "##[]##..@.[]......##\n"
				+ "##[].....[]...[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################\n";
		assertEquals(expectedMap, day15.map.toString());
	}

	@Test
	void move_up_will_not_move_if_blocked() throws Exception {
		String startMap = "" +
				  "####################\n"
				+ "##.....#....[]..[]##\n"
				+ "##.....[].....[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##....[].....[]...##\n"
				+ "##[]##.[].[]......##\n"
				+ "##[]....@[]...[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################";
		day15.map = new Map(startMap, "\n");
		day15.assignRobot();
		day15.instructionsList = new ArrayList<>(Arrays.asList(UP));
		day15.moveAll();
		
		String expectedMap = "" +
				  "####################\n"
				+ "##.....#....[]..[]##\n"
				+ "##.....[].....[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##....[].....[]...##\n"
				+ "##[]##.[].[]......##\n"
				+ "##[]....@[]...[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################\n";
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void move_up_will_not_move_if_blocked2() throws Exception {
		String startMap = "" +
				    "###########################################################\n"
				  + "##[]....[].............[][][][][][]##..[]....[][]....######\n"
				  + "##......[].........##[][]......[]..##[]....[]..[]....[]..##\n"
				  + "##....[].......[]..[]......##....[][][]......[]..........##\n"
				  + "##[].........##[][][]..........[]##[]............##..[]..##\n"
				  + "##[]..............[].....................[]..............##\n"
				  + "##....[]..[]][]...[].......[]..........[]..##......##....##\n"
				  + "##..........][][]..[]....[]............[]................##\n"
				  + "##......[]...####...@..[][][]..........[][][][]......##..##\n"
				  + "##[][]..[]##.[]..........[]##......##......[]..[][]..##..##\n"
				  + "##[].........##............[][]..........[]..[]....[]....##\n"
				  + "###########################################################";
		day15.map = new Map(startMap, "\n");
		day15.assignRobot();
		day15.instructionsList = new ArrayList<>(Arrays.asList(UP));
		day15.moveAll();
		
		String expectedMap = "" +
			    "###########################################################\n"
			  + "##[]....[].............[][][][][][]##..[]....[][]....######\n"
			  + "##......[].........##[][]......[]..##[]....[]..[]....[]..##\n"
			  + "##....[].......[]..[]......##....[][][]......[]..........##\n"
			  + "##[].........##[][][]..........[]##[]............##..[]..##\n"
			  + "##[]..............[].....................[]..............##\n"
			  + "##....[]..[]][]...[].......[]..........[]..##......##....##\n"
			  + "##..........][][]..[]....[]............[]................##\n"
			  + "##......[]...####...@..[][][]..........[][][][]......##..##\n"
			  + "##[][]..[]##.[]..........[]##......##......[]..[][]..##..##\n"
			  + "##[].........##............[][]..........[]..[]....[]....##\n"
			  + "###########################################################\n";
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void move_up_will_not_move_if_blocked3() throws Exception {
		String startMap = "" +
				    "#############################\n"
				  + "#..[]............[][]......##\n"
				  + "#..[]............[][]..[]..##\n"
				  + "#......[]..[]..[]##[]..##[]##\n"
				  + "#..[]..........[]..##[].[].##\n"
				  + "#..##..........[][].[][].@.##\n"
				  + "#############################";
		day15.map = new Map(startMap, "\n");
		day15.assignRobot();
		day15.instructionsList = new ArrayList<>(Arrays.asList(UP));
		day15.moveAll();
		
		String expectedMap = "" +
			    "#############################\n"
			  + "#..[]............[][]......##\n"
			  + "#..[]............[][]..[]..##\n"
			  + "#......[]..[]..[]##[]..##[]##\n"
			  + "#..[]..........[]..##[].[].##\n"
			  + "#..##..........[][].[][].@.##\n"
			  + "#############################\n";
		assertEquals(expectedMap, day15.map.toString());
	}
	
	@Test
	void move_down_will_move_all_boxes_below() throws Exception {
		String startMap = "" +
				  "####################\n"
				+ "##...@......[]..[]##\n"
				+ "##...[].......[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##....[].....[]...##\n"
				+ "##[]##.[].[]......##\n"
				+ "##[]....[]....[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################";
		day15.map = new Map(startMap, "\n");
		day15.assignRobot();
		day15.instructionsList = new ArrayList<>(Arrays.asList(DOWN));
		day15.moveAll();
		
		String expectedMap = "" +
				  "####################\n"
				+ "##..........[]..[]##\n"
				+ "##...@........[]..##\n"
				+ "##...[].....[]..[]##\n"
				+ "##..[][].....[]...##\n"
				+ "##[]##[]..[]......##\n"
				+ "##[]...[].....[]..##\n"
				+ "##..[][][][]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################\n";
		assertEquals(expectedMap, day15.map.toString());
	}
	@Test
	void move_down_will_move_all_boxes_below_then_be_blocked() throws Exception {
		String startMap = "" +
				  "####################\n"
				+ "##...@......[]..[]##\n"
				+ "##...[].......[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##....[].....[]...##\n"
				+ "##[]##.[].[]......##\n"
				+ "##[]....[]....[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################";
		day15.map = new Map(startMap, "\n");
		day15.assignRobot();
		day15.instructionsList = new ArrayList<>(Arrays.asList(DOWN, DOWN, DOWN));
		day15.moveAll();
		
		String expectedMap = "" +
				  "####################\n"
				+ "##..........[]..[]##\n"
				+ "##...@........[]..##\n"
				+ "##...[].....[]..[]##\n"
				+ "##..[][].....[]...##\n"
				+ "##[]##[]..[]......##\n"
				+ "##[]...[].....[]..##\n"
				+ "##..[][][][]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################\n";
		assertEquals(expectedMap, day15.map.toString());
	}

	@Test
	void move_right_will_move_all_boxes_right_then_be_blocked() throws Exception {
		String startMap = "" +
				  "####################\n"
				+ "##..........[]..[]##\n"
				+ "##...[]..#...@[]..##\n"
				+ "##..[][].#..[]..[]##\n"
				+ "##....[].#...[]...##\n"
				+ "##[]##.[]#[]......##\n"
				+ "##[]....[]....[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################";
		day15.map = new Map(startMap, "\n");
		day15.assignRobot();
		day15.instructionsList = new ArrayList<>(Arrays.asList(RIGHT, RIGHT, RIGHT));
		day15.moveAll();
		
		String expectedMap = "" +
				  "####################\n"
				+ "##..........[]..[]##\n"
				+ "##...[]..#.....@[]##\n"
				+ "##..[][].#..[]..[]##\n"
				+ "##....[].#...[]...##\n"
				+ "##[]##.[]#[]......##\n"
				+ "##[]....[]....[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################\n";
		assertEquals(expectedMap, day15.map.toString());
	}

	@Test
	void move_down_will_move_all_boxes_below2() throws Exception {
		String startMap = "" +
				  "####################\n"
				+ "##.....@....[]..[]##\n"
				+ "##.....[].....[]..##\n"
				+ "##..[][]....[]..[]##\n"
				+ "##....[].....[]...##\n"
				+ "##[]##.[].[]......##\n"
				+ "##[].....[]...[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################";
		day15.map = new Map(startMap, "\n");
		day15.assignRobot();
		day15.instructionsList = new ArrayList<>(Arrays.asList(DOWN));
		day15.moveAll();
		
		String expectedMap = "" +
				  "####################\n"
				+ "##..........[]..[]##\n"
				+ "##.....@......[]..##\n"
				+ "##..[].[]...[]..[]##\n"
				+ "##....[].....[]...##\n"
				+ "##[]##[]..[]......##\n"
				+ "##[]...[][]...[]..##\n"
				+ "##..[][]..[]..[][]##\n"
				+ "##........[]......##\n"
				+ "####################\n";
		assertEquals(expectedMap, day15.map.toString());
	}
	
	@Test
	void verify_all_moves_for_modified_input() throws Exception {
		String expectedMap = "" +
				    "####################\n"
				  + "##[].......[].[][]##\n"
				  + "##[]...........[].##\n"
				  + "##[]........[][][]##\n"
				  + "##[]......[]....[]##\n"
				  + "##..##......[]....##\n"
				  + "##..[]............##\n"
				  + "##..@......[].[][]##\n"
				  + "##......[][]..[]..##\n"
				  + "####################\n";
		day15.adjustMapForPart2();
		day15.moveAll();
		assertEquals(expectedMap, day15.map.toString());
	}
	
	@Test
	void verify_sum_of_gps_for_sample_is_9021() throws Exception {
		day15.adjustMapForPart2();
		day15.moveAll();
		assertEquals(9021, day15.calculateGPS_sum());
	}
	
	@Test
	void part2_answer() throws Exception {
		day15 = new Day15();
		day15.adjustMapForPart2();
		day15.moveAll();
		System.out.println(day15.map);
		System.out.println(day15.calculateGPS_sum());//1510523 is too low.  1610523 is too high.
													 //1514630 is too low.
//		assertEquals(9021, day15.calculateGPS_sum());//1597035 should be close-ish to.
		int curWalls = 0;
		for(int y=0; y<day15.map.getArea().size(); y++) {
			for(int x=0; x<day15.map.getArea().get(y).size(); x++) {
				char curChar = day15.map.getArea().get(y).get(x);
				if(curChar=='#') {
					curWalls++;
				}
			}
		}
		assertEquals(curWalls, day15.totalWalls);
	}
}
