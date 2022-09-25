package prac2;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        Circle[] circles = new Circle[len];
        for(int i=0; i < len; i++){
            double x = scan.nextDouble();
            double y = scan.nextDouble();
            double r = scan.nextDouble();
            circles[i] = new Circle(x,y,r);
        }

        for(int i=0;i<len;i++){
            System.out.println(circles[i]);
        }
    }
}
