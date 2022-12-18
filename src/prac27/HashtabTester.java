package prac27;

public class HashtabTester {
    public static void main(String[] args){
        Hashtab<Integer> tab = new Hashtab<Integer>();
        tab.add(12, "Kuzin");
        tab.add(321, "Toyota");
        tab.add(123, "Pivo");
        tab.print();
    }
}
