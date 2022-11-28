package prac25;
import java.util.regex.*;

public class Prices {
    public static void main(String[] args){
        String line = "44 USD, 0.004 EU, 123 RUB";
        String[] words = line.split(", ");
        for(String word: words){
            System.out.println(word);
        }
    }
}
