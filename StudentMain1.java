/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmain1;

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

public class StudentMain1 {
    public static void main(String args[]){
        //Set up Scanner
            Scanner scan = new Scanner(System.in);
        //Set up Array
            ArrayList<Student> students = new ArrayList<>();

    //Research suggested this, I think it works very well!
        //Prompt user interactions
        System.out.print("How many students do you want to add? ");
            //User Response is new number of Students
                int numStudents = scan.nextInt();
                    scan.nextLine();

        for (int i = 0; i < numStudents; i++) { //i++ is semi-new to me so I had some help
            System.out.println("Adding student " + (i+1));
            System.out.print("First Name: ");
                String first = scan.nextLine();
            System.out.print("Last Name: ");
                String last = scan.nextLine();

            // For entering course names
                System.out.print("Course 1 name: ");
                    String c1Name = scan.nextLine();
                System.out.print("Course 2 name: ");
                    String c2Name = scan.nextLine();
                System.out.print("Course 3 name: ");
                    String c3Name = scan.nextLine();

            // Create student constructor with courses
                Student student = new Student(first, last, c1Name, c2Name, c3Name);

            // Set test scores
                for (int j = 1; j <= 3; j++) { //same here!
                    System.out.print("Enter score for " + student.getCourseName(j) + ": ");
                    int score = scan.nextInt();
                    student.setTestScore(j, score);
                }
                    scan.nextLine(); // consume newline
                         students.add(student);
        }

        // Print out all students **AT END**
            System.out.println("--- Student Records ---");
                for (Student s : students) {
                    System.out.println(s);
                    System.out.println("-----------------------");
                }
            //close off the scanner before program ends
                scan.close();
    }
}

//---New-Class------------------------------------------------------------------
class Student {
    //Declare variables
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

    // Filled in constructor with name only
        public Student(String first, String last) {
            this.firstName = first;
            this.lastName = last;
            this.course1 = new Course();
            this.course2 = new Course();
            this.course3 = new Course();
        }

    // Bigger constructor with courses
        public Student(String first, String last, String c1Name, String c2Name, String c3Name) {
            this.firstName = first;
            this.lastName = last;
            this.course1 = new Course(c1Name);
            this.course2 = new Course(c2Name);
            this.course3 = new Course(c3Name);
        }

    // Set score for a specific courses (1-3)
        //Mini constructor again!!!
            public void setTestScore(int courseNumber, int score) {
                switch(courseNumber) { //researched switch
                    case 1 -> course1.setScore(score);
                    case 2 -> course2.setScore(score);
                    case 3 -> course3.setScore(score);
                    //incase of wrong reply (Set as the defualt response)
                        default -> System.out.println("Invalid course number");
                }
            }

    // Get score for a specific course (1-3)
        public int getTestScore(int courseNumber) {
            return switch(courseNumber) { //researched return switch
                case 1 -> course1.getScore();
                case 2 -> course2.getScore();
                case 3 -> course3.getScore();
                default -> -1;
            };
        }

    // Get the course names
        public String getCourseName(int courseNumber) {
            return switch(courseNumber) {
                case 1 -> course1.getName();
                case 2 -> course2.getName();
                case 3 -> course3.getName();
                default -> "Unknown";
            };
        }

    // Compute the average with math
        public double getAverage() {
            return (course1.getScore() + course2.getScore() + course3.getScore()) / 3.0;
        }

    // toString
        @Override
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
    //Secret declarations
        private String name;
        private int score;

    // Empty constructor
        public Course() {
            this.name = "Unknown";
            this.score = 0;
        }

    // Constructor with the course name
        public Course(String name) {
            this.name = name;
            this.score = 0;
        }

    //Score Getter + Setter
        // Setter score
            public void setScore(int score) {
                this.score = score;
            }

        // Getter score
            public int getScore() {
                return score;
            }

    // Get course name
        public String getName() {
            return name;
        }

    //String for printing
        @Override
        public String toString() {
            return name + " Test Score: " + score;
        }
}