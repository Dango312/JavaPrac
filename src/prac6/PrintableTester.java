package prac6;

public class PrintableTester {
    public static void main(String[] args){
        Printable[] p = {
                new Book("Белый Клык", "Джэк Лондон", "приключение"),
                new Book("Капитанская дочка", "Александр Пушкин", "роман"),
                new Shop("The Times", 15),
                new Shop("Вокруг света", 3)
        };
        for (int i =0; i< p.length;i++){
            p[i].print();
        }
    }
}

class Book implements Printable{
    String name, author, genre;

    public Book(String name, String author, String genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public void print() {
        System.out.println("\""+ name+ "\"" + "| автор: " + author + "| жанр: " + genre);
    }
}

//Почему журнал назывется Shop?
class Shop implements Printable{
    String name;
    int number;

    public Shop(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public void print() {
        System.out.println("\""+ name+ "\"" + " №" + number);
    }
}
