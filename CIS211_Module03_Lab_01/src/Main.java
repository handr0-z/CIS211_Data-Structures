/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURITA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          FEBRUARY 5, 2026
PROJECT:       MODULE 3 - LAB 1: LINKED LIST
NOTES:         PROGRAM CREATED TO BECOME FAMILIAR WITH LINKED LISTS AS A DATA STRUCTURE.

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
=====================================================================================================
*/

public class Main
{
	public static void main(String[] args)
	{
        DTCCLinkedList list = new DTCCLinkedList();

        list.add(10);
        list.add(20);
        list.add(30);

        // Verify valid index is provided by the user, If not notify user of invalid index.
        try{System.out.println("Element at index 1: " + list.get(1));} // Output: 20
        catch(IndexOutOfBoundsException e){System.out.println(e.getMessage());}

        System.out.println("List: " + list.toString()); // Output: [10, 20, 30]

        list.add(40);
        list.add(50);

        System.out.println("List after adding more elements: " + list.toString()); // Output: [10, 20, 30, 40, 50]
	}
}
