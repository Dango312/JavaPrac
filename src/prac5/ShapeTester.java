package prac5;

public class ShapeTester {
    public static void main(String[] args){
        Shape sh = new Shape("Square", 20, 25);
        System.out.println(sh);
        Circle cir = new Circle(9);
        System.out.println(cir);
        Square squ = new Square(4);
        System.out.println(squ);
        Rectangle rec = new Rectangle(3, 5);
        System.out.println(rec);
    }
}

class Shape{
    String type;
    double perimeter;
    double area;
    public Shape(String type, double perimeter, double area){
        this.type = type;
        this.perimeter = perimeter;
        this.area = area;
    }

    String getType(){
        return type;
    }
    double getArea(){
        return area;
    }
    double getPerimeter(){
        return perimeter;
    }

    @Override
    public String toString(){
        return type + ": "+"perimeter = "+perimeter+" area = " + area;
    }
}

class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        super("Circle", Math.PI*radius*2, Math.PI*Math.pow(radius, 2));
        this.radius = radius;
    }
    String getType(){
        return "Circle";
    }
    double getArea(){
        return Math.PI*radius*radius;
    }
    double getPerimeter(){
        return Math.PI*radius*2;
    }

    @Override
    public String toString(){
        return "Circle: {" + "radius = " + radius + "; perimeter = " + perimeter + "; area = " + area +"}";
    }

}

class Square extends Shape{
    private double a;
    public Square(double a){
        super("Square", 2*(a+a), a*a);
        this.a = a;
    }
    String getType(){
        return "Square";
    }
    double getArea(){
        return a*a;
    }
    double getPerimeter(){
        return 2*(a+a);
    }
    @Override
    public String toString(){
        return "Square: {"+ "a = " + a + "; perimeter = " + perimeter + "; area = " + area +"}";
    }
}

class Rectangle extends Shape{
    private double a;
    private double b;
    public Rectangle(double a, double b){
        super("Rectangle", 2*(a+b), a*b);
        this.a = a;
        this.b = b;
    }
    String getType(){
        return "Rectangle";
    }
    double getArea(){
        return a*b;
    }
    double getPerimeter(){
        return 2*(a+b);
    }
    @Override
    public String toString(){
        return "Rectangle: {"+ "a = "+ a + ", b = "+ b + "; perimeter = " + perimeter + "; area = " + area +"}";
    }
}
