/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmain;

/**
 *
 * @author theod
 */

/*Directions:
I supply a very basic “skeleton code” for a Student Class
Often in jobs in IT you will be given the “high level” Class to work on
You need to make it work properly - add features and so on
I want you to alter this base Class as follows:
Each student object should have 3 courses
Each course will have a test
Provide constructors (overloaded) for student/course objects
Each test score will be initialized to zero
Provide methods to  setTestScore and getTestScore for each course
Provide a method called getAverage that computes this
Alter toString to provide the student details
Modify the driver Class to allow adding students and getting their scores
Provide a planning doc to show your logic in how you design the classes/relationships
Provide a simple UML Class Diagram to show the relationships, and where the public/private methods are
*/

//Declare Imports
    import java.util.Scanner;
    import java.util.ArrayList;

public class StudentMain {
    public static void main(String args[]){
        //Set up Scanner
            Scanner scan = new Scanner(System.in);
        //Set up Array
            ArrayList<Student> students = new ArrayList<>();

        //Prompt user interactions
        System.out.print("How many students do you want to add? ");
            //User Response is new number of Students
                int numStudents = scan.nextInt();
                    scan.nextLine();

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Adding student " + (i+1));
            System.out.print("First Name: ");
            String first = scan.nextLine();
            System.out.print("Last Name: ");
            String last = scan.nextLine();

            // Enter course names
            System.out.print("Course 1 name: ");
            String c1Name = scan.nextLine();
            System.out.print("Course 2 name: ");
            String c2Name = scan.nextLine();
            System.out.print("Course 3 name: ");
            String c3Name = scan.nextLine();

            // Create student with courses
            Student st = new Student(first, last, c1Name, c2Name, c3Name);

            // Set test scores
            for (int j = 1; j <= 3; j++) {
                System.out.print("Enter score for " + st.getCourseName(j) + ": ");
                int score = scan.nextInt();
                st.setTestScore(j, score);
            }
            scan.nextLine(); // consume newline
            students.add(st);
        }

        // Print all students
        System.out.println("--- Student Records ---");
        for (Student s : students) {
            System.out.println(s);
            System.out.println("-----------------------");
        }
        scan.close();
    }
}

//---New-Class------------------------------------------------------------------
class Student {
    private String firstName, lastName;
    private Course course1, course2, course3;

    // Empty constructor
    public Student() {
        this.firstName = "";
        this.lastName = "";
        this.course1 = new Course();
        this.course2 = new Course();
        this.course3 = new Course();
    }

    // Constructor with name only
    public Student(String first, String last) {
        this.firstName = first;
        this.lastName = last;
        this.course1 = new Course();
        this.course2 = new Course();
        this.course3 = new Course();
    }

    // Constructor with courses
    public Student(String first, String last, String c1Name, String c2Name, String c3Name) {
        this.firstName = first;
        this.lastName = last;
        this.course1 = new Course(c1Name);
        this.course2 = new Course(c2Name);
        this.course3 = new Course(c3Name);
    }

    // Set score for a specific course (1-3)
    public void setTestScore(int courseNumber, int score) {
        switch(courseNumber) {
            case 1 -> course1.setScore(score);
            case 2 -> course2.setScore(score);
            case 3 -> course3.setScore(score);
            default -> System.out.println("Invalid course number");
        }
    }

    // Get score for a specific course (1-3)
    public int getTestScore(int courseNumber) {
        return switch(courseNumber) {
            case 1 -> course1.getScore();
            case 2 -> course2.getScore();
            case 3 -> course3.getScore();
            default -> -1;
        };
    }

    // Get course name
    public String getCourseName(int courseNumber) {
        return switch(courseNumber) {
            case 1 -> course1.getName();
            case 2 -> course2.getName();
            case 3 -> course3.getName();
            default -> "Unknown";
        };
    }

    // Compute average
    public double getAverage() {
        return (course1.getScore() + course2.getScore() + course3.getScore()) / 3.0;
    }

    // toString
    public String toString() {
        return firstName + " " + lastName + "\n" +
               course1 + "\n" + 
               course2 + "\n" + 
               course3 + "\n" +
               "Average Score: " + getAverage();
    }
}

//---New-Class------------------------------------------------------------------
class Course {
    private String name;
    private int score;

    // Empty constructor
    public Course() {
        this.name = "Unknown";
        this.score = 0;
    }

    // Constructor with course name
    public Course(String name) {
        this.name = name;
        this.score = 0;
    }

    // Set score
    public void setScore(int score) {
        this.score = score;
    }

    // Get score
    public int getScore() {
        return score;
    }

    // Get course name
    public String getName() {
        return name;
    }

    public String toString() {
        return name + " Test Score: " + score;
    }
}
