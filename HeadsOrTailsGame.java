
/**
 * Justin Baraniuk
 * October 14, 2018
 * 2 player coin toss game.
 * Players randomly guess coin side up.
 * First player to 3 wins.
 */
import java.util.Scanner;
import java.util.ArrayList;
public class HeadsOrTailsGame
{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList <Player> players = new ArrayList<>();
        Coin coin = new Coin();
        
        // Create first player
        System.out.print("Enter the first player's name: ");
        Player first = new Player(keyboard.next());       
        
        // Create second player
        System.out.print("Enter the second player's name: ");
        Player second = new Player(keyboard.next());
       
        // Add players to the players list
        players.add(first);
        players.add(second);

        int round = 0;

        boolean gameOver = false;
        // Create Player winner object that will hold the winning player's values
        Player winner = new Player();

        while (!gameOver) {
            // Display round
            round++;
            System.out.println("\n------------------------------");
            System.out.println("\nRound " + round + " Start!");
            System.out.println("\n------------------------------\n");

            // Players take turns guessing
            for (Player p: players)
                System.out.println(p.guess());

            // Random coin toss
            String sideUp = coin.toss();        

            // Check player guessing against sideUp value;
            for (Player p: players) {
                if (p.getGuess() == sideUp) {                
                    System.out.println(p.getName() + " guessed correctly.");
                    p.gainPoint();
                    if (p.getPoints() == 3) {
                    	
                    	// Game over
                        gameOver = true;
                        
                        // Set the winning player to the Player winner object
                        winner = p;
                    }
                }
                else {
                    System.out.println(p.getName() + " guessed incorrectly.");
                    p.losePoint();
                }
            }

            // Display player points
            for (Player p: players) {
                System.out.println(p + " has " + p.getPoints() 
                    + " point(s).");
            }  
        }
        
        // Display winner
        System.out.println("\n------------------------------");
        System.out.println("\nGame Over");
        System.out.println(winner + " is the winner!");
        System.out.println("\n------------------------------\n");

    }
}
