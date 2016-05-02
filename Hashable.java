/**
 * Joel Quainoo
 * The <code>Hashable</code> interface provides the basic structure for any
 * data type that can be hashed. This means that any instance of the data type
 * should be interpretable as an integer. The <code>hash()</code> method of
 * this interface achieves this. For example, for a <code>String</code> data
 * type, the key of a string instance <code>s</code> should be an integer value
 * achieved by calling <code>s.hash()</code>.
 * @author leonjoel
 */
public interface Hashable {
    /**
     * Converts an instance of a hashable data type to a non-negative integer.
     * @return the integer value.
     */
	int hash(); 
}