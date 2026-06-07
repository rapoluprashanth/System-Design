package OOPS;

class MyCar {
    private String brand;
    private String model;
    private boolean isEngineOn = false;
    private int currentSpeed = 0;
    private int currentGear = 0;

    MyCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
        return;
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine starts with a roar!");
    }

    public void shiftGear(int gear) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off! Cannot Shift Gear.");
            return;
        }
        this.currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off! Cannot accelerate.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0)
            currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        MyCar obj = new MyCar("Suzuki", "alto");
        obj.startEngine();
        obj.shiftGear(5);
        obj.accelerate();
        obj.brake();
        obj.stopEngine();

        // obj.currentSpeed=100; Data security
        obj.setCurrentSpeed(100);
        System.out.println(obj.getCurrentSpeed());
    }
}