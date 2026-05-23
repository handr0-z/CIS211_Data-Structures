public interface Queue<T>
{
    // Place an element at the rear of the queue.
    // @param The element being enqueued.
    // @throws IllegalStateException- if the element cannot be added at this time due to capacity restrictions.
    public void enqueue(T it) throws IllegalStateException;

    // Remove and return element at the front of the queue.
    // @return element at the front of the queue.
    // @return null if the queue is empty.
    public T dequeue();

    // @return the front element;
    // @return null if the queue is empty.
    public T frontValue();

    // Detects whether this queue is empty.
    // @return True if the queue is empty.
    public boolean isEmpty();

    // public boolean isEmpty();
    // @return the number of elements in the queue.
    public int length();
}
