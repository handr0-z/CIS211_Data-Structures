public interface Stack<T>
{
    // Add item T to top of the stack.
    // @throws IllegalStateException if the element cannot be added due to capacity restrictions.
    void push(T item) throws IllegalStateException;

    // Returns & REMOVES the top entry of the stack. Returns NULL if the stack is empty.
    T pop();

    // Returns the top entry of the stack without removing it. Returns NULL if the stack is empty.
    T peek();

    // Checks if the stack is empty. Returns TRUE if empty, FALSE otherwise.
    boolean isEmpty();

    // Returns the number of entries in the stack.
    int length();
}
