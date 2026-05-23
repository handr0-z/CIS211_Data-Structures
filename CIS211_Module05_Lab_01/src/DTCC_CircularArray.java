public class DTCC_CircularArray
{
    private final int DEFAULT_CAPACITY = 5;
    private int[] array; // The array used to store the integers
    private int front; // An integer tracking the index of the first element in the circular array.
    private int back; // An integer tracking the index of hte next available spot in the circular array.
    private int size; // An integer tracking the number of elements currently stored in the array.
    private int capacity; // The total capacity of the array.

    // Constructor
    public DTCC_CircularArray()
    {
        array = new int[DEFAULT_CAPACITY];
        this.capacity = array.length;
    }

    // Overloaded Constructor
    public DTCC_CircularArray(int capacity)
    {
        // Initializes the array with a given initial capacity;
        array = new int[capacity];
        this.capacity = array.length;
    }

    public void add(int value) throws IllegalStateException
    {
        // If the array is full, throws an IllegalStateException.
        if (size < capacity)
        {
            // Adds the given integer value to the next available spot in the circular array, indicated by back.
            // After adding the value, back should be updated to the next index in a circular manner.
            array[back] = value;
            back = (back + 1) % capacity;
            size++;
        }
        else {throw new IllegalStateException();}
    }

    public int get(int index) throws IndexOutOfBoundsException
    {
        // If the index is out of bounds (i.e., less than 0 or greater than or equal to size), it should throw an IndexOutOfBoundsException.
        if (index >= size || index < 0) {throw new IndexOutOfBoundsException();}

        // The index should be calculated based ont he position of the front.
        // Returns the integer stored at the specified index.
        return array[(front + index) % capacity];
    }

    // Method that removes the element at the specified index, shifting the remaining elements accordingly.
    public void remove(int index)
    {
        // If the index is out of bounds, throws an IndexOutOfBoundsException.
        if (index >= size || index < 0) {throw new IndexOutOfBoundsException();}

        // If index is in the first half of the list (closer to the front), shifts elements to the right. (towards front).
        if (index <= size / 2)
        {
            // My attempt at the index shifting.
            for (int i = index; i < size; i++) {array[(front + i) % capacity] = array[(front + i + 1) % capacity];}

            // Mr An's way to index shift.
            //for (int i = 0; i < (size - index - 1); i++) {array[(front + index + i) % capacity] = array[(front + index + i + 1) % capacity];}

            // Updates front or back accordingly after shifting.
            back = (front + size - 1) % capacity;
        }
        else // If index is in the second half (closer to the back), shifts elements to the left (towards back).
        {
            // My attempt at the index shifting.
            int prev = array[front];
            for (int i = index; i > ((front - 1) % capacity); i--) {array[(back + i + 1 + capacity) % capacity] = array[(back + i + capacity) % capacity];}
            array[(front + 1) % capacity] = prev;

            // Mr. An's way to index shift
            /*int prev = array[front];

            for (int i = 0; i < index; i++)
            {
                int temp = array[(front + i + 1) % capacity]; // Store starting element in temporary variable.
                array[(front + i + 1) % capacity] = prev;
                prev = temp;
            }*/

            // Updates front or back accordingly after shifting.
            front = (front + 1) % capacity;
        }

        size--;
    }

    // Returns a string representation of the list in the format [element1, element2, ..., elementN].
    @Override
    public String toString()
    {
        // The elements should be printed in the order form front to back.
        StringBuilder text = new StringBuilder();

        // If the list is empty, it should return "[]"
        if  (size == 0)
        {
            text.append("[]");
            return text.toString();
        }
        else
        {
            text.append("[");
            for (int i = 0; i < size - 1 ; i++) {text.append(array[(front + i) % capacity] + ", ");}
            text.append(array[(front + size - 1) % capacity] + "]");

            return text.toString();
        }
    }
}
