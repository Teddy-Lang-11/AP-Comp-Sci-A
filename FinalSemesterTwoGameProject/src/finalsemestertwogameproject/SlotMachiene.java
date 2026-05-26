package finalsemestertwogameproject;

import java.util.Random;

/**
 * SlotMachine class - handles spinning and calculating winnings.
 */
public class SlotMachiene {

    private String[][] symbols; // 3x3 grid

    private static final String[] POSSIBLE_SYMBOLS = {"Cherry", "Lemon", "Orange", "Bell", "Star", "Diamond"};

    public SlotMachiene() {
        symbols = new String[3][3];
    }

    /**
     * Spins the machine - fills the 3x3 grid with random symbols.
     * @return the filled 3x3 grid
     */
    public String[][] spin() {
        Random rand = new Random();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int index = rand.nextInt(POSSIBLE_SYMBOLS.length);
                symbols[row][col] = POSSIBLE_SYMBOLS[index];
            }
        }
        return symbols;
    }

    /**
     * Calculates winnings based on the grid and bet.
     * Scoring:
     *   Row match:      3x bet
     *   Column match:   2x bet
     *   Diagonal match: 4x bet
     *   Jackpot (all 9 same): 20x bet
     *   No match: 0
     */
    public int calculateWinnings(String[][] grid, int bet) {
        int winnings = 0;

        // Check jackpot (all 9 symbols match)
        boolean jackpot = true;
        String first = grid[0][0];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (!grid[row][col].equals(first)) {
                    jackpot = false;
                }
            }
        }
        if (jackpot) {
            return bet * 20;
        }

        // Check rows
        for (int row = 0; row < 3; row++) {
            if (grid[row][0].equals(grid[row][1]) && grid[row][1].equals(grid[row][2])) {
                winnings += bet * 3;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (grid[0][col].equals(grid[1][col]) && grid[1][col].equals(grid[2][col])) {
                winnings += bet * 2;
            }
        }

        // Check diagonals
        if (grid[0][0].equals(grid[1][1]) && grid[1][1].equals(grid[2][2])) {
            winnings += bet * 4;
        }
        if (grid[0][2].equals(grid[1][1]) && grid[1][1].equals(grid[2][0])) {
            winnings += bet * 4;
        }

        return winnings;
    }

    /**
     * Prints the 3x3 grid to the console.
     */
    public static void printGrid(String[][] grid) {
        System.out.println("+----------+----------+----------+");
        for (int row = 0; row < 3; row++) {
            System.out.print("|");
            for (int col = 0; col < 3; col++) {
                // Pad each cell to 10 chars wide so columns line up
                System.out.printf(" %-8s |", grid[row][col]);
            }
            System.out.println();
            System.out.println("+----------+----------+----------+");
        }
    }
}