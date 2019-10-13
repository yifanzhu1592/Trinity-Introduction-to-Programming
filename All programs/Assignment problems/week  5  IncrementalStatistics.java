import java.util.Scanner;

import javax.swing.JOptionPane;

public class IncrementalStatistics {

	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog(
				"This program computes the average and variance of all numbers entered.\n"
				+ "Enter a number (or type 'exit'):");
		Scanner inputScanner = new Scanner(input);
		double previousAverage = 0;
		double previousVariance = 0;
		double average = 0;
		double variance = 0;
		int amountOfNumbers = 0;
		
		while (inputScanner.hasNextDouble() || !inputScanner.next().equals("exit")) {
			if (inputScanner.hasNextDouble()) {
				amountOfNumbers++;
				double number = inputScanner.nextDouble();
				average = previousAverage + (number - previousAverage) / amountOfNumbers;
				variance = ((previousVariance * (amountOfNumbers - 1))
						+ (number - previousAverage) * (number - average)) / amountOfNumbers;
				previousAverage = average;
				previousVariance = variance;
				input = JOptionPane.showInputDialog(String.format("So far the average is %.1f "
						+ "and the variance is %.2f\n"
						+ "Enter another number (or type 'exit'):", average, variance));
				inputScanner = new Scanner(input);
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid input.");
				input = JOptionPane.showInputDialog(String.format("So far the average is %.1f "
						+ "and the variance is %.2f\n"
						+ "Enter another number (or type 'exit'):", average, variance));
				inputScanner = new Scanner(input);
			}
		}
		
		JOptionPane.showMessageDialog(null, "Goodbye.");
		
		inputScanner.close();

	}

}
