import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		
		final int STANDARD_UPPER_LIMIT = 25;
		final int A_HUNDRED_PERCENT = 100;
		
		double averageBMI = 0;
		int numberOfPeople = 0;
		int numberOfOverweightOrObesePeople = 0;
		boolean finished = false;
		
		Scanner input = new Scanner(System.in);
		
		while (!finished) {
			System.out.print("Enter the person's height in metres (or quit): ");
			if (input.hasNextDouble()) {
				double height = input.nextDouble();
				if (height <= 0) {
					System.err.println("Invalid input! Enter a number that is bigger than 0!");
					input.nextLine();
				}
				else {
					System.out.print("Enter their weight in kilograms: ");
					if (input.hasNextDouble()) {
						double weight = input.nextDouble();
						if (weight <= 0) {
							System.err.println("Invalid input! Enter a number that is bigger than 0!");
							input.nextLine();
						}
						else {
							double BMI = weight / (height * height);
							averageBMI = (averageBMI * numberOfPeople + BMI) / ++numberOfPeople;
							if (BMI > STANDARD_UPPER_LIMIT) {
								numberOfOverweightOrObesePeople++;
							}
							int percentageOfOverweightOrObese = 
									(int) ((double) numberOfOverweightOrObesePeople /
											(double) numberOfPeople * A_HUNDRED_PERCENT);
							System.out.format("The average BMI is %.1f and %d%% of the people are overweight or obese.\n",
									averageBMI, percentageOfOverweightOrObese);
						}
					}
					else {
						System.err.println("Invalid input! Enter a number!");
						input.nextLine();
					}
				}
			}
			else if (input.hasNext("quit")) {
				finished = true;
			}
			else {
				System.err.println("Invalid input! Enter a number!");
				input.nextLine();
			}
		}
		input.close();

	}

}
