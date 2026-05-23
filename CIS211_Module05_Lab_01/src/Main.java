/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURITA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          FEBRUARY 10, 2026
PROJECT:       MODULE 5 - LAB 1: CIRCULAR ARRAY LIST
NOTES:         PROGRAM CREATED TO BECOME FAMILIAR WITH A CIRCULAR ARRAY LIST

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
=====================================================================================================
*/

public class Main
{
    public static void main(String[] args)
    {
        DTCC_CircularArray list = new DTCC_CircularArray(5);

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println("List: " + list.toString());
        // Output: [10, 20, 30, 40, 50]
        // Array: [10, 20, 30, 40, 50]

        list.remove(2);
        System.out.println("After removing index 2: " + list.toString());
        // Output: [10, 20, 40, 50]
        // Array: [XX, 10, 20, 40, 50]

        list.remove(3);
        System.out.println("After removing index 3: " + list.toString());
        // Output: [10, 20, 40]
        // Array: [XX, 10, 20, 40, XX]

        list.add(60);
        System.out.println("After adding 60: " + list.toString());
        // Output: [10, 20, 40, 60]
        // Array: [XX, 10, 20, 40, 60]

        list.add(76);
        System.out.println("After adding 76: " + list.toString());
        // Output: [10, 20, 40, 60, 76]
        // Array: [76, 10, 20, 40, 60]

        list.remove(2);
        System.out.println("After removing index 2: " + list.toString());
        // Output: [10, 20, 60, 76]
        // Array: [76, XX, 10, 20, 60]

        list.add(60);
        System.out.println("After adding 60: " + list.toString());
        // Output: [10, 20, 60, 76, 60]
        // Array: [76, 60, 10, 20, 60]

        list.remove(4);
        System.out.println("After removing index 4: " + list.toString());
        // Output: [10, 20, 60, 76]
        // Array: [76, XX, 10, 20, 60]

        list.remove(3);
        System.out.println("After removing index 3: " + list.toString());
        // Output: [10, 20, 60]
        // Array: [XX, XX, 10, 20, 60]

        list.remove(0);
        System.out.println("After removing index 0: " + list.toString());
        // Output: [20, 60]
        // Array: [XX, XX, XX, 20, 60]

        list.add(70);
        System.out.println("After adding 70: " + list.toString());
        // Output: [20, 60, 70]
        // Array: [70, XX, XX, 20, 60]

        list.add(44);
        System.out.println("After adding 44: " + list.toString());
        // Output: [20, 60, 70, 44]
        // Array: [70, 44, XX, 20, 60]

        list.add(20);
        System.out.println("After adding 20: " + list.toString());
        // Output: [20, 60, 70, 44, 20]
        // Array: [70, 44, 20, 20, 60]

        list.add(90); // Should throw an IllegalStateException
        System.out.println("After adding 90: " + list.toString());
    }
}
