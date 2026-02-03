/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arraysassignment;

import java.util.Random;
import java.util.Arrays;
/**
 *
 * @author theod
 */

/*
Write out an initialized array "weekDays" with all 7 days of the week. Print the days of the 
week out, one day per row. Now resize the array to 5, and copy just the weekdays 
(so not Saturday or Sunday) to it, and print the days again, one day per row. Comment 
your code where you are resizing it.

For an extra bonus point, add a shuffling method, to change the order of the days randolmly.
*/
public class ArraysAssignment {

    public static void main(String[] args) {   
        //Create array w/ all days
            String[] daysOfWeekArray = {
                "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
            };
        //Print all out    
            for (int i = 0; i < daysOfWeekArray.length; i++) {
                System.out.println(daysOfWeekArray[i]); } //Prints one per row 
            
            
            System.out.println(); // blank line
            System.out.println("RESIZED:");
            
        //Weekdays only???
            String[] weekDaysArray = new String[5];
            
            //** RESIZING **: copy ONLY weekdays
                for (int i = 0; i < 5; i++) {
                    weekDaysArray[i] = daysOfWeekArray[i + 1]; //print numbers 1 - 5 (Mon - Fri)
                }
            //Prints list as long as there are days to print
                for (int i = 0; i < weekDaysArray.length; i++) {
                    System.out.println(weekDaysArray[i]);
                }

                
            //Extra Point Step??? Sure :]
                //Declare Real Fast
                    Random rand = new Random();

                //How do we modify the OG list?
                    for (int i = daysOfWeekArray.length - 1; i > 0; i--) {
                        int randomIndex = rand.nextInt(i + 1);

                    // Swap elements
                        String temp = daysOfWeekArray[i];
                        daysOfWeekArray[i] = daysOfWeekArray[randomIndex];
                        daysOfWeekArray[randomIndex] = temp;
                    }
                    
                //PRINT IT ALL OUT 
                    System.out.println();
                    System.out.println("After shuffle:");

                    for (int z = 0; z < daysOfWeekArray.length; z++) {
                        System.out.println(daysOfWeekArray[z]);
                    }
}
}

    




    