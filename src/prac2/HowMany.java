package prac2;
import java.util.Scanner;

public class HowMany {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the line");
        String input = sc.nextLine();
        int counter = 0;

        if(input.length() != 0){
            counter++;
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == ' '){
                    counter++;
                }
            }
        }
        System.out.println("You entered "+counter+" words");
    }
}

