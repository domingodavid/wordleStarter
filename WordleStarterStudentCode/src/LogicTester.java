import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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


		
		//WRITE additional assertions that the method
		//will surely FAIL. 
		//BREAK the code.......
		//test 4 - hard case 2
		
		
		
		//test 4 - hard case 3
		
		
 	}
	
	@Test
	void testGetCorrect() {
		//testing the method when the guess is aloft and the word is alien
		//results in a return of "al" because these are all the correctly guessed
		//letters
		assertTrue(Logic.getCorrect("alien", "aloft").equals("al"));		
		assertTrue(Logic.getCorrect("tares", "tarts").equals("tars"));
		assertTrue(Logic.getCorrect("tares", "cares").equals("ares"));
		assertTrue(Logic.getCorrect("alien", "poops").equals(""));

		
	}
	
	@Test
	void testGetLetters() {
		assertTrue(Logic.getLetters("alien", "among").equals("n"));
		assertTrue(Logic.getLetters("notes", "lists").equals("li"));
		
	}
	
	@Test
	void testDne() {
		//add yours
		
	}	
	
	@Test
	void testLocation() {
		// write the assert statements that test the
		// logic of the location method
		// 1) how do you call the method? 
		//      1b) what are the actual parameters going to be?
		// 2) what's the expected result for the actual parameters?
		//      2b) do you know why? 
		
		//easy test - test something that should return true
		assertTrue( Logic.location("alien", "apple", 0) );
		
		//east test - test something that should be false
		assertFalse( Logic.location("alien", "apple", 1) );
		assertFalse( Logic.location("alien", "apple", 2) );
		assertFalse( Logic.location("alien", "apple", 3) );
		
		
		
	}
	
	@Test
	void testGuessWord() {

	
	}
	
	@Test
	void testGetNext() {
		//create a dictionary
		ArrayList<String> dict = new ArrayList<String>();
		
		//add some words
		dict.add("alien"); //0
		dict.add("poops"); //1
		dict.add("cover"); //2
		dict.add("river"); //3
		dict.add("liver"); //4
		
		String usedList = "alienpoopscoverriver";
		
		//try generating the next index 5x. it should always return 4 because
		//it's the only free spot
		for(int i = 0; i < 5; i++) {
			//test that the next number should be at position 4
			int nextIndex = Logic.getNext(5, usedList, dict);
			
			//only word left is liver - should have generated
			//index 4 - can also just check index 4!
			assertTrue(nextIndex == 4);
			assertTrue(dict.get(nextIndex).equals("liver"));
		}
	}	
	
	@Test
	void testIsWord() {
		//create a dictionary
		ArrayList<String> dict = new ArrayList<String>();
		
		//add some words
		dict.add("alien");
		dict.add("poops");
		dict.add("cover");
		dict.add("river");
		dict.add("liver");
		
		//test #1 - check something that exists?
		//should be true because checking a word that's in the dictionary
		assertTrue(Logic.isWord("alien", dict)); 
		
		//test #2 - check something that doesn't exist?
		
		//test #3 - what else haven't we checked?
		
		//test #4 - anything else?
		
		
	}

}
