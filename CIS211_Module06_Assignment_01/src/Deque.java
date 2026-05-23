public interface Deque<E>
{
    // Place an element at the front of the queue.
    public void addFront(E it) throws IllegalStateException;

    // Place an element at the rear of the queue.
    public void addBack(E it) throws IllegalStateException;

    // Remove and return element at the front of the queue. Return null if the queue is empty.
    public E removeFront();

    // Remove and return element at the back of the queue. Return null if the queue is empty.
    public E removeBack();

    // Returns the front element. Returns null if the queue is empty.
    public E getFront();

    // Returns the back element. Return null if the queue is empty
    public E getBack();

    // Detects whether this queue is empty. Returns TRUE if empty, FALSE otherwise.
    public boolean isEmpty();

    // Return the number of elements in the queue.
    public int length();
}
