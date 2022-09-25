package prac2;

public class Poker {
    public static void main(String[] args){
        Deck deck = new Deck();
        int players = 5;
        for (int i = 0; i < players * 5; i++) {
            System.out.println(deck.deck[i]);
            if (i % 5 == 5 - 1)
                System.out.println();
        }
    }
}

class Deck{
    private static String[] suits = {"Spade", "Diamond", "Heart", "Clubs"};
    private static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static int n = suits.length * ranks.length;
    public static String[] deck = new String[n];

    public Deck(){
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deck[suits.length*i + j] = ranks[i] + " " + suits[j];
            }
        }

        for (int i = 0; i < n; i++) {
            int r = i + (int)(Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
    }

    @Override
    public String toString(){
        String str = "";
        for(int i=0;i<n;i++){
            str += deck[i] + "; ";
        }
        return str;
    }
}
