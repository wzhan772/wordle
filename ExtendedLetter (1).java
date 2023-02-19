/**
 * this class represents a subclass of Letter and adds additional features to the game
 * @author William Zhang 251215208
 *
 */
public class ExtendedLetter extends Letter{
	//set private given variables
	private String content;
	private int family;
	private boolean related;
	private int SINGLETON = -1;
	
	/**
	 * method sets all variables
	 * @param s is String s
	 */
	public ExtendedLetter(String s) {
		super('c');
		content = s;
		related = false;
		family = SINGLETON;
	}
	
	/**
	 * method initializes instance variables given
	 * @param s is String s
	 * @param fam is family int
	 */
	public ExtendedLetter(String s, int fam) {
		super('c');
		content = s;
		related = false;
		family = fam;
	}
	
	//method checks to see if other is an instanceOf extendedLetter
	public boolean equals(Object other) {
		if (other instanceof ExtendedLetter) {
			if (this.family == ((ExtendedLetter)other).family) {
				this.related = true;
			}
			if (this.content.equals(((ExtendedLetter)other).content)) {
				return true;
			}
		}
		return false;
	}
	
	//method that overrides Letter toString and gives representation of this
	//ExtendedLetter object
	public String toString() {
		String adjLetter = "";
		if (this.isUnused() && (this.related == true)) {
			adjLetter = "." + this.content + ".";
		} else {
			//set alternate string
			String alternate = decorator();
			adjLetter = alternate + this.content + alternate;
		}
		return adjLetter;
	}
	
	/**
	 * 
	 * @param content is size of array of content
	 * @param codes is int representation of codes
	 * @return array letters of the same size as the size of the array content
	 */
	public static Letter[] fromStrings(String[] content, int[] codes) {
		Letter[] letters = new Letter[content.length];
		//loop through and create new array
		for (int i = 0 ; i < content.length ; i++) {
			if (codes == null) {
				ExtendedLetter subContent = new ExtendedLetter(content[i]);
				letters[i] = subContent;
			} else {
				ExtendedLetter subContent = new ExtendedLetter(content[i], codes[i]);
				letters[i] = subContent;
			}
		}
		return letters;
	}
}
