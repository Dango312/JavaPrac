package prac4;
public class SesonsTester {
    private static SesonsEnum bestSeason = SesonsEnum.SUMMER;
    public static void main(String[] args) {
        System.out.println(bestSeason.getAverageTemp());
        System.out.println(bestSeason.getDescription());
        whatSeason(SesonsEnum.FALL);
        getInfo();
    }
    public static void whatSeason(SesonsEnum se){
        switch(se){
            case SPRING:
                System.out.println("I hate spring");
                break;
            case SUMMER:
                System.out.println("I love summer");
                break;
            case FALL:
                System.out.println("I hate fall");
                break;
            case WINTER:
                System.out.println("I hate winter");
                break;
        }
    }
    public static void getInfo(){
        for(SesonsEnum seson: SesonsEnum.values()){
            System.out.println(seson.toString() + " temp: " + seson.getAverageTemp() + " desc: " + seson.getDescription());
        }
    }
}
enum SesonsEnum {
    SPRING(12.3),
    SUMMER(26.7){
        @Override
        public String getDescription(){
            return "Теплое время года";
        }
    },
    FALL(8.6),
    WINTER(-21.2);

    private double averageTemp;

    SesonsEnum(double averageTemp) {
        this.averageTemp = averageTemp;
    }
    public String getDescription(){
        return "Холодное время года";
    }
    public double getAverageTemp(){
        return this.averageTemp;
    }
}
