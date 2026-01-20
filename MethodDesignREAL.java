/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.methoddesign;

/**
 *
 * @author TLang2026
 */

/*I supply a very basic “skeleton code” for a Student Class
Often in jobs in IT you will be given the “high level” Class to work on
You need to make it work properly - add features and so on

I want you to alter this base Class as follows:
    [DONE]  Each student object should have 3 courses
        [DONE]  Each course will have a test
    [???] nProvide constructors (overloaded) for student/course objects
    [DONE]  Each test score will be initialized to zero
    Provide methods to  setTestScore and getTestScore for each course
    Provide a method called getAverage that computes this   **Added on / totally new**
    Alter toString to provide the student details
    Modify the driver Class to allow adding students and getting their scores
    Provide a planning doc to show your logic in how you design the classes/relationships
    Provide a simple UML Class Diagram to show the relationships, and where the public/private methods are*/

//public class
public class MethodDesign {
    public static void main(String args[]){
        //Student st1 = new Student("Bob", "Smith");
        //doesn't do anything right now.
    }
}

//------------------------------------------------------------------------------

//basic class Student - should have 3 courses
class Student {
    private String firstName, lastName;
        Course c1 = new Course();
            int t1 = c1.setScore(89);
        Course c2 = new Course();
            int t2 = c1.setScore(76);
        Course c3 = new Course();
            int t3 = c1.setScore(95);
        
    //empty constructor to create empty Student object
        public Student() {
                firstName = "";
                lastName = "";
        }
        
//basic constructor to create Student object with name only
        public Student(String first, String last) {
                firstName = first;
                lastName = last;
        }
    //needs a constructor to include 3 course objects

    //basic toString code
    @Override
        public String toString() {
            String result;
                result = firstName + " " + lastName + "\n";
            return result;
        }
}

//------------------------------------------------------------------------------

//basic class Course
class Course{
    public int score = 0;
        public int setScore(int inScore){
                score = inScore;
            return score;
        }
        public int getScore(){
            return score;
        }
}