import java.util.Scanner;

public class Week6eTest2016 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean end = false;
		
		while (!end) {
			System.out.print("Enter the coefficients of your second order polynomial separated by spaces (or enter quit): ");
			
			if (input.hasNextDouble()) {
				double a = input.nextDouble();
				
				if (input.hasNextDouble()) {
					double b = input.nextDouble();
					
					if (input.hasNextDouble()) {
						double c = input.nextDouble();
						
						double x1 = 0;
						double x2 = 0;
						
						if (b * b - 4 * a * c > 0) {
							x1 = (-b + Math.sqrt(b * b - 4 * a *c)) / (2 * a);
							x2 = (-b - Math.sqrt(b * b - 4 * a *c)) / (2 * a);
							System.out.println("The roots to this equation are x=" + x1 + " and x=" + x2);
						}
						else if (b * b - 4 * a * c == 0) {
							x1 = -b / (2 * a);
							System.out.println("The roots to this equation is x=" + x1);
						}
						else {
							System.out.println("This equation has no roots.");
						}
					}
					else {
						System.err.println("Enter numbers!");
						input.nextLine();
					}
					
				}
				else {
					System.err.println("Enter numbers!");
					input.nextLine();
				}
				
			}
			else if (input.next().equals("quit")) {
				end = true;
			}
			else {
				System.err.println("Enter numbers!");
				input.nextLine();
			}
			
		}

	}

}
