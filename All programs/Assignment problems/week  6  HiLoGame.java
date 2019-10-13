import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class HiLoGame {

	public static void main(String[] args) {
		
		try {
			final int CARD_NUMBERS = 13;
			final int REQUIREMENT = 4;
			final int JACK = 11;
			final int QUEEN = 12;
			final int KING = 13;
			final int ACE = 14;
			final int LOWEST_NUMBER = 2;
			final int HIGHEST_NUMBER = 9;
			final int FIRST_TIME = 0;
			
			String guess = "";
			String input = "";
			Scanner inputScanner = new Scanner(input);
			Random rand = new Random();
			int successfulTimes = 0;
			int guessTimes = 0;
			int lastCard = 0;
			boolean lose = false;
			boolean valid = true;
			
			do {
				int card = rand.nextInt(CARD_NUMBERS) + LOWEST_NUMBER;
				if (card >= LOWEST_NUMBER && card <= HIGHEST_NUMBER) {
					JOptionPane.showMessageDialog(null, "The card is a "+ card + ".");
				}
				else if (card == ACE){
					JOptionPane.showMessageDialog(null, "The card is a Ace.");
				}
				else if (card == JACK){
					JOptionPane.showMessageDialog(null, "The card is a Jack.");
				}
				else if (card == QUEEN){
					JOptionPane.showMessageDialog(null, "The card is a Queen.");
				}
				else if (card == KING){
					JOptionPane.showMessageDialog(null, "The card is a King.");
				}
				
				if (guessTimes != FIRST_TIME) {
					if ((guess.equals("higher") && (card > lastCard)) ||
						(guess.equals("lower") && (card < lastCard)) ||
						(guess.equals("equal") && (card == lastCard))) {
						successfulTimes++;
					}
					else {
						lose = true;
					}
				}
				
				if (!lose && (successfulTimes < REQUIREMENT)) {
					lastCard = card;
					input = JOptionPane.showInputDialog("Do you think the next card will be higher, lower or equal? ");
					inputScanner = new Scanner(input);
					guess = inputScanner.next();
					if (!guess.equals("higher") && !guess.equals("lower") && !guess.equals("equal")) {
						valid = false;
						lose = true;
					}
					guessTimes++;
				}
				inputScanner.close();
				
			} while (successfulTimes < REQUIREMENT && !lose);
			
			if (successfulTimes == REQUIREMENT) {
				JOptionPane.showMessageDialog(null, "Congratulations.  You got them all correct.");
			}
			else if (valid) {
				JOptionPane.showMessageDialog(null, "Try it next time.");
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid input. Good Bye.");
			}
		}
		catch (NoSuchElementException exception) {
			JOptionPane.showMessageDialog(null, "Invalid input. Good Bye.");
		}
		catch (NullPointerException exception) {
			JOptionPane.showMessageDialog(null, "You exit the game");
		}

	}

}
