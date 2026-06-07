package OOPS;

abstract class Car {
    protected String brand;
    protected String model;
    protected boolean isEngineOn;
    protected int currentSpeed;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isEngineOn = false;
        this.currentSpeed = 0;
    }

    // common methods
    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine started.");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }

    public abstract void accelerate(); // Dynamic polymorphism

    public abstract void accelerate(int speed); // static polymorphism

    public abstract void brake(); // Dynamic polymorphism
}

class ManualCar extends Car {

    protected int currentGear;

    public ManualCar(String brand, String model) {
        super(brand, model);
        this.currentGear = 0;
    }

    public void shiftGear(int gear) {
        currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

    public void accelerate() { // Overriding and Overloading
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    public void accelerate(int speed) { // Overriding and Overloading
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += speed;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    public void brake() { // Overriding
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot brake! Engine is off.");
            return;
        }
        currentSpeed -= 20;
        if (currentSpeed < 0)
            currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }
}

class ElectricCar extends Car {
    private int batteryPercentage;

    public ElectricCar(String brand, String model) {
        super(brand, model);
        this.batteryPercentage = 100;
    }

    public void batteryCharge() {
        batteryPercentage = 100;
        System.out.println(brand + " " + model + " : Battery fully charged!");
    }

    public void accelerate() { // Overriding and Overloading
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        if (batteryPercentage <= 0) {
            System.out.println(brand + " " + model + " : Battery dead! Cannot accelerate.");
            return;
        }
        currentSpeed += 20;
        batteryPercentage -= 10;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h. Battery at "
                + batteryPercentage + "%.");
    }

    public void accelerate(int speed) { // Overriding and Overloading
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        if (batteryPercentage <= 0) {
            System.out.println(brand + " " + model + " : Battery dead! Cannot accelerate.");
            return;
        }
        currentSpeed += speed;
        batteryPercentage -= 10;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h. Battery at "
                + batteryPercentage + "%.");
    }

    public void brake() { // Overriding
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot brake! Engine is off.");
            return;
        }
        if (batteryPercentage <= 0) {
            System.out.println(brand + " " + model + " : Battery dead! Cannot brake.");
            return;
        }
        currentSpeed -= 20;
        batteryPercentage += 10;
        if (currentSpeed < 0)
            currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h. Battery at "
                + batteryPercentage + "%.");
    }

}

public class Polymorphism {
    public static void main(String[] args) {
        Car obj1 = new ManualCar("shift", "alto");
        obj1.startEngine();
        obj1.accelerate();
        obj1.accelerate(10);
        obj1.brake();
        obj1.stopEngine();

        System.out.println("----------------------");

        Car obj2 = new ElectricCar("Tesla", "Model S");
        obj2.startEngine();
        obj2.accelerate();
        obj2.accelerate(20);
        obj2.brake();
        obj2.stopEngine();
    }
}
