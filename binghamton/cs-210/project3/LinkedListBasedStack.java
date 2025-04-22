import java.util.EmptyStackException;

class Node {
    String val;
    Node next;

    public Node(String val) {
        this.val = val;
    }
}

public class LinkedListBasedStack implements StackADT {
    Node head;

    @Override
    public void push(String item) {
        if (head == null) {
            head = new Node(item);
            return;
        } 
            
        Node node = new Node(item);
        node.next = head;
        head = node;
    }

    @Override
    public String pop() {
        if (isEmpty())
            throw new EmptyStackException();
        String val = head.val;

        head = head.next;

        return val;
    }

    @Override
    public String peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return head.val;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}