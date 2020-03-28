/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment: I have correctly defined ResolveBet.
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment: My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet.
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment: My program ensures the bet amount is not greater than the cash in the wallet.
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15]..
Comment: My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned.
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment: My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet.
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment: My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment: I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it.
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment: My program loops continuously until the user either enters quit or the cash in the wallet is 0.
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment: I ask the user to enter any of the four bet types or quit.
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: My program calls resolveBet for each bet type entered.
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment: At the end of the game my program presents a summary message regarding winnings and losses.

 Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;

public class ChuckALuck {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean valid = true;
		boolean again = true;
		double cash = 0;
		System.out.print("How much cash do you have? ");
		do {
			if  (input.hasNextInt()) {
				cash = input.nextDouble();
				if (cash <= 0) {
					System.err.print("Please enter a number larger than 0: ");
					valid = false;
				}
				else {
					valid = true;
				}
			}
			else {
				System.err.print("Please enter a number: ");
				input.next();
				input.nextLine();
				valid = false;
			}
		} while (!valid);
		double initialCash = cash;
		Wallet wallet = new Wallet();
		wallet.put(cash);
		String betType = "";
		do {
			do {
				System.out.print("Please type \"Triple\" \"Field\" \"High\" \"Low\" or \"quit\": ");
				betType = input.next();
				if (betType.equals("Triple") || betType.equals("Field") || betType.equals("High") || betType.equals("Low")) {
					ResolveBet(betType, wallet);
					valid = true;
				}
				else if (betType.equals("quit")){
					System.out.println("See you!");
					again = false;
					valid = true;
				}
				else {
					System.err.println("Invalid input!");
					input.nextLine();
					valid = false;
				}
			} while (!valid);

		} while (again && wallet.check() > 0);
		
		double netIncome = wallet.check() - initialCash;
		System.out.println("You have " + wallet.check() + " now, and your net income is " + netIncome);
	}
	
	public static void ResolveBet(String bet, Wallet wallet) {
		final int PAYOUT_TRIPLE = 30;
		final int PAYOUT_OTHERS = 1;
		
		Scanner input = new Scanner(System.in);
		boolean valid = true;
		double betAmount = 0;
		System.out.print("You have " + wallet.check() + ", how much do you like to bet? ");
		do {
			if  (input.hasNextDouble()) {
				betAmount = input.nextDouble();
				if (betAmount > wallet.check()) {
					System.err.print("Please enter a number you can afford: ");
					valid = false;
				}
				else {
					valid = true;
				}
			}
			else {
				System.err.print("Please enter a number: ");
				input.next();
				input.nextLine();
				valid = false;
			}
		} while (!valid);
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		Dice dice3 = new Dice();
		int summation = dice1.roll() + dice2.roll() + dice3.roll();
		if (bet.equals("Triple")
			&& dice1.topFace() == dice2.topFace() && dice1.topFace() == dice3.topFace()
			&& dice1.topFace() != 1 && dice1.topFace() != 6) {
				System.out.println("You win, you have won " + PAYOUT_TRIPLE * betAmount);
				wallet.put(PAYOUT_TRIPLE * betAmount);
		}
		else if (bet.equals("Field") && (summation < 8 || summation > 12)) {
			System.out.println("You win, you have won " + PAYOUT_OTHERS * betAmount);
			wallet.put(PAYOUT_OTHERS * betAmount);
		}
		else if (bet.equals("High") && summation > 10
				&& !(dice1.topFace() == dice2.topFace() && dice1.topFace() == dice3.topFace())) {
					System.out.println("You win, you have won " + PAYOUT_OTHERS * betAmount);
					wallet.put(PAYOUT_OTHERS * betAmount);
		}
		else if (bet.equals("Low") && summation < 11
				&& !(dice1.topFace() == dice2.topFace() && dice1.topFace() == dice3.topFace())) {
					System.out.println("You win, you have won " + PAYOUT_OTHERS * betAmount);
					wallet.put(PAYOUT_OTHERS * betAmount);
		}
		else {
			System.out.println("You lose, you have lost " + betAmount + "\n");
			wallet.get(betAmount);
		}
	}
	
}
