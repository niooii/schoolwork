// ArrayBasedList implementation of ListADT
public class ArrayBasedList implements ListADT {

    private String[] list;
    // The number of elements currently on the list
    private int size;
    // Initial capacity of the array
    private static final int INITIAL_CAPACITY = 10;
    private int capacity = INITIAL_CAPACITY;

    public ArrayBasedList() {
        list = new String[INITIAL_CAPACITY];
        size = 0;
    }

    private void shr(int start_idx) {
        for (int i = size; i > start_idx; i--) {
            list[i] = list[i-1];
        }
    }

    private void shl(int start_idx) {
        for (int i = start_idx; i < size; i++) {
            list[i-1] = list[i];
        }
    }

    @Override
    public boolean add(int index, String s) {
        if (index > size || index < 0)
            return false;

        if (size + 1 > capacity) {
            // exponential growth - i think this is how the c++ stl implements it
            capacity *= 2;
            resize(capacity);
        }

        shr(index);
        list[index] = s;

        size++;

        return true;
    }

    @Override
    public String remove(int index) {
        if (index >= size || index < 0)
            return "";

        String s = list[index];
        list[index] = null;
        shl(index + 1);

        size--;

        return s;
    }

    @Override
    public void clear() {
        // no need to null elements here, since the internal array is never
        // accessed raw.
        size = 0;
    }

    @Override
    public String print(String sep) {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += list[i];
            if (i < size - 1) {
                result += sep;
            }
        }
        return result;
    }


    @Override
    public String getIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        return list[index];
    }

    // a Helper method that resizes the array to a new capacity
    private void resize(int newCapacity) {
        String[] newList = new String[newCapacity];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }

}
