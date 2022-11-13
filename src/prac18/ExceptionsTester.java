package prac18;
import java.util.Scanner;

public class ExceptionsTester {
    public static void main(String[] args){
        //exceptionDemo();
        ThrowsDemo td = new ThrowsDemo();
        td.getKey();
    }

    public static void exceptionDemo() {
        Scanner myScanner = new Scanner( System.in);
        System.out.print( "Enter an integer ");
        try {
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println( 2/i );
        }
        catch (ArithmeticException e){
            System.out.println("Division by zero!!!!!"); // при арифметической ошибке
        }
        catch (NumberFormatException d){
            System.out.println("Wrong input!!!!"); // вызывается при неправильном формате введённого значения
        }
        finally {
            System.out.println("2 / i"); // выполняется в любом случае
        }

    }
}


