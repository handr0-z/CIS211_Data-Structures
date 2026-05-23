public class DTCC_BinarySearchTree
{
    // Variables Needed
    Node root;

    private class Node
    {
        int data; // Stores the integer value of the node.
        Node left; // A reference to the left node in the tree.
        Node right; // A reference to the right node in the tree
    }

    // Constructor
    public DTCC_BinarySearchTree() {}

    // Method used to add a new value to the tree.
    public void add(int value)
    {
        // Check if tree is empty.
        if (root == null)
        {
            // Create root of new tree.
            root = new Node();
            root.data = value;
            return;
        }

        // Assume no duplicates
        add(value, root);
    }

    // Private recursive method to add a new value to the tree
    private void add(int value, Node subtreeRoot)
    {
        // Check if value is less than or greater than current node value.
        if (value < subtreeRoot.data) // Go left
        {
            // Check if next node exists.
            if (subtreeRoot.left == null)
            {
                // Create a new node
                subtreeRoot.left = new Node();
                subtreeRoot.left.data = value;
                return;
            }

            // Recursive method call
            add(value, subtreeRoot.left);
        }
        else if (value > subtreeRoot.data) // Go Right
        {
            // Check if next node exists.
            if (subtreeRoot.right == null)
            {
                // Create a new node
                subtreeRoot.right = new Node();
                subtreeRoot.right.data = value;
                return;
            }

            // Recursive method call
            add(value, subtreeRoot.right);
        }
    }

    // Method used to verify if value exists inside the tree.
    public boolean get(int value)
    {
        // Variables needed for method.
        boolean found;

        // Check if tree is empty.
        if (root == null) {return false;}

        // Check root node to see if value exists.
        found = get(value, root);

        return found;
    }

    // Private recursive used to verify if value exists inside the tree.
    private boolean get(int value, Node subtreeRoot)
    {
        // Variable needed for method
        boolean found = false;

        // Check if value is stored in current node or if value is less than or greater than current node value.
        if (subtreeRoot.data == value) {return true;}
        else if (value < subtreeRoot.data) // Go left
        {
            // Check if next node exists.
            if (subtreeRoot.left == null) {return false;}

            // Recursive method call
            found = get(value, subtreeRoot.left);
        }
        else if (value > subtreeRoot.data) // Go right
        {
            // Check if next node exists.
            if (subtreeRoot.left == null) {return false;}

            // Recursive method call
            found = get(value, subtreeRoot.right);
        }

        return found;
    }

    // Method to return a string value displaying contents of tree.
    public String toString()
    {
        StringBuilder text = new StringBuilder();

        if  (root == null)
        {
            text.append("[]");
            return text.toString();
        }

        text.append("[");
        text.append(toString(root));
        text.append("]");

        return text.toString();
    }

    // Private recursive used to return a string value displaying contents of tree.
    private String toString(Node subtreeRoot)
    {
        StringBuilder text = new StringBuilder();

        // Check if there are any values less than the current node value.
        if (subtreeRoot.left != null) {text.append(toString(subtreeRoot.left));}

        if (subtreeRoot.left == null) {text.append(subtreeRoot.data);}
        else {text.append(", " + subtreeRoot.data);}

        // Check if there are any values less than the current node value.
        if (subtreeRoot.right != null) {text.append(", " + toString(subtreeRoot.right));}

        return text.toString();
    }
}
