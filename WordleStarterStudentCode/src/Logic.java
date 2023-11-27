import java.util.ArrayList;

public class Logic {
	
	/*
	 * Return true if the character exists anywhere in str
	 * case should not matter
	 */
	public static boolean exists(String word, String character) {
		
		/*
		 * String methods: indexOf
		 *     returns an int where it starts in the String
		 *     returns -1 if not found
		 */
		
 		return (word.toLowerCase()).indexOf(character.toLowerCase()) >= 0  ;
 		
	}
		
	
	/* return true if the characters at i for word and current display are the same 
	 * 
	 * location("alien", "apple", 0) -> true (both are a)
	 * location("alien", "apple", 1) -> false (chars are not the same at 1)
	 * 
	 * */
	public static boolean location(String word, String curr, int i) {
		
		//String methods to use? : indexOf? 
		// substring? equals?
		return false;
		
		
	}
	
	/*
	 * Return true if the guess matches the word
	 */
	public static boolean guessWord(String guess, String word) {
		//to be completed
		return false;
	}

	
	/*
	 * Return a String with only the characters that are in the right
	 * place. 
	 * 
	 * @param word - the 5-letter word that is being guessed
	 * @param guess - the 5-letter guessed word
	 */
	public static String getCorrect(String word, String guess) {
		return "";
	}
	
	/*
	 * Return the characters that are in the word, but in the
	 * wrong spots
	 */
	public static String getLetters(String word, String guess) {
		
		return "";
		
	} 
	
	/*
	 * returns the characters from the guess that do not appear
	 * in the word
	 */
	public static String dne(String word, String guess) {
		return "";
	}
	
	
	/*
	 * Return a random number between 0 and total where
	 * total is the total number of words in our 5-word dictionary. 
	 * The same word cannot be selected twice. 
	 * 
	 * @param list the list of indexes that have already been used
	 */
	public static int getNext(int total, String usedList, ArrayList<String> dictionary) {
		System.out.println(total+":"+usedList);
		return -1; //delete me once you're ready to implement me
		//continue generating a random # between 0 and the the last possible 
		//index (inclusive)
		//check if it's in the used list!
		//if not, good to go
		//else generate another random number
		
		
		/* uncomment 95 to 105 and fill it in if you need some helper code */
		
//		int next = /* math.random formula */
//		String word = dictionary.get(next);		
//		while(usedList.indexOf(word)!=-1) {
//			//generate another index
//			next = ?;
//			
//			//grab the word from the new index by updating word
//			word = ?;
//		}
//	
//		return next;
		
		
	}
	
	/* return true if the word is a word 
	 * we should ignore case
	 * 
	 */ 
	public static boolean isWord(String guess, ArrayList<String> dictionary) {
		
		
		for(int i = 0; i < dictionary.size() ; i++) {
			
			//grab a word from the dictionary
			String word = dictionary.get(i);
			
			//what do we do with guess and the current word in the dictionary?
			if( word.equals(guess) ) { //found it in the dictionary at position i
				return true;
			}		
			
		}
		
		//if we traverse the entire dictionary and didn't return true
		//what does that mean? what's the result?
		// TO DO - return a result?
		return false;
	}

}
