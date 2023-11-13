import java.util.ArrayList;

public class Logic {
	
	/*
	 * Return true if the character exists anywhere in str
	 */
	public static boolean exists(String word, String character) {
 		return false;
	}
		
	
	/* return true if the characters at i for word and current display are the same */
	public static boolean location(String word, String curr, int i) {
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
	public static int getNext(int total, String usedList) {
		System.out.println(total+":"+usedList);
		//to do
		return 0;
		
	}
	
	/* return true if the word is a word */
	public static boolean isWord(String guess, ArrayList<String> dictionary) {
		
		
		
		return false;
		
	}

}
