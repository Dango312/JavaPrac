package prac8;
import java.util.Scanner;

public class NaturalNumCheck {
    static int num = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        checkNumber(n);
    }
    private static void checkNumber(int n) {
        if (n > 1) {
            if (n % num != 0) {
                num++;
                checkNumber(n);
            }
            else if (n % num == 0) {
                if (num == n){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
}


