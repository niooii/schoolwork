public class QueueDriver {

    public static void main(String[] args) {

        //////////////////////OurQueue///////////////////////
        System.out.println("Testing ArrayBasedQueue Implementation");
        ArrayBasedQueue ourQueue = new ArrayBasedQueue(5);

       // Add elements to the queue
        System.out.println("Adding elements to the queue....");

        ourQueue.offer(1);
        ourQueue.offer(2);
        ourQueue.offer(3);
        ourQueue.offer(4);
        ourQueue.offer(5);

       // Attempting to add another element when the queue is full (expecting an error or some handling)
        System.out.println("Attempting to add an element to a full queue.....");
        try {
            ourQueue.offer(6);
        } catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }


        System.out.println("Polled: " + ourQueue.poll());

        System.out.println("Peeking front: " + ourQueue.peek());

        // Polling remaining elements one by one
        System.out.println("Polled: " + ourQueue.poll());
        System.out.println("Polled: " + ourQueue.poll());
        System.out.println("Polled: " + ourQueue.poll());
        System.out.println("Polled: " + ourQueue.poll());

        // Testing when the queue is empty
        System.out.println("Attempting to poll from an empty queue......");
        try {
            System.out.println(ourQueue.poll());
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

        // Re-adding an element after the queue is empty
        System.out.println("Adding an element after emptying the queue....");
        ourQueue.offer(4);

        //Removing the single element in the queue
        try {
            System.out.println("Polled: " + ourQueue.poll());
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

    }
}
