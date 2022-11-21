package Factory;

public class VictorianChair implements Chair{
    private int age;
    public VictorianChair(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public void sitOnChair(){
        System.out.println("It`s victorian chair");
    }
}
class MagicChair implements Chair{
    public void doMagic(){
        System.out.println("Expecto patronus!");
    }

    public void sitOnChair(){
        System.out.println("It`s magic chair");
    }
}
class FunctionalChair implements Chair{
    public int sum(int a, int b){
        return a+b;
    }
    public void sitOnChair(){
        System.out.println("It`s functional chair");
    }
}
