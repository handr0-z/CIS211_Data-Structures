class LinkedMap<K, V>
{
    private Node head, tail;
    private int count;

    class Node
    {
        K key;
        V value;
        Node prev, next;
    }
}