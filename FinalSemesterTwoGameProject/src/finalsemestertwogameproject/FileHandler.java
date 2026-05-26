/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalsemestertwogameproject;

/**
 *
 * @author theod
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * FileHandler class - reads from and writes to .txt files.
 *
 * Files used:
 *   userdata.txt      - stores player name and balance
 *   game_history.txt  - stores a log of each round played
 *   settings.txt      - stores bet multiplier (managed by main class)
 */
public class FileHandler {

    /**
     * Loads player data from userdata.txt.
     * File format (one line): "name,balance"
     * Returns null if file doesn't exist or can't be read.
     */
    public static Player loadPlayerData(String filename) {
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("[FileHandler] No save file found. Starting fresh.");
            return null;
        }

        try {
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int balance = Integer.parseInt(parts[1]);
                    scanner.close();
                    return new Player(name, balance);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("[FileHandler] Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("[FileHandler] Error parsing balance from file.");
        }

        return null;
    }

    /**
     * Saves player data to userdata.txt (overwrites existing content).
     * Writes format: "name,balance"
     */
    public static void savePlayerData(Player player, String filename) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename, false));
            writer.println(player.toFileString());
            writer.close();
            System.out.println("[FileHandler] Progress saved.");
        } catch (IOException e) {
            System.out.println("[FileHandler] Error saving data: " + e.getMessage());
        }
    }

    /**
     * Appends one line to game_history.txt.
     */
    public static void appendGameHistory(String entry, String filename) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename, true));
            writer.println(entry);
            writer.close();
        } catch (IOException e) {
            System.out.println("[FileHandler] Error writing history: " + e.getMessage());
        }
    }

    /**
     * Reads and prints the entire game_history.txt to the console.
     */
    public static void printGameHistory(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("No game history yet.");
            return;
        }

        try {
            Scanner scanner = new Scanner(file);
            System.out.println("===== GAME HISTORY =====");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            System.out.println("========================");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("[FileHandler] Could not read history: " + e.getMessage());
        }
    }

    /**
     * Clears the game history file (used when a new player starts).
     */
    public static void clearGameHistory(String filename) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename, false));
            writer.close();
        } catch (IOException e) {
            System.out.println("[FileHandler] Error clearing history: " + e.getMessage());
        }
    }
}

