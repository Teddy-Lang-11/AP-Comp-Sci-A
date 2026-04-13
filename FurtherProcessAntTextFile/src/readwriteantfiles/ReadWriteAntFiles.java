/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package readwriteantfiles;

/**
 *
 * @author TLang2026
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;


/* DIRECTION:
    Set up an ANT project to add your information - name, email address, graudation year and username to a text file in a folder called "Contacts". 
Place it in the project path as demonstrated. The project should also read the recorded file. Extra point if you set it so that these data 
are read in from user input by the Scanner.
*/

public class ReadWriteAntFiles {
 public static void main(String[] args) {

        ArrayList<Contact> contacts = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        String filePath = "TextFiles/ContactYay.txt";

        // Load existing contacts
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    contacts.add(new Contact(
                        parts[0].trim(),
                        parts[1].trim(),
                        Integer.parseInt(parts[2].trim()),
                        parts[3].trim()
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("No existing file found.");
        }

        // Main loop
        while (true) {
            System.out.println("""
                
                CONTACT LOG
                a = add contact
                e = sort by email
                y = sort by grad year
                n = sort by name
                q = quit
                """);

            char command = scan.nextLine().toLowerCase().charAt(0);

            if (command == 'q') break;

            if (command == 'a') {
                System.out.print("Enter name: ");
                String name = scan.nextLine();

                System.out.print("Enter email: ");
                String email = scan.nextLine();

                System.out.print("Enter graduation year: ");
                int grad = Integer.parseInt(scan.nextLine());

                System.out.print("Enter username: ");
                String user = scan.nextLine();

                Contact newContact = new Contact(name, email, grad, user);
                contacts.add(newContact);

                // Write to file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                    writer.write(newContact.toString());
                    writer.newLine();
                    System.out.println("Contact saved.");
                } catch (IOException e) {
                    System.out.println("Error writing file.");
                }
            }

            else if (command == 'e') {
                contacts.sort(Comparator.comparing(c -> c.email));
            }
            else if (command == 'y') {
                contacts.sort(Comparator.comparingInt(c -> c.grad));
            }
            else if (command == 'n') {
                contacts.sort(Comparator.comparing(c -> c.name));
            }

            // Display contacts
            System.out.println("\nContacts:");
            for (Contact c : contacts) {
                System.out.println(c);
            }
        }

        scan.close();
    }

    static class Contact {
        String name, email, user;
        int grad;

        public Contact(String name, String email, int grad, String user) {
            this.name = name;
            this.email = email;
            this.grad = grad;
            this.user = user;
        }

        @Override
        public String toString() {
            return name + "," + email + "," + grad + "," + user;
        }
    }
}
