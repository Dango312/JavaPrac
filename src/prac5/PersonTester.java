package prac5;

public class PersonTester {
    public static void main(String [] args){
        Person p1 = new Person();
        Person p2 = new Person("John", 21);
        p2.move();
        p1.move();
    }
}

class Person{
    private String fullName;
    private int age;

    Person(){

    }
    Person(String fullName, int age){
        this.fullName = fullName;
        this.age = age;
    }

    public void move() {
        System.out.println(fullName + " идёт");
    }
    public void talk(){
        System.out.println(fullName + " говорит");
    }
}
