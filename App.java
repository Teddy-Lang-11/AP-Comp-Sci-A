/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.darraysassignment;

import java.util.Random;

/**
 *
 * @author TLang2026
 */

/*DIRECTIONS:
    Write a 2D String array called deckOfCards. This will have 4 arrays, each of length 13. 
Fill the 4 arrays with the 4 suits of playing cards, from Ace to King (1 to 13). Shuffle 
the deck, and deal out 4 hands of 5 cards from this 2D array (no dealing the same card twice). 
Show the hands (Diamonds, Hearts, Clubs, Spades).*/

public class App {

    public static void main(String[] args) {
        //Set up the Array Values
            int rows = 4;
            int columns = 13;
            
            String[][] Deck = new String[rows][columns]; //4 wide - 13 long
            
                //Specific Values
                    String[] suit = {"Hearts", "Diamonds", "Clubs", "Spades"};
                    String[] value = {"Ace", "2", "3", "4", "5", "6", "7",
                        "8", "9", "10", "Jack", "Queen", "King"};
        
        //Add them into the Array [Researched :) ]
            for (int i = 0; i < Deck.length; i++) {        // for the suits
                for (int j = 0; j < Deck[i].length; j++) { // for the cards
                    Deck[i][j] = value[j] + " of " + suit[i]; 
                }
            }
        
        //Create deck in correct format [Researched :) ]
            String[][] displayGridA = new String[4][14];

            for (int i = 0; i < 4; i++) {
                displayGridA[i][0] = suit[i]; // suits
                for (int j = 1; j <= 5; j++) {
                    displayGridA[i][j] = Deck[i][j - 1];
                }
                for (int j = 6; j < 14; j++) {
                    displayGridA[i][j] = Deck[i][j - 1];
                }
            }
         
         //Printing out Deck
            System.out.println("--Unshuffled Deck--");
        for (int i = 0; i < displayGridA.length; i++) {
            for (int j = 0; j < displayGridA[i].length; j++) {
                System.out.printf("%-20s", displayGridA[i][j]);
            }
            System.out.println();
        }
    
//------------------Random-Hands------------------------------------------------
//import the random
    Random rand = new Random();
    
    //Set up new
        boolean[][] used = new boolean[rows][columns];

            System.out.println(" ");
            System.out.println("--Dealt Hands--");
            System.out.println(" ");

        //for loop
            for (int hand = 0; hand < 4; hand++) {
                System.out.println("Hand " + (hand + 1)+ ": ");

                int cardsDealt = 0;

                while (cardsDealt < 5) { //continue to print more
                    int randSuit = rand.nextInt(rows);      // 0–3 (hearts - spades)
                    int randCard = rand.nextInt(columns);   // 0–12 (ace - king)

                    // Make sure the card has not been used
                        //RESEARCH :)
                        if (!used[randSuit][randCard]) {
                            used[randSuit][randCard] = true;
                            System.out.println("  " + Deck[randSuit][randCard]);
                            cardsDealt++;
                        }
                }

                System.out.println();
            }

    
    }
}

    