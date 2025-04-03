public class Node {

    private String value;
    private Node next;

    public Node(String value){
        this.value = value;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return this.next;
    }


    public String getValue(){
        return this.value;
    }

}
