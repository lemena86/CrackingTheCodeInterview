package Chapter2;

/**
 * Created by nisum on 12/20/17.
 */
public class LinkedList {
    Node head;

    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = new Node(data);
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
        }
    }

    /**
     * Question 2_1
     */
    public void removeDups(){

    }


    public String toString() {
        StringBuilder output = new StringBuilder();

        if (head != null) {
            output.append("[").append(head).append("]");
            Node temp = head.getNext();
            while (temp != null) {
                output.append("[").append(temp).append("]");
                temp = temp.getNext();
            }
        }
        return output.toString();
    }

}

class Node {
    Node next;
    Object data;

    public Node(Object dataValue) {
        next = null;
        data = dataValue;
    }

    public Node(Object dataValue, Node nextValue) {
        next = nextValue;
        data = dataValue;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object dataValue) {
        data = dataValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextValue) {
        next = nextValue;
    }

    @Override
    public String toString() {
        return this.getData().toString();
    }
}
