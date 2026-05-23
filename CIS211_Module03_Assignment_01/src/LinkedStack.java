
public class LinkedStack<T> implements Stack<T>
{
    private class Node
    {
        T data; // Reference to object being stored in the list.
        Node next; // A reference to the next node in the list.
    }

    private int size; // An integer tracking the number of elements in the list.
    private Node head; // A reference to the first node in the list.

    // Add item T to top of the stack.
    // @throws IllegalStateException if the element cannot be added due to capacity restrictions.
    @Override
    public void push(T item) throws IllegalStateException
    {
        // The top of the stack is the head
        Node node = new Node();
        node.next = head;
        node.data = item;
        head = node;
        size++;
    }


    @Override
    public T pop() throws NullPointerException
    {
        // Forgot to include a check for empty stack originally.
        if (size == 0) {throw new NullPointerException("Stack is empty");}

        Node temp = new Node();
        temp = head;
        head = head.next;
        size--;
        return temp.data;
    }

    // Returns the top entry of the stack without removing it. Returns NULL if the stack is empty.
    @Override
    public T peek()  throws NullPointerException
    {
        // Forgot to include a check for empty stack originally.
        if (size == 0) {throw new NullPointerException("Stack is empty");}

        return head.data;
    }

    // Checks if the stack is empty. Returns TRUE if empty, FALSE otherwise.
    @Override
    public boolean isEmpty()
    {
        if (size == 0) return true;
        return false;
    }

    // Method that returns the number of entries in the stack.
    @Override
    public int length() {return size;}

    // Method to return a string value displaying contents of Linked List.
    public String toString()
    {
        StringBuilder text = new StringBuilder();

        // Create a temporary node to iterate through Linked List.
        Node temp = head;

        if  (size == 0)
        {
            text.append("[]");
            return text.toString();
        }
        else
        {
            text.append("[");

            for (int i = 0; i < size - 1; i++)
            {
                text.append(temp.data + ", ");
                temp = temp.next;
            }

            text.append(temp.data + "]");

            return text.toString();
        }
    };
}
