/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pascaltriangle;

import java.util.Scanner;

/**
 *
 * @author TLang2026
 */
public class PascalTriangle {
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
            
        //Print time ONLY TARGET ROW
            public static void printOneRow(int targetRow) {
                 System.out.print("Row " + targetRow + ": ");
                    
                    // Only one loop needed 
                        for (int j = 0; j <= targetRow; j++) {
                            System.out.printf("%4d", pascalTriangle(targetRow, j));
                        }
                 
                 System.out.println();
             }
        
        //Actual Display for user
            public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                
                //ask
                    System.out.println("Which row of Pascal's Triangle do you want to print:");
                        int rows = input.nextInt(); 
                //Final Print out
                    printOneRow(rows);
            }
    }

