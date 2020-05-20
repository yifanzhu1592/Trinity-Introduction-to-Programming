import java.util.Scanner;

public class TestResizableCircle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean valid = true;
		double radius = 0;
		int percent = 0;

		System.out.print("Please enter the radius of the circle: ");
		do {
			if (input.hasNextDouble()) {
				radius = input.nextDouble();
				if (radius <= 0) {
					System.err.print("Please enter a number larger than 0: ");
					input.nextLine();
					valid = false;
				} else {
					valid = true;
				}
			} else {
				System.err.print("Please enter a number: ");
				input.next();
				input.nextLine();
				valid = false;
			}
		} while (!valid);

		System.out.print("Please enter the percentage reduction: ");
		do {
			if (input.hasNextInt()) {
				percent = input.nextInt();
				if (percent >= 100) {
					System.err.print("Please enter an integer smaller than 100: ");
					input.nextLine();
					valid = false;
				} else {
					valid = true;
				}
			} else {
				System.err.print("Please enter an integer: ");
				input.next();
				input.nextLine();
				valid = false;
			}
		} while (!valid);

		ResizableCircle circle = new ResizableCircle(radius);
		circle.resize(percent);
		System.out.printf("Perimeter of the resized circle is %.2f\nArea of the resized circle is %.2f",
				circle.getPerimeter(), circle.getArea());
	}

}
