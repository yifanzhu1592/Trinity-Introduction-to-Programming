/* SELF ASSESSMENT
   1. Did I use appropriate easy-to-understand, meaningful variables and CONSTANTS within the code? 
       Mark out of 10: 10
       Comment: Yes, I did.
   2. Did I format the variable and CONSTANT names appropriate (in lowerCamelCase and UPPERCASE)?
       Mark out of 5: 5
       Comment: Yes, I did.
   3. Did I generate the computer's choice in each game correctly using a Random number generator?
       Mark out of 10: 10
       Comment: Yes, I did.
   4. Did I input the user's choice in each game correctly?
       Mark out of 10: 10
       Comment: Yes, I did.
   5. Did I correctly compare the choices and update the score appropriately?
       Mark out of 20: 20
       Comment: Yes, I did.
   6. Did I inform the user of who won each game (and why) correctly?
       Mark out of 10: 10
       Comment: Yes, I did.
   7. Did I use an appropriate for loop to allow the player to play 5 games?  There should be only one loop.
       Mark out of 20: 20
       Comment: Yes, I did.
   8. Did I output the final scores correctly after the 5 games were played. 
       Mark out of 10: 10
       Comment: Yes, I did.
   9. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: Yes, I did.
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		
		final int NUMBER_OF_TIMES = 5;
		final int NUMBER_OF_CHOICES = 3;
		final int ROCK = 1;
		final int PAPER = 2;
		final int SCISSORS = 3;
		
		Scanner input = new Scanner(System.in);
		int computerScore = 0;
		int userScore = 0;
		
		for (int times = 0; times < NUMBER_OF_TIMES; times++) {
			System.out.print("Enter 1 (for Rock) or 2 (for Paper) or 3 (for Scissors): ");
			int userChoice = input.nextInt();
			Random rand = new Random();
			int computerChoice = rand.nextInt(NUMBER_OF_CHOICES) + 1;
			
			if (userChoice == computerChoice) {
				System.out.println("This round was a draw as I chose " + computerChoice + " too");
			}
			else if ((userChoice == ROCK && computerChoice == SCISSORS)
				  || (userChoice == PAPER && computerChoice == ROCK)
				  || (userChoice == SCISSORS && computerChoice == PAPER)) {
				System.out.println("You won this round as I chose " + computerChoice);
				userScore++;
			}
			else {
				System.out.println("You lost this round as I chose " + computerChoice);
				computerScore++;
			}
		}
		
		System.out.println("The final score was Computer: " + computerScore + " User: " + userScore);
		
		input.close();
	}

}
