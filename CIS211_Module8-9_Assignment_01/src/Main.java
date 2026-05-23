/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURIsTA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          APRIL 26TH, 2026
PROJECT:       MODULE 11 - ASSIGNMENT 1: RECURSION, ITERATION, AND ALGORITHMIC PERFORMANCE
NOTES:         PROGRAM CREATED TO DEMONSTRATE AN UNDERSTANDING OF PERFORMANCE OF IMPLEMENTATIONS.

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
STARTER CODE WAS PROVIDED BY THE TEACHER FOR THIS ASSIGNMENT.
=====================================================================================================
*/

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        // Define variables needed
        final int TOTAL_FACTORIAL_ELEMENTS = 21;
        final int TOTAL_FIBONACCI_ELEMENTS = 7;
        final int TOTAL_TRIALS = 5;
        int[] ARRAY_LENGTH = {1000,2000, 4000, 8000}; // Total number of random numbers to be generated

        // Test Factorial
        testFactorial(TOTAL_FACTORIAL_ELEMENTS, TOTAL_TRIALS);

        // test Fibonacci
        testFibonacci(TOTAL_FIBONACCI_ELEMENTS, TOTAL_TRIALS);

        // Test Sorting
        testMerge(ARRAY_LENGTH, TOTAL_TRIALS);
    }

    // Method used to test factorial.
    public static void testFactorial(int numberOfElements, int numberOfTrials)
    {
        // Variables needed
        long startTime;
        long endTime;
        long factorialRecursiveTimes[] = new long[numberOfElements];
        long factorialIterativeTimes[] = new long[numberOfElements];
        long factorialRecursiveResults[] = new long[numberOfElements];
        long factorialIterativeResults[] = new long[numberOfElements];
        int[] nValues = new int[numberOfElements];

        for (int i = 0; i < numberOfElements; i++)
        {
            int n = i;
            nValues[i] = n; // save nth value into an array

            long recursiveTimes[] = new long[numberOfTrials];
            long iterativeTimes[] = new long[numberOfTrials];

            // Run 5 trials
            for (int j = 0; j < numberOfTrials; j++)
            {
                // Recursive
                startTime = System.nanoTime();
                long recursiveResult = AlgorithmLibrary.factorial(n);
                endTime = System.nanoTime();
                recursiveTimes[j] = endTime - startTime;

                // Iterative
                startTime = System.nanoTime();
                long iterativeResult = AlgorithmLibrary.nFactorial(n);
                endTime = System.nanoTime();
                iterativeTimes[j] = endTime - startTime;

                if (j == 0)
                {
                    factorialRecursiveResults[i] = recursiveResult;
                    factorialIterativeResults[i] = iterativeResult;
                }
            }

            // Compute averages
            long recursiveAvg = 0;
            long iterativeAvg = 0;

            for (int j = 0; j < numberOfTrials; j++)
            {
                recursiveAvg += recursiveTimes[j];
                iterativeAvg += iterativeTimes[j];
            }

            recursiveAvg /= recursiveTimes.length;
            iterativeAvg /= iterativeTimes.length;

            factorialRecursiveTimes[i] = recursiveAvg;
            factorialIterativeTimes[i] = iterativeAvg;
        }

        exportToCSV("factorial.csv", "n", "Recursive Factorial", "Recursive Results", "Non-Recursive Factorial (Iterative)", "Iterative Results", nValues, factorialRecursiveTimes, factorialRecursiveResults, factorialIterativeTimes, factorialIterativeResults);
    }

    // Method used to test Fibonacci.
    public static void testFibonacci(int numberOfElements, int numberOfTrials)
    {
        // Variables needed
        long startTime;
        long endTime;
        long fibonacciRecursiveTimes[] = new long[numberOfElements];
        long fibonacciIterativeTimes[] = new long[numberOfElements];
        long fibonacciRecursiveResults[] = new long[numberOfElements];
        long fibonacciIterativeResults[] = new long[numberOfElements];
        int[] nValues = new int[numberOfElements];

        for (int i = 0; i < numberOfElements; i++)
        {
            int n = i * 5;
            nValues[i] = n;

            long recursiveTimes[] = new long[numberOfTrials];
            long iterativeTimes[] = new long[numberOfTrials];

            for (int j = 0; j < numberOfTrials; j++)
            {
                // Recursive
                startTime = System.nanoTime();
                long recursiveResult = AlgorithmLibrary.fibonacci(n);
                endTime = System.nanoTime();
                recursiveTimes[j] = endTime - startTime;

                // Iterative
                startTime = System.nanoTime();
                long iterativeResult = AlgorithmLibrary.nFibonacci(n);
                endTime = System.nanoTime();
                iterativeTimes[j] = endTime - startTime;

                if (j == 0)
                {
                    fibonacciRecursiveResults[i] = recursiveResult;
                    fibonacciIterativeResults[i] = iterativeResult;
                }
            }

            long recursiveAvg = 0;
            long iterativeAvg = 0;

            for (int j = 0; j < numberOfTrials; j++)
            {
                recursiveAvg += recursiveTimes[j];
                iterativeAvg += iterativeTimes[j];
            }

            recursiveAvg /= numberOfTrials;
            iterativeAvg /= numberOfTrials;

            fibonacciRecursiveTimes[i] = recursiveAvg;
            fibonacciIterativeTimes[i] = iterativeAvg;

            // Stop if too slow
            if (recursiveAvg > 1000000000)
            {
                System.out.println("Stopping early at n = " + n);
                break;
            }
        }

        exportToCSV("fibonacci.csv", "n", "Recursive Fibonacci", "Recursive Results", "Non-Recursive Fibonacci (Iterative)", "Iterative Results", nValues, fibonacciRecursiveTimes, fibonacciRecursiveResults, fibonacciIterativeTimes, fibonacciIterativeResults);
    }

    // Method used to test Sorting.
    public static void testMerge(int[] arraySize, int numberOfTrials)
    {
        // Variables needed
        long startTime;
        long endTime;
        long mergeSortRecursiveTimes[] = new long[arraySize.length];
        long selectionSortIterativeTimes[] = new long[arraySize.length];

        Random rand = new Random();

        for (int i = 0; i < arraySize.length; i++)
        {
            long totalMergeTime = 0;
            long totalSelectionTime = 0;

            for (int j = 0; j < numberOfTrials; j++)
            {
                // Create base array with random numbers
                int[] baseArray = new int[arraySize[i]];
                // Generate random numbers range is 2x the length of the array for bigger spread in domain.
                for (int k = 0; k < arraySize[i]; k++) {baseArray[k] = rand.nextInt(arraySize[i] * 2);}

                // Copy Array
                int[] mergeSort = baseArray.clone();
                int[] selectionSort = baseArray.clone();

                // Recursive Merge Sort
                startTime = System.nanoTime();
                AlgorithmLibrary.mergeSort(mergeSort);
                endTime = System.nanoTime();
                totalMergeTime += (endTime - startTime);

                // Iterative Selection Sort
                startTime = System.nanoTime();
                AlgorithmLibrary.selectionSort(selectionSort);
                endTime = System.nanoTime();
                totalSelectionTime += (endTime - startTime);
            }

            //Calculate Average
            mergeSortRecursiveTimes[i] = (totalMergeTime / numberOfTrials);
            selectionSortIterativeTimes[i] = (totalSelectionTime / numberOfTrials);
        }

        exportToCSV("sorting.csv", "Array Size (n)", "Recursive Merge Sort", "Non-Recursive Selection Sort (Iterative)", arraySize, mergeSortRecursiveTimes, selectionSortIterativeTimes);
    }

    // Method used to export data to csv file (factorial and fibonacci)
    public static void exportToCSV(String filename, String header1, String header2, String header3, String header4, String header5, int[] inputSizes, long[] times1, long[] results1, long[] times2, long[] results2)
    {
        try (FileWriter writer = new FileWriter(filename))
        {
            // Header
            writer.write(header1 + "," + header2 + "," + header3 + "," + header4 + "," + header5 + "\n");

            // Data
            for (int i = 0; i < inputSizes.length; i++) {writer.write(inputSizes[i] + "," + times1[i] + "," + results1[i] + "," + times2[i] + "," + results2[i] + "\n");}

            System.out.println("CSV file created: " + filename);
        }
        catch (IOException e) {System.out.println("Error writing CSV file.");}
    }

    // Method used to export data to csv file (sorting)
    public static void exportToCSV(String filename, String header1, String header2, String header3, int[] inputSizes, long[] times1, long[] times2)
    {
        try (FileWriter writer = new FileWriter(filename))
        {
            // Header
            writer.write(header1 + "," + header2 + "," + header3 + "\n");

            // Data
            for (int i = 0; i < inputSizes.length; i++) {writer.write(inputSizes[i] + "," + times1[i] + "," + times2[i] + "\n");}

            System.out.println("CSV file created: " + filename);
        }
        catch (IOException e) {System.out.println("Error writing CSV file.");}
    }
}
