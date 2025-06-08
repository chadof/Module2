package Collections;

import java.util.Arrays;

public class MyArrayList<T> {
    private final int ARRAY_SIZE = 10;

    private Object[] array = new Object[ARRAY_SIZE];
    private int count = 0;


    public MyArrayList(T[] array) {
        addAll(array);
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void add(T item) {
        if(count == size()-1) {
            Object[] newArray = new Object[size()*2];
            System.arraycopy(array, 0, newArray, 0, count);
            array = newArray;
        }
        array[count++]=item;
    }

    public void remove(int index) {
        for(int i = index; i<count;i++) {
            array[i] = array[i+1];
        }
        array[count] = null;
        count--;
    }
    public void addAll(T[] array) {
        for (T t : array) {
            add(t);
        }
    }
    public int size(){
        return count;
    }
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array,count));
    }
}

