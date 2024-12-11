package day11;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Node;

public class Day11Part1 {

	private Day11 day11;
	
	@BeforeEach
	public void setup() {
		day11 = new Day11(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		Node expectedSecondNode = new Node(17, null);
		Node expectedFirstNode = new Node(125, expectedSecondNode);
		
		assertEquals(expectedFirstNode, day11.firstNode);
		assertEquals(expectedSecondNode, day11.firstNode.getNext());
		assertEquals(2, day11.nodeCount);
	}
	
	@Test
	void after_1_blink_sample_is_253000_1_7() throws Exception {
		Node expected3 = new Node(7, null);
		Node expected2 = new Node(1, expected3);
		Node expected1 = new Node(253000, expected2);
		
		day11.blink();
		
		assertEquals(3, day11.nodeCount);
		assertEquals(expected1, day11.firstNode);
		assertEquals(expected2, day11.firstNode.getNext());
		assertEquals(expected3, day11.firstNode.getNext().getNext());
	}
	
	@Test
	void after_2_blink_sample_is_253_0_2024_14168() throws Exception {
		Node expected4 = new Node(14168, null);
		Node expected3 = new Node(2024, expected4);
		Node expected2 = new Node(0, expected3);
		Node expected1 = new Node(253, expected2);
		
		day11.blink();
		day11.blink();
		
		assertEquals(4, day11.nodeCount);
		assertEquals(expected1, day11.firstNode);
		assertEquals(expected2, day11.firstNode.getNext());
		assertEquals(expected3, day11.firstNode.getNext().getNext());
		assertEquals(expected4, day11.firstNode.getNext().getNext().getNext());
	}
	
	@Test
	void after_6_blink_sample_is_2097446912_14168_4048_2_0_2_4_40_48_2024_40_48_80_96_2_8_6_7_6_0_3_2() throws Exception {
		Node expected4 = new Node(2, null); //Actually should have many trailing Nodes.
		Node expected3 = new Node(4048, expected4);
		Node expected2 = new Node(14168, expected3);
		Node expected1 = new Node(2097446912, expected2);
		
		day11.blink();
		day11.blink();
		day11.blink();
		day11.blink();
		day11.blink();
		day11.blink();
		
		assertEquals(22, day11.nodeCount);
		assertEquals(expected1, day11.firstNode);
		assertEquals(expected2, day11.firstNode.getNext());
		assertEquals(expected3, day11.firstNode.getNext().getNext());
		assertEquals(expected4.getValue(), day11.firstNode.getNext().getNext().getNext().getValue());
	}
	
	@Test
	void verify_after_25_blinks_sample_has_55312_stones() throws Exception {
		day11.blink25Times();
		
		assertEquals(55312, day11.nodeCount);
	}
	
	@Test
	void part1_answer() throws Exception {
		day11 = new Day11();
		day11.blink25Times();
//		System.out.println(day11.nodeCount);
		assertEquals(193607, day11.nodeCount);
	}
}
