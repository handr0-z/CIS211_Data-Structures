/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURIsTA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          MARCH 30, 2026
PROJECT:       MODULE 7 - ASSIGNMENT 1: DICTIONARY HASH TABLE
NOTES:         PROGRAM CREATED TO DEMONSTRATE AN UNDERSTANDING OF IMPLEMENTATION OF HASH MAPPING.

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
STARTER CODE/ CODE CREATED IN CLASS WITH INSTRUCTOR WAS USED AS A TEMPLATE FOR POKEDEX CLASS.
=====================================================================================================
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        // List to store data from CSV file
        Pokedex<String, Pokemon> pokedex = new Pokedex<>();

        // Variables
        int menuSelect;
        boolean exit = false;

        // Obtain data from csv File.
        csvReader(pokedex);

        // Program Banner.
        programBanner();

        do {

            System.out.println("CURRENT POKEDEX ENTRIES: " + pokedex.pokedexSize());
            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Display Main Menu.
            menuSelect = mainMenu();

            switch (menuSelect) {
                case 0:
                    pokedex.displayAllPokemon();
                    break;
                case 1:
                    search(pokedex);
                    break;
                case 2:
                    addEntry(pokedex);
                    break;
                case 3:
                    removeEntry(pokedex);
                    break;
                case 4:
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("Goodbye!");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    exit = true;
            }
        } while (exit != true);

    }

    // Method used to display program banner;
    public static void programBanner()
    {
        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                           MODULE 7 - ASSIGNMENT 1:  DICTIONARY HASH TABLE                           ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program can be used as a POKEDEX. It allows the user to view the information of all Pokemon.");
        System.out.println("The user can also search for a specific Pokemon or add/ remove the information of a Pokemon manually.");
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    // Method used to display main menu.
    public static int mainMenu()
    {
        Scanner input = new Scanner(System.in);

        int menuOption;

        do {
            System.out.println("What would you like to do?\n");

            System.out.println("1) Show all POKEMON entries");
            System.out.println("2) Search for POKEMON entry");
            System.out.println("3) Add POKEMON entry");
            System.out.println("4) Remove POKEMON entry");
            System.out.println("5) Exit Program\n");
            System.out.print("Selected Option: ");

            // Trap to ensure valid input is obtained from user.
            while(true)
            {
                if (input.hasNextInt())
                {
                    menuOption = input.nextInt();
                    break;
                }
                else
                {
                    System.out.println("\nError! Invalid input detected.");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.print("Enter menu option: ");
                    input.next();
                }
            }

            if (menuOption < 1 || menuOption > 5)
            {
                System.out.println("\nError! Invalid input detected.");
                System.out.println("-----------------------------------------------------------------------------------------------------");
            }

        } while (menuOption < 1 || menuOption > 5);

        return menuOption - 1;
    }

    // Method used to search for Pokémon by name.
    public static void search(Pokedex<String, Pokemon> pokedex)
    {
        Scanner input = new Scanner(System.in);

        // Variables
        String name;
        int counter = 0;

        System.out.println("-----------------------------------------------------------------------------------------------------");
        do {
            System.out.print("Enter the name of the POKEMON you would like to search for: ");

            name = input.nextLine(); // Needed to change to be able to read entire input (including spaces)
            System.out.println("-----------------------------------------------------------------------------------------------------");

            Pokemon pokemon = pokedex.getPokemon(name);

            if (pokemon != null) {
                System.out.println("ID #: " + pokemon.getId());
                System.out.println("Name: " + pokemon.getName());
                System.out.println("Type 1: " + pokemon.getType1());
                System.out.println("Type 2: " + pokemon.getType2());
                System.out.println("Total:  " + pokemon.getTotal());
                System.out.println("Health: " + pokemon.getHealth());
                System.out.println("Attack: " + pokemon.getAttack());
                System.out.println("Defense: " + pokemon.getDefense());
                System.out.println("Special Attack: " + pokemon.getSpecialAttack());
                System.out.println("Special Defense: " + pokemon.getSpecialDefense());
                System.out.println("Speed: " + pokemon.getSpeed());
                System.out.println("Generation: " + pokemon.getGeneration());
                System.out.println("Legendary: " + pokemon.isLegendary());
                System.out.println("-----------------------------------------------------------------------------------------------------");
                break;
            } else {
                counter++;
                System.out.println("Error! Pokemon not found in Pokedex.");
                System.out.println("[" + counter + "/3] failed attempts.");

                // Notify user about returning to main menu.
                if (counter == 3) {System.out.println("Returning to Main Menu...");}

                System.out.println("-----------------------------------------------------------------------------------------------------");
            }
        } while (counter < 3);
    }

    // Method used to add Pokémon entry
    public static void addEntry(Pokedex<String, Pokemon> pokedex)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.print("Enter the name of the POKEMON you would like to add: ");
        String name = input.next();
        System.out.print("Enter ID # of the POKEMON you would like to add: ");
        int id = input.nextInt();
        System.out.print("Enter type 1 (String): ");
        String type1 = input.next();
        System.out.print("Enter type 2 (String): ");
        String type2 = input.next();
        System.out.print("Enter health value (Integer): ");
        int health = input.nextInt();
        System.out.print("Enter Attack value (Integer): ");
        int attack = input.nextInt();
        System.out.print("Enter Defense value (Integer): ");
        int defense = input.nextInt();
        System.out.print("Enter Special Attack Value (Integer): ");
        int specialAttack = input.nextInt();
        System.out.print("Enter Special Defense Value (Integer): ");
        int specialDefense = input.nextInt();
        System.out.print("Enter Speed (Integer): ");
        int speed = input.nextInt();
        System.out.print("Enter Generation (Integer): ");
        int generation = input.nextInt();
        System.out.print("Enter Legendary (Boolean): ");
        boolean legendary = input.nextBoolean();

        int total = health + attack +  defense + specialAttack + specialDefense + speed;

        Pokemon p = new Pokemon(id, name, type1, type2, total, health, attack, defense, specialAttack, specialDefense, speed, generation, legendary);

        pokedex.addPokemon(p.getName(), p);

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Pokemon entry added successfully!");
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    // Method used to remove Pokémon entry
    public static void removeEntry(Pokedex<String, Pokemon> pokedex)
    {
        Scanner input = new Scanner(System.in);

        // Variables
        String name;
        int counter = 0;
        boolean removed;

        System.out.println("-----------------------------------------------------------------------------------------------------");
        do {
            System.out.print("Enter the name of the POKEMON you would like to remove: ");

            name = input.next();
            System.out.println("-----------------------------------------------------------------------------------------------------");

            removed = pokedex.removePokemon(name);

            if (removed == false) {
                counter++;
                System.out.println("Error! Pokemon not found in Pokedex.");
                System.out.println("[" + counter + "/3] failed attempts.");

                // Notify user about returning to main menu.
                if (counter == 3) {System.out.println("Returning to Main Menu...");}

                System.out.println("-----------------------------------------------------------------------------------------------------");
            } else
            {
                counter = 3;
                System.out.println("Pokemon removed successfully!");
                System.out.println("-----------------------------------------------------------------------------------------------------");
            }
        }while (counter < 3);
    }

    // Method used to obtain data from CSV file
    public static void csvReader(Pokedex<String, Pokemon> pokedex)
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

                pokedex.addPokemon(p.getName(), p);
            }

        } catch (Exception e) {throw new RuntimeException(e);}
    }
}