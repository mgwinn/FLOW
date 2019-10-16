/**
 * This program asks the user to enter a seed and amount of matches
 * to then battle their chosen dragons against each other in a game like rock paper scissors.
 * @author Maddie Gwinn, Michael Krebs
 * @version 20191210
 *
 */
import java.util.Scanner;
import java.util.Random;

public class DragonTrainersTest {

	public static void game(Random seed, Scanner keyboard, int match)   {//method to carry out the tournament after collecting initial data
		int cWin = 0;
		int pWin = 0;
		int tie = 0;
		
		for (int i = 0; i < match; ++i)   {//for loop to run for the amount of matches given
			
			int com = seed.nextInt(3);//rand to create computers choice
			String cChoice = "";

		
			if (com == 0)   {//if statements to give output for computer's choice
				cChoice = "Fire dragon.";
			}
			else if (com == 1)   {
				cChoice = "Plant dragon.";
			}
			else if (com == 2)  {
				cChoice = "Water dragon.";
			}
		
			System.out.print("Please select one of your dragons [Fire/Plant/Water]: ");//statements to create player's choice
			String player = keyboard.nextLine();
			char choice = player.charAt(0);
		
			String pChoice = "";
			int numChoice = 0;
		
			if (choice == 'F' || choice == 'f')  {//if statements to protect againt case differences and assign dragon based on choice
				numChoice = 0;
				pChoice = "Fire dragon.";
			}
			else if (choice == 'P' || choice == 'p')   {
				numChoice = 1;
				pChoice = "Plant dragon.";
			}
			else if (choice == 'W' || choice == 'w')   {
				numChoice = 2;
				pChoice = "Water dragon.";
			}
			else   {
				numChoice = 5;//random number assigned to numChoice to act as default win for computer
				pChoice = "You don't have a " + player + " dragon, so you choose no dragons.";
			}
		
			if (com == 0 && numChoice == 0)   {//if statements to output who won based on the two dragons
				System.out.println("You chose: " +pChoice);
				System.out.println("I chose: " +cChoice);
				
				System.out.println("A Tie!");
				System.out.println("");
				tie = tie + 1;//statements to add to win counters to tally statistics at the end of the tournament
			}
			else if (com == 0 && numChoice == 1)   {
				System.out.println("You chose: " +pChoice);
				System.out.println("I chose: " +cChoice);
				
				System.out.println("Fire defeats Plant - you lose!");
				System.out.println("");
				cWin = cWin + 1;
			}
			else if (com == 0 && numChoice == 2)   {
				System.out.println("You chose: " +pChoice);
				System.out.println("I chose: " +cChoice);
				
				System.out.println("Water defeats Fire - you win!");
				System.out.println("");
				pWin = pWin + 1;
			}
			else if (com == 1 && numChoice == 0)   {
				System.out.println("You chose: " +pChoice);
				System.out.println("I chose: " +cChoice);
				
				System.out.println("Fire defeats Plant - you win!");
				System.out.println("");
				pWin = pWin + 1;
			}
			else if (com == 1 && numChoice == 1)   {
				System.out.println("You chose: " +pChoice);
				System.out.println("I chose: " +cChoice);
				
				System.out.println("A Tie!");
				System.out.println("");
				tie = tie + 1;
			}
			else if (com == 1 && numChoice == 2)   {
				System.out.println("You chose: " +pChoice);
				System.out.println("I chose: " +cChoice);
				
				System.out.println("Plant defeats Water - you lose!");
				System.out.println("");
				cWin = cWin + 1;
			}
			else if (com == 2 && numChoice == 0)   {
				System.out.println("You chose: " +pChoice);
				System.out.println("I chose: " +cChoice);
				
				System.out.println("Water defeats Fire - you lose!");
				System.out.println("");
				cWin = cWin + 1;
			}
			else if (com == 2 && numChoice == 1)   {
				System.out.println("You chose: " +pChoice);
				System.out.println("I chose: " +cChoice);
				
				System.out.println("Plant defeats Water - you win!");
				System.out.println("");
				pWin = pWin + 1;
			}
			else if (com == 2 && numChoice == 2)   {
				System.out.println("You chose: " +pChoice);
				System.out.println("I chose: " +cChoice);
				
				System.out.println("A Tie!");
				System.out.println("");
				tie = tie + 1;
			}
			else if (numChoice == 5)   {
				System.out.println(pChoice);
				System.out.println("I chose: " +cChoice);
				System.out.println("I win by default!");
				System.out.println("");
				cWin = cWin + 1;
			}
		}
		
		System.out.println("The tournament is over!");//final output statements
		System.out.println("We tied " +tie+ " matches.");
		System.out.println("I won " +cWin+ " matches.");
		System.out.println("You won " +pWin+ " matches.");
		
		if (cWin > pWin)   {//output statment of who wins
			System.out.println("I am the winner!");
		}
		else if (pWin > cWin)   {
			System.out.println("You are the winner!");
		}
		else if (cWin == pWin)   {
			System.out.println("Neither of us can claim victory here!");
		}
	}
	
	public static void main(String[] args) {//main method to collect initial data
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a random seed: ");
		int seed = keyboard.nextInt();
		Random rnd = new Random(seed);
		
		System.out.print("How many matches will we play? ");
		int matches = keyboard.nextInt();
		keyboard.nextLine();
		
		game(rnd, keyboard, matches);//method call to run game method
		
		keyboard.close();
	}

}