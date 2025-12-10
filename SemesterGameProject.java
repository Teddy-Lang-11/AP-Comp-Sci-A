/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semestergameproject;

//Imports
    import java.util.Random;
    import java.util.Scanner;
        
/**
 *
 * @author TLang2026
 */

public class SemesterGameProject {
    public static void main(String[] args) {
    

    //Declarations
        Scanner input = new Scanner(System.in);
       
        
        //Prompts to play y/n
            System.out.println("Ready to Start?(y/n)");
                //Set up string for user responses
                        String r1; //where r1 is the first instance of user input
                            r1 = input.nextLine();
            //yes - start game
                if (r1.equalsIgnoreCase("y")){
                    System.out.println("Input Detected.");
                    System.out.println(" ");
                //Create an object of the Game class
                    Game newGame = new Game();
                        newGame.start();
                }
            //no - quit program/Loop
                else if (r1.equalsIgnoreCase("n")) {
                        System.out.println("Input Detected.");
                        System.out.println(" ");
                        }
                
            //other
                 else System.out.println("Please enter either y or n");
                   
            
    }
}

//-----------------------New-Class----------------------------------------------

class Game{        
        
    //Declarations
        Scanner input = new Scanner(System.in);
        int wallet = 1000;

        //Activate Game
            public void start() {

        //Game Starts...
            System.out.println("--- Starting the Game! ---");
            System.out.println(" ");
     
        //Game Active
            //Utilize a Boolean to continue the game's loop
                 boolean playing = true;
                 
            //Wallet Code (How it works and flow of money
                 while (playing && wallet > 0) {

                    //Display current cash
                        System.out.println("Wallet: $" + wallet);
                        System.out.println(" ");
            
                // Deal 2 Cards (USE CardGen Class)(A & B)
                    //Card generation
                        CardGen c = new CardGen();
                            
                        //Two starter Cards
                            int cardA = c.getCardA();
                            int cardB = c.getCardB();

                        //Display these cards w/ cool graphics
                                                //Formatting Card
                        if (cardA < 10 && cardB < 10){
                    System.out.println( " _______       _______");
                    System.out.println( "|" + cardA + "      |     |" + cardB + "      |");
                    System.out.println( "|       |     |       |");
                    System.out.println( "|       |     |       |");
                    System.out.println( "|      " + cardA + "|     |      " + cardB + "|");
                    System.out.println( " -------       -------");
                        }
                    else if (cardA >= 10 && cardB >= 10){
                        System.out.println( " _______       _______");
                        System.out.println( "|" + cardA + "     |     |" + cardB + "     |");
                        System.out.println( "|       |     |       |");
                        System.out.println( "|       |     |       |");
                        System.out.println( "|     " + cardA + "|     |     " + cardB + "|");
                        System.out.println( " -------       -------");
                        }
                    else if (cardA < 10 && cardB >= 10){
                        System.out.println( " _______       _______");
                        System.out.println( "|" + cardA + "      |     |" + cardB + "     |");
                        System.out.println( "|       |     |       |");
                        System.out.println( "|       |     |       |");
                        System.out.println( "|      " + cardA + "|     |     " + cardB + "|");
                        System.out.println( " -------       -------");
                    }
                    else if (cardA >= 10 && cardB < 10){
                        System.out.println( " _______       _______");
                        System.out.println( "|" + cardA + "     |     |" + cardB + "      |");
                        System.out.println( "|       |     |       |");
                        System.out.println( "|       |     |       |");
                        System.out.println( "|     " + cardA + "|     |      " + cardB + "|");
                        System.out.println( " -------       -------");
                    }
                
                //Ask User, 'Will next card be between these two?' y/n
                    System.out.println(" ");
                    System.out.println("Will the next card be between these two? y/n");
                    String userGuess = input.nextLine();

                    
                //Bet Code
                
                int bet = 0;
                
                    //Ask user for bet 
                        while (true) {
                            System.out.println("Enter your bet amount:");
    
                        if (input.hasNextInt()) {
                            bet = input.nextInt();
                                input.nextLine(); // consume leftover newline
        
                        if (bet > 0 && bet <= wallet) {
                            break; // valid bet, exit loop
                        }
                             else {
                                System.out.println("Bet must be between $1 and $" + wallet + ".");
                            }
                        
                            } else {
                                System.out.println("Please enter a valid number.");
                                input.nextLine(); // clear invalid input
                            }
                        }
                 

            
                    //Take out bet
                        wallet -= bet;
                        
                //Show User the card C
                    int cardC = c.getCardC();
                    System.out.println(" ");
                    System.out.println("Card C");
                    
                    //Formatting Card
                        if (cardC < 10){
                    System.out.println( " _______");
                    System.out.println( "|" + cardC + "      |");
                    System.out.println( "|       |");
                    System.out.println( "|       |");
                    System.out.println( "|      " + cardC + "|");
                    System.out.println( " ------- ");
                        }
                    else if (cardC >= 10){
                        System.out.println( " _______");
                        System.out.println( "|" + cardC + "     |");
                        System.out.println( "|       |");
                        System.out.println( "|       |");
                        System.out.println( "|     " + cardC + "|");
                        System.out.println( " ------- ");
                    }
                    
                /*see if it is really in the middle or not
                    RESEARCH THIS */
                    int lowCard = Math.min(cardA, cardB);
                    int highCard = Math.max(cardA, cardB);
                
                /*Boolean expression to compare card c to the min & max
                    OR IF SAME
                    RESEARCH*/
                     boolean isBetween = cardC > lowCard && cardC < highCard;
                     boolean isEquals = cardC == lowCard || cardC == highCard;

                
                    //yes + true :)
                        if (userGuess.equalsIgnoreCase("y") && isBetween) {
                            //WIN ~ add 200 to wallet 
                                System.out.println(" ");
                                System.out.println("Correct! You win $" + bet + " !");
                                    wallet += (bet * 2);;
                                System.out.println("Wallet: $" + wallet);
                        }
                        
                    //no + true :)
                        else if (userGuess.equalsIgnoreCase("n") && !isBetween) {
                            // WIN ~ add 200 to wallet
                                System.out.println(" ");
                                System.out.println("Correct! You win $" + bet + " !");
                                    wallet += (bet * 2);
                                System.out.println("Wallet: $" + wallet);
                        }
                        
                    //no + false :(
                        else if (userGuess.equalsIgnoreCase("n") && isBetween) {
                                System.out.println(" ");
                                System.out.println("Incorrect! You lost $" + bet + " !");
                                System.out.println("Wallet: $" + wallet);
                        }
                        
                    //yes + false :(
                        else if (userGuess.equalsIgnoreCase("y") && !isBetween) {
                            //LOSE ~ add 0 to wallet 
                                System.out.println(" ");
                                System.out.println("Incorrect! You lost $" + bet + " !");
                                System.out.println("Wallet: $" + wallet);
                        }
                    
                    //If it is same as a boundary card:
                        //Yes :/
                        else if (userGuess.equalsIgnoreCase ("y")  && isEquals) {
                            System.out.println(" ");
                            System.out.println("Wow! Same card! You lost $" + bet + " ! Better luck next time!");
                            System.out.println("Wallet: $" + wallet);
                        }
                        
                        //No :/
                        else if (userGuess.equalsIgnoreCase ("n")  && isEquals) {
                            System.out.println(" ");
                            System.out.println("Wow! Same card! You lost $" + bet + " ! Better luck next time!");
                            System.out.println("Waller: $" + wallet);
                        }
                        
                        
                       
            //Prompt to play again
                System.out.println(" ");
                System.out.println("Perhaps another round?...");
                System.out.println(" ");
                System.out.println("Play again? (y/n)");
                    String userContinue = input.nextLine();

                //If u wanna quit    
                if (!userContinue.equalsIgnoreCase("y")) {
                playing = false;
            }
    }
            //Final Score
                System.out.println(" ");
                System.out.println("Game over! Final wallet amount: $" + wallet);
}
}


        
//-----------------------New-Class----------------------------------------------

class CardGen{ //(Regardless of Suit)(Ace[1]-King[13])
    
    
    //Declarations
        Random deal = new Random();
    
    //Generation
        //Card A
            //Randomly generated value (1-13)
                int valCardA = deal.nextInt(13) + 1; //Makes range 0-12 but then adds 1
                
            /* In case we wanna add suits    
                //Randomly generated card suit (1-4)
                    int suitCardA = deal.nextInt(4) + 1; //Makes range 0-3 but then adds 1 */
                
            //Getter + Setters
                public int getCardA() {
                    return valCardA;
                }



        //Card B
            //Randomly generated value (1-13)
                int valCardB = deal.nextInt(13) + 1;
            
            /*In case we wanna add suits
                //Randomly generated card suit (1-4)
                    int suitCardB = deal.nextInt(4) + 1; */
                
            //Getter    
                public int getCardB() {
                    return valCardB;
                }
        

        //Card C
            //Randomly generated value (1-13)
                int valCardC = deal.nextInt(13) + 1;
            
            /*In case we wanna add suits
                //Randomly generated card suit (1-4)
                    int suitCardB = deal.nextInt(4) + 1; */
                
            //Getter    
                public int getCardC() {
                    return valCardC;
                }
            
            //Make the card format
                /*
                    _______
                   |       |
                   |       |
                   |       |
                   |       |
                    -------
                */
}

//-----------------------New-Class----------------------------------------------