package Collections;

import java.util.Arrays;

public class MyArrayList<T> {
    private final int ARRAY_SIZE = 10;

    private Object[] array = new Object[ARRAY_SIZE];
    private int count = 0;


    public MyArrayList(T[] array) {
        addAll(array);
    }

    public MyArrayList() {}

    public T get(int index) {
        return (T) array[index];
    }

    public void add(T item) {
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
        for(int i = 0;i< array.length;i++) {
            add(array[i]);
        }
    }
    public int size(){
        return count;
    }
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array,count));
    }
}

