import java.util.Iterator;
import java.util.LinkedList;

public class Pokedex<K, V>
{
    // Variables needed
    private final int DEFAULT_CAPACITY = 100;
    private LinkedList<Entry>[] table; // Array of Linked Lists.
    private int count = 0;

    // Nested class to store Pokémon entries
    private class Entry
    {
        K key;
        V value;
    }

    // Default Constructor
    public Pokedex() {table = new LinkedList[DEFAULT_CAPACITY];}

    // Overloaded Constructor
    public Pokedex(int size) {table = new LinkedList[size];}

    // Method used to add Pokémon from table.
    public void addPokemon(K key, V value)
    {
        // Get correct index according the name of the Pokémon provided.
        int index = hash(key);

        // Create a node for the Pokémon to be added
        Entry entry = new Entry();
        entry.key = key;
        entry.value = value;

        // Check if Linked List stored in specified index of the Array is empty.
        if (table[index] == null)
        {
            // Create a new list
            table[index] = new LinkedList<>();

            table[index].add(entry); // Add new entry to list.
            count++; // Increase count
            return;
        }

        // Create iterator to loop through LinkedList inside Array.
        Iterator<Entry> itr = table[index].iterator();

        // Loop created to loop through specified index Linked List.
        // itr starts before head of Linked list, so itr.next() gets all items inside Linked List.
        while (itr.hasNext())
        {
            // Create Entry object to get information for list.
            Entry tempEntry = itr.next();

            // Check if item already exists inside the list.
            if (tempEntry.key.equals(key)) {tempEntry.value = entry.value; return;} // Update existing entry
        }

        // If entry does not exist, add new entry to list.
        table[index].add(entry);
        count++;
    }

    // Method used to remove Pokémon from table.
    public boolean removePokemon(K key)
    {
        // Get correct index according the name of the Pokémon provided.
        int index = hash(key);

        // Check if Pokémon entry is inside Array
        if (table[index] != null)
        {
            // Create iterator to loop through LinkedList inside Array.
            Iterator<Entry> itr = table[index].iterator();

            // Loop created to loop through specified index Linked List.
            // itr starts before head of Linked list, so itr.next() gets all items inside Linked List.
            while(itr.hasNext())
            {
                // Create Entry object to get information for list.
                Entry entry = itr.next();

                // Check if Pokémon name matches the name provided and it's active.
                if(entry.key.equals(key))
                {
                    itr.remove();
                    count--;
                    return true;
                }
            }
        }
        return false;
    }

    // Method used to search for specific Pokémon Map
    public V getPokemon(K key)
    {
        // Get correct index according the name of the Pokémon provided.
        int index = hash(key);

        // Check if Pokémon entry is inside Array
        if (table[index] == null) {return null;}

        // Create iterator to loop through LinkedList inside Array.
        Iterator<Entry> itr = table[index].iterator();

        // Loop created to loop through specified index Linked List.
        // itr starts before head of Linked list, so itr.next() gets all items inside Linked List.
        while(itr.hasNext())
        {
            // Create Entry object to get information for list.
            Entry entry = itr.next();

            // Check if Pokémon name (key) matches the name provided.
            if(entry.key.equals(key)) {return entry.value;}
        }

        return null;
    }

    // Method used to display the Pokémon Stored inside table.
    public void displayAllPokemon()
    {
        // Loop through table.
        for (int i = 0; i < table.length; i++)
        {
            // Check if specific index is empty.
            if  (table[i] == null) {continue;} // Move onto next index value.
            else
            {
                // Create iterator to loop through LinkedList inside Array.
                Iterator<Entry>  itr = table[i].iterator();

                // Loop created to loop through specified index Linked List.
                // itr starts before head of Linked list, so itr.next() gets all items inside Linked List.
                while (itr.hasNext())
                {
                    // Create Entry object to get infromation from iterator.
                    Entry entry = itr.next();

                    // Create temporary Pokémon object to obtain information.
                    Pokemon pokemon = (Pokemon) entry.value;

                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    displayPokemonInfo(pokemon);
                }
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    // Method used to get a hash value for indexing.
    private int hash(K key)
    {
        // Define variable needed
        String name = key.toString();
        int index = 0;
        int hash = 0;

        for (int i = 0; i < name.length(); i++) {hash = 21 * hash + name.charAt(i);}

        index = Math.abs(hash) % table.length;

        return index;
    }

    // Method used to display information.
    private void displayPokemonInfo(Pokemon p)
    {
        System.out.println("ID #: " + p.getId());
        System.out.println("Name: " + p.getName());
        System.out.println("Type 1: " + p.getType1());
        System.out.println("Type 2: " + p.getType2());
        System.out.println("Total:  " + p.getTotal());
        System.out.println("Health: " + p.getHealth());
        System.out.println("Attack: " + p.getAttack());
        System.out.println("Defense: " + p.getDefense());
        System.out.println("Special Attack: " + p.getSpecialAttack());
        System.out.println("Special Defense: " + p.getSpecialDefense());
        System.out.println("Speed: " + p.getSpeed());
        System.out.println("Generation: " + p.getGeneration());
        System.out.println("Legendary: " + p.isLegendary());
    }

    // Method used to get the total number of Pokémon inside table.
    public int pokedexSize(){return count;}
}
