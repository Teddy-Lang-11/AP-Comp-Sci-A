/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskdriver;

/**
 *
 * @author theod
 */
public class Task implements Priority, Complexity, Comparable<Task> { //Research big time!
    
    //Declare Private
        private final String name;
        private int priority;
        private int complexity;
        
    //Create a Constructor for Prints
        public Task(String name, int priority, int complexity){
            this.name = name;
            this.priority = priority;
            this.complexity = complexity;         
        }
        
        //Create a getters/setters to attain from private declaration
            //Priority
                //Setter
        @Override
                    public void setPriority(int priority){
                        this.priority = priority;
                    }

                //Getter
        @Override
                    public int getPriority(){
                        return priority;
                    }
            
            //Complexity
                //Setter
        @Override
                    public void setComplexity(int complexity){
                        this.complexity = complexity;
                    }
                
                //Getter
        @Override
                    public int getComplexity(){
                        return complexity;
                    }
                    
            //Don't need one for the same since its a string
                 
            //Now create the method to compare the tasks (Major Research)
        @Override
                    public int compareTo(Task other){
                        //Compare off of Priority
                            if (this.priority != other.priority){
                                return other.priority - this.priority; //results in the highest priority task being first
                            }
                        //Same Priority? Compare off of Complexity
                            return other.complexity - this.complexity; //results in the highest complexity first  
                    }
                    
            //Printing Set up String

    /**
     *
     * @return
     */
        @Override
                public String toString(){
                    return name + " ~ Priority: " + priority + " ~ Complexity: " + complexity;
                }
}

 
