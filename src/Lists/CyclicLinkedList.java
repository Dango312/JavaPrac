package Lists;

public class CyclicLinkedList {
    private Node head;

    public void insertFirst(Book data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
        while (newNode.next != null){
            if(newNode.next == null){
                newNode.next.last = newNode;
                return;
            }
        }
    }

    void search_elem(String name){
        Node t = head;
        while (t.next != null) {
            if (t.data.getName().equals(name)) {
                System.out.println(t.data);
            }
            t = t.next;
        }
    }
    void del_elem(String name) {
        Node t = head;
        if(t.data.getName().equals(name)){
            head = head.next;
        }
        else{
            while (t.next != null) {
                if (t.next.data.getName().equals(name)) {
                    t.next = t.next.next;
                    return;
                }
                t = t.next;
            }
        }

    }

    public void printLinkedList() {
        Node current = head;
        while (current != null) {
            current.displayNodeData();
            current = current.next;

        }
        System.out.print("NULL");

    }

    void is_empty(){
        if(head == null){        //если список пуст -
            System.out.println("Is empty");
        }
        else{
            System.out.println("Isn`t empty");
        }
    }

    Book get_head(){
        return head.data;
    }
}
