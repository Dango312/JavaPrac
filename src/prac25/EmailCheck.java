package prac25;
import java.util.regex.*;

public class EmailCheck {
    public static void main(String[] args){
        String regex = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";
        String email1 = "mirea@gmail.com";
        String email2 = "nemire@@gmail..ru";

        boolean isValid = email1.matches(regex);
        System.out.println(email1 +" : "+ isValid);

        isValid = email2.matches(regex);
        System.out.println(email2 +" : "+ isValid);
    }
}
