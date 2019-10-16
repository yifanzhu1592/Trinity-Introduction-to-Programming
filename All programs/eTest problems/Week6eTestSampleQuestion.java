import java.util.Scanner;

public class Week6eTestSampleQuestion {

	public static void main(String[] args) {

		boolean end = false;
		while (!end) {
			System.out.print("Please enter a number: ");
			Scanner input = new Scanner(System.in);
			if (input.hasNextDouble()) {
				double limit = input.nextDouble();
				if (limit < 1) {
					System.out.println("The number entered should be larger than or equal to 1.");
				}
				else {
					System.out.print("The numbers whose squares are less than or equal to " + limit + " are 0");
					for (int number = 1; number * number <= limit; number++) {
						System.out.print(", " + number);
					}
					System.out.print(".");
					end = true;
				}
			}
			else {
				System.err.println("Invalid input!");
				input.nextLine();
			}
		}

	}

}
