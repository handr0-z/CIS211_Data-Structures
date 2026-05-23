/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURITA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          JANUARY 29, 2026
PROJECT:       MODULE 2 - ASSIGNMENT 1: ARRAY STACK & TEST PROGRAM
NOTES:         PROGRAM CREATES A STACK ADT AND TESTS TO ENSURE PROPER FUNCTIONALITY.

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE. STARTER
CODE FOR THE INTERFACE WAS PROVIDED THIS ASSIGNMENT BY THE INSTRUCTOR.
=====================================================================================================
*/

// ADJUST PROGRAM TO NOTIFY USER OF EMPTY STACK ASIDE FROM NULL WHEN POP OR PEEK IS CALLED.

import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        // List to store data
        ArrayStack<Integer> stack = new ArrayStack<>();

        // Variables needed
        int menuSelect = 0;
        boolean exit = false;

        // Program Banner.
        programBanner();

        // Add test values to stack
        stack.push(12);
        stack.push(2);
        stack.push(54);
        stack.push(33);
        stack.push(78);
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Check if stack is empty
        do
        {
            // Display Main Menu.
            menuSelect = mainMenu();
            System.out.println("-----------------------------------------------------------------------------------------------------");

            switch (menuSelect)
            {
                case 0:
                    addToStack(stack);
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    break;
                case 1:
                    System.out.println("Popping item from the stack...");
                    if (stack.isEmpty() == true){System.out.println("The stack is empty.");}
                    else {System.out.println("Popped Item: " + stack.pop());}
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("Peeking at the stack...");
                    if (stack.isEmpty() == true){System.out.println("The stack is empty.");}
                    else {System.out.println("Peeked Item: " + stack.peek());}
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("Is the stack empty?");
                    System.out.println("Status: " + stack.isEmpty());
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    break;
                case 4:
                    System.out.println("Current Stack Size: " + stack.length());
                    System.out.println("Current Stack Contents: " + stack.toString());
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    exit = true;
            }
        }
        while (exit != true);
    }

    // Method used to display program banner;
    public static void programBanner()
    {
        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                         MODULE 2 - ASSIGNMENT 1:  ARRAY STACK & TEST PROGRAM                        ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program creates a stack ADT and tests to ensure proper functionality. At start of program the");
        System.out.println("stack is populated with (5) values for testing purposes. These can be removed if needed.");
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    // Method used to display main menu.
    public static int mainMenu()
    {
        int menuOption = 0;

        do {
            System.out.println("What would you like to do?");

            System.out.println("1) Push to Stack");
            System.out.println("2) Pop the Stack");
            System.out.println("3) Peek at Stack");
            System.out.println("4) Verify if Stack is Empty");
            System.out.println("5) Check Stack Size & Length");
            System.out.println("6) Exit Program\n");
            System.out.print("Option Selected: ");

            // Trap to ensure valid input is obtained from user.
            while(true)
            {
                if (input.hasNextInt())
                {
                    menuOption = input.nextInt();
                    break;
                }
                else
                {
                    System.out.println("\nError! Invalid input detected.");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.print("Enter valid option: ");
                    input.next();
                }
            }

            if (menuOption < 1 || menuOption > 6)
            {
                System.out.println("\nError! Invalid input detected.");
                System.out.println("-----------------------------------------------------------------------------------------------------");
            }

        } while (menuOption < 1 || menuOption > 6);

        return menuOption - 1;
    }

    // Method used to obtain value to add to stack.
    public static void addToStack(ArrayStack<Integer> stack)
    {
        int value;

        System.out.print("Please enter the integer value you would like to add to the stack: ");
        value = input.nextInt();
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Error handling when stack is full. Used the following link to understand how to use throws & try/ catch.
        // https://www.google.com/search?q=how+to+properly+use+throws+in+java&sca_esv=c04783e6906b025b&sxsrf=ANbL-n6QNsI6n_zd8bkI47wzD7AV3txo2g%3A1770074450644&ei=UjGBacX8JoOh5NoPkdm94Qo&biw=1466&bih=842&aic=0&ved=0ahUKEwjF7eyW-buSAxWDEFkFHZFsL6wQ4dUDCBE&uact=5&oq=how+to+properly+use+throws+in+java&gs_lp=Egxnd3Mtd2l6LXNlcnAiImhvdyB0byBwcm9wZXJseSB1c2UgdGhyb3dzIGluIGphdmEyCBAhGKABGMMEMggQIRigARjDBEimF1DCBFiSFnABeAGQAQCYAWCgAcACqgEBNLgBA8gBAPgBAZgCBaACxgLCAgoQABiwAxjWBBhHwgIFEAAY7wXCAggQABiABBiiBJgDAIgGAZAGCJIHATWgB4QNsgcBNLgHxQLCBwM0LjHIBwKACAA&sclient=gws-wiz-serp
        try {stack.push(value);}
        catch (IllegalStateException e) {System.out.println(e.getMessage());}
    }
}
