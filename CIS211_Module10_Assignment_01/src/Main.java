/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURIsTA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          APRIL 19, 2026
PROJECT:       MODULE 10 - ASSIGNMENT 1: BINARY SEARCH TREE MAP
NOTES:         PROGRAM CREATED TO DEMONSTRATE AN UNDERSTANDING OF IMPLEMENTATION OF TREES

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
STARTER CODE/ CODE CREATED IN CLASS WITH INSTRUCTOR WAS USED AS A TEMPLATE FOR POKEDEX CLASS.
=====================================================================================================
When selecting Pokemon from the CSV file to test the program for efficiency I tried to be as diverse
in my selection as possible. I did this based on Pokémon ID values. If a Pokémon had a higher ID
then they were lower in the list since the Pokémon are added starting with ID 1 until reaching the
max Pokemon ID in the CSV file. That being said they are organized within the Binary Search Tree
based on the value of the Pokemon names, not their ID's. That being said, If the Pokémon ID is
larger than they are farther away from the Initial Entry; meaning more comparisons are needed to
get to the Pokemon. With this in mind, I found that the average number of comparisons needed to find
a Pokemon was 15 (based on the Pokémon I selected below). I believe this is more than reasonable
given the number of entries within the Binary Search Tree & CSV file in comparisons to a LinkedList.
The number of comparisons needed to find a Pokemon entry drops significantly for entries added to
the list at the end. This makes its alot more reasonable to search through a dataset. While all the
data is available like before, the change is that distance from the intial entry to any other data
entry is reduced drastically.
=====================================================================================================
*/

import java.io.BufferedReader;
import java.io.FileReader;

public class Main
{
    public static void main(String[] args)
    {
        // Create Binary Search tree
        BinarySearchTree<String, Pokemon> pokedex = new BinarySearchTree<>();

        // Obtain data from csv File.
        csvReader(pokedex);

        // Program Banner
        programBanner();

        Pokemon p1 = pokedex.get("Cyndaquil");
        displayPokemonInfo(p1);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        Pokemon p2 = pokedex.get("Treecko");
        displayPokemonInfo(p2);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        Pokemon p3 = pokedex.get("Squirtle");
        displayPokemonInfo(p3);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        Pokemon p4 = pokedex.get("Woobat");
        displayPokemonInfo(p4);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        Pokemon p5 = pokedex.get("Snivy");
        displayPokemonInfo(p5);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        Pokemon p6 = pokedex.get("Lugia");
        displayPokemonInfo(p6);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        Pokemon p7 = pokedex.get("Haunter");
        displayPokemonInfo(p7);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        Pokemon p8 = pokedex.get("Pichu");
        displayPokemonInfo(p8);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        Pokemon p9 = pokedex.get("Dragonite");
        displayPokemonInfo(p9);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        Pokemon p10 = pokedex.get("Pancham");
        displayPokemonInfo(p10);
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    // Method used to display program banner;
    public static void programBanner()
    {
        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                          MODULE 10 - ASSIGNMENT 1:  BINARY SEARCH TREE MAP                          ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program uses a Binary Search Tree (BST) Map to store the data of Pokemon, it uses pokemon names ");
        System.out.println("to search its database for a match. Before displaying the data, it also notes the number of          ");
        System.out.println("comparisons required to to find the correct entry within the database. Search entries are hardcoded  ");
        System.out.println("into the program, however they can be adjustment. Simply change the name of the desired Pokemon.     ");
        System.out.println("Entries are case sensitive.");
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    // Method used to display information.
    public static void displayPokemonInfo(Pokemon p)
    {
        System.out.println("\nID #: " + p.getId());
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

    // Method used to obtain data from CSV file
    public static void csvReader(BinarySearchTree<String, Pokemon> pokedex)
    {
        // Variables
        String line;
        String csvSplitBy = ",";
        String filePath = "pokemon.csv";

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

                Pokemon p = new Pokemon(id, name, type1, type2, total, health, attack, defense, specialAttack, specialDefense, speed, generation, legendary);

                pokedex.put(p.getName(), p);
            }

        } catch (Exception e) {throw new RuntimeException(e);}
    }
}
