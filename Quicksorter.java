import java.util.ArrayList;
import java.util.Comparator;

public class Quicksorter<E> implements Sorter<E>{
	private ArrayList<E> data;
	private Comparator<E> comparator;
	
	public Quicksorter(Comparator<E> comparator, ArrayList<E> data){
		this.comparator = comparator;
		this.data = data;
	}

	@Override
	public void sort() {
		 quickSort(data, 0, data.size() - 1);
	}

	private void quickSort( ArrayList<E> array, int low, int high) {
        int pivot;
        if(low >= high)
            return;
       pivot = partition(array, low, high);
       quickSort(array, low, pivot-1 );
       quickSort(array, pivot+1, high);
    }

	
	private int partition(ArrayList<E> arr, int lo, int hi)
    {
        E pivotVal = arr.get(lo);
        int right = hi;
        int left = lo + 1;

        while( left <= right )
        {
            while(left <= hi && comparator.compare(arr.get(right), pivotVal) == 1)
                left++;

            while(comparator.compare(arr.get(right), pivotVal) == -1)
                right--;

            if( left < right )
            {
                swap( arr, left, right );
                left++;
                right--;
            }
        }

        swap(arr, lo, right );
        return right;
    }

	 private void swap( ArrayList<E> array, int i, int j){
        E temp = array.get(i);
        array.set( i, array.get(j));
        array.set( j, temp);
    }

	@Override
	public void setComparator(Comparator<E> comparator) {
		this.comparator = comparator;
	}

}
