public class CircularArrayQueue<T> implements Queue<T>
{
    private int DEFAULT_CAPACITY = 20;
    private T[] array;
    private int front;
    private int back;
    private int size;

    // Default Constructor
    public CircularArrayQueue()
    {
        this.array = (T[])new Object[DEFAULT_CAPACITY];
        front = 0;
        back = 0;
        size = 0;
    }

    // Overloaded Constructor
    public CircularArrayQueue(int capacity)
    {
        this.array = (T[])new Object[capacity];
        front = 0;
        back = 0;
        size = 0;
    }

    @Override
    public void enqueue(T it) throws IllegalStateException
    {
        // If the array is full, throws an IllegalStateException.
        if (size < array.length)
        {
            // Adds the given integer value to the next available spot in the circular array, indicated by back.
            // After adding the value, back should be updated to the next index in a circular manner.
            array[back] = it;
            back = (back + 1) % array.length;
            size++;
        }
        else {throw new IllegalStateException("Error! Deck is currently filled to capacity. Unable to add more items");}
    }

    @Override
    public T dequeue()
    {
        // Return null if the array is empty
        if (isEmpty()) {return null;}

        T removed = array[front];

        front = (front + 1) % array.length;
        size--;

        return removed;
    }

    @Override
    public T frontValue()
    {
        // Return null if the array is empty
        if (isEmpty()) {return null;}
        else {return array[front];}
    }

    @Override
    public boolean isEmpty()
    {
        if (size == 0) {return true;}

        return false;
    }

    @Override
    public int length() {return size;}

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
            for (int i = 0; i < size - 1 ; i++) {text.append(array[(front + i) % array.length] + ", ");}
            text.append(array[(front + size - 1) % array.length] + "]");

            return text.toString();
        }
    }
}
