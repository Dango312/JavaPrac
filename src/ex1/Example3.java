package ex1;
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args){
        //вывод аргументов командной строки
        for (int i =0;i < args.length; i++){
            System.out.print(args[i]);
        }

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        series();
        factorial(n);
    }
    //гармонический ряд
    private static void series(){
        for (int i =1;i<=10;i++){
            System.out.print("1/"+i+" + ");
        }
        System.out.println();
    }
    //факториал
    private static void factorial(int n){
        int res = 1;
        while (n>1){
            res*=n;
            n--;
        }
        System.out.println(res);
    }
}
