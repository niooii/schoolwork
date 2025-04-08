/**
 * An interface representing a queue data structure.
 * A queue follows the FIFO (First In, First Out) principle.
 */
public interface QueueADT {

    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to be added to the queue
     */
    public void offer(int element);



    /**
     * Removes and returns the element from the front of the queue.
     *
     * @return the element from the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public int poll();



    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public int peek();



    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty();



    /**
     * Checks if the queue is full.
     *
     * @return true if the queue is full, false otherwise
     */
    public boolean isFull();
}
