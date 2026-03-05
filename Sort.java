/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sort;

/**
 *
 * @author TLang2026
 */
public class Sort {
 public static void main(String[] args)
    {
        Contact[] friends = new Contact[9];
        friends[0] = new Contact("John", "Smith", "610-555-7384");
        friends[1] = new Contact("Sarah", "Barnes", "215-555-3827");
        friends[2] = new Contact("Aaron", "Riley", "733-555-2969");
        friends[3] = new Contact("Laura", "Ramone", "663-555-3984");
        friends[4] = new Contact("Larry", "Smith", "464-555-3489");
        friends[5] = new Contact("Frank", "Phelps", "322-555-2284");
        friends[6] = new Contact("Mario", "Guzman", "804-555-9066");
        friends[7] = new Contact("Marsha", "Grant", "464-555-3489");
        friends[8] = new Contact("Joey", "Ramone", "464-555-3489");
        //calling the sort on the array, which implements Comparable
        
        Sorting.selectionSort(friends);
        System.out.println("*** Selection Sort ***");
        for (Contact friend : friends)
            System.out.println(friend);
        
        Sorting.insertionSort(friends);
        System.out.println("*** Insertion Sort ***");
        for (Contact friend : friends)
            System.out.println(friend);
        
    }
}
//-----------New-Class----------------------------------------------------------
class Sorting{
//SELECTION SORT
    public static void selectionSort(Comparable[] list){
        int n = list.length;

        for (int i = 0; i < n - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < n; j++)
            {
                if (list[j].compareTo(list[minIndex]) < 0)
                {
                    minIndex = j;
                }
            }

            Comparable temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
    }

//INSERTION SORT
  public static void insertionSort(Comparable[] list){
    for (int index = 1; index < list.length; index++){
        Comparable key = list[index];
        int position = index;

        while (position > 0 && key.compareTo(list[position - 1]) < 0)
        {
            list[position] = list[position - 1];
            position--;
        }

        list[position] = key;
    }
    }
}
//-----------New-Class----------------------------------------------------------
class Contact implements Comparable
{
    private String firstName, lastName, phone;
    //-----------------------------------------------------------------
    // Constructor: Sets up this contact with the specified data.
    //-----------------------------------------------------------------
    public Contact(String first, String last, String telephone){
        firstName = first;
        lastName = last;
        phone = telephone;
    }
    
    //-----------------------------------------------------------------
    // Returns a description of this contact as a string.
    //-----------------------------------------------------------------
    public String toString(){
        return lastName + ", " + firstName + "\t" + phone;
    }
    
    //-----------------------------------------------------------------
    // Returns a description of this contact as a string.
    //-----------------------------------------------------------------
    public boolean equals(Object other){
        return (lastName.equals(((Contact)other).getLastName()) &&
        firstName.equals(((Contact)other).getFirstName()));
    }
    
    //-----------------------------------------------------------------
    // Phone number getter.
    //-----------------------------------------------------------------
    public String getPhone(){
        return phone;
    }
    
    //-----------------------------------------------------------------
    // Uses both last and first names to determine ordering.
    //-----------------------------------------------------------------
    public int compareTo(Object other){
        String otherPhone = ((Contact)other).getPhone();
            return phone.compareTo(otherPhone);
        }
    
    //-----------------------------------------------------------------
    // First name accessor.
    //-----------------------------------------------------------------
    public String getFirstName(){
        return firstName;
    }
    
    //-----------------------------------------------------------------
    // Last name accessor.
    //-----------------------------------------------------------------
    public String getLastName(){
        return lastName;
    }
}