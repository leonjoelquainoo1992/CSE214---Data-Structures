import java.util.Comparator;

public interface Sorter<E>{
	public void sort();
	public void setComparator(Comparator<E> comparator);
}
