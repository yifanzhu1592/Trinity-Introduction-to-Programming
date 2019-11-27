import java.util.Scanner;

public class DigitFrequencies {
	
	public static void main(String[] args) {
		
		final int NUMBER_OF_DIGITS = 10;
		
		Scanner input = new Scanner(System.in);
		
		int[] frequencies = new int[NUMBER_OF_DIGITS];
		for (int index = 0; index < frequencies.length; index++) {
			frequencies[index] = 0;
		}
		
		System.out.print("Enter a number> ");
		while (!input.hasNext("quit")) {
			if (input.hasNextInt()) {
				countDigitFrequencies(input.nextInt(), frequencies);
				System.out.print("Digit frequencies: ");
				printDigitFrequencies(frequencies);
				System.out.print("\nEnter a number> ");
			}
			else {
				input.next();
				input.nextLine();
				System.err.println("Enter a number!!!!");
				System.out.print("Enter a number> ");
			}
		}
	}
	
	static void countDigitFrequencies(int number, int[] frequencies) {
		if (frequencies != null) {
			while (number != 0) {
				int digit = number % 10;
				frequencies[digit]++;
				number = number / 10;
			}
		}
	}
	
	static void printDigitFrequencies(int[] frequencies) {
		if (frequencies != null) {
			for (int index = 0; index < frequencies.length; index++) {
				if (frequencies[index] != 0) {
					System.out.print(" " + index + "(" + frequencies[index] + ")");
				}
			}
			System.out.println();
		}
	}
	
}
