class MyMap<K, V>
{
    // array?
    private final int DEFAULT_CAPACITY = 50;

    private K[] keys;
    private V[] values;

    private int count = 0;
    private int collisions = 0;
    private  int size;

    public MyMap()
    {
        keys = (K[])(new Object[DEFAULT_CAPACITY]);
        values = (V[])(new Object[DEFAULT_CAPACITY]);
    }

    public MyMap(int size)
    {
        keys = (K[])(new Object[size]);
        values = (V[])(new Object[size]);
        this.size = size;
    }

//    public void insert(K key, V value) {
//        // some converter thing
//        int index = hash(key);
//        if (keys[index] == null) {
//            keys[index] = key;
//            values[index] = value;
//            count++;
//        } else {
//            collisions++;
//        }
//    }

    public void insert(K key, V value)
    {
        int index = hash1(key);
        int stepSize = hash2(key);

        while (keys[index] != null)
        {
            if (keys[index].equals(key))
            {
                values[index] = value;
                return;
            }
            collisions++;
            // Use the second hash to determine how far to jump
            index = (index + stepSize) % size;
        }

        keys[index] = key;
        values[index] = value;
    }

    public V get(K key)
    {
        int index = hash(key);
        return values[index];
    }

    private int hash(K key)
    {
        // worst hash function of all time
        // return 0;

        // a MUCH better (but one that we don't understand) version
//        int index = key.hashCode();
//        index = Math.abs(index) % keys.length;
//        return index;

        // ok - one more time, this is OUR first version
        return customHashFunction(key);
    }

    private int hash1(K key)
    {
        int h = key.hashCode();
        return (h & 0x7fffffff) % size;
    }

    // Secondary Hash: Determines the STEP SIZE (must not be 0)
    private int hash2(K key)
    {
        int h = key.hashCode();
        // A common formula: PRIME - (h % PRIME)
        // Let's pick a prime smaller than our table size, e.g., 7
        return 7 - ((h & 0x7fffffff) % 7);
    }

    private int customHashFunction(K key)
    {
        int index;
        // something here...
        String string = key.toString();

        long someNumber = 0;
        for (int i = 0; i < string.length(); i++) {someNumber = 31 * someNumber + string.charAt(i);}

        int finalHash = (int)someNumber;


        /*
        array size = 1000, first version with only 1 letter, 185 collisions
        same thing... 2 letters?  161 collisions
        use all the letters? 41 collisionsp

        array size = 2000, use all letters? 39 collisions?

        array size = 3000?
         */

        //double hash
        // so re-hash our hash value
        //index = multiplicationHash(someNumber)% keys.length;;

        return (finalHash & 0x7fffffff) % keys.length;
    }

    private int multiplicationHash(int num)
    {
        final float MULT_HASH_CONST = 0.0123f;
        double hash1 = (num) * MULT_HASH_CONST;
        double hash2 = hash1 % 1; // hash2 = 0.1771
        int index = (int)(hash2 * keys.length); // 17
        //index = hash2 & (index-1);

        return index;
    }

    public int getCollisions() {return collisions;}
}