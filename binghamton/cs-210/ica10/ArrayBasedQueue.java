import java.lang.IllegalStateException;

public class ArrayBasedQueue implements QueueADT {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    //Constructor
    public ArrayBasedQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void offer(int element) {
    	if (isFull())
    		throw new IllegalStateException("CANNOT PERFORM OFFER OPERATION-THE QUEUE IS ALREADY FULL");
    		
   		size++;
		queue[front++ % capacity] = element;
    }

    @Override
    public int poll() {
    	if (isEmpty()) 
    		throw new IllegalStateException("CANNOT PERFORM POLL OPERATION-THE QUEUE IS EMPTY");
		size--;
        return queue[++rear % capacity];
    }


    @Override
    public int peek() {
		if (isEmpty()) 
    		throw new IllegalStateException("CANNOT PERFORM PEEK OPERATION-THE QUEUE IS EMPTY");
		
        return queue[(rear + 1) % capacity];
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

}
