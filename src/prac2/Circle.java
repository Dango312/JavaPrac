package prac2;
import java.util.Random;

public class Circle extends Point{
    private double radius = 1;

    public Circle(double xCenter, double yCenter, double radius){
        super(xCenter, yCenter);
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void randPointIn(){
        double minX = x-radius;
        double maxX = x+radius;
        double minY = y-radius;
        double maxY = y+radius;
        Random random = new Random();
        double rx = minX + random.nextDouble(maxX-minX);
        double ry = minY + random.nextDouble(maxY-minY);
        System.out.println("Random point inside the circle {x = " + rx + ", y = " + ry + "}");
    }

    @Override
    public String toString(){
        return "Circle{" +
                "x = " + x +
                ", y = " + y +
                ", radius = " + radius + "}";
    }
}
