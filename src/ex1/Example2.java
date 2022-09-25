package ex1;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        //Сумма элементов массива
        int[] a = new int[10];
        int sum=0;
        int i = 0;
        while(i<10){
            int num = in.nextInt();
            a[i] = num;
            sum+=num;
            i++;
        }

        //минимальный/максимальный элемент
        int max = a[0];
        int min = a[0];;;
        int j=0;
        while (j<10){
            if (a[j] > max){
                max = a[j];
            }
            else if (a[j] < min) {
                min = a[j];
            }
            j++;
        }
        System.out.println("Сумма равна = " + sum);
        System.out.println("Минимальный элемент = " + min);
        System.out.println("Максимальный элемент = " + max);
    }
}
