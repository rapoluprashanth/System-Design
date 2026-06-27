package SOLID_DESIGN_PRINCIPLES.InterfaceSegregationPrinciple;

interface Shape {
    public void area();

    public void volume();
}

class Square implements Shape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public void area() {
        System.out.println("Area of Square is " + side * side);
    }

    public void volume() {   // Unnecessary method
        throw new UnsupportedOperationException("Volume not applicable for Square");
    }
}

class Rectangle implements Shape {

    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void area() {
        System.out.println("Area of  is Rectangle " + length * breadth);
    }

    public void volume() {   // Unnecessary method
        throw new UnsupportedOperationException("Volume not applicable for Rectangle");
    }
}

class Cube implements Shape {
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

class Client {
    private Shape p;

    public Client(Shape p) {
        this.p = p;
    }

    public void getResult() {
        try {
            p.area();
            p.volume();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

public class ISPViolated {
    public static void main(String[] args) {
        Square square = new Square(10);
        Rectangle rec = new Rectangle(10, 20);
        Cube cube = new Cube(20);

        Client obj1 = new Client(square);
        obj1.getResult();

        Client obj2 = new Client(rec);
        obj2.getResult();

        Client obj3 = new Client(cube);
        obj3.getResult();

    }
}
