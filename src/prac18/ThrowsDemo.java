package prac18;

import java.util.Scanner;

public class ThrowsDemo {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println("Enter line:");
                String key = myScanner.nextLine();
                printDetails(key);
            }
            catch (RuntimeException e){
                System.out.println("You entered an empty line. Try again");
            }
        }
    }
    public void printDetails(String key) {
        String message = getDetails(key);
        System.out.println(message);
    }
    private String getDetails(String key) {
        if(key == null) {
            throw new RuntimeException ( "Key set to empty string" );
        }
        return "data for " + key; }
}



