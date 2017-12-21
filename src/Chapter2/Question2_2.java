package Chapter2;

public class Question2_2 {


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(3);
        linkedList.add(56);
        linkedList.add(76);
        linkedList.add(1);
        linkedList.add(54);
        linkedList.add(5);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.getKthElement(4));
    }
}