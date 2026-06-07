package OOPS;
class Car{
   protected String brand;
   protected String model;
   protected boolean isEngineOn;
   protected int currentSpeed;

    public Car(String brand,String model){
    this.brand=brand;
    this.model=model;
    this.isEngineOn=false;
    this.currentSpeed=0;
   }

    public void startEngine(){
      isEngineOn=true;
      System.out.println(brand + " " + model + " : Engine started.");
   }

    public void stopEngine(){
      isEngineOn=false;
      currentSpeed=0;
      System.out.println(brand + " " + model + " : Engine turned off.");
   }

    public void accelerate(){
      if(!isEngineOn){
         System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
         return;
      }
      currentSpeed+=20;
      System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    public void brake(){
       if(!isEngineOn){
         System.out.println(brand + " " + model + " : Cannot brake! Engine is off.");
         return;
       }
       currentSpeed-=20;
       if(currentSpeed<0)
       currentSpeed=0;
       System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }
}

class ManualCar extends Car{
    private int currentGear;

    public ManualCar(String brand, String model){
        super(brand, model);
        this.currentGear=0;
    }

    public void shiftGear(int gear){
       currentGear=gear;
       System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }
}

class ElectricCar extends Car{
    private int batteryCharge;

    public ElectricCar(String brand, String model){
        super(brand, model);
        this.batteryCharge=0;
    } 

    public void batteryPercentage(int bc){
        batteryCharge=bc;
        System.out.println(brand + " " + model + " : Battery Percentage " + batteryCharge);
    }

}
public class Inheritance {
    public static void main(String args[]){
        ManualCar obj1=new ManualCar("Suzuki", "alto");
        obj1.startEngine();
        obj1.accelerate();
        obj1.brake();
        obj1.shiftGear(1);
        obj1.stopEngine();

        System.out.println("----------------------");

        ElectricCar obj2=new ElectricCar("Tesla","Model S");
        obj2.startEngine();
        obj2.accelerate();
        obj2.brake();
        obj2.batteryPercentage(50);
        obj2.stopEngine();
    }
}
