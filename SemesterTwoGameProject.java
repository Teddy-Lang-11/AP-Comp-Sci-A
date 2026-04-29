/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semestertwogameproject;

/**
 *
 * @author theod
 */

//Imports
        import java.util.Scanner;
        import java.io.*;
        import java.util.Random;

public class SemesterTwoGameProject {

    /**
     * @param args the command line arguments
     */
    
    /*
    FORMAT/SUPREMACY:
        1) SlotMachineCasino.java   (main ~ SemesterTwoGameProject)
        2) Player.java
        3) SlotMachine.java
        4) FileHandler.java
    */

    private static final Scanner scanner = new Scanner(System.in);
    private static  FileHandler fileHandler = new FileHandler();
    private static  SlotMachine slotMachine = new SlotMachine();

    public static void main(String[] args) {

        Player player = fileHandler.loadPlayerData("userdata.txt");

        System.out.println("Welcome " + player.getName());

        boolean running = true;

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert Credits");
            System.out.println("2. Set Bet & Spin");
            System.out.println("3. View Game History");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertCredits(player);
                    break;
                case 2:
                    playRound(player);
                    break;
                case 3:
                    viewGameHistory();
                    break;
                case 4:
                    running = false;
                    break;
            }
        }

        fileHandler.savePlayerData(player, "userdata.txt");
        System.out.println("Game saved. Goodbye!");
    }

    // 🔹 Insert Credits
    public static void insertCredits(Player player) {
        System.out.print("Enter amount to add: ");
        int amount = scanner.nextInt();
        player.setBalance(player.getBalance() + amount);
        System.out.println("New Balance: $" + player.getBalance());
    }

    // 🔹 Play = Set Bet + Spin + Determine Result
    public static void playRound(Player player) {
    System.out.print("Enter bet: ");
    int bet = scanner.nextInt();

    if (bet > player.getBalance()) {
        System.out.println("Not enough balance.");
        return;
    }

    // ✅ ALWAYS subtract bet first
    player.setBalance(player.getBalance() - bet);

    String[][] grid = slotMachine.spin();
    displayGrid(grid);

    int winnings = slotMachine.calculateWinnings(grid, bet);

    if (winnings > 0) {
        processWin(player, winnings, bet);
    } else {
        processLoss(player, bet);
    }
}

    // 🔹 Determine Result is implicit via winnings

    // 🔹 Process Winning (matches UML)
    public static void processWin(Player player, int winnings, int bet) {
        player.setBalance(player.getBalance() + winnings);

        System.out.println("You WON $" + winnings);
        System.out.println("Balance: $" + player.getBalance());

        fileHandler.appendGameHistory(
            "WIN | Bet: " + bet + " | Won: " + winnings,
            "game_history.txt"
        );
    }

    // 🔹 Process Losing (matches UML)
    public static void processLoss(Player player, int bet) {
        player.setBalance(player.getBalance() - bet);

        System.out.println("You lost $" + bet);
        System.out.println("Balance: $" + player.getBalance());

        if (player.getBalance() <= 0) {
            System.out.println("Game Over! No balance left.");
        }

        fileHandler.appendGameHistory(
            "LOSS | Bet: " + bet,
            "game_history.txt"
        );
    }

    // 🔹 View Game History
    public static void viewGameHistory() {
        try (BufferedReader br = new BufferedReader(new FileReader("game_history.txt"))) {
            String line;
            System.out.println("\n--- GAME HISTORY ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No history found.");
        }
    }

    // 🔹 Helper
    public static void displayGrid(String[][] grid) {
        System.out.println("\n--- SLOT RESULT ---");
        for (String[] row : grid) {
            for (String s : row) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
//-------Player.java-------------------------------------------
class Player {
    private String name;
    private int balance;

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
 
//-------SlotMachine.java-------------------------------------------
class SlotMachine {
    private final String[][] symbols; // 3x3 grid
    private final String[] possibleSymbols = {"A", "B", "C", "7", "$"};

    public SlotMachine() {
        symbols = new String[3][3];
    }

    public String[][] spin() {
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                symbols[i][j] = possibleSymbols[rand.nextInt(possibleSymbols.length)];
            }
        }
        return symbols;
    }

    public int calculateWinnings(String[][] grid, int bet) {
        int winnings = 0;

        // Simple rule: each matching row = 2x bet
        for (int i = 0; i < 3; i++) {
            if (grid[i][0].equals(grid[i][1]) && grid[i][1].equals(grid[i][2])) {
                winnings += bet * 2;
            }
        }

        return winnings;
    }
}
  
//-------FileHandler.java-------------------------------------------  
class FileHandler {

    public Player loadPlayerData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String name = br.readLine();
            int balance = Integer.parseInt(br.readLine());
            return new Player(name, balance);
        } catch (IOException e) {
            System.out.println("No save file found. Creating new player.");
            return new Player("Default", 100);
        }
    }

    public void savePlayerData(Player player, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println(player.getName());
            pw.println(player.getBalance());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendGameHistory(String entry, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
            pw.println(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    
   
