package prac8;

public class Factorization {
    public static void main(String[] args){
        factorization(7869420, 2);
    }

    static void factorization(int n, int num) {
        if (num > n / 2) {
            System.out.print(n + " ");
            return;
        }
        if (n % num == 0) {
            System.out.print(num + " ");
            factorization(n / num, num);
        }
        else {
            factorization(n, ++num);
        }
    }
}
