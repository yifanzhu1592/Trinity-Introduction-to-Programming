/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5:  5

 2. Did I indent the code appropriately?

        Mark out of 5: 5

 3. Did I write the initialiseHighScores function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:  15

 4. Did I write the printHighScores function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:  15

 5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:  15

 6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  20

 7. Did I write the main function body correctly (first asking for the number of scores to be maintained and then repeatedly asking for scores)?

       Mark out of 20:  20

 8. How well did I complete this self-assessment?

        Mark out of 5: 5

 Total Mark out of 100 (Add all the previous marks): 100

*/ 

import java.util.Scanner;

public class HighScores {
	
	public static void main(String[] args) {
		System.out.print("How many scores do you want to maintain? ");
		Scanner input = new Scanner(System.in);
		final int NUMBER_OF_SCORES = input.nextInt();
		int[] highScores = new int[NUMBER_OF_SCORES];
		initialiseHighScores(highScores);
		System.out.print("Please enter the score (Enter 'quit' to quit): ");
		while (input.hasNextInt()) {
			int newScore = input.nextInt();
			if (higherThan(highScores, newScore)) {
				insertScore(highScores, newScore);
			}
			printHighScores(highScores);
			System.out.print("Please enter the score: ");
		}
		System.out.println("Bye!");
	}
	
	public static void initialiseHighScores(int[] highScores) {
		for (int index = 0; index < highScores.length; index++) {
			highScores[index] = 0;
		}
	}
	
	public static void printHighScores(int[] highScores) {
		System.out.print("The high scores are ");
		if (highScores[0] > 0) {
			System.out.print(highScores[0]);
			for (int index = 1; index < highScores.length; index++) {
				if (highScores[index] > 0) {
					System.out.print(", " + highScores[index]);
				}
			}
			System.out.println();
		}
	}
	
	public static boolean higherThan(int[] highScores, int newScore) {
		return newScore > highScores[highScores.length - 1];
	}
	
	public static void insertScore(int[] highScores, int newScore) {
		int index = 0;
		while (newScore <= highScores[index]) {
			index++;
		}
		for (int moveIndex = highScores.length - 1; moveIndex > index; moveIndex--) {
			highScores[moveIndex] = highScores[moveIndex - 1];
		}
		highScores[index] = newScore;
	}
	
}
