/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arraysassignment;

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
            String[] daysOfWeek = {
                "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
            };
        //Print all out    
            for (int i = 0; i < daysOfWeek.length; i++) {
                System.out.println(daysOfWeek[i]); //Prints one per row 
            }
            
            System.out.println(); // blank line
            System.out.println("RESIZED:");
            
        //Weekdays only???
            String[] weekDays = new String[5];
            
            //** RESIZING **: copy ONLY weekdays (Monday–Friday)
                for (int i = 0; i < 5; i++) {
                    weekDays[i] = daysOfWeek[i + 1]; //print numbers 1 - 5 (Mon - Fri)
                }
            //Prints list as long as there are days to print
                for (int i = 0; i < weekDays.length; i++) {
                    System.out.println(weekDays[i]);
                }

                
            //Extra Point Step???
    }
}
