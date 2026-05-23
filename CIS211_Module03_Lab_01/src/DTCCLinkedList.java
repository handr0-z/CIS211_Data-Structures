public class DTCCLinkedList
{
    private class Node
    {
        int data; // Stores the integer value of the node.
        Node next; // A reference to the next node in the list.
    }

    private int size; // An integer tracking the number of elements in the list.
    private Node head; // A reference to the first node in the list.


    // Constructor
    public DTCCLinkedList()
    {
        size = 0;
        head = null;
    };

    // Method used to add items to the end of Linked List.
    public void add(int value)
    {
        // Create a new node to add to the end of the Linked List.
        Node node = new Node();
        node.data = value;
        node.next = null; // Not Necessary

        // Check if Linked list has 1st item.
        if (head == null)
        {
            head = node; // Assign newly created Node item as the head of Linked List.
            size++; // Update size of Linked List.
            return; // Exit method, the following code is irrelevant for first item in Linked list.
        }

        // Create a temporary node to iterate through Linked List.
        Node temp = head;

        // Cycle through linked list until reaching the end.
        while (temp.next != null) {temp = temp.next;}

        // Assign newly created Node item to end of Linked List.
        temp.next = node;
        size++; // Update Size of linked list.
    };

    // Method used to get the value of a Node within a Linked List.
    public int get(int index) throws IndexOutOfBoundsException
    {
        // Create a temporary node to iterate through Linked List.
        Node temp = head;

        if (index >= size || index < 0) {throw new IndexOutOfBoundsException("IndexOutOfBoundsException: The Specified index [" + index + "] is out of bounds!");}

        // Cycle through linked list until the desired Node.
        for (int i = 0; i < index; i++) {temp = temp.next;}

        return temp.data;
    };

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
