/**
 * Joel Quainoo
 * @author leonjoel
 */
public class Alphabet<E> implements Hashable<E> {
	private E ch;

	public Alphabet(E ch) {
		this.ch = ch;
	}

	/**
	 * @return the value of the class field - ch
	 */
	public E getCh() {
		return ch;
	}

	/**
	 * (int)getCh() to get ASCII value for the character - ch to an integer 
	 * There are 26 possible character set for all lower case alphabets for the so I 
	 * take the ASCII value for each character modulo 26 <total number of lower case
	 * alphabets> and return the key of for the slot for which the value can be inserted.
	 * @return an integer value.
	 * 
	 * This is so simple my a non-programming friends will be able to tell what this line [return ((int)getCh()) % 26;]
	 * is doing from their sleep.
	 */
	@Override
	public int hash() {
		return ((int)getCh()) % 26;
	}
	
	/**
	 * @return String value of the class field - ch
	 */
	public String toString(){
		return "" + ch;
	}
}
