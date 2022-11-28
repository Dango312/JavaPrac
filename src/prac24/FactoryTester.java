package prac24;

public class FactoryTester {
    public static void main(String[] args) {
        Client client = new Client();
        ChairFactory chairFactory = new ChairFactory();
        FunctionalChair funnyChair = chairFactory.createFunctionalChair();
        client.setChair(funnyChair);
        client.sit();
        System.out.println("Funny chair sums: "+ funnyChair.sum(3, 6));
    }
}

class Client{
    private Chair chair;
    public void sit(){
        chair.sitOnChair();
    }
    public void setChair(Chair chair){
        this.chair = chair;
    }
}
