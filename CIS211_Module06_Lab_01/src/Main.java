/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURITA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          MARCH 18, 2026
PROJECT:       MODULE 6 - LAB 1: DOUBLY LINKED LIST
NOTES:         PROGRAM CREATED TO BECOME FAMILIAR WITH A DOUBLY-LINKED LIST

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
=====================================================================================================
*/

public class Main
{
    public static void  main(String[] args)
    {
        DTCC_DoublyLInkedList list = new DTCC_DoublyLInkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("List: " + list.toString()); // Output: [10, 20, 30, 40, 50]

        System.out.println("Element at index 1: " + list.get(1)); // Output: 20

        list.remove(2);
        System.out.println("List after removing element at index 2: " + list.toString()); // Output: [10, 20, 40, 50]

        list.remove(0);
        System.out.println("List after removing element at index 0: " + list.toString()); // Output: [20, 40, 50]

        list.remove(2);
        System.out.println("List after removing element at index 2: " + list.toString()); // Output: [20, 40]
    }
}
