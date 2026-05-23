/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURITA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          JANUARY 29, 2026
PROJECT:       MODULE 2 - LAB 1: ARRAY LIST
NOTES:         PROGRAM CREATED TO BECOME FAMILIAR WITH ARRAY LISTS AS A DATA STRUCTURE AND PRACTICE
               WORKING WITH ARRAYS AND IMPLEMENTING KEY METHODS THAT ARE COMMON IN LIST STRUCTURES.

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
=====================================================================================================
*/

public class Main
{
    public static void main(String[] args)
    {
        DTCCArrayList list = new DTCCArrayList(5);

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Element at index 1: " +  list.get(2)); // Output should be 20.
        System.out.println("List: " + list.toString()); // Output should be: [10, 20, 30]

        list.add(40);
        list.add(50);

        System.out.println("List after adding more elements: " + list.toString()); // Output should be: [10, 20, 30, 40, 50]
    }
}
