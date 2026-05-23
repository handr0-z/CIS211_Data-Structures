/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURITA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          FEBRUARY 10, 2026
PROJECT:       MODULE 3 - ASSIGNMENT 1: LINKED STACK - POKEMON BATTLE
NOTES:         PROGRAM CREATED TO BECOME FAMILIAR WITH LINKED STACK AS A DATA STRUCTURE.

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
=====================================================================================================
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        // List to store data from CSV file of all Pokémon.
        Pokemon[] pokedex = new Pokemon[800];

        // Lists to store data of each trainer for battle.
        LinkedStack<Pokemon> trainer1 = new LinkedStack<>();
        LinkedStack<Pokemon> trainer2 = new LinkedStack<>();

        // Variable to control the total number of battles.
        int totalRounds = 15;

        // Obtain data from csv File.
        csvReader(pokedex);

        // Populate trainer rosters from pokedex list
        pokemonSelector(pokedex, trainer1, totalRounds);
        pokemonSelector(pokedex, trainer2, totalRounds);

        // Program Banner.
        programBanner(totalRounds);

        // Simulate Pokemon Battle.
        battle(trainer1, trainer2, totalRounds);
    }

    // Method used to display program banner;
    public static void programBanner(int rounds)
    {
        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                    MODULE 3 - ASSIGNMENT 1:  LINKED STACK - POKEMON CARD BATTLE                     ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program simulates a Pokemon battle between (2) trainers, each trainer gets random Pokemon to use");
        System.out.println("in battle with for (" + rounds + ") rounds. At the end the winner is decided based on the number of ");
        System.out.println("rounds won.");
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
    public static void pokemonSelector(Pokemon[] pokedex, LinkedStack<Pokemon> trainer, int rounds)
    {
        for (int i = 0; i <rounds; i++)
        {
            // Decide which Pokémon to add to roster randomly
            Random random = new Random();
            int result = random.nextInt(pokedex.length - 1);

            // Add Pokémon to trainer roster.
            trainer.push(pokedex[result]);
        }
    }

    // Method used to simulate Pokémon Battle
    public static void battle(LinkedStack<Pokemon> trainer1, LinkedStack<Pokemon> trainer2, int rounds)
    {
        // Variables needed
        int t1Score = 0;
        int t2Score = 0;
        int draw = 0;

        System.out.println("BATTLE START!");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        for (int i = 0; i < rounds; i++)
        {
            // Variables needed
            int results = 0;

            Pokemon t1Pokemon = trainer1.pop(); // Pokémon of trainer 1.
            Pokemon t2Pokemon = trainer2.pop(); // Pokémon of trainer 2.

            System.out.println("ROUND #" + (i+1) + "\t\tTRAINER 1\t\t\t\t\tVS.\t\tTRAINER 2");
            System.out.println("NAME:\t\t\t" + t1Pokemon.getName() + getSeparation(t1Pokemon.getName().length())+ t2Pokemon.getName());
            System.out.println("ATTACK:\t\t\t" + t1Pokemon.getAttack() + "\t\t\t\t\t\t\t\t\t" + t2Pokemon.getAttack());
            System.out.println("DEFENSE:\t\t"  + t1Pokemon.getDefense() + "\t\t\t\t\t\t\t\t\t" + t2Pokemon.getDefense());
            System.out.println("...");
            results = roundResults(t1Pokemon, t2Pokemon);

            switch (results) {
                case 0:
                    System.out.println("Trainer 1 wins this round.");
                    t1Score++;
                    break;
                case 1:
                    System.out.println("Trainer 2 wins this round.");
                    t2Score++;
                    break;
                case 2:
                    System.out.println("This round ends in a tie.");
                    draw++;
                    break;
            }
            System.out.println("-----------------------------------------------------------------------------------------------------");
        }
        System.out.println("BATTLE END!");
        System.out.println("...");
        if (t1Score > t2Score && t1Score > draw){System.out.println("Trainer 1 is declared the winner with [" + t1Score + "] rounds won!\nTrainer 2 won [" + t2Score + "] rounds.");}
        else if (t2Score > t1Score && t2Score > draw){System.out.println("Trainer 2 is declared the winner with [" + t2Score + "] rounds won!\nTrainer 1 won [" + t1Score + "] rounds.");}
        else System.out.println("The battle has resulted in [" + draw + "] ties.\nTrainer 1 won [" +  t1Score + "] rounds.\nTrainer 2 won [" +  t2Score + "] rounds.");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // For testing purposes the lines below are used to verify the scores at the end of the battle.
        //System.out.println("Trainer 1: " + t1Score);
        //System.out.println("Trainer 2: " + t2Score);
        //System.out.println("Draws: " + draw);
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
        if (t1.getAttack() > t2.getDefense())
        {
            if (t2.getAttack() > t1.getDefense()) {return 2;} // Draw
            return 0; // Trainer 1 wins.
        }

        if (t2.getAttack() > t1.getDefense()) {return 1;} // Trainer 2 wins.

        return 2; // Draw
    }
}
