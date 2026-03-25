/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package readwritefile;

/**
 *
 * @author TLang2026
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

    public class ReadWriteFile {
        public static void main(String[] args) {
            String filePath = "example.txt";
            String outPath = "TextFiles/otherText.txt";
            String contentToWrite = "Hello, this is a sample text to write in the file.";
        
        // Write to file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(contentToWrite);
                System.out.println("Successfully wrote to the file.");
                } 

                catch (IOException e) {
                    System.err.println("An error occurred while writing to the file: " + e.getMessage());
                }
        
        // Read from file
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
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
