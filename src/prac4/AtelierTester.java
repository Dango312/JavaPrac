package prac4;

public class AtelierTester {
    public static void main(String[] args) {
        Cloth[] cloths = new Cloth[4];
        cloths[0] = new TShirt(Sizes.M,30.8 , "Green");
        cloths[1] = new Pants(Sizes.XS, 32.8, "Back");
        cloths[2] = new Skirt(Sizes.XS, 40.7, "Black");
        cloths[3] = new Tie(Sizes.L, 11.99, "Blue");
        Atelier.dressWoman(cloths);
        Atelier.dressMan(cloths);
    }
}
abstract class Atelier {
    public static void dressWoman(Cloth[] cloths){
        for(int i =0; i < cloths.length; i++){
            Class[] interfaces = cloths[i].getClass().getInterfaces();
            for(Class c : interfaces){
                if("WomenClothing".equals(c.getSimpleName())){
                    WomenClothing cont = (WomenClothing) cloths[i];
                    System.out.println(cont.dressWoman());
                }
            }
        }
    }
    public static void dressMan(Cloth[] cloths){
        for(int i =0; i < cloths.length; i++){
            Class[] interfaces = cloths[i].getClass().getInterfaces();
            for(Class c : interfaces){
                if("MenClothing".equals(c.getSimpleName())){
                    MenClothing cont = (MenClothing) cloths[i];
                    System.out.println(cont.dressMan());
                }
            }
        }
    }
}
enum Sizes {
    XXS(32){
        @Override
        public String getDescription(){
            return "детский размер";
        }
    },XS(34),S(36),M(38),L(40);
    private int euroSize;
    Sizes(int euroSize){
        this.euroSize = euroSize;
    }
    public String getDescription(){
        return "Взрослый размер";
    }
}
interface MenClothing {
    String dressMan();
}
interface WomenClothing {
    String dressWoman();
}
abstract class Cloth{
    protected Sizes size;
    protected double price;
    protected String color;
}
class TShirt extends Cloth implements MenClothing,WomenClothing{
    public TShirt(Sizes size, double price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public String dressMan(){
        return "dressing man with Tshirt size: "+this.size.toString()+" color: " + this.color + " price: " + this.price;
    }
    public String dressWoman(){
        return "dressing woman with Tshirt size: "+this.size.toString()+" color: " + this.color + " price: " + this.price;
    }
}
class Pants extends Cloth implements MenClothing,WomenClothing{
    public Pants(Sizes size, double price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public String dressMan(){
        return "dressing man with Pants size: "+this.size.toString()+" color: " + this.color + " price: " + this.price;
    }
    public String dressWoman(){
        return "dressing woman with Pants size: "+this.size.toString()+" color: " + this.color + " price: " + this.price;
    }
}
class Skirt extends Cloth implements WomenClothing{
    public Skirt(Sizes size, double price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }
    public String dressWoman(){
        return "dressing woman with skirt size: "+this.size.toString()+" color: " + this.color + " price: " + this.price;
    }
}
class Tie extends Cloth implements MenClothing{
    public Tie(Sizes size, double price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public String dressMan(){
        return "dressing man with tie size: "+this.size.toString()+" color: " + this.color + " price: " + this.price;
    }
}
