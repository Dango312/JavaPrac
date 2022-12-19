package prac27;

import java.util.Random;

public class HashtabTester {
    public static void main(String[] args){
        Random rand = new Random();
        Hashtab<String, Integer> hashtab = new Hashtab<>();
        hashtab.hashtabAdd("Carrot", rand.nextInt(10));
        hashtab.hashtabAdd("Pirate", rand.nextInt(10));
        hashtab.hashtabAdd("Parrot", 7);
        hashtab.hashtabAdd("Table", rand.nextInt(10));

        hashtab.print();
        hashtab.hashtabDelete("Table");
        hashtab.print();
        System.out.println(hashtab.get_element("Parrot"));
        hashtab.clear();
    }
}
