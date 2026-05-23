/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURITA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          APRIL 7, 2026
PROJECT:       MODULE 10 - LAB 1: BINARY SEARCH TREE
NOTES:         PROGRAM CREATED TO BECOME FAMILIAR WITH TREES AS A DATA STRUCTURE.

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
=====================================================================================================
*/

public class Main
{
    public static void main(String[] args)
    {
        DTCC_BinarySearchTree bst = new DTCC_BinarySearchTree();
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        System.out.println(bst.get(3));    // Output: true
        System.out.println(bst.get(8));    // Output: false
        System.out.println(bst.toString()); // Output: "2, 3, 4, 5, 7"
    }
}
