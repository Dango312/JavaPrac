package prac3;

import java.util.Random;

public class Circle extends Point{
    private int radius=1;
    Circle(int radius, int xCenter, int yCenter){
        super(xCenter, yCenter);
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void randPointIn(){
        int minX = x-radius;
        int maxX = x+radius;
        int minY = y-radius;
        int maxY = y+radius;
        Random random = new Random();
        int rx = minX + random.nextInt(maxX-minX);
        int ry = minY + random.nextInt(maxY-minY);
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
