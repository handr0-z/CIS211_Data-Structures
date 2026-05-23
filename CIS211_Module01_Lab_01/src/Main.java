/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURITA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          JANUARY 14, 2026
PROJECT:       MODULE 1 - LAB 1 JAVA REVIEW
NOTES:         CLASSES & OBJECTS - PROGRAM CREATED TO HELP UNDERSTAND INHERITANCE AND POLYMORPHISM.

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
=====================================================================================================
*/

import java.sql.SQLOutput;
import java.util.Scanner;

static Scanner input = new Scanner(System.in);

void main()
{
    // Declare any classes needed for program.
    Pokemon[] roster =
            {
                    new Pokemon("Bulbasaur", 45, 49,39),
                    new Pokemon("Charmander", 39, 52,33),
                    new Pokemon("Squirtle", 44, 43,45),
            };

    // Declare any variables needed for program.
    String menuSelect;
    int playerSelection = 0;
    int enemySelection = 0;
    boolean proceed = false;
    boolean loopProgram = false;

    do {
        // Display Program Banner
        programBanner();

        // Display Welcome message.
        System.out.println("Hello Trainer, Choose a POKEMON from the list below to use in battle.");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Display restaurant menu to user.
        System.out.println("POKEMON SELECTION:");
        displayMenu(roster);
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Prompt user to order an item from the menu.
        playerSelection = menuSelect(roster);
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Select POKEMON for enemy to use.
        if (playerSelection == 0) {enemySelection = 1;}
        else if (playerSelection == 1) {enemySelection = 2;}
        else {enemySelection = 0;}

        // POKEMON BATTLE!
        System.out.println("BATTLE START!");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Trainer sends out " + roster[playerSelection].getName() + "!\n");
        System.out.println("Opponent sends out " + roster[enemySelection].getName() + "!");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        battle(roster, playerSelection, enemySelection);


        // Ask if user would like to order again.
        do {
            System.out.print("Would you like to run program again? (Yes/ No) ");
            menuSelect = input.next();

            if (menuSelect.equals("Yes")) {
                loopProgram = true;
                proceed = true;
                System.out.println("-----------------------------------------------------------------------------------------------------");
            }
            else if (menuSelect.equals("No")) {
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("Ending program.");
                loopProgram = false;
                proceed = true;
            } else {
                System.out.println("\nError! Invalid input detected.");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                proceed = false;
            }
        } while (proceed == false);

        // Reset any variables needed for new order.
        playerSelection = 0;
        enemySelection = 0;

    }while (loopProgram == true);
}

// Method used to display program banner;
public static void programBanner()
{
    // Program Banner
    System.out.println("-----------------------------------------------------------------------------------------------------");
    System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
    System.out.println("                                    MODULE 1 - LAB 1:  JAVA REVIEW                                   ");
    System.out.println("-----------------------------------------------------------------------------------------------------");
    System.out.println("This program simulates a POKEMON battle using (2) pre-defined POKEMON.");
    System.out.println("-----------------------------------------------------------------------------------------------------");
}

// Method used to display POKEMON available.
public static void displayMenu(Pokemon[] roster)
{
    System.out.println("POKEMON AVAILABLE:");
    for (int i = 0; i < roster.length; i++) {System.out.println((i + 1) + ") " + roster[i].getName());}
}

// Method used to POKEMON selection.
public static int menuSelect(Pokemon[] roster)
{
    int menuOption = 0;

    do {
        System.out.print("Enter option to select a POKEMON: ");

        // Trap to ensure valid input is used.
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

        if (menuOption <= 0 || menuOption > roster.length)
        {
            System.out.println("\nError! Invalid input detected.");
            System.out.println("-----------------------------------------------------------------------------------------------------");
        }

    } while (menuOption <= 0 || menuOption > roster.length);

    return menuOption - 1;
}

// Method used to display POKEMON battle information.
public static void battle(Pokemon[] roster, int user, int enemy)
{
    int round = 1;
    // look to simulate turns in POKEMON Battle.
    do {
        // Decide who attacks first.
        Random random = new Random();
        int result = random.nextInt(2);
        double damage = 0;

        System.out.println("ROUND #" + round + ":\n");

        if (result == 0) {
            // User attack
            damage = (roster[user].getAttackPoints() - roster[enemy].getDefensePoints()) / 2;
            roster[enemy].setHealthPoints(roster[enemy].getHealthPoints() - damage);

            System.out.println(roster[user].getName() + " attacks " + roster[enemy].getName() + "!");
            System.out.println(roster[enemy].getName() + " takes " + damage + " points of damage.\n");
            System.out.println(roster[enemy].getName() + " HP: " + roster[enemy].getHealthPoints());

            // Notify user if battle is over.
            if (roster[enemy].getHealthPoints() == 0)
            {
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println(roster[enemy].getName() + " has fainted!");
                System.out.println("YOU WIN!");
                break;
            }

            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Enemy attack
            damage = (roster[enemy].getAttackPoints() - roster[user].getDefensePoints()) / 2;
            roster[user].setHealthPoints(roster[user].getHealthPoints() - damage);

            System.out.println(roster[enemy].getName() + " attacks " + roster[user].getName() + "!");
            System.out.println(roster[user].getName() + " takes " + damage + " points of damage.\n");
            System.out.println(roster[user].getName() + " HP: " + roster[user].getHealthPoints());

            // Notify user if battle is over.
            if (roster[user].getHealthPoints() == 0)
            {
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println(roster[user].getName() + " has fainted!");
                System.out.println("YOU LOOSE!");
                break;
            }

        } else {
            // Enemy attack
            damage = (roster[enemy].getAttackPoints() - roster[user].getDefensePoints()) / 2;
            roster[user].setHealthPoints(roster[user].getHealthPoints() - damage);

            System.out.println(roster[enemy].getName() + " attacks " + roster[user].getName() + "!");
            System.out.println(roster[user].getName() + " takes " + damage + " points of damage.\n");
            System.out.println(roster[user].getName() + " HP: " + roster[user].getHealthPoints());

            // Notify user if battle is over.
            if (roster[user].getHealthPoints() == 0)
            {
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println(roster[user].getName() + " has fainted!");
                System.out.println("YOU LOOSE!");
                break;
            }

            System.out.println("-----------------------------------------------------------------------------------------------------");

            // User attack
            damage = (roster[user].getAttackPoints() - roster[enemy].getDefensePoints()) / 2;
            roster[enemy].setHealthPoints(roster[enemy].getHealthPoints() - damage);

            System.out.println(roster[user].getName() + " attacks " + roster[enemy].getName() + "!");
            System.out.println(roster[enemy].getName() + " takes " + damage + " points of damage.\n");
            System.out.println(roster[enemy].getName() + " HP: " + roster[enemy].getHealthPoints());

            // Notify user if battle is over.
            if (roster[enemy].getHealthPoints() == 0)
            {
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println(roster[enemy].getName() + " has fainted!");
                System.out.println("YOU WIN!");
                break;
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("ROUND RESULTS:\n");
        System.out.println(roster[user].getName() + " HP: " + roster[user].getHealthPoints());
        System.out.println(roster[enemy].getName() + " HP: " + roster[enemy].getHealthPoints());
        System.out.println("-----------------------------------------------------------------------------------------------------");
        round++;
    } while (roster[user].getHealthPoints() > 0 || roster[enemy].getHealthPoints() > 0);

}
