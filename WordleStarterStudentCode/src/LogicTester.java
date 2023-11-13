import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LogicTester {

	@Test
	void testExists() {
		// Test to see if exists works correctly
		// given some input, what is the expected output and
		// did your method return the expected?
		
		//test 1 - simple case 1
		assertFalse(Logic.exists("alien", "x"));
		
		//test 2 - simple case 2
		assertTrue(Logic.exists("alien", "a"));

 		//test 3 - simple case 3
		assertTrue(Logic.exists("alien", "n"));

	
		//Hard cases or corner cases that occur less often but are the
		//majority of cases the programmers miss
		//test 4 - hard case 1

		
		//test 4 - hard case 2
		
		
		//test 4 - hard case 3
		
		
 	}
	
	@Test
	void testGetCorrect() {
		assertTrue(Logic.getCorrect("alien", "aloft").equals("al"));
		assertTrue(Logic.getCorrect("tares", "tarts").equals("tar"));
		assertTrue(Logic.getCorrect("tares", "cares").equals("ares"));

	}
	
	@Test
	void testGetLetters() {
		assertTrue(Logic.getLetters("alien", "among").equals("n"));
		assertTrue(Logic.getLetters("notes", "lists").equals("li"));
		
	}
	
	@Test
	void testDne() {
		assertTrue(Logic.getLetters("alien", "among").equals("amog"));
		assertTrue(Logic.getLetters("notes", "lists").equals("li"));
		
	}
	
	
	
	@Test
	void testLocation() {

	
	}
	
	@Test
	void testGuessWord() {

	
	}
	
	
	@Test
	void testGetNext() {

	
	}
	
	
	
	@Test
	void testIsWord() {

		
	}
	

}
