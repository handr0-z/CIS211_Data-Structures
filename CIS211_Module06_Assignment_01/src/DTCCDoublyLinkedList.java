public class DTCCDoublyLinkedList<E> implements Deque<E>
{
    private class Node
    {
        E data; // Stores the integer value of the node.
        Node next; // A reference to the next node in the list.
        Node previous; // A reference to previous node in list.
    }

    private int size; // An integer tracking the number of elements in the list.
    private Node head; // A reference to the first node in the list.
    private Node tail; // A reference to the last node in the list.

    // Constructor
    public DTCCDoublyLinkedList()
    {
        size = 0;
        head = null;
    };

    // Method used to add items to the front of the list.
    @Override
    public void addFront(E item) throws IllegalStateException
    {
        // Create a new node to add
        Node node = new Node();
        node.data = item;
        node.next = null; // Not Necessary
        node.previous = null; // Not necessary

        // Check if list is empty.
        if (isEmpty())
        {
            head = node; // Assign newly created Node item as the head of list.
            tail = node; // Assign newly created Node item as the tail of the list.
            size++; // Update size of the List.
            return; // Exit method, the following code is irrelevant for first item in the list.
        }

        // Assign the newly added node as the head of the list.
        head.previous = node;
        node.next = head;
        head = node;

        size++; // Update Size of the list.
    }

    // Method used to add items to the back of the list.
    @Override
    public void addBack(E item) throws IllegalStateException
    {
        // Create a new node to add
        Node node = new Node();
        node.data = item;
        node.next = null; // Not Necessary
        node.previous = null; // Not necessary

        // Check if the list is empty.
        if (isEmpty())
        {
            head = node; // Assign newly created Node item as the head of list.
            tail = node; // Assign newly created Node item as the tail of the list.
            size++; // Update size of the list.
            return; // Exit method, the following code is irrelevant for first item in list.
        }

        // Assign the newly added node as the head of the list.
        tail.next = node;
        node.previous = tail;
        tail = node;

        size++; // Update Size of the list.
    }

    // Method used to remove and return element at the front of the list.\
    @Override
    public E removeFront()
    {
        // Check if the list is empty.
        if (isEmpty()) {return null;}

        // Check if list contains 1 item only.
        if (size == 1)
        {
            size--;
            return head.data;
        }

        // Create temporary Node and assign a new head.
        Node temp = head;
        head = head.next;

        size--;
        return temp.data;
    }

    // Method used to remove and return element at the back of the list.
    @Override
    public E removeBack()
    {
        if (isEmpty()) {return null;}

        // Check if list contains 1 item only.
        if (size == 1)
        {
            size--;
            return head.data;
        }

        // Create temporary Node and assign a new head.
        Node temp = tail;
        tail = tail.previous;

        size--;
        return temp.data;
    }

    // Method used to get the value at the front of the list.
    @Override
    public E getFront() throws IllegalStateException
    {
        // Check if the list is empty.
        if (isEmpty()) {return null;}

        return head.data;
    }

    // Method used to get the value at the back of the list.
    @Override
    public E getBack() throws IllegalStateException
    {
        // Check if the list is empty.
        if (isEmpty()) {return null;}

        return tail.data;
    }

    // Method used to check if the list is empty.
    @Override
    public boolean isEmpty()
    {
        if (size == 0) {return true;}
        else {return false;}
    }

    // Method used to get the size of the list.
    @Override
    public int length(){return size;}

    // Method to return a string value displaying contents of the list.
    public String toString()
    {
        StringBuilder text = new StringBuilder();

        // Create a temporary node to iterate through list.
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
    }
}
