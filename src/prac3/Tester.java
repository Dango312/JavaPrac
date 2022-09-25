package prac3;

import java.util.Random;

public class Tester {

    public static void main(String[] args){
        Tester ts = new Tester();
        int len = 10;
        Circle[] circles = new Circle[len];
        Random random = new Random();
        for(int i=0; i < len; i++){
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);
            int r = random.nextInt(1000);
            circles[i] = new Circle(r, x, y);
        }
        for(int i=0;i<len;i++){
            System.out.println(circles[i]);
        }
        ts.bubbleSort(circles);

        System.out.println('\n');

        for(int i=0;i<len;i++){
            System.out.println(circles[i]);
        }

        System.out.println("\nMin: " + ts.findMin(circles));
        System.out.println("Max: " + ts.findMax(circles));
    }

    void bubbleSort(Circle arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j].getRadius() > arr[j + 1].getRadius()) {
                    Circle temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    Circle findMin(Circle arr[]){
        int n = arr.length;
        Circle min = new Circle(1001,0,0);
        for(int i=0;i<n;i++){
            if (arr[i].getRadius() < min.getRadius()){
                min = arr[i];
            }
        }
        return min;
    }

    Circle findMax(Circle arr[]){
        int n = arr.length;
        Circle max = new Circle(0,0,0);
        for(int i=0;i<n;i++){
            if (arr[i].getRadius() > max.getRadius()){
                max = arr[i];
            }
        }
        return max;
    }
}
