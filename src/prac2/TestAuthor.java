package prac2;

public class TestAuthor {
    public static void main(String[] args){
        Author author1 = new Author("H.P.Lovecraft", "fish@mail.com", 'm');
        author1.setEmail("cthulhu@gmail.com");
        System.out.println(author1);
    }
}
