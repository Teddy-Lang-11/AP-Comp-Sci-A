/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.radiuscalc;

/**
 *
 * @author TLang2026
 */
/* Directions:
You need to test the provided code. It contains a number of errors of various types
and as such does not work right now. This assignment tests your ability to test and 
find and fix the bugs. In the software industry, you will often be asked to fix bugs 
in code written by someone who is no longer with the company - as often they will have 
moved on, and their buggy code will have been in use for some time, but the bugs never 
found/fixed before. RadiusCalcTest/RadiusCalc at main · jpnelsondons/RadiusCalcTest

Fixing other people's code is a nightmare. Often you will just say it's easier just
to re-write the whole thing again. That is not an option in this assignment. You need 
to find the bugs and fix them. I will come round the class and judge your work. Please 
submit your "fixed" code to GitHub, and share it with me.*/

//Imports???
    import java.util.Scanner;

public class RadiusCalc {

    /**
     * @param args the command line arguments
     */
    //carry out calculations or circular items
    //such as a circle, a sphere, a cone, a column
            //Set Up Scanner
                //Changes var s to scan & made static
                 static Scanner scan = new Scanner(System.in);
                 
                 
    public static void main(String[] args) {

        
        System.out.println("This program calculates round item numbers such as \n" +
                "1 - Area of a circle (𝜋r^2)\n" +
                "2 - Volume of a sphere (4/3 * 𝜋r^3)\n" +
                "3 - Volume of a cone (𝜋r^2 h/3)\n" +
                "4 - Volume of a column (𝜋r^2 h)");
        System.out.println("Type the number for which one you want to calculate");
        int i = scan.nextInt();
            if (i == 1){
                Calc1();
            }else if (i == 2){
                Calc2();
            }else if(i == 3){
                Calc3();
            }else if(i == 4){
                Calc4();
            }
    }
    
    /*1*/ public static void Calc1(){
        System.out.println("enter the radius of your circle");
            int r = scan.nextInt();
        double resultCircle = Math.PI * Math.pow(r, 2); //A=𝜋r2
        
        System.out.println(resultCircle);
    }
    
    /*2*/ public static void Calc2(){
        System.out.println("enter the radius of your circle");
            int r = scan.nextInt();
        //Made 4/3 to 4.0/3.0 b/c they are doubles
            double resultColumn = (4.0/3.0) * Math.PI * Math.pow(r, 3); //V = (4/3) * 𝜋r3
        
        System.out.println(resultColumn);
    }
        
    /*3*/ public static void Calc3(){
        System.out.println("enter the radius of your cone, then height of your cone");
        int r = scan.nextInt();
        int h = scan.nextInt();
        double resultConeH = ((Math.PI * Math.pow(r, 2)) *(h /3));//V = 𝜋r2 * (h/3)
        
        System.out.println(resultConeH);
    }
        
    /*4*/ public static void Calc4(){
        System.out.println("enter the radius of your column, then height of your column");
            int r = scan.nextInt();
            int h = scan.nextInt();
        double resultConeR = Math.PI * Math.pow(r, 2) * h; // 𝑉 = 𝜋𝑟2 * H

        System.out.println(resultConeR);
    }
    

}
