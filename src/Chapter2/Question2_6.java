package Chapter2;

public class Question2_6 {


    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();

        linkedList1.add(1);
        linkedList1.add(2);
        linkedList1.add(2);
        linkedList1.add(1);
        //linkedList1.add(11);

        System.out.println(linkedList1.toString());
        System.out.println(linkedList1.isPalindrome());
    }
}