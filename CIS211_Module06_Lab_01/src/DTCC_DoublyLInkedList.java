public class DTCC_DoublyLInkedList
{
    private Node head; // A reference to the first node in the list
    private Node tail; // A reference to the last node in the list.
    private int count; // An integer tracking the number of elements  in the list.

    private class Node
    {
        int data; // Stores the integer value of the node.
        Node next, prev; // Reference to the next and previous nodes in the list.
    }

    // Constructor
    DTCC_DoublyLInkedList()
    {
        head = null;
        tail = null;
        count = 0;
    }

    // Method used to add items to "tail".
    public void add(int it)
    {
        // Create new node to store data
        Node node = new Node();
        node.data = it;

        // Check if list is empty.
        if (count == 0)
        {
            head = node; // Assign newly created Node item as the head of Linked List.
            tail = head; // Assign the tail as the head for the first item.
            count++; // Update size of Linked List.
            return; // Exit method, the following code is irrelevant for first item in Linked list.
        }

        // Assign new Node as the tail in the Linked List
        tail.next = node;
        node.prev = tail;
        tail = node;
        count++;
    }

    // Method used to retrieve the data stored in the specified index.
    public int get(int index)
    {
        // Check if index is out of bounds
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();

        // search the Linked List
        Node itr = head;
        for (int i =0; i < index; i++) {itr = itr.next;}

        return itr.data;
    }

    public boolean remove(int index)
    {
        // If index is closer to tail.

        // Check if empty
        if (count == 0) {return false;}

        // Check if index is out of bounds
        if (index < 0 || index >= count) {throw new IndexOutOfBoundsException();}

        // Check if closer to head or tail
        if (index > count / 2)
        {
            // Check if index to be removed is the tail.
            if (index == count - 1) {tail = tail.prev; count--; return true;}

            Node itr = tail;

            // Cycle through list and stop (1) short
            for (int i =count; i > index + 1; i--) {itr = itr.prev;}

            Node after = itr; // Assign itr to a reference variable called before
            after.prev = itr.prev.prev;
            itr = itr.prev.prev;
            itr.next = after;
            count--;

            return true;
        }
        else
        {
            // if index is closer to head.

            // Check if index to be removed is the head.
            if (index == 0) {head = head.next; count--; return true;}

            Node itr = head;

            // Cycle through list and stop (1) short
            for (int i = 0; i < index - 1; i++) {itr = itr.next;}

            Node before = itr; // Assign itr to a reference variable called before
            before.next = itr.next.next;
            itr = itr.next.next;
            itr.prev = before;
            count--;

            return true;
        }
    }

    // Method to return a string value displaying contents of Linked List.
    public String toString()
    {
        StringBuilder text = new StringBuilder();

        // Create a temporary node to iterate through Linked List.
        Node temp = head;

        if  (count == 0)
        {
            text.append("[]");
            return text.toString();
        }
        else
        {
            text.append("[");

            for (int i = 0; i < count - 1; i++)
            {
                text.append(temp.data + ", ");
                temp = temp.next;
            }

            text.append(temp.data + "]");

            return text.toString();
        }
    }
}