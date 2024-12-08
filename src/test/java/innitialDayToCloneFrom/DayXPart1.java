package innitialDayToCloneFrom;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DayXPart1 {

	private DayX day1;
	
	@BeforeEach
	public void setup() {
		day1 = new DayX(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<Long> expectedLeftList = new ArrayList<Long>();
		ArrayList<Long> expectedRightList = new ArrayList<Long>();
		expectedLeftList.add(3l);
		expectedLeftList.add(4l);
		expectedLeftList.add(2l);
		expectedLeftList.add(1l);
		expectedLeftList.add(3l);
		expectedLeftList.add(3l);
		
		expectedRightList.add(4l);
		expectedRightList.add(3l);
		expectedRightList.add(5l);
		expectedRightList.add(3l);
		expectedRightList.add(9l);
		expectedRightList.add(3l);
		
//		assertEquals(expectedLeftList, day1.leftList);
//		assertEquals(expectedRightList, day1.rightList);
	}
	
	@Test
	void part1_answer() throws Exception {
		day1 = new DayX();
//		System.out.println(day1.getAnswer());
	}
}
