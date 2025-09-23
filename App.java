/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sideddiegenerator;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author theod
 */
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random generator = new Random();
        
        //Generate a number 1-6
        int numDie = generator.nextInt(6) + 1;
        
        //print out number
        System.out.println("*Dice rolls*");
        System.out.println("     " + numDie);
        System.out.println(" ");
        
        //code for re-roll or quit
         while (true){
         System.out.println("Press 'r' to re-roll. Press 'q' to quit");
         
         //What's the user input?
          String input;
            input = scanner.nextLine();
            //if it is an 'r'
             if (input.trim().equalsIgnoreCase("r")) {
                // Redo Roll
                int diceRoll = generator.nextInt(6) + 1;
                System.out.println("*Dice Rolls*");
                System.out.println("     " + diceRoll);
        }
             //if it is an 'q'
             else if (input.trim().equalsIgnoreCase("q")) {
                System.out.println("Goodbye!");
                
                break; 
         }
    }
}
}