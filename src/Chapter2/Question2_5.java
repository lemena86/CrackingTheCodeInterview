package Chapter2;

public class Question2_5 {


    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList1.add(9);
        linkedList1.add(7);
        linkedList1.add(8);
        linkedList1.add(8);
        linkedList2.add(6);
        linkedList2.add(8);
        linkedList2.add(5);
        System.out.println(linkedList1.toString());
        System.out.println(linkedList2.toString());
        LinkedList result = LinkedList.sumListsReverseOrder(linkedList1,linkedList2);
        System.out.println(LinkedList.printList(result));
    }
}