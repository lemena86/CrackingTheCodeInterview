package Chapter2;

import java.util.HashMap;
import java.util.Map;

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
    public void removeDups() {
        Map<Object, Boolean> map = new HashMap<>();
        if (head != null) {
            map.put(head.getData(), true);
            Node prev = head;
            Node cursor = head.getNext();
            while (cursor != null) {
                if (map.containsKey(cursor.getData())) {
                    prev.setNext(cursor.getNext());
                } else {
                    map.put(cursor.getData(), true);
                    prev = cursor;
                }
                cursor = cursor.getNext();
            }
        }
    }

    public void removeDupsWithoutMap() {
        Node prev, cursor;
        Node cursor1 = head;
        while (cursor1 != null) {
            cursor = cursor1.getNext();
            prev = cursor1;
            while (cursor != null) {
                if (cursor1.getData() == cursor.getData()) {
                    prev.setNext(cursor.getNext());
                } else {
                    prev = cursor;
                }
                cursor = cursor.getNext();
            }
            cursor1 = cursor1.getNext();
        }
    }

    public Object getKthElement(int index) {
        int count = 0;
        Node cursor = head;
        while (cursor != null) {
            count++;
            cursor = cursor.getNext();
        }
        cursor = head;
        int aux = 1;
        while (cursor != null) {
            if (aux == count - index) return cursor;
            cursor = cursor.getNext();
            aux++;
        }
        return null;
    }

    public void removeMiddle() {
        Node cursor1 = head, cursor2 = head, prev = null;
        while (cursor2.getNext() != null) {
            if(cursor2.getNext().getNext() == null) break;
            prev = cursor1;
            cursor1 = cursor1.getNext();
            cursor2 = cursor2.getNext().getNext();
        }
        prev.setNext(cursor1.getNext());
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
