package Lists2;

public class ListSortTester {
    public static void main(String[] args){
        DoublyLinkedList lst = new DoublyLinkedList();
        lst.add(5);
        lst.add(3);
        lst.add(6);
        lst.add(2);
        lst.add(10);
        lst.add(4);
        lst.add(2);
        lst.add(18);
        lst.add(20);

        lst.printLinkedList();
        System.out.println("");
        lst.sort_list();
        lst.printLinkedList();
        System.out.println("");
    }

}
