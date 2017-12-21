package Chapter2;

public class Question2_3 {


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(3);
        linkedList.add(56);
        linkedList.add(76);
        linkedList.add(11);
        linkedList.add(1);
        linkedList.add(54);
        linkedList.add(5);
        System.out.println(linkedList.toString());
        linkedList.removeMiddle();
        System.out.println(linkedList);
    }
}