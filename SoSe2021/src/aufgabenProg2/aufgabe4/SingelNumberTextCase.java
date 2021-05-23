package aufgabenProg2.aufgabe4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SingelNumberTextCase 
{
	int[] numsA = {7,3,5,3,5};
	int[] numsB = {1,8,1,8};
	int[] numsC = {9};

	@Test
	void testSingleNumber() 
	{
		assertTrue(9==SingleNumber.singleNumber(numsC),"Mein Array: [9] Expected Ausagbe: 9");
		assertTrue(7==SingleNumber.singleNumber(numsA),"Mein Array: [7,3,5,3,5] Expected Ausgabe: 7");
		assertTrue(-1==SingleNumber.singleNumber(numsB),"Mein Array: [1,8,1,8] Expected Ausgabe: -1");
		assertFalse(6==SingleNumber.singleNumber(numsA),"Mein Array: [7,3,5,3,5] Expected Ausgabe: 6");
		//assertEquals(7==SingleNumber.singleNumber(numsA),"Mein Array: [7,3,5,3,5] Expected Ausgabe: 7");
	}

}
