import java.util.EmptyStackException;

public class ArrayBasedStack implements StackADT {
    final static int INITIAL_CAPACITY = 32;
    int capacity = INITIAL_CAPACITY;
    int nextFree = 0;
    String[] storage;

    ArrayBasedStack() {
        storage = new String[capacity];
    }

    void resize() {
        int newCapacity = capacity * 2;
        String[] newStorage = new String[newCapacity];
        System.arraycopy(storage, 0, newStorage, 0, capacity);
        storage = newStorage;
    }

    @Override
    public void push(String item) {
        if (nextFree >= capacity)
            resize();
        storage[nextFree++] = item;
    }

    @Override
    public String pop() {
        if (isEmpty())
            throw new EmptyStackException();
        return storage[--nextFree];
    }

    @Override
    public String peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return storage[nextFree - 1];
    }

    @Override
    public boolean isEmpty() {
        return nextFree == 0;
    }
}