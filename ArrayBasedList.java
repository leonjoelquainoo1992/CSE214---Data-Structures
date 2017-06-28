import java.util.*;
@SuppressWarnings("unchecked")
public class ArrayBasedList<E> implements Comparable<E>, ListInterface<E> {
	static int indexOfElement = 0;
	int size;
	private E[] arrayList;
	private final int CAPACITY = 20000;


	public ArrayBasedList(){
		setArrayList((E[]) new Object[CAPACITY]);
		setSize(0);
	}

	public E[] getArrayList() {
		return arrayList;
	}

	public void setArrayList(E[] arrayList) {
		this.arrayList = arrayList;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}


	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public void add(E obj) {
		arrayList[indexOfElement] = obj;
		size++; indexOfElement++;
	}

	@Override
	public boolean add(E obj, int index) {
		if(index >= 0 && index <= arrayList.length - 1){
			if(isEmpty() && index == 0){
				indexOfElement = index;
				arrayList[index] = obj;
				size++; indexOfElement++;
				return true;
			}
			else if(arrayList[index] == null){
				arrayList[index] = obj;
				size++;
				return true;
			}
			else{
				arrayList[index] = obj;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addSorted(E obj) {
		arrayList[indexOfElement] = obj;
		size++; indexOfElement++;
		Arrays.sort(arrayList);
		return true;
	}

	@Override
	public E get(int index) {
		if(index >= 0 && index <= size)
			return arrayList[index];
		return null;
	}

	@Override
	public E replace(E obj, int index) {
		E element = arrayList[index];
		arrayList[index] = obj;
		if(element == null){
			size++;
		}
		return element;
	}

	@Override
	public boolean remove(int index) {
		if((index >= 0)  && (index < size)){
			for(int i = index + 1; i<= size; i++){
				arrayList[i-1] = arrayList[i];
			}
			size--;
			return true;
		}
		return false;
	}

	@Override
	public void removeAll() {
		java.util.Arrays.fill(arrayList, null);
		size = 0; indexOfElement= 0;
	}

	//Erase
	public void displayList(){
		System.out.print(arrayList[0]);
		for(int i = 1; i < arrayList.length; i++){
			if(arrayList[i] != null)
				System.out.print("--->" + arrayList[i]);
			else
				continue;
				
		}
	}
}
