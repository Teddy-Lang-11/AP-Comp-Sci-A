/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author theod
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Set up scanner for user inputs
         Scanner input = new Scanner(System.in);

        // Ask user for starting amount
         System.out.print("Enter the financial amount (e.g. 1000000): ");
         double amount = input.nextDouble();

        // Ask user for number of months
         System.out.print("Enter number of months for repayment: ");
         int months = input.nextInt();

        // Create an object of InterestRateCalculator
         InterestRateCalculator calculator = new InterestRateCalculator();

        // Create method to calculate and display the payments
         calculator.calculateRepayments(amount, months);

        input.close();
    }
}
