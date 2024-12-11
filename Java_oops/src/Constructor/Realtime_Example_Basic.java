package Constructor;


	
	class Car {
	    private String engineType;
	    private int fuelLevel;

	    // Constructor to initialize the car's engine type and fuel level
	    public Car(String engineType, int fuelLevel) {
	        this.engineType = engineType;
	        this.fuelLevel = fuelLevel;
	        System.out.println("Car with engine " + engineType + " and fuel level " + fuelLevel + " created.");
	    }

	    public void start() {
	        if (fuelLevel > 0) {
	            System.out.println("Car with " + engineType + " engine is starting.");
	        } else {
	            System.out.println("Fuel is empty. Cannot start the car.");
	        }
	    }
	}


public class Realtime_Example_Basic {
	    public static void main(String[] args) {
	        Car car = new Car("V8", 10);
	        car.start();
	    }
	}


