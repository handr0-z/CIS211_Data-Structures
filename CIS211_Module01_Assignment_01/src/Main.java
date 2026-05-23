/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURITA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          JANUARY 17, 2026
PROJECT:       MODULE 1 - ASSIGNMENT 1 JAVA REVIEW, PARSING CSV
NOTES:         PROGRAM CREATED TO ENSURE I AM FAMILIAR WITH JAVA AND FILE HANDLING.

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
=====================================================================================================
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        // List to store data from CSV file
        Pokemon[] pokedex = new Pokemon[800];

        // Variables
        int menuSelect = 0;
        boolean exit = false;

        // Obtain data from csv File.
        csvReader(pokedex);

        // Program Banner.
        programBanner();

        do {
            // Display Main Menu.
            menuSelect = mainMenu();

            switch (menuSelect) {
                case 0:
                    displayAllPOKEMONs(pokedex);
                    break;
                case 1:
                    searchForPOKEMON(pokedex);
                    break;
                case 2:
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
        System.out.println("                         MODULE 1 - ASSIGNMENT 1:  JAVA REVIEW, CSV PARSING                          ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program can be used as a POKEDEX to allow users to search or find info about a POKEMON.");
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    // Method used to display main menu.
    public static int mainMenu()
    {
        int menuOption = 0;

        do {
            System.out.println("What would you like to do?");

            System.out.println("1) Show all POKEMON Entries");
            System.out.println("2) Search for POKEMON by name");
            System.out.println("3) Exit Program\n");
            System.out.print("Option Selected: ");

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
                    System.out.print("Enter option to select a POKEMON: ");
                    input.next();
                }
            }

            if (menuOption < 1 || menuOption > 3)
            {
                System.out.println("\nError! Invalid input detected.");
                System.out.println("-----------------------------------------------------------------------------------------------------");
            }

        } while (menuOption < 1 || menuOption > 3);

        return menuOption - 1;
    }

    // Method used to search for POKEMON by name.
    public static void searchForPOKEMON(Pokemon[] pokedex)
    {
        // Variables
        String name;
        boolean match = false;

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.print("Enter the name of the POKEMON you would like to search for: ");
        name = input.next();
        System.out.println("-----------------------------------------------------------------------------------------------------");

        for (int i = 0; i < pokedex.length; i++)
        {
            if (name.equals(pokedex[i].getName()))
            {
                System.out.println("ID #: " + pokedex[i].getId());
                System.out.println("Name: " + pokedex[i].getName());
                System.out.println("Type 1: " + pokedex[i].getType1());
                System.out.println("Type 2: " + pokedex[i].getType2());
                System.out.println("Total:  " + pokedex[i].getTotal());
                System.out.println("Health: " + pokedex[i].getHealth());
                System.out.println("Attack: " + pokedex[i].getAttack());
                System.out.println("Defense: " + pokedex[i].getDefense());
                System.out.println("Special Attack: " +  pokedex[i].getSpecialAttack());
                System.out.println("Special Defense: " +  pokedex[i].getSpecialDefense());
                System.out.println("Speed: " + pokedex[i].getSpeed());
                System.out.println("Generation: " + pokedex[i].getGeneration());
                System.out.println("Legendary: " + pokedex[i].isLegendary());
                System.out.println("-----------------------------------------------------------------------------------------------------");
                match = true;
            }

            if (!match && (pokedex.length - 1) == i)
            {
                System.out.println("Error! Pokemon not found in Pokedex.");
                System.out.println("-----------------------------------------------------------------------------------------------------");
            }
        }
    }

    // Method used to obtain data from CSV file
    public static void csvReader(Pokemon[] pokedex)
    {
        // Variables
        String line;
        String csvSplitBy = ",";
        String filePath = "pokemon.csv";
        int i = 0;

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

                pokedex[i] = new Pokemon(id, name, type1, type2, total, health, attack, defense, specialAttack, specialDefense, speed, generation, legendary);

                i++;
            }

        } catch (Exception e) {throw new RuntimeException(e);}
    }

    // Method used to display all Pokémon entries
    public static void displayAllPOKEMONs(Pokemon[] pokedex)
    {
        for (int i = 0; i < pokedex.length; i++)
        {
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("ID #: " + pokedex[i].getId());
            System.out.println("Name: " + pokedex[i].getName());
            System.out.println("Type 1: " + pokedex[i].getType1());
            System.out.println("Type 2: " + pokedex[i].getType2());
            System.out.println("Total:  " + pokedex[i].getTotal());
            System.out.println("Health: " + pokedex[i].getHealth());
            System.out.println("Attack: " + pokedex[i].getAttack());
            System.out.println("Defense: " + pokedex[i].getDefense());
            System.out.println("Special Attack: " +  pokedex[i].getSpecialAttack());
            System.out.println("Special Defense: " +  pokedex[i].getSpecialDefense());
            System.out.println("Speed: " + pokedex[i].getSpeed());
            System.out.println("Generation: " + pokedex[i].getGeneration());
            System.out.println("Legendary: " + pokedex[i].isLegendary());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }
}
