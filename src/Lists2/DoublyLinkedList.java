package Lists2;

public class DoublyLinkedList {
    private Node head;
    private int listLen;
    public DoublyLinkedList() {
        listLen = 0;
    }
    public void add(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
        if(newNode.next!=null){
            newNode.next.prev = newNode;
        }
        newNode.prev = null;
        listLen++;
    }
    public void add(int data, int index){
        Node newNode = new Node();
        newNode.data = data;
        Node current = head;
        if (index == 0){
            add(data);
            return;
        }
        for (int i=1; i<index && current.next != null; i++){
            current = current.next;
        }
        newNode.next = current.next;
        newNode.next.prev = newNode;
        newNode.prev = current;
        current.next = newNode;
        listLen++;
    }

    public void delete_node(int index){
        Node current = head;
        if(index == 0){
            head = head.next;
            head.prev = null;
        }

        for(int i=1; i<index;i++){
            if (current.next == null){
                return;
            }
            current = current.next;
        }
        if (current.next.next != null){
            current.next.next.prev = current;
            current.next = current.next.next;
        }
        else{
            current.next = null;
        }
        listLen--;
    }

    public Object get(int index){
        if (index <= 0) return null;
        Node current = head.next;
        for (int i = 1; i < index; i++){
            if (current.next == null) return null;
            current = current.next;
        }
        return current.data;
    }

    public void printLinkedList() {
        Node current = head;
        while (current != null) {
            current.displayNodeData();
            current = current.next;
        }
        System.out.print("NULL\n");
    }

    public int get_len(){
        return listLen;
    }

    public Node getHead(){
        return head;
    }

    public void sort_list(){
        Node start = head;
        int pos = 0;
        while (start.next != null){
            Node current = start.next;
            Node minNode = current;
            while(current != null){
                if (current.data <= minNode.data){
                    minNode = current;
                }
                current = current.next;
            }
            if (minNode.next == null){
                minNode.prev.next = null;
            }
            else if(minNode.prev != null){
                minNode.next.prev = minNode.prev;
                minNode.prev.next = minNode.next;
            }

            //minNode.displayNodeData();
            //System.out.println("");
            add(minNode.data, pos);
            //printLinkedList();
            //System.out.println("");
            pos++;
        }
    }
}

class Node{
    int data;
    Node next;
    Node prev;

    public void displayNodeData() {
        System.out.print(data +  " {");
        if (next != null) {
            System.out.print("next="+ next.data + " ");
        }
        else{
            System.out.print("next=null ");
        }
        if (prev != null) {
            System.out.print("prev = "+ prev.data + " } -> ");
        }
        else{
            System.out.print("prev = null } -> ");
        }
    }
}

/*
public void insertionSort()
 {
 int in, out;
 for(out=1; out<nElems; out++) // out - разделительный маркер
 {
 long temp = a[out]; // Скопировать помеченный элемент
 in = out; // Начать перемещения с out
 while(in>0 && a[in-1] >= temp) // Пока не найден меньший элемент
 {
 a[in] = a[in-1]; // Сдвинуть элемент вправо
 --in; // Перейти на одну позицию влево
 }
 a[in] = temp; // Вставить помеченный элемент
 }
 }
 */
