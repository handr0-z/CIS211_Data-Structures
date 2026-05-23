/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURITA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          MARCH 24, 2026
PROJECT:       MODULE 7 - LAB 1: HASH FUNCTIONS
NOTES:         PROGRAM CREATED TO BECOME FAMILIAR HASH FUNCTIONS

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
=====================================================================================================
Out of the hash functions I used, named simpleHash() and complexHash(). The complex hash function
seems to be better. The simple hash function I used I treated as a test case for weak hash mapping.
There were a total of 420 collisions and 380 successful indexing attempts. The function simply
created a hash based on the integer values of the characters the name contained and added them up.
Afterward, using the absolute value of the total I modded by the size of the array which I was using
to store the data (array of size 800). I chose to make the array size 800 because this would allow
for 1 value to be stored in each index without any collisions (base case). Afterward I looked
improving the base hash function. To do this I implemented some of the code that we discussed during
class; I multiplied my hash value by a prime number and added the value of the characters for the
name of the Pokémon. The final was obtained by using the absolute value of the total I modded by the
size of the array. This method seemed to improve the distribution area in for indexing, there were
283 collisions and 517 successful indexing attempts. The number of collisions was higher than expected
for the second, considering it vastly improved the distribution during the extra credit assignment in
class. I did mess around with the prime number my hash function used, there was a slight change but
nothing considerable. looking over the data, my complexHash() seemed to have a larger area of
distribution than my simpleHash(). I expected this result however, I assumed the difference would
larger. I do recall Mr. An mentioned that the size of the array should be 30% bigger than the
expected data size. I also messed around that but got similar results. More time would be required
to research and implement a new hashing method to reduce the number of collisions.
=====================================================================================================
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Variables needed
        int option;
        boolean loop = true;

        // Display program banner.
        programBanner();

        do
        {
            // Prompt user to select option
            System.out.println("Select option to test from list below");
            System.out.println("1) Normal Mapping");
            System.out.println("2) Hash Mapping 1");
            System.out.println("3) Hash Mapping 2");
            System.out.println("4) Exit Program");

            System.out.print("Selected Option: ");
            option = input.nextInt();

            switch (option)
            {
                case 1: csvReader(option);
                        break;
                case 2: csvReader(option);
                        break;
                case 3: csvReader(option);
                        break;
                case 4: loop = false;
                        break;
                default:
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("Error! Invalid input detected.");
            }
            System.out.println("-----------------------------------------------------------------------------------------------------");
        }
        while (loop);
    }

    // Method used to display program banner;
    public static void programBanner()
    {
        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                                  MODULE 7 - LAB 1:  HASH FUNCTIONS                                  ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program is used to test different methods of storing data into an array using hashing, the user ");
        System.out.println("must select from the options provided. Afterwards the program will keep track of the number of       ");
        System.out.println("collisions and the number successful unique storage attempts.");
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    // Method used to obtain data from CSV file
    public static void csvReader(int option)
    {
        // List to store data from CSV file of all Pokémon.
        Pokemon[] pokedex = new Pokemon[800];

        // Variables
        String line;
        String csvSplitBy = ",";
        String filePath = "pokemon.csv";
        int key = 0;
        int collisions = 0;
        int successful = 0; // Keep track of unique-successful hash mapping.

        // Obtain information from CSV file.
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            // Skip the header to avoid storage issues.
            br.readLine();

            // Store information obtained from CSV file (1 line at a time.)
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(csvSplitBy); // Use comma (,) as a seperator.

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String type1 = data[2];
                String type2 = data[3];
                int total = Integer.parseInt(data[4]);
                int health = Integer.parseInt(data[5]);
                int attack = Integer.parseInt(data[6]);
                int defense = Integer.parseInt(data[7]);
                int specialAttack = Integer.parseInt(data[8]);
                int specialDefense = Integer.parseInt(data[9]);
                int speed = Integer.parseInt(data[10]);
                int generation = Integer.parseInt(data[11]);
                boolean legendary = Boolean.parseBoolean(data[12]);

                // Obtain Hash value based on name of Pokémon.
                if (option == 2){key = simpleHash(pokedex, name);}
                else if (option == 3){key = complexHash(pokedex, name);}

                // Check if index is empty
                if (pokedex[key] == null)
                {
                    pokedex[key] = new Pokemon(id, name, type1, type2, total, health, attack, defense, specialAttack, specialDefense, speed, generation, legendary);
                    successful++;
                }
                else
                {
                    collisions++;
                }

                key++;
            }

        } catch (Exception e) {throw new RuntimeException(e);}

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Number of collisions: " + collisions);
        System.out.println("Number of successful indexing: " + successful);
    }

    // Hash Function 1
    // Simple hash function obtained from: https://cseweb.ucsd.edu/~kube/cls/100/Lectures/lec16/lec16-13.html
    public static int simpleHash(Pokemon[] pokedex, String name)
    {
        // Define variable needed
        int hash = 0;
        int key = 0;

        for (int i = 0; i < name.length(); i++) {hash = hash + name.charAt(i);}

        key = Math.abs(hash) % pokedex.length;

        return key;
    }

    // Hash Function 2
    // Complex hash function was obtained from Google Gemini during the in-class extra credit assignment from week 9.
    // The assignment was focused on finding the most efficient hash function possible. Using prime numbers calculate
    // the key improved it immensely during the extra credit.
    public static int complexHash(Pokemon[] pokedex, String name)
    {
        // Define variable needed
        int hash = 0;
        int key = 0;

        for (int i = 0; i < name.length(); i++) {hash = 21 * hash + name.charAt(i);}

        key = Math.abs(hash) % pokedex.length;

        return key;
    }
}
