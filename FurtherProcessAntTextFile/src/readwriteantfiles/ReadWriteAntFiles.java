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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;


/* DIRECTION:
    Set up an ANT project to add your information - name, email address, graudation year and username to a text file in a folder called "Contacts". 
Place it in the project path as demonstrated. The project should also read the recorded file. Extra point if you set it so that these data 
are read in from user input by the Scanner.
*/

public class ReadWriteAntFiles {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter shortFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.US); // Explicitly setting to US locale for consistent example
        
        //Scanner Code
            Scanner scan = new Scanner(System.in);
                System.out.println("Enter Name, Email, Grad Year, Username: \n");
                    String userInput = scan.nextLine();
                
            // Format the LocalDateTime to a string
            String formattedDateTime = now.format(shortFormatter);
            String filePath = "TextFiles/Contact.txt";
            String outPath = "TextFiles/Contact.txt";
            String contentToWrite = userInput; 
            
            /*"""
                                    Name: Theodore Lang
                                    Email: tlang2026@cchsdons.com
                                    Grad Year: 2026
                                    Username: tlang
                                    """ + formattedDateTime;
            */
            
            
            // Write to file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            
            //writer.write(contentToWrite);
                writer.append(contentToWrite + "\n");
                    System.out.println("Successfully wrote to the file." + formattedDateTime);
                
                } 
                
                catch (IOException e) {
                    System.err.println("An error occurred while writing to the file: " + e.getMessage());
                }
                
                // Read from file
                try (BufferedReader reader = new BufferedReader(new FileReader(outPath))) {
                    String line;
                        System.out.println("\nReading from the file:");
                
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } 
                
                catch (IOException e) {
                    System.err.println("An error occurred while reading from the file: " + e.getMessage());
                }
    }
    
}
