// LinkedBasedList implementation of ListADT
class LinkedBasedList implements ListADT {
    private Node head;
    private int size;

    // Constructor
    public LinkedBasedList() {
        head = null;
        size = 0;
    }

    // Adds an element at a specific index
    @Override
    public boolean add(int index, String s) {
        if (index < 0 || index > size)
            return false;

        Node node_at_idx = getNode(index);
        Node new_node = new Node(s);

        Node prev = getNode(index - 1);

        new_node.setNext(node_at_idx);

        if (prev != null)
            prev.setNext(new_node);
        else
            head = new_node;

        size++;

        return true;
    }

    // Removes an element at a specific index
    @Override
    public String remove(int index) {
        if (index < 0 || index >= size)
            return "";

        Node node = getNode(index);

        Node next = getNode(index + 1);
        Node prev = getNode(index - 1);

        if (prev != null)
            prev.setNext(next);
        else
            head = next;

        size--;

        assert node != null;
        return node.getValue();
    }

    @Override
    //Clear the entire list and reset the size
    public void clear() {
        // for garbage collected languages this should be enough, right?
        head = null;
        size = 0;
    }

    @Override
    public String print(String sep) {
        if (head == null) {
            return ""; // Return an empty string if the list is empty
        }

        String result = head.getValue(); // Start with the first element
        Node current = head.getNext();  // Move to the next node

        while (current != null) {
            result += sep + current.getValue(); // Concatenate each element with the separator
            current = current.getNext();
        }
        return result;
    }


    @Override
    public String getIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    // Helper method that returns the node at the specified index
    private Node getNode(int index) {
        if (index < 0 || index >= size)
            return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }


}
