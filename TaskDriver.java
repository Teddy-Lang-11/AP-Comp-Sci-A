/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taskdriver;

/**
 *
 * @author theod
 */
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author theod
 */

/*Directions:
In this project you will set up a to-do list of tasks with different complexities
and priorities, and compare these.

Set up an interface called Priority, with methods setPriority and getPriority. 
This intrrface should allow defining a way to establish numeric priority between 
different object instances.

Design a Class called Task and implement it (instantiate objects) in the main 
method, that instantiates one or more of these to-do tasks. Task should implement
Priority.

Have Task also implement the Complexity interface shown earlier (in MiniQuiz). 
Also have task implement the Comparable Interface (it is in the standard Class 
library, no need to import anything). 

The driver class (containing the main method) should rank the tasks in order 
of priority, then complexity.
*/

public class TaskDriver {
    public static void main(String[] args) {
        
        //Implement an Array List
            ArrayList<Task> tasks = new ArrayList<>();
            
            //Add the tasks IN FORMAT
                tasks.add(new Task("Math Homework", 3, 8));
                tasks.add(new Task("English Essay", 2, 4));
                tasks.add(new Task("Study for Test", 3, 9));
                tasks.add(new Task("Clean Room", 1, 2));

        // Rank tasks by priority, then by complexity
            Collections.sort(tasks);

        // Display ranked tasks
            for (Task task : tasks) {
                /*Print!*/ System.out.println(task);
            }   
    }
    
}
