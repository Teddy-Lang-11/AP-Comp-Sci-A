/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vehicledemo;

/**
 *
 * @author TLang2026
 */

/* DIRECTIONS:
I want you to use the code I have supplied for Vehicle and Car, and expand on this. 
Look up vehicle specs on the web.

I want each person to create 2 Class files that inherit from Car, as well as 2 Boat Classes, 
2 Airplane classes, and 2 other vehicle Classes (impress me!). I basicallty want 
to get you used to using inheritance.

You can override the toString to print out speial characteristics, use the Speedometer methods 
as needed (should all speeds be in mph?). I may give extra credit if I am impressed by someone's 
imaginitive coding. Please make sure to comment everything well.
*/


// Vehicle Demo (Main Class)
public class VehicleDemo {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new TeslaModelS(),
                new ChevroletCorvette(),
                new SpeedBoat(),
                new LuxuryYacht(),
                new Boeing747(),
                new F22Raptor(),
                new FunBulletTrain(),
                new FunSpaceShuttle()
        };

        // Demonstrates polymorphism
        for (Vehicle v : vehicles) {
            System.out.println(v);
            System.out.println("----------------------------------");
        }
    }
}


// ===============================
// Speedometer Interface
// ===============================
interface Speedometer {
    void setSpeed(double inSpeed);
    double getSpeed();
}


// ===============================
// Base Vehicle Class
// ===============================
class Vehicle implements Speedometer {

    protected String brandName = "";
    protected double speed = 0.0; // mph
    protected int passengers = 0;
    protected double cargoWeight = 0.0; // lbs

    public Vehicle() {}

    public Vehicle(String inBrand, double inSpeed, int inPassengers, double inCargo) {
        brandName = inBrand;
        speed = inSpeed;
        passengers = inPassengers;
        cargoWeight = inCargo;
    }

    public String getBrand() { return brandName; }
    public void setBrandName(String inBrand) { brandName = inBrand; }

    @Override
    public double getSpeed() { return speed; }

    @Override
    public void setSpeed(double inSpeed) { speed = inSpeed; }

    public int getPassengers() { return passengers; }
    public void setPassengers(int inPassengers) { passengers = inPassengers; }

    public double getCargoWeight() { return cargoWeight; }
    public void setCargoWeight(double inCargoWeight) { cargoWeight = inCargoWeight; }

    @Override
    public String toString() {
        return "Brand: \t\t\t" + brandName + "\n" +
               "Speed (mph): \t\t" + getSpeed() + "\n" +
               "Passengers: \t\t" + passengers + "\n" +
               "Cargo (lbs): \t\t" + cargoWeight + "\n";
    }
}


// ===============================
// Car Class (extends Vehicle)
// ===============================
class Car extends Vehicle {

    int wheels = 4;
    boolean spoiler = false;
    boolean stereo = false;
    double mpg;

    public Car(String brand, double speed, int passengers,
               double cargo, double mpg) {

        super(brand, speed, passengers, cargo);
        this.mpg = mpg;
    }

    public void setSpoiler(boolean s) { spoiler = s; }
    public void setStereo(boolean s) { stereo = s; }

    @Override
    public double getSpeed() {
        if (spoiler)
            return super.getSpeed() + 20;
        else
            return super.getSpeed();
    }

    public double getMPG() {
        if (stereo)
            return mpg * 0.9;
        else
            return mpg;
    }

    @Override
    public String toString() {
        return super.toString() +
               "Wheels: \t\t\t" + wheels + "\n" +
               "MPG: \t\t\t" + getMPG() + "\n";
    }
}


// ===============================
// 2 Classes Extending Car
// ===============================

class TeslaModelS extends Car {

    private int batteryRange = 396;

    public TeslaModelS() {
        super("Tesla Model S Plaid", 200, 5, 500, 120);
        setSpoiler(true);
    }

    @Override
    public String toString() {
        return "=== Tesla Model S ===\n" +
               super.toString() +
               "Battery Range: \t\t" + batteryRange + " miles\n";
    }
}

class ChevroletCorvette extends Car {

    private double engineSize = 6.2;

    public ChevroletCorvette() {
        super("Chevrolet Corvette", 194, 2, 300, 19);
        setSpoiler(true);
    }

    @Override
    public String toString() {
        return "=== Chevrolet Corvette ===\n" +
               super.toString() +
               "Engine: \t\t\t" + engineSize + "L V8\n";
    }
}


// ===============================
// 2 Boat Classes
// ===============================

class SpeedBoat extends Vehicle {

    private int engines = 2;

    public SpeedBoat() {
        super("Cigarette Racing Boat", 85, 6, 2000);
    }

    @Override
    public String toString() {
        return "=== Speed Boat ===\n" +
               super.toString() +
               "Engines: \t\t\t" + engines + "\n";
    }
}

class LuxuryYacht extends Vehicle {

    private double length = 131;

    public LuxuryYacht() {
        super("Sunseeker 131", 30, 12, 15000);
    }

    @Override
    public String toString() {
        return "=== Luxury Yacht ===\n" +
               super.toString() +
               "Length: \t\t\t" + length + " ft\n";
    }
}


// ===============================
// 2 Airplane Classes
// ===============================

class Boeing747 extends Vehicle {

    private int engines = 4;

    public Boeing747() {
        super("Boeing 747-400", 614, 416, 140000);
    }

    @Override
    public String toString() {
        return "=== Boeing 747 ===\n" +
               super.toString() +
               "Engines: \t\t\t" + engines + "\n";
    }
}

class F22Raptor extends Vehicle {

    private boolean stealth = true;

    public F22Raptor() {
        super("F-22 Raptor", 1500, 1, 20000);
    }

    @Override
    public String toString() {
        return "=== F-22 Raptor ===\n" +
               super.toString() +
               "Stealth Capable: \t" + stealth + "\n";
    }
}


// ===============================
// 2 Creative Vehicle Classes
// ===============================

class FunBulletTrain extends Vehicle {

    private int trainCars = 16;

    public FunBulletTrain() {
        super("Shinkansen N700", 200, 1300, 0);
    }

    @Override
    public String toString() {
        return "=== Bullet Train ===\n" +
               super.toString() +
               "Train Cars: \t\t" + trainCars + "\n";
    }
}

class FunSpaceShuttle extends Vehicle {

    private double maxAltitude = 1200; // miles

    public FunSpaceShuttle() {
        super("NASA Space Shuttle", 17500, 7, 50000);
    }

    @Override
    public String toString() {
        return "=== Space Shuttle ===\n" +
               super.toString() +
               "Max Altitude: \t\t" + maxAltitude + " miles\n";
    }
}
