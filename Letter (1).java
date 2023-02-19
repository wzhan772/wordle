/**
 * this class represents a single letter that will be used in the game 
 * @author William Zhang 251215208
 *
 */
public class Letter {
	//private variables given to set
	private char letter;
	private int label;
	final private int UNSET = 0;
	final private int UNUSED = 1;
	final private int USED = 2;
	final private int CORRECT = 3;
	
	//method used to set variables label and letter
	public Letter(char c) {
		label = UNSET;
		letter = c;
	}
	
	//method used to check if otherObject is of the class Letter
	public boolean equals(Object otherObject) {
		if (otherObject instanceof Letter) {
			if (((Letter) otherObject).letter == letter) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * method used to return +, -, !, or "space"
	 * @return value of decorator
	 */
	public String decorator() {
		String letterDec = "";
		if (label == USED) {
			letterDec = "+";
		} else if (label == UNUSED) {
			letterDec = "-";
		} else if (label == CORRECT) {
			letterDec = "!";
		} else if (label == UNSET) {
			letterDec = " ";
		}
		return letterDec;
	}
	
	// method used to output letter and label in specified format
	public String toString() {
		String dString = decorator();
		return (dString + letter + dString);
	}
	
	//method used to set label to UNUSED
	public void setUnused() {
		label = UNUSED;
	}
	
	//method used to set label to USED
	public void setUsed() {
		label = USED;
	}
	
	//method used to set label to CORRECT
	public void setCorrect() {
		label = CORRECT;
	}
	
	//method used check if label is UNUSED 
	public boolean isUnused() {
		if (label == UNUSED) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param s String s
	 * @return array of objects of class Letter
	 */
	public static Letter[] fromString(String s) {
		Letter[] chars = new Letter[s.length()];
		for (int i = 0; i < s.length(); i++) {
			chars[i] = new Letter(s.charAt(i));
		}
		return chars;
	}
}
