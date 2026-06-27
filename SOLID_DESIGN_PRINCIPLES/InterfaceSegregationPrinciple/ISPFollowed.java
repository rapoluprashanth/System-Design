package SOLID_DESIGN_PRINCIPLES.InterfaceSegregationPrinciple;

// -Many client specific interface are better than one general purpose interface 
// -client should not be forced to implement methods if they don't need
interface Shape2D {
    public void area();
}

interface Shape3D {
    public void volume();
}

class Square implements Shape2D {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public void area() {
        System.out.println("Area of Square is " + side * side);
    }
}

class Rectangle implements Shape2D {

    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void area() {
        System.out.println("Area of is Rectangle " + length * breadth);
    }
}

class Cube implements Shape2D, Shape3D {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public void area() {
        System.out.println("Area of Cube is " + 6 * side * side);
    }

    public void volume() {
        System.out.println("Volume of Cube is " + side * side * side);
    }
}

public class ISPFollowed {
    public static void main(String[] args) {
        Square square = new Square(10);
        Rectangle rec = new Rectangle(10, 20);
        Cube cube = new Cube(20);

        square.area();
        rec.area();
        cube.area();
        cube.volume();
    }
}
