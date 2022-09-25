package prac3;

public class Point {
    int x = 0;
    int y = 0;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public double getX() {
        return x;
    }

    @Override
    public String toString(){
        return "Point{"+ x + ", "+y+"}";
    }
}
