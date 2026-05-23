/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURIsTA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          FEBRUARY 30, 2026
PROJECT:       MODULE 5 - ASSIGNMENT 1: CIRCULAR ARRAY QUEUE
NOTES:         PROGRAM CREATED TO DEMONSTRATE AN UNDERSTANDING OF IMPLEMENTATION OF A CIRCULAR ARRAY
               QUEUE.

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
=====================================================================================================
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // List to store data from CSV file of all Pokémon.
        Pokemon[] pokedex = new Pokemon[800];

        // Lists to store data of each trainer for battle.
        CircularArrayQueue<Pokemon> trainer1 = new CircularArrayQueue<>();
        CircularArrayQueue<Pokemon> trainer2 = new CircularArrayQueue<>();
        int startingDeckSize = 10;

        // Obtain data from csv File.
        csvReader(pokedex);

        // Populate trainer rosters from pokedex list
        pokemonSelector(pokedex, trainer1, startingDeckSize);
        pokemonSelector(pokedex, trainer2, startingDeckSize);

        // Program Banner.
        programBanner();

        // Simulate Pokemon Battle.
        battle(trainer1, trainer2);
    }

    // Method used to display program banner;
    public static void programBanner()
    {
        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                            MODULE 5 - ASSIGNMENT 1:  CIRCULAR ARRAY QUEUE                           ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program simulates a Pokemon battle between (2) trainers, each trainer gets (10) random Pokemon  ");
        System.out.println("cards to use at the start. The trainers use and wager a Pokemon card from their deck each turn. The  ");
        System.out.println("winner of a round gets both cards added to the back of their deck. The game ends when one trainer    ");
        System.out.println("does not have any more cards to play in their deck or after a specified number of rounds.");
        System.out.println("-----------------------------------------------------------------------------------------------------");
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

    // Method used to populate LinkedStack of trainers.
    public static void pokemonSelector(Pokemon[] pokedex, CircularArrayQueue<Pokemon> trainer, int startingDeckSize)
    {
        for (int i = 0; i < startingDeckSize; i++)
        {
            // Decide which Pokémon to add to roster randomly
            Random random = new Random();
            int result = random.nextInt(pokedex.length - 1);

            // Add Pokémon to trainer roster.
            trainer.enqueue(pokedex[result]);
        }
    }

    // Method used to simulate Pokémon Battle
    public static void battle(CircularArrayQueue<Pokemon> trainer1, CircularArrayQueue<Pokemon> trainer2)
    {
        Scanner input = new Scanner(System.in);

        // Variables needed
        int rounds;

        // Prompt user to confirm the number of rounds to be played.
        while(true) // Trap to ensure valid input is obtained from user.
        {
            System.out.println("How many rounds would you like?");
            System.out.print("Desired # of rounds: ");

            if (!input.hasNextInt())
            {
                System.out.println("\nError! Invalid input detected.");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                input.next(); // Clear invalid input.
                continue; // Skip current iteration of loop;
            }

            rounds = input.nextInt();

            if (rounds < 1)
            {
                System.out.println("\nError! Number of rounds must be greater than 0.");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                continue;
            }

            break; // Valid input obtained.
        }

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("BATTLE START!");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        for (int i = 0; i < rounds; i++)
        {
            // Variables needed
            int results = 0;

            Pokemon t1Pokemon = trainer1.dequeue(); // Pokémon of trainer 1.
            Pokemon t2Pokemon = trainer2.dequeue(); // Pokémon of trainer 2.

            System.out.println("ROUND #" + (i+1) + "\t\tTRAINER 1 [" + (trainer1.length() + 1) + "]\t\t\t\tVS.\t\tTRAINER 2 [" + (trainer2.length() + 1) + "]");
            System.out.println("NAME:\t\t\t" + t1Pokemon.getName() + getSeparation(t1Pokemon.getName().length())+ t2Pokemon.getName());
            System.out.println("ATTACK:\t\t\t" + t1Pokemon.getAttack() + "\t\t\t\t\t\t\t\t\t" + t2Pokemon.getAttack());
            System.out.println("DEFENSE:\t\t"  + t1Pokemon.getDefense() + "\t\t\t\t\t\t\t\t\t" + t2Pokemon.getDefense());
            System.out.println("...");
            results = roundResults(t1Pokemon, t2Pokemon);

            switch (results)
            {
                case 0:
                    System.out.println("Trainer 1 wins this round.");
                    trainer1.enqueue(t1Pokemon);
                    trainer1.enqueue(t2Pokemon);
                    break;
                case 1:
                    System.out.println("Trainer 2 wins this round.");
                    trainer2.enqueue(t1Pokemon);
                    trainer2.enqueue(t2Pokemon);
                    break;
            }
            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Check if there are trainer has any cards left to play.
            if (trainer1.isEmpty() || trainer2.isEmpty()) {break;}
        }
        System.out.println("RESULTS:\t\tTRAINER 1 [" + trainer1.length() + "]\t\t\t\tVS.\t\tTRAINER 2 [" + trainer2.length() + "]");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("BATTLE END!");
        System.out.println("...");
        if (trainer2.isEmpty() || (trainer1.length() > trainer2.length())){System.out.println("Trainer 1 wins!");}
        else if (trainer1.length() == trainer2.length()){System.out.println("The match has ended in a draw.");}
        else {System.out.println("Trainer 2 wins!");}
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    // Method to format round information.
    // this code was obtained from https://stackoverflow.com/questions/26576909/how-to-format-string-output-so-that-columns-are-evenly-centered
    public static String getSeparation(int length)
    {
        StringBuilder sb = new StringBuilder();

        // add spaces to match the longest string
        for(int i = 0; i < (32 - length); i++) {sb.append(" ");}
        sb.append("\t"); // add separation tab
        return sb.toString();
    }

    // Method used to determine the winner of the round.
    public static int roundResults(Pokemon t1, Pokemon t2)
    {
        // Determine winner of the round
        if (t1.getAttack() > t2.getDefense()) {return 0;}// Trainer 1 wins.}
        else {return 1;} // Trainer 2 wins.
    }
}


