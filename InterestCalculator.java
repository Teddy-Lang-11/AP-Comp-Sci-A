/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author theod
 */
import java.text.NumberFormat;

public class InterestRateCalculator {

    // Constant for interest rate (3.5%)
    public static final double RATE = 0.035;

    // Private variables
    private double amount;
    private int months;

    // Public method to start the calculations
    public void calculateRepayments(double principal, int totalMonths) {
        this.amount = principal;
        this.months = totalMonths;

        double remaining = amount;
        double totalPaid = 0;

        // For currency formatting
         NumberFormat currency = NumberFormat.getCurrencyInstance();
         NumberFormat percent = NumberFormat.getPercentInstance();
         percent.setMinimumFractionDigits(2);

        //Print
         System.out.println("\n--- Loan Repayment Schedule ---");
         System.out.println("Interest Rate: " + percent.format(RATE));
         System.out.println("--------------------------------------");

        //Had to research this
        for (int month = 1; month <= months; month++) {
            // Apply interest for this month
            double interest = remaining * RATE;

            // Monthly payment (remaining divided by months left)
            double monthlyPayment = (remaining / (months - month + 1)) + interest;

            totalPaid += monthlyPayment;

        //Final Prints
            System.out.println("Month " + month + ": Payment = " + currency.format(monthlyPayment)
                    + " | Total Paid So Far = " + currency.format(totalPaid));

            // Subtract only the portion that pays down principal
            remaining -= (monthlyPayment - interest);
        }

        System.out.println("--------------------------------------");
        System.out.println("Total Amount Paid: " + currency.format(totalPaid));
        System.out.println("Total Interest Paid: " + currency.format(totalPaid - amount));
    }
}
