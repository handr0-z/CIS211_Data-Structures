public class DTCCArrayList
{
    // Variables necessary for the class.
    private int[] array; // Array used to store integers.
    private int size; // An integer tracking the number of elements currently stored in the array.

    // Constructor
    public DTCCArrayList(int initialCapacity)
    {
        array = new int [initialCapacity];
        size = 0;
    }

    // Method used to add values into array.
    public void add(int value)
    {
        // Check if array is full and notify user.
        if (size == array.length) {System.out.println("Array is full");}
        else
        {
            array[size] = value;
            size++;
        }
    }

    // Method used to get value from array
    public int get(int index) {return array[index];}

    // Method used to return a string representation of the list.
    public String toString()
    {
        StringBuilder text = new StringBuilder();

        if  (size == 0)
        {
            text.append("[]");
            return text.toString();
        }
        else
        {
            text.append("[");
            for (int i = 0; i < size - 1; i++) {text.append(array[i] + ", ");}
            text.append(array[size - 1] + "]");

            return text.toString();
        }
    }
}
