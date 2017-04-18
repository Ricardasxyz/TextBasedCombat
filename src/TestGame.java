import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class TestGame {

    public static void main(String[] args) {

        // System Objects
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // Game Variables
        String[] enemies = { "Black-goku", "Zamasu", "Evil-Buu", "Cell",
                "Freeza" };
        int maxenemyhealth = 100;
        int enemyattackdamage = 25;

        // player variables
        int health = 100;
        int attackdamage = 50;
        int senzubeans = 3;
        int senzubeansHealAmount = 40;
        int healthpotiondropchance = 50; // percentage

        boolean running = true;

        System.out.println("Welcome to the Survival Arena!");

        GAME: while (running) {
            System.out.println("----------------------------------");

            int enemyHealth = rand.nextInt(maxenemyhealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while(enemyHealth > 0){
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack.");
                System.out.println("\t2. Use Senzu Bean.");
                System.out.println("\t4. Fire Kamehameha attack!");
                System.out.println("\t3. Run!");

                String input = scanner.nextLine();

                if(input.equals("1")){
                    int damageDealt = rand.nextInt(attackdamage);
                    int damageTaken = rand.nextInt(enemyattackdamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You punch the " + enemy + " for " + damageDealt + " damage");
                    System.out.println("\t> You got hit by the " + enemy + " for " + damageTaken + " damage!" );
                    if (health < 0) {
                        System.out.println("You have taken too much damage, this world got destroyed by " + enemy + "...");
                        break;
                    }
                }
                else if(input.equals("2")){

                if(senzubeans > 0){
                    health += senzubeansHealAmount;
                    senzubeans--;
                    System.out.println("\t> You have used a Senzu bean, healing yourself by " + senzubeansHealAmount + "."
                            + "\n\t> You now have " + health + " HP."
                            + "\n\t> You have " + senzubeans + " senzu beans left");

                }
                else{
                    System.out.println(" You have no Senzu beans left! Defeat enemies to get more! ");
                }

                }
                else if(input.equals("3")){
                    System.out.println("You ran away from the " + enemy + " enemy.");
                    continue GAME;
                }
                else{
                    System.out.println("\tInvalid command ;-)");
                }


            }
            if(health < 1) {
                System.out.println("You limp out of the arena, weak from battle. ");
                break;
            }

            System.out.println("-------------------------------------");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + health + " HP left. #");

            if (rand.nextInt(100) < healthpotiondropchance) {
                senzubeans++;
                System.out.println(" # " + enemy + " dropped the Senzu Bean! # ");
                System.out.println(" # You now have: " + senzubeans + " senzu beans. #");

            }
            System.out.println("-------------------");
            System.out.println(" What would you like to do? ");
            System.out.println("1. Continue Fighting? ");
            System.out.println("2. Quit fighting?...");

            String in = scanner.nextLine();

            while(!in.equals("1") && !in.equals("2")){
                System.out.println("invalid command!");
                in = scanner.nextLine();
            }
            if(in.equals("1")){
                System.out.println(" You continue fighting, man. Great choice! ");
            }
            else if(in.equals("2")){
                System.out.println(" You have defeated the BAD GUYS! Thanks! ");
                break;
            }
        }
        System.out.println("###################");
        System.out.println("# Thanks for playing!# ");
        System.out.println("###################");
    }
}