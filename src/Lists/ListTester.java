/*
Задание на списки №1
 */

package Lists;
import java.util.Scanner;

public class ListTester {
    public static void main(String[] args){
        int command;
        Scanner scr = new Scanner(System.in);
        CyclicLinkedList Shop = new CyclicLinkedList();
        Shop.insertFirst(new Book("Book1", "Author1", "Novel"));
        Shop.insertFirst(new Book("Book2", "Author2", "Novel"));
        Shop.insertFirst(new Book("Book3", "Author2", "Science"));
        Shop.insertFirst(new Book("Book4", "Author3", "Poem"));
        System.out.println("Добро пожаловать.\nСписок комманд:\n" +
                "1 - добавить книгу\n" +
                "2 - удалить книгу\n" +
                "3 - вывести список\n" +
                "4 - проверка на пустоту\n" +
                "5 - найти книгу\n" +
                "0 - выйти из консоли. ");
        while (true){
            System.out.println("\nВведите комманду: ");
            command = Integer.parseInt(scr.nextLine());
            if (command == 0){
                break;
            }
            else if (command == 1){
                System.out.println("Введите название книги: ");
                String name, author, genre;
                name = scr.nextLine();
                System.out.println("Введите автора: ");
                author = scr.nextLine();
                System.out.println("Введите жанр: ");
                genre = scr.nextLine();
                Shop.insertFirst(new Book(name, author, genre));
            }
            else if (command == 2) {
                String name;
                System.out.println("Введите название книги: ");
                name = scr.nextLine();
                Shop.del_elem(name);
            }
            else if (command == 3) {
                Shop.printLinkedList();
            }
            else if (command == 4){
                Shop.is_empty();
            }
            else if (command == 5) {
                String name;
                System.out.println("Введите название книги: ");
                name = scr.nextLine();
                Shop.search_elem(name);
            }
            else if (command == 75){
                System.out.println(Shop.get_head());
            }
        }
    }
}


class Node {
    Book data;
    public Node next; // предыдущий добавленный элемент
    public Node prev; // следующий добавленный элемент
    public Node last; // последний добавленный элемент

    public void displayNodeData() {
        System.out.print(data +  " - "+" next = "  + next.data);
        if (last != null) {
            System.out.print(" last = "+ last.data + "\n");
        }
        else{
            System.out.print("last = 0\n");
        }
    }

}

class SinglyLinkedList {
    private Node head;

    public void insertFirst(Book data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
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

class Book{
    private String name, author, genre;


    public Book(String name, String author, String genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}