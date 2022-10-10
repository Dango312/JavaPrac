package prac8;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        palindromeCheck(word);
    }

    static void palindromeCheck(String word){
        if (word.length() == 1) {
            System.out.println("YES");
        } else {
            if (word.substring(0, 1).equals(word.substring(word.length() - 1, word.length()))) {
                if (word.length() == 2) {
                    System.out.println("YES");
                }
                palindromeCheck(word.substring(1, word.length() - 1));
            } else {
                System.out.println("NO");
            }
        }
    }
}
