/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURIsTA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          MARCH 30, 2026
PROJECT:       MODULE 9 - LAB 1: EFFICIENCY
NOTES:         PROGRAM CREATED TO GET FAMILIAR WITH SORTING AND EFFICIENCY

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
=====================================================================================================
Initially I was planning on using Insertion sort as the method of testing. When I initially used it
my average sorting time was approximately 18 ms. This was in large part due to the first few sorting
reaching 200ms before dropping to an average of 15ms. After I did this, I decided to implement
Array.sort() to see how much faster it would be in comparison. it ended up being approximately 1.5ms
I was going to leave it at with insertion sort however after the class lecture covering shell sort,
I realiezed that insertion sort was severely lacking. I decided to switch up the sorting method
to implement shell sort instead. This provided me with an average sorting time of 3 ms. Shell sort
greatly reduced the sorting time. It is still 2x slower than the Array.sort() method.

INSERT SORT AVERAGE SORT TIME: 18 MS
SHELL SORT AVERAGE SORT TIME: 3.1 MS
ARRAY.SORT() AVERAGE SORT TIME: 1.5 MS

=====================================================================================================
*/

import java.util.Arrays;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        // Define variables needed
        final int TOTAL_TIMES = 50; // Number of times program will run through sorting.
        final int ARRAY_LENGTH = 50000; // Total number of random numbers
        int[] randomNumbers = new int[ARRAY_LENGTH]; // Array used to store random numbers to be generated.
        long[] sortingTimes = new long[TOTAL_TIMES]; // Array used to the sorting times of each attempt
        float averageTime = 0; // Average sorting time of all attempts
        long startTime;
        long endTime;

        // Program Banner
        programBanner();

        // Sort using custom sort method (Shell Sort)
        // Sorting method obtained from Recursion & Sorting Presentation used for lecture by Mr. An
        for (int i = 0; i < TOTAL_TIMES; i++)
        {
            // Generate random numbers
            generateRandomNumbers(randomNumbers);

            // Method to calculate sorting time obtained from: https://www.geeksforgeeks.org/java/measure-time-taken-function-java/
            // Start measuring execution time.
            startTime = System.nanoTime();

            // Sort the array list.
            shellSort(randomNumbers);

            // Stop measuring execution time.
            endTime = System.nanoTime();

            // Calculate execution time in milliseconds
            sortingTimes[i] = (endTime - startTime) / 1000000;
        }

        // Calculate average sorting time.
        for (int i = 0; i < TOTAL_TIMES; i++)
        {
            // Display sort time for each attempt.
            //System.out.println("Sorting Time " + (i+1) + ": " + sortingTimes[i] + "ms");

            averageTime += sortingTimes[i];
        }
        averageTime /= TOTAL_TIMES;

        // Display average sorting time.
        System.out.println("[SHELL SORTING METHOD] Average Sorting Time: " + averageTime + "ms");

        // Sort using Array.sort()
        for (int i = 0; i < TOTAL_TIMES; i++)
        {
            // Generate random numbers
            generateRandomNumbers(randomNumbers);

            // Method to calculate sorting time obtained from: https://www.geeksforgeeks.org/java/measure-time-taken-function-java/
            // Start measuring execution time.
            startTime = System.nanoTime();

            // Sort the array list.
            Arrays.sort(randomNumbers);

            // Stop measuring execution time.
            endTime = System.nanoTime();

            // Calculate execution time in milliseconds
            sortingTimes[i] = (endTime - startTime) / 1000000;
        }

        // Calculate average sorting time.
        for (int i = 0; i < TOTAL_TIMES; i++)
        {
            // Display sort time for each attempt.
            // System.out.println("Sorting Time " + (i+1) + ": " + sortingTimes[i] + "ms");

            averageTime += sortingTimes[i];
        }
        averageTime /= TOTAL_TIMES;

        // Display average sorting time.
        System.out.println("\n[ARRAY.SORT() METHOD] Average Sorting Time: " + averageTime + "ms");
        System.out.println("-----------------------------------------------------------------------------------------------------");

    }

    // Method used to display program banner;
    public static void programBanner()
    {
        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                                    MODULE 9 - LAB 1:  EFFICIENCY                                    ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program was created to to get familiar with sorting efficiency. The program creates an array of ");
        System.out.println("random integers (50,000 items) and sorts them in order. It compiles the average sorting time of 50   ");
        System.out.println("attempts using a custom sorting method (Shell Sort) created by the for this program. Afterward it    ");
        System.out.println("repeats the process using Array.sort() included in the java.util Library.");
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    // Method to generate random numbers
    public static void generateRandomNumbers(int[] list)
    {
        // variables needed.
        Random random = new Random();
        int number;

        // Generate required integer values needed for list to be full.
        for (int i = 0; i < list.length; i++)
        {
            number = random.nextInt();
            list[i] = number;
        }
    }

    // Method used to sort numbers
    // Method was obtained from Recursion & Sorting Presentation used for lecture by Mr. An
    public static void shellSort(int[] list)
    {
        int n = list.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = list[i];
                int j;
                for (j = i; j >= gap && list[j - gap] > temp; j -= gap) {
                    list[j] = list[j - gap];
                }
                list[j] = temp;
            }
        }
    }

    // Method used to sort numbers
    // Method was obtained from Recursion & Sorting Presentation used for lecture by Mr. An
    public static void slSort(int[] list)
    {
        int n = list.length;
        for (int i = 1; i < n; i++) {
            int key = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }
}
