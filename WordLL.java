/**
 * this class stores the mystery word along with all of the subsequent guessed that have occured
 *
 */
public class WordLL {
	//set private given variables
	private Word mysteryWord;
	private LinearNode<Word> history;
	
	//method to set history as null and mysterWord as mystery
	public WordLL(Word mystery) {
		history = null;
		mysteryWord = mystery;
	}
	
	//method to check if the guess is equal to the mystery word
	public boolean tryWord(Word guess) {
		LinearNode<Word> guessNext = new LinearNode<Word>(guess);
		guessNext.setNext(history);
		history = guessNext;
		boolean same = guess.labelWord(mysteryWord);
		//if they are the same return true, otherwise return false
		if (same == true) {
			return true;
		} else {
			return false;
		}
	}
	
	//method shows past guesses starting with most recent games
	public String toString() {
		LinearNode<Word> historyTemp = history;
		//initialize output string
		String stringOut = "";
		//while the history contains an element, print it out
		while (historyTemp != null) {
			stringOut += historyTemp.getElement().toString() + "\n";
			historyTemp = historyTemp.getNext();
		}
		return stringOut;
	}
}
