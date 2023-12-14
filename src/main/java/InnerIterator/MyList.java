package InnerIterator;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyList<T> {
    T[] arr;
    int count;

    ArrayIterator<T> arrayIterator = new ArrayIterator<>(arr);

    MyList() {
        arr = (T[]) new Object[1];
        count = 0;
    }

    void add(T item) {
        if (count == arr.length) {
            Object[] newArr = new Object[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = (T[]) newArr;
        }
        arr[count++] = item;
    }

    T remove() {
        if (count == 0) throw new NoSuchElementException();
        T temp = (T) arr[--count];
        arr[count] = null;
        return temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }


    static class ArrayIterator <T>{
        private final T[] array;
        private int index = 0;

        public ArrayIterator(T[] array) {
            this.array = array;
        }

        public boolean hasNext() {
            return index < array.length;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[index++];
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        ArrayIterator<Integer> it = new ArrayIterator<>(arr);
        while (it.hasNext()) {
            System.out.println(it.next() + "");
        }
    }
}

