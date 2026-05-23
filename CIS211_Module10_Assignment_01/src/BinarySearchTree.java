public class BinarySearchTree<K extends Comparable<K>, V>
{
    // Variables needed
    private Node root;

    // Nested class to store entries
    private class Node
    {
        K key;
        V value;
        Node left, right;

        public Node(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }

    // Default Constructor
    public BinarySearchTree() {}

    // Method used to add a new entry to the tree.
    public void put(K key, V value)
    {
        // Check if tree is empty.
        if (root == null)
        {
            // Create root of new tree.
            root =  new Node(key, value); // add entry as head of the tree.
            return;
        }

        // Assume no duplicate
        put(root, key, value);
    }

    // Private recursive method to add new entry to the tree.
    private void put(Node subTreeRoot, K key, V value)
    {
        // Check if key is equal to current node.
        if (key.compareTo(subTreeRoot.key) == 0) {return;}
        else if (key.compareTo(subTreeRoot.key) < 0) // Go Left
        {
            // Check if next node exists.
            if (subTreeRoot.left == null) {subTreeRoot.left = new Node(key, value);} // Create new node.

            //Recursive Method call
            put(subTreeRoot.left, key, value);
        }
        else // Go Right
        {
            // Check if next node exists
            if (subTreeRoot.right == null) {subTreeRoot.right = new Node(key, value);} // Create new node

            // Recursive Method Call
            put(subTreeRoot.right, key, value);
        }
    }

    // Method used to search for entry inside the tree.
    public V get(K key)
    {
        // Variables needed for method.
        V found = null;
        int comparisons = 0;

        // Check if tree is empty.
        if (root == null)
        {
            System.out.println("Number of comparisons: " + comparisons);
            return found;
        }

        // Check root node to see if value exists.
        found = get(root, key, comparisons);

        return found;
    }

    // Private recursive method to search for entry inside the tree.
    private V get(Node subTreeRoot, K key, int comparisons)
    {
        // Variables needed for method.
        V found = null;

        // Increment number of Comparisons.
        comparisons++;

        // Check if value is stored in current node
        if (key.compareTo(subTreeRoot.key) == 0)
        {
            System.out.println("Number of comparisons: " + comparisons);
            found = subTreeRoot.value;
        }
        else if (key.compareTo(subTreeRoot.key) < 0) // Go Left.
        {
            // Check if next node exists.
            if (subTreeRoot.left == null) {return found;}

            // Recursive method call
            found = get(subTreeRoot.left, key, comparisons);
        }
        else // Go Right
        {
            // Check if next node exists.
            if (subTreeRoot.right == null) {return found;}

            // Recursive method call
            found = get(subTreeRoot.right, key, comparisons);
        }
        return found;
    }

}
