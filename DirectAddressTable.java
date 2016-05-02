/**
 * Joel Quainoo
 * @author leonjoel
 * DirectAddressTable.java
 * @param <V>
 */
@SuppressWarnings("unchecked")
public class DirectAddressTable<V extends Hashable> implements Dictionary<V> {
	private Object[] table;
	int size = 0;
	
	public DirectAddressTable(){
		table = new Object[26];
	}

	/*
	 * @see Dictionary#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	/*
	 * @see Dictionary#insert(Hashable)
	 */
	@Override
	public void insert(V value) {
		if(value == null)
			throw new NullPointerException(value +" is invalid");
		table[value.hash()] = value;
		size++;
	}

	/*
	 * @see Dictionary#delete(Hashable)
	 */
	@Override
	public V delete(V value){
		V data;
		if(isEmpty())
			throw new NullPointerException("Table Is Empty");
		else{
			data = ((V) table[value.hash()]);
			table[value.hash()] = null;
			size--;
		}
		return data;
	}

	/*
	 * @see Dictionary#find(int)
	 */
	@Override
	public V find(int key) {
		if(key < 0 || key >= 26)
			return null;
		return ((V) table[key]);
	}
	
	/**
	 * returns String representation of the table
	 */
	public String toString() {
		String str = "";
		for(int i = 0; i < table.length; i++){
			if(i < 10)
				str += (i + " ----- " + table[i] + "\n");
			else
				str += (i + " ---- " + table[i] + "\n");	
		}
		return str;
	}
	
}
