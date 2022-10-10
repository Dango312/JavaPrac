package prac6;
//№1,2, 6-9, 12-13
public class MovableTester {
    public static void main(String[] args){
        MovableCircle c1 = new MovableCircle(0,0, 2, 4, 6);
        System.out.println(c1);
        c1.moveLeft();
        System.out.println(c1);
        System.out.println("-------------------------------------------------");
        MovableRectangle r1 = new MovableRectangle(0,0,8, 8, 3, 2);
        System.out.println(r1);
        r1.moveDown();
        r1.moveRight();
        System.out.println(r1);
    }
}

class MovablePoint implements Movable{
    int x, y, xSpeed, ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        y += ySpeed;
    }

    @Override
    public void moveDown() {
        y -= ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }
}
class MovableCircle extends MovablePoint{
    int radius;
    MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        super(x, y, xSpeed, ySpeed);
        this.radius = radius;
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
    }

    @Override
    public void moveUp() {
        center.y += ySpeed;
    }

    @Override
    public void moveDown() {
        center.y -= ySpeed;
    }

    @Override
    public void moveLeft() {
        center.x -= xSpeed;
    }

    @Override
    public void moveRight() {
        center.x += xSpeed;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}

class MovableRectangle extends MovablePoint{
    MovablePoint topLeft, bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        super(0,0,xSpeed,ySpeed);
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    @Override
    public void moveUp() {
        topLeft.y += ySpeed;
        bottomRight.y += ySpeed;
    }

    @Override
    public void moveDown() {
        topLeft.y -= ySpeed;
        bottomRight.y -= ySpeed;
    }

    @Override
    public void moveLeft() {
        topLeft.x -= xSpeed;
        bottomRight.x -= xSpeed;
    }

    @Override
    public void moveRight() {
        topLeft.x += xSpeed;
        bottomRight.x += xSpeed;
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topLeft=" + topLeft +
                ", topRight=" + bottomRight +
                '}';
    }
}