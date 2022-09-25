package prac4;
import java.util.ArrayList;
import java.util.Scanner;
public class InternetShop {
    public static void main(String[] args) {
        User user = new User();
    }
}
enum Products{
    BREAD("Dough", 80,1),MILK("Milk", 90,2),
    CHEESE("Milk", 150,3),EGGS("Eggs", 160,4),
    PIZZA("cooked", 350,5),BURGER("cooked", 250,6);
    private final String category;
    private final int price;
    private final int _id;

    Products(String category, int price, int id) {
        this.category = category;
        this.price = price;
        this._id = id;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }
    public int get_id(){return this._id;}
}
class ProductsProvider{
    public void provideFullCatologue(){
        for(Products p :Products.values()){
            System.out.println(p.toString()+" category: " + p.getCategory() + " price: " + p.getPrice() + " id: "+p.get_id());
        }
    }
    public void providePartialCatalogue(String category){
        for(Products p :Products.values()){
            if(p.getCategory().equalsIgnoreCase(category)){
                System.out.println(p.toString()+" category: " + p.getCategory() + " price: " + p.getPrice() + " id: "+p.get_id());
            }
        }
    }
    public boolean isCategoryRelevant(String category){
        for(Products p: Products.values()){
            if(p.getCategory().equalsIgnoreCase(category)){
                return true;
            }
        }
        return false;
    }
}
class Cart {
    private ArrayList<Products> products = new ArrayList<Products>();
    public void addProduct(Products product){
        this.products.add(product);
    }
    public int buy(){
        int sum = 0;
        for(Products p:products){
            sum+=p.getPrice();
        }
        return sum;
    }
    public ArrayList<Products> getProducts(){
        return this.products;
    }
    public ArrayList<String> getNamesOfCart(){
        ArrayList<String> productsNames= new ArrayList<String>();
        for(Products p: products){
            productsNames.add(p.toString().toLowerCase());

        }
        return productsNames;
    }
}
class CartProvider{
    private final Cart cart = new Cart();
    public void addProduct(int id){
        for(Products p : Products.values()){
            if(p.get_id()==id){
                cart.addProduct(p);
            }
        }
    }
    public void visualiseCart(){
        for(int i = 0; i < cart.getProducts().size(); i++){
            Products p = cart.getProducts().get(i);
            System.out.println(p.toString() + " category: " + p.getCategory() + " price: " + p.getPrice());
        }
    }
    public void visualiseBuying(){
        ArrayList<String> productsNames = cart.getNamesOfCart();
        int sum = cart.buy();
        System.out.print(productsNames.get(0));
        for(int i = 1; i < productsNames.size(); i++){
            System.out.print(", "+productsNames.get(i));
        }
        System.out.println("");
        System.out.println("Итоговая сумма: " + sum);
    }

}
abstract class ConsoleManager{
    private static final ProductsProvider pp = new ProductsProvider();
    private static final CartProvider cp = new CartProvider();
    public static void consoleManagerCycle(Scanner sc){
        String message = "";
        while(!message.equalsIgnoreCase("stop")) {
            message = sc.nextLine();
            if(message.equalsIgnoreCase("cart")){
                ConsoleManager.printCart();
            }
            else if(pp.isCategoryRelevant(message)){
                ConsoleManager.providePartialCatalogue(message);
            }
            else if(message.equalsIgnoreCase("Full catalogue")){
                ConsoleManager.provideFullCatologue();
            }
            else if(message.substring(0,3).equalsIgnoreCase("add")){
                ConsoleManager.addItemToCart(message);
            }
            else if(message.equalsIgnoreCase("buy")){
                ConsoleManager.buyCart();
            }
        }
    }
    private static void providePartialCatalogue(String message){
        ConsoleManager.pp.providePartialCatalogue(message);
    }
    private static void provideFullCatologue(){
        pp.provideFullCatologue();
    }
    private static void printCart(){
        cp.visualiseCart();
    }
    private static void addItemToCart(String message){
        int id = Integer.valueOf(message.substring(4));
        cp.addProduct(id);
    }
    private static void buyCart(){
        cp.visualiseBuying();
    }

}
class User {
    private String email, password;

    public User() {
        Scanner sc = new Scanner(System.in);
        String password="", email="";
        while (email.equals("")){
            System.out.println("Введите Логин");
            email = sc.nextLine();
        }
        while (password.equals("")){
            System.out.println("Введите пароль");
            password = sc.nextLine();
        }


        this.email = email;
        this.password = password;
        login();
        printGuide();
        ConsoleManager.consoleManagerCycle(sc);
    }
    private void login() {
        if (!this.email.equals("") && !this.password.equals("")) {
            System.out.println("регистрация прошла успешно)");
        } else {
            System.out.println("Регистрация прошла неудачно(");
        }
    }
    private void printGuide(){
        System.out.println("Список доступных функций");
        System.out.println("full catalogue - выводит все доступные в магазине товары");
        System.out.println("#categoryName - при вводе категории выводит список товаров данной категории");
        System.out.println("cart - отображает все товары находящиеся в корзине");
        System.out.println("add #id - добавляет товар с указанным id");
        System.out.println("buy - выводит купленные товары и их общую стоимость");
        System.out.println("stop - закончить сессию");
    }
}