/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.recursion;

import java.util.Scanner;

/**
 *
 * @author TLang2026
 */
public class Recursion {
        //set up  thing
            public static int pascalTriangle(int row, int column) {
                //Stops Recursion (Base Case)
                    if (column == 0 || column == row) {
                        return 1; //Limit is 1 (as in the triangle)
                    }
                
                //Recursive call
                    else {
                        return pascalTriangle(row - 1, column - 1) + pascalTriangle(row - 1, column);
                    }
            }
            
        //Print time
            public static void printPascalTriangle(int numRows){
                for (int i = 0; i < numRows; i++) {
                    
                    //Tab in for spaces between rows
                        for (int j = 0; j < numRows - i; j++) {
                                System.out.print("  "); 
                        }
                        
                    for (int j = 0; j <=i; j++){
                        //activate Recursive
                            System.out.printf("%4d", pascalTriangle(i, j)); //Spacing!
                    }
                    //new lines
                        System.out.println();
                }
            }
        
        //Actual Display for user
            public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                
                //ask
                    System.out.println("How many rows do you wish to print:");
                        int rows = input.nextInt(); 
                //Final Print out
                    printPascalTriangle(rows);
            }
    }

