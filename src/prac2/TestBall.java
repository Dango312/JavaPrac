package prac2;
import java.util.Scanner;

public class TestBall {
    public static void main(String[] args){
        Ball b1 = new Ball(3.4, 2.6);
        System.out.println(b1);

        Scanner in = new Scanner(System.in);
        double dx = in.nextDouble();
        double dy = in.nextDouble();
        b1.move(dx, dy);
        System.out.println(b1);
    }
}
