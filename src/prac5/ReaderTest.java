package prac5;

public class ReaderTest {
    public static void main(String[] args){
        Reader r1 = new Reader("Ivanov Ivan Ivanovich", "biology", "15.03.2002", "88346982513", 1325);
        r1.takeBook("Anatomy", "Genetic");
        r1.returnBook("Anatomy");
    }
}

class Reader{
    String FIO, faculty, birthDate, phoneNumber;
    int readerTicketNumber;

    public Reader(String FIO, String faculty, String birthDate, String phoneNumber, int readerTicketNumber) {
        this.FIO = FIO;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.readerTicketNumber = readerTicketNumber;
    }

    public void takeBook(int n){
        System.out.println(FIO + " взял " + n + " книг");
    }
    public void takeBook(String...books){
        String m = "";
        for(String book: books){
            m += (book + ", ");
        }
        System.out.println(FIO + " взял книги: " + m);
    }
    public void takeBook(Book...books){
        String m = "";
        for(Book book: books){
            m += (book + ", ");
        }
        System.out.println(FIO + " взял книги: " + m);
    }


    public void returnBook(int n){
        System.out.println(FIO + " вернул " + n + " книг");
    }
    public void returnBook(String...books){
        String m = "";
        for(String book: books){
            m += (book + ", ");
        }
        System.out.println(FIO + " вернул книги книги: " + m);
    }
    public void returnBook(Book...books){
        String m = "";
        for(Book book: books){
            m += (book + ", ");
        }
        System.out.println(FIO + " вернул книги: " + m);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "FIO='" + FIO + '\'' +
                ", faculty='" + faculty + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", readerTicketNumber=" + readerTicketNumber +
                '}';
    }
}

class Book{
    String name, Author;

    public Book(String name, String author) {
        this.name = name;
        this.Author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }
}