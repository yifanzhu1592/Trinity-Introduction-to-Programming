import java.util.Scanner;

public class Integers {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int[] integers = null;
		
		System.out.print("Enter an integer to add to the array (or 'quit' to finish): ");
		while (!input.hasNext("quit")) {
			if (input.hasNextInt()) {
				if (integers != null) {
					int[] newIntegers = new int[integers.length + 1];
					for (int index = 0; index < integers.length; index++) {
						newIntegers[index] = integers[index];
					}
					newIntegers[newIntegers.length - 1] = input.nextInt();
					System.out.format("The average value is " + averageValue(newIntegers) + ", and ");
					if (!allIncreasing(newIntegers)) {
						System.out.print("not ");
					}
					System.out.println("all values are increasing.");
					integers = newIntegers;
					System.out.print("Enter an integer to add to the array (or 'quit' to finish): ");
				}
				else {
					integers = new int[1];
					integers[0] = input.nextInt();
					System.out.print("The average value is " + averageValue(integers) + ", and ");
					if (!allIncreasing(integers)) {
						System.out.print("not ");
					}
					System.out.println("all values are increasing.");
					System.out.print("Enter an integer to add to the array (or 'quit' to finish): ");
				}
			}
			else {
				System.err.println("Enter an integer please!");
				input.next();
				input.nextLine();
				System.out.print("Enter an integer to add to the array (or 'quit' to finish): ");
			}
		}
		input.close();
	}
	
	public static double averageValue(int[] integers) {
		if (integers != null) {
			int sum = 0;
			for (int index = 0; index < integers.length; index++) {
				sum += integers[index];
			}
			double average = (double) sum / integers.length;
			
			return average;
		}
		else {
			return 0;
		}
	}
	
	public static boolean allIncreasing(int[] integers) {
		if (integers != null) {
			for (int index = 0; index < integers.length - 1; index++) {
				if (integers[index] >= integers[index + 1]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
