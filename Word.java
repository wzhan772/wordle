/**
 * this class represents a word in the game that is made up of any number of letters
 *
 */
public class Word {
	//set private given variable
	private LinearNode<Letter> firstLetter;
	
	/**
	 * this method stores letters within the linked structure
	 * @param letters is the input of letters
	 */
	public Word(Letter[] letters) {
		firstLetter = new LinearNode<Letter>(letters[0]);
		LinearNode<Letter> node = firstLetter;
		//loop through to add each letter into the list
		for (int i = 1; i < letters.length; i++) {
			LinearNode<Letter> newNode = new LinearNode<Letter>(letters[i]);
			node.setNext(newNode);
			node = newNode;
		}
	}
	
	//method used to output the word in specified format
	public String toString() {
		LinearNode<Letter> position = firstLetter;
		//placeholder to use at the end
		String wordHolder = "Word:";
		String wordElements = "";
		while (position != null) {
			//add each letter to the word
			wordElements += (" " + position.getElement().toString());
			position = position.getNext();
		}
		return (wordHolder + wordElements + " ");
	}
	
	/**
	 * this method labels letter objects with respect to a mystery word
	 * @param mystery is the mystery word
	 * @return true or false depending on the guess and letter of the actual word
	 */
	public boolean labelWord(Word mystery) {
		LinearNode<Letter> attempt = firstLetter;
		LinearNode<Letter> wordCheck = mystery.firstLetter;
		//set counters to check the position of guess and word and the number of correct guesses
		int indexCheck = 0; 
		int correctLetter = 0; 
		if (mystery != null && (firstLetter != null)) {
			//while loop compares all the letters to the mystery word
			while (attempt != null) {
				attempt.getElement().setUnused();
				wordCheck = mystery.firstLetter;
				//index inside loop to check that loop is still valid
				int indexCheckIn = 0;
				while (wordCheck != null) {
					//set each guess as used, correct, and check if the guess has a letter to begin with
					if (attempt.getElement().equals(wordCheck.getElement())) {
						attempt.getElement().setUsed();
						if (indexCheck == indexCheckIn) {
							attempt.getElement().setCorrect();
							correctLetter = correctLetter + 1;
						} else if (indexCheck > indexCheckIn) {
							wordCheck = wordCheck.getNext();
							indexCheckIn = indexCheckIn + 1;
							if (wordCheck != null) {
								if (attempt.getElement().equals(wordCheck.getElement())) {
									attempt.getElement().setCorrect();
									correctLetter = correctLetter + 1;
								}
							}
						}
						//break out of the loop
						break;
					}
					//get the next check and increase the index by one
					wordCheck = wordCheck.getNext();
					indexCheckIn++;
				}
				//increase outer index by one and get the next attempt
				attempt = attempt.getNext();
				indexCheck++;
			}
			//if the check is not empty and the letter matches with the index then return true
			if (wordCheck != null) {
				if (correctLetter == indexCheck && (wordCheck.getNext() == null)) {
					return true;
				}
			}
		}
		return false;
	}
}
