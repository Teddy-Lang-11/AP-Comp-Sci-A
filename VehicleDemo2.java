/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vehicledemo2;

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



public class VehicleDemo2 {

    public static void main(String[] args) {
        
// Vehicle Demo (Main Class)

        Vehicle[] vehicles = {
                //Cars
                    new TeslaModelS(),
                    new ChevroletCorvette(),
                //Boats
                    new SpeedBoat(),
                    new LuxuryYacht(),
                //Planes
                    new Boeing747(),
                    new F22Raptor(),
                //Creatives
                    new BulletTrain(),
                    new SpaceShuttle()
        };

        // Demonstrates polymorphism
            for (Vehicle v : vehicles) {
                System.out.println(v);
                System.out.println("----------------------------------");
            }
    }

}

// Speedometer Interface
    interface Speedometer {
        void setSpeed(double inSpeed);
        double getSpeed();
    }


//PROVIDED CODE
//----------Base Vehicle Class--------------------------------------------------
class Vehicle implements Speedometer {

    //Researched and said to place these as protected???
    //Variables
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
    //Brand Getter/Setter
        public String getBrand() { return brandName; }
        public void setBrandName(String inBrand) { brandName = inBrand; }

    //Speed Getter/Setter
        @Override
        public double getSpeed() { return speed; }

        @Override
        public void setSpeed(double inSpeed) { speed = inSpeed; }

    //Passengers Getter/Setter    
        public int getPassengers() { return passengers; }
        public void setPassengers(int inPassengers) { passengers = inPassengers; }

    //CargoWeight Getter/Setter
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

//OTHER PROVIDED CODE
//----------------Car Class (extends Vehicle)-----------------------------------
class Car extends Vehicle {

    //Variables
        int wheels = 4;
        boolean spoiler = false;
        boolean stereo = false;
        double mpg;

    //String
        public Car(String brand, double speed, int passengers,
                   double cargo, double mpg) {

            super(brand, speed, passengers, cargo); //SUPER STRING
            this.mpg = mpg;
        }

    //GETTER + SETTER
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

    //Prints
        @Override
        public String toString() {
            return super.toString() +
                   "Whe"
                    + "els: \t\t" + wheels + "\n" +
                   "MPG: \t\t\t" + getMPG() + "\n"; //I like this return way more than system.out.print
        }
        
        
}


// 2 Classes Extending Car

//------ELECTRIC TESLA MODEL S---------------------------------------------
class TeslaModelS extends Car {

    //New variable???
        private int batteryRange = 396;

    public TeslaModelS() {
        super("Tesla Model S Plaid", 200, 5, 500, 120); //SUPER STRING FROM CAR
        setSpoiler(true);
    }

    //Print it out
        @Override
        public String toString() {
            return "\t--- Tesla Model S ---\n" +
                   super.toString() +
                   "Battery Range: \t\t" + batteryRange + " miles\n";
        }
        
        //Just follow this format!!! Nice and Easy :)
        
}

//-------Corvette-----------------------------------------------------------
class ChevroletCorvette extends Car {

    private double engineSize = 6.2;

    public ChevroletCorvette() {
        super("Chevrolet Corvette", 194, 2, 300, 19); //SUPER STRING FROM CAR
        setSpoiler(true); //Also with spoiler
    }

    //PRINT
        @Override
        public String toString() {
            return "\t--- Chevrolet Corvette ---\n" +
                   super.toString() +
                   "Engine: \t\t" + engineSize + "L V8\n";
        }
}



// 2 Boat Classes (expand Vehicle)

//--------SPEED BOAT-----------------------------------------------------------
class SpeedBoat extends Vehicle {

    //Specific Variables
        private int engines = 2;
    
    public SpeedBoat() {
        super("Cigarette Racing Boat", 85, 6, 2000); //Super String from Vehicle
    }

    //PRINT IT ALL OUT
        @Override
        public String toString() {
            return "\t--- Speed Boat ---\n" +
                   super.toString() +
                   "Engines: \t\t" + engines + "\n";
        }
}

//------Luxury Yacht-----------------------------------------------------------
class LuxuryYacht extends Vehicle {
    
    //Specifics?
        private double length = 131;

    public LuxuryYacht() {
        super("Sunseeker 131", 30, 12, 15000);
    }

    //Print it out
        @Override
        public String toString() {
            return "\t--- Luxury Yacht ---\n" +
                   super.toString() +
                   "Length: \t\t" + length + " ft\n";
        }
}



// 2 Airplane Classes (off of Vechicle)

//--------Boeing 747---------------------------------------------------------
class Boeing747 extends Vehicle {

    //Specific Variable?
        private int engines = 4;

    public Boeing747() {
        super("Boeing 747-400", 614, 416, 140000); //SUPER STRING
    }

    //Return it 
        @Override
        public String toString() {
            return "\t--- Boeing 747 ---\n" +
                   super.toString() +
                   "Engines: \t\t" + engines + "\n";
        }
}

//-----F22 Raptor------------------------------------------------------------
class F22Raptor extends Vehicle {

    //Specific Trait?
        private boolean stealth = true;

    public F22Raptor() {
        super("F-22 Raptor", 1500, 1, 20000); //SUPER STRING
    }

    //PRINT IT OUT
        @Override
        public String toString() {
            return "\t--- F-22 Raptor ---\n" +
                   super.toString() +
                   "Stealth Capable: \t" + stealth + "\n";
        }
}



// 2 Creative Vehicle Classes

//-----BULLER TRAIN----------------------------------------------------------
class BulletTrain extends Vehicle {

    //Specific Variable
        private int trainCars = 16;

    public BulletTrain() {
        super("Shinkansen N700", 200, 1300, 0); //SUPER STRING
    }

    //Return it
        @Override
        public String toString() {
            return "\t--- Bullet Train ---\n" +
                   super.toString() +
                   "Train Cars: \t\t" + trainCars + "\n";
        }
}

//------SPACE SHUTTLE--------------------------------------
class SpaceShuttle extends Vehicle {

    //Specific Variable
        private double maxAltitude = 1200; // miles

    public SpaceShuttle() {
        super("NASA Space Shuttle", 17500, 7, 50000); //SUPER STRING
    }

    //Return it :)
        @Override
        public String toString() {
            return "\t--- Space Shuttle ---\n" +
                   super.toString() +
                   "Max Altitude: \t\t" + maxAltitude + " miles\n";
        }
}

    

