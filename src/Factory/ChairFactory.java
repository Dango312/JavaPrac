package Factory;

public class ChairFactory implements AbstractChairFactory {
    public VictorianChair createVictorianChair(int age){
        return new VictorianChair(age);
    }
    public MagicChair createMagicChair(){
        return new MagicChair();
    }
    public FunctionalChair createFunctionalChair(){
        return new FunctionalChair();
    }
}
