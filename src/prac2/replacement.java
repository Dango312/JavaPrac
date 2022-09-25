package prac2;
import java.util.Scanner;

public class replacement {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] stroka = new String[5];
        for (int i =0;i< stroka.length; i++){
            stroka[i] = in.nextLine();
        }
        for(int i=0; i< stroka.length/2;i++){
            String tmp = stroka[i];
            stroka[i] = stroka[stroka.length-i-1];
            stroka[stroka.length-i-1] = tmp;
        }
        for(int i=0;i< stroka.length;i++){
            System.out.println(stroka[i]);
        }
    }
}
