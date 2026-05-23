/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURITA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          MARCH 20, 2026
PROJECT:       MODULE 6 - ASSIGNMENT 1: DLL DEQUE
NOTES:         PROGRAM CREATED TO BECOME FAMILIAR WITH A DOUBLY-LINKED LIST

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
=====================================================================================================
*/

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Variables
        boolean match;
        String word;

        // Display program banner
        programBanner();

        while (true) {
            // Prompt user to provide word to check
            System.out.print("Enter word: ");
            Scanner input = new Scanner(System.in);
            word = input.nextLine();
            System.out.println("");

            if (word.equalsIgnoreCase("Exit")) {break;}

            match = checkPalindrome(word);

            if (match == true) {
                System.out.println("Yes! " + word + " is a palindrome.");
            } else {
                System.out.println("No! " + word + " is not a palindrome.");
            }
            System.out.println("-----------------------------------------------------------------------------------------------------");
        }
    }

    // Method used to display program banner;
    public static void programBanner()
    {
        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                                 MODULE 6 - ASSIGNMENT 1:  DLL DEQUE                                 ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program can be used to check if a given word is a palindrome.");
        System.out.println("Note: this palindrome checker is NOT case sensitive and will ignore spaces.");
        System.out.println("to exit the program type EXIT.");
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    // Method used to check if word provided is palindrome.
    public static boolean checkPalindrome(String word)
    {
        // Daclare variables needed.
        int size;
        char front;
        char back;

        // Remove spaces from String
        // Reference for how to remvoe spaces and special characters
        // https://stackoverflow.com/questions/34649239/palindrome-ignoring-spaces-cases-special-characters
        word = word.replaceAll("[^a-zA-Z0-9]", "");

        // Change words to lowercase.
        word = word.toLowerCase();

        size = word.length();

        // Check if 1 letter was provided.
        if (size == 1) {return true;}

        DTCCDoublyLinkedList list = new DTCCDoublyLinkedList();

        // add characters to deque.
        for (int i = 0; i < size; i++){list.addFront(word.charAt(i));}

        // Check if word is palindrome.
        for (int i = 0; i < size / 2; i++)
        {
            front = (char) list.removeFront();
            back = (char) list.removeBack();

            if (front != back) {return false;}
        }

        return true;
    }
}
