package prac5;

import javax.swing.*;

public class PhoneTester {
    public static void main(String[] args){
        Phone iPhone = new Phone("88005553535", "iPhone 27", 200.2);
        Phone Samsung = new Phone("89643195462", "A51");
        Phone Nokia = new Phone();
        iPhone.receiveCall("Ануар", "89643195462");
        Nokia.sendMessage("88005553535", "89643195462", "+73492579811");
        System.out.println(Samsung.getNumber());
    }
}


class Phone{
    private String number;
    private String model;
    private double weight;

    Phone(String number, String model, double weight){
        this.number = number;
        this.model = model;
        this.weight = weight;
    }
    Phone(String number, String model){
        this.number = number;
        this.model = model;
    }
    Phone(){
        System.out.println("Я телефон");
    }
    public String getNumber() {
        return number;
    }
    public void receiveCall(String name){
        System.out.printf("Звонит %s \n", name);
    }
    public void receiveCall(String name, String num){
        System.out.printf("Звонит %s %s \n", name, num);
    }
    public void sendMessage(String...numbers){
        for(String num: numbers){
            System.out.println("Number: " + num);
        }
    }

}
