package Chapter2;

import java.awt.*;
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
            if (cursor2.getNext().getNext() == null) break;
            prev = cursor1;
            cursor1 = cursor1.getNext();
            cursor2 = cursor2.getNext().getNext();
        }
        prev.setNext(cursor1.getNext());
    }

    public boolean deleteNode(Node n) {
        if (n == null || n.getNext() == null) {
            return false;
        }
        Node next = n.getNext();
        n.setData(next.getData());
        n.setNext(next.getNext());
        return true;
    }

    public static LinkedList sumListsReverseOrder(LinkedList one, LinkedList two) {
        int length = length(one);
        int length1 = length(two);
        if (length < length1) {
            padWithZeros(one, length1 - length);
        }
        if (length1 < length) {
            padWithZeros(two, length - length1);
        }
        LinkedList result = new LinkedList();
        int sum, reminder = 0;
        if (one.head != null && two.head != null) {
            sum = (Integer) one.head.getData() + (Integer) two.head.getData();
            if (sum >= 10) {
                sum -= 10;
                reminder = 1;
            }
            Node head = new Node(sum);
            Node cursor = head;
            Node cursor1 = one.head.getNext();
            Node cursor2 = two.head.getNext();
            while (cursor1 != null || cursor2 != null) {
                sum = (Integer) cursor1.getData() + (Integer) cursor2.getData();
                sum += reminder;
                if (sum >= 10) {
                    sum -= 10;
                    reminder = 1;
                } else {
                    reminder = 0;
                }
                cursor.setNext(new Node(sum));
                cursor = cursor.getNext();

                //ultimo nodo
                if (cursor1.getNext() == null && reminder != 0) {
                    cursor.setNext(new Node(reminder));
                }
                cursor1 = cursor1.getNext();
                cursor2 = cursor2.getNext();
            }
            result.head = head;
        }
        return result;
    }

    public boolean isPalindrome() {
        if (head != null && head.getNext() != null) {
            Node c1 = head;
            Node c2 = head;
            while (c2 != null && c2.getNext() != null) {
                c1 = c1.getNext();
                c2 = c2.getNext().getNext();
            }
            c1 = c1.getNext();
            LinkedList aux = new LinkedList();
            aux.head = new Node(c1.getData());
            while (c1.getNext() != null) {
                c1 = c1.getNext();
                Node n = new Node(c1.getData());
                n.setNext(aux.head);
                aux.head = n;
            }
            c1 = head;
            c2 = aux.head;
            while (c2 != null) {
                if (c1.getData() != c2.getData()) {
                    return false;
                }
                c1 = c1.getNext();
                c2 = c2.getNext();
            }
            return true;
        }
        return false;
    }

    public static int length(LinkedList list) {
        int count = 0;
        Node cursor = list.head;
        while (cursor != null) {
            count++;
            cursor = cursor.getNext();
        }
        return count;
    }

    public static void padWithZeros(LinkedList list, int count) {
        Node cursor = list.head;
        while (cursor.getNext() != null) {
            cursor = cursor.getNext();
        }
        for (int i = 0; i < count; i++) {
            cursor.setNext(new Node(0));
            cursor = cursor.getNext();
        }
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

    public static String printList(LinkedList list) {
        StringBuilder output = new StringBuilder();
        Node head = list.head;
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
