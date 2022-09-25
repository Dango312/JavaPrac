package ex1;
import java.util.Scanner;

public class Example {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        //сумма элементов массива
        int[] a = new int[10];
        int sum=0;
        for (int i=0;i<10;i++){
            int num = in.nextInt();
            a[i] = num;
            sum+=num;
        }
        in.close();
        System.out.println("Сумма элементов массива = " + sum );
        System.out.println("Среднее арифметическое = " + sum / a.length);
        for (int i=0;i<10;i++){
            System.out.print(a[i] + ", ");
        }
    }

}
