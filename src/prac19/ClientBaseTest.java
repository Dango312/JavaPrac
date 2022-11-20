package prac19;
import java.util.Hashtable;
import java.util.Scanner;

public class ClientBaseTest{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UI ui = new UI(sc);
        ui.controllIn();
    }
}

abstract class UX {
    private static Hashtable<String, Integer> dataBase = new Hashtable<String, Integer>();
    public static void addElement(String FIO, int INN){
        dataBase.put(FIO, INN);
    }
    public static String checkElement(String FIO, int INN){
        int targetINN = dataBase.get(FIO);
        if(targetINN != INN){
            throw new FIOOrINNIsNotValidException();
        }
        return "Success";
    }

}
class UI {
    private Scanner scanner;
    public UI(Scanner sc){
        this.scanner = sc;
    }
    public void controllIn(){
        while (true){
            String command = this.scanner.nextLine();
            if(command.equalsIgnoreCase("register")){
                System.out.println("Enter FIO: ");
                String FIO = this.scanner.nextLine();
                System.out.println("Enter INN: ");
                int INN = Integer.parseInt(this.scanner.nextLine());
                UX.addElement(FIO, INN);
            } else if (command.equalsIgnoreCase("login")) {
                try {
                    System.out.println("Enter FIO: ");
                    String FIO = this.scanner.nextLine();
                    System.out.println("Enter INN: ");
                    int INN = Integer.parseInt(this.scanner.nextLine());
                    System.out.println(UX.checkElement(FIO, INN));
                } catch (FIOOrINNIsNotValidException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            } else if (command.equalsIgnoreCase("end")) {
                break;
            }
        }
    }
}
class FIOOrINNIsNotValidException extends RuntimeException{
    public FIOOrINNIsNotValidException(){
        super("Incorrect data");
    }
}