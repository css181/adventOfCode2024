package day2;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day2Part1 {

	private Day2 day2;
	
	@BeforeEach
	public void setup() {
		day2 = new Day2(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void convertFileToArrayOfCharArrayTest() {
		ArrayList<Report> expectedReports = new ArrayList<Report>();
		expectedReports.add(new ReportDecreasing(1,"7 6 4 2 1"));
		expectedReports.add(new ReportIncreasing(2,"1 2 7 8 9"));
		expectedReports.add(new ReportDecreasing(3,"9 7 6 2 1"));
		expectedReports.add(new ReportIncreasing(4,"1 3 2 4 5"));
		expectedReports.add(new ReportDecreasing(5,"8 6 4 4 1"));
		expectedReports.add(new ReportIncreasing(6,"1 3 6 7 9"));
		
		assertEquals(expectedReports, day2.getReports());
	}
	
	@Test
	void can_verify_if_report_is_safe() throws Exception {
		assertTrue(day2.getReports().get(0).isSafe());
		assertFalse(day2.getReports().get(1).isSafe());
		assertFalse(day2.getReports().get(2).isSafe());
		assertFalse(day2.getReports().get(3).isSafe());
		assertFalse(day2.getReports().get(4).isSafe());
		assertTrue(day2.getReports().get(5).isSafe());								
	}
	
	@Test
	void part1_answer() throws Exception {
		day2 = new Day2();
		System.out.println(day2.totalSafeReports());
	}
}
