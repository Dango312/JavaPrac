package prac3;
import java.util.Random;

public class RandArr {
    public static void main(String[] args){
        int n = 10;
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        Random rand = new Random();
        for (int i=0;i<n;i++){
            arr1[i] = rand.nextInt(1000);
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i=0;i<n;i++) {
            arr2[i] = (int) (Math.random()*1000);
            System.out.print(arr2[i] + " ");
        }
    }
}
