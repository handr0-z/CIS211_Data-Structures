/**
 * Starter code for:
 * Recursion, Iteration, and Algorithmic Performance
 *
 * DO NOT MODIFY the algorithmic logic in this file.
 * You may call these methods from your own driver and timing code.
 */
public class AlgorithmLibrary
{

    /* =========================
       FACTORIAL
       ========================= */

    // Recursive factorial
    public static long factorial(int n)
    {
        if (n == 0) {return 1;}
        return n * factorial(n - 1);
    }

    // Non-recursive (iterative) factorial
    public static long nFactorial(int n)
    {
        long result = 1;
        for (int i = 1; i <= n; i++) {result *= i;}
        return result;
    }

    /* =========================
       FIBONACCI
       ========================= */

    // Recursive Fibonacci (naive, no memoization)
    public static int fibonacci(int n)
    {
        if (n <= 1) {return n;}
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Non-recursive (iterative) Fibonacci
    public static int nFibonacci(int n)
    {
        if (n <= 1) {return n;}

        int prev = 0;
        int curr = 1;

        for (int i = 2; i <= n; i++)
        {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    /* =========================
       MERGE SORT (RECURSIVE)
       ========================= */

    // Recursive mergeSort
    public static void mergeSort(int[] array)
    {
        if (array.length <= 1) {return;}

        int mid = array.length / 2;

        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {left[i] = array[i];}

        for (int i = mid; i < array.length; i++) {right[i - mid] = array[i];}

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    // Non-recursive (iterative) mergeSort. -- (DO NOT NEED TO TEST, FOR REFERENCE ONLY)
    private static void merge(int[] result, int[] left, int[] right)
    {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length)
        {
            if (left[i] <= right[j]) {result[k++] = left[i++];}
            else {result[k++] = right[j++];}
        }

        while (i < left.length) {result[k++] = left[i++];}

        while (j < right.length) {result[k++] = right[j++];}
    }

    /* =========================
       SELECTION SORT (ITERATIVE)
       ========================= */

    public static void selectionSort(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < array[minIndex]) {minIndex = j;}
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    /* =========================
       BINARY SEARCH
       ========================= */

    // Recursive binary search
    // Returns index of key, or -1 if not found
    public static int binarySearch(int[] v, int key, int low, int high)
    {
        if (low > high) {return -1;}

        int mid = (low + high) / 2;

        if (v[mid] == key) {return mid;}
        else if (key < v[mid]) {return binarySearch(v, key, low, mid - 1);}
        else {return binarySearch(v, key, mid + 1, high);}
    }

    // Non-recursive (iterative) binary search
    public static int nBinarySearch(int[] v, int key)
    {
        int low = 0;
        int high = v.length - 1;

        while (low <= high)
        {
            int mid = (low + high) / 2;

            if (v[mid] == key) {return mid;}
            else if (key < v[mid]) {high = mid - 1;}
            else {low = mid + 1;}
        }

        return -1;
    }
}