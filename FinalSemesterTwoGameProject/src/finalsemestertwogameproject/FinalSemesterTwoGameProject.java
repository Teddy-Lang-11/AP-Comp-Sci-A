package finalsemestertwogameproject;

import java.util.Scanner;
import javax.sound.sampled.Clip;

/**
 * FinalSemesterTwoGameProject - the main class that runs the slot machine game.
 *
 * Game Flow:
 *   1. Load player data (Insert Credits / Load Balance)
 *   2. Set bet amount
 *   3. Pull Lever / Spin  --> plays spin_wheel.wav
 *   4. Determine Result
 *        Win  --> plays win_applause.wav
 *        Lose --> plays lose_whah_whah.wav
 *   5. View Game History (optional)
 *   6. Exit Game (saves data)
 *
 * Text files used:
 *   userdata.txt      - player name + balance
 *   game_history.txt  - log of all rounds
 *   settings.txt      - stores the current bet multiplier setting
 *
 * Sound files (place in src/finalsemestertwogameproject/sounds/):
 *   spin_wheel.wav
 *   win_applause.wav
 *   lose_whah_whah.wav
 */
public class FinalSemesterTwoGameProject {

    static final String USER_DATA_FILE = "userdata.txt";
    static final String HISTORY_FILE   = "game_history.txt";
    static final String SETTINGS_FILE  = "settings.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Print instructions (required by rubric)
        printInstructions();

        // STEP 1: Insert Credits / Load Balance
        Player player = FileHandler.loadPlayerData(USER_DATA_FILE);

        if (player == null) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine().trim();
            player = new Player(name, 100);
            System.out.println("Welcome, " + name + "! You start with 100 credits.");
            FileHandler.clearGameHistory(HISTORY_FILE);
        } else {
            System.out.println("Welcome back, " + player.getName() + "!");
            System.out.println("Balance loaded from file: " + player.getBalance() + " credits.");
        }

        // Load bet multiplier from settings.txt (3rd text file)
        int betMultiplier = loadBetMultiplier(scanner);

        // Create the slot machine object
        SlotMachiene machine = new SlotMachiene();
        int roundNumber = 1;

        // MAIN GAME LOOP
        boolean playing = true;

        while (playing) {

            System.out.println("\n==========================================");
            System.out.println("  " + player.getName() + " | Balance: " + player.getBalance() + " credits");
            System.out.println("  Bet Multiplier: x" + betMultiplier);
            System.out.println("==========================================");
            System.out.println("What would you like to do?");
            System.out.println("  1 - Spin (Pull Lever)");
            System.out.println("  2 - View Game History");
            System.out.println("  3 - Change Bet Multiplier");
            System.out.println("  4 - Exit Game");
            System.out.print("Choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    // STEP 2: Set Bet Amount
                    int bet = getBet(scanner, player.getBalance());

                    // Apply the multiplier from settings.txt
                    int actualBet = bet * betMultiplier;
                    if (actualBet > player.getBalance()) {
                        System.out.println("Not enough credits for that bet with multiplier x"
                                + betMultiplier + ". Try a smaller bet.");
                        break;
                    }

                    System.out.println("\nSpinning... (Bet: " + actualBet + " credits)");

                    // -----------------------------------------------
                    // STEP 3: Pull Lever / Spin
                    // Start spin sound in background, spin the reels,
                    // then stop the sound once the result is ready.
                    // -----------------------------------------------
                    Clip spinClip = Soundplayer.playAsync("spin_wheel.wav");
                    playSpinAnimation();          // short visual delay while sound plays
                    String[][] grid = machine.spin();
                    Soundplayer.stopClip(spinClip); // stop spin sound before result shows

                    SlotMachiene.printGrid(grid);

                    // STEP 4: Determine Result
                    int winnings = machine.calculateWinnings(grid, actualBet);

                    if (winnings > 0) {
                        // -----------------------------------------------
                        // Process Winning - play applause
                        // -----------------------------------------------
                        System.out.println(">>> YOU WIN! +" + winnings + " credits!");
                        Soundplayer.play("win_applause.wav");  // plays fully before continuing
                        player.setBalance(player.getBalance() + winnings);

                    } else {
                        // -----------------------------------------------
                        // Process Losing - play wah wah
                        // -----------------------------------------------
                        System.out.println(">>> No match. You lost " + actualBet + " credits.");
                        Soundplayer.play("lose_whah_whah.wav"); // plays fully before continuing
                        player.setBalance(player.getBalance() - actualBet);

                        // Check for Game Over
                        if (player.getBalance() <= 0) {
                            System.out.println("\n*** GAME OVER! You're out of credits! ***");
                            FileHandler.appendGameHistory("Round " + roundNumber
                                    + " | Bet: " + actualBet
                                    + " | Won: 0 | Balance: 0 | GAME OVER", HISTORY_FILE);
                            FileHandler.savePlayerData(player, USER_DATA_FILE);
                            playing = false;
                            break;
                        }
                    }

                    // Log round to game_history.txt
                    FileHandler.appendGameHistory("Round " + roundNumber
                            + " | Bet: " + actualBet
                            + " | Won: " + winnings
                            + " | Balance: " + player.getBalance(), HISTORY_FILE);

                    // Auto-save after every round
                    FileHandler.savePlayerData(player, USER_DATA_FILE);
                    roundNumber++;
                    break;

                case "2":
                    // STEP 5: View Game History
                    FileHandler.printGameHistory(HISTORY_FILE);
                    break;

                case "3":
                    // Change multiplier and save to settings.txt
                    betMultiplier = changeBetMultiplier(scanner);
                    saveBetMultiplier(betMultiplier);
                    System.out.println("Bet multiplier set to x" + betMultiplier + " (saved to settings.txt).");
                    break;

                case "4":
                    // STEP 6: Exit Game
                    playing = false;
                    break;

                default:
                    System.out.println("Invalid choice. Enter 1, 2, 3, or 4.");
            }
        }

        FileHandler.savePlayerData(player, USER_DATA_FILE);
        System.out.println("\nGoodbye, " + player.getName() + "! Final balance: "
                + player.getBalance() + " credits. Progress saved.");
        scanner.close();
    }

    // -------------------------------------------------------
    // HELPER METHODS
    // -------------------------------------------------------

    private static void printInstructions() {
        System.out.println("============================================");
        System.out.println("        WELCOME TO JAVA SLOT MACHINE        ");
        System.out.println("============================================");
        System.out.println("HOW TO PLAY:");
        System.out.println("  - You start with 100 credits.");
        System.out.println("  - Each spin, choose a bet amount.");
        System.out.println("  - A 3x3 grid of symbols is revealed.");
        System.out.println("  - Matches pay out as follows:");
        System.out.println("      Row match:      x3 your bet");
        System.out.println("      Column match:   x2 your bet");
        System.out.println("      Diagonal match: x4 your bet");
        System.out.println("      JACKPOT (all 9): x20 your bet!");
        System.out.println("  - If no match, you lose your bet.");
        System.out.println("  - The game ends when you run out of credits.");
        System.out.println("  - Your balance is saved automatically.");
        System.out.println("  - Adjust the bet multiplier in settings.");
        System.out.println("SETUP:");
        System.out.println("  No setup required - just run the program!");
        System.out.println("  Save files: userdata.txt, game_history.txt, settings.txt");
        System.out.println("============================================\n");
    }

    private static int getBet(Scanner scanner, int balance) {
        int bet = 0;
        while (bet < 1 || bet > balance) {
            System.out.print("Enter your bet (1 - " + balance + "): ");
            try {
                bet = Integer.parseInt(scanner.nextLine().trim());
                if (bet < 1 || bet > balance) {
                    System.out.println("Invalid bet. Must be between 1 and " + balance + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
        return bet;
    }

    /**
     * Shows a rolling animation in the console while the spin sound plays.
     * Lasts about 2 seconds so the spin sound has time to play.
     */
    private static void playSpinAnimation() {
        String[] frames = {
            "[ ? | ? | ? ]",
            "[ ~ | ~ | ~ ]",
            "[ * | * | * ]",
            "[ ? | ? | ? ]",
            "[ ~ | ~ | ~ ]",
            "[ * | * | * ]",
            "[ ? | ? | ? ]",
            "[ ~ | ~ | ~ ]"
        };
        for (String frame : frames) {
            System.out.print("\r  " + frame + "  ");
            try {
                Thread.sleep(250); // 8 frames x 250ms = 2 seconds total
            } catch (InterruptedException e) {
                // no action needed
            }
        }
        System.out.println(); // move to next line after animation
    }

    private static int loadBetMultiplier(Scanner scanner) {
        java.io.File file = new java.io.File(SETTINGS_FILE);
        if (file.exists()) {
            try {
                java.util.Scanner fileScanner = new java.util.Scanner(file);
                if (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine().trim();
                    String[] parts = line.split("=");
                    if (parts.length == 2 && parts[0].equals("multiplier")) {
                        int m = Integer.parseInt(parts[1]);
                        fileScanner.close();
                        System.out.println("Bet multiplier loaded from settings.txt: x" + m);
                        return m;
                    }
                }
                fileScanner.close();
            } catch (Exception e) {
                // Fall through to ask user
            }
        }
        int multiplier = changeBetMultiplier(scanner);
        saveBetMultiplier(multiplier);
        return multiplier;
    }

    private static int changeBetMultiplier(Scanner scanner) {
        System.out.println("Choose a bet multiplier:");
        System.out.println("  1 - Normal  (x1)");
        System.out.println("  2 - Double  (x2)");
        System.out.println("  3 - Triple  (x3)");
        System.out.print("Choice: ");
        int choice = 1;
        try {
            choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice < 1 || choice > 3) choice = 1;
        } catch (NumberFormatException e) {
            choice = 1;
        }
        return choice;
    }

    private static void saveBetMultiplier(int multiplier) {
        try {
            java.io.PrintWriter writer = new java.io.PrintWriter(
                    new java.io.FileWriter(SETTINGS_FILE, false));
            writer.println("multiplier=" + multiplier);
            writer.close();
        } catch (java.io.IOException e) {
            System.out.println("[Settings] Could not save settings.");
        }
    }
}