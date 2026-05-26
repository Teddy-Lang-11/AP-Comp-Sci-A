/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalsemestertwogameproject;

/**
 *
 * @author theod
 */
public class Player {
/*
 * Player class - stores the player's name and balance.
 */

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

    /**
     * Returns a formatted string for saving to userdata.txt
     * Format: "name,balance"
     */
    public String toFileString() {
        return name + "," + balance;
    }
}