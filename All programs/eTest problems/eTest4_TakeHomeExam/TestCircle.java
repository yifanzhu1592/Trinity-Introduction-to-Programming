import java.util.Scanner;

public class TestCircle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean valid = true;
		double radius = 0;

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

		Circle circle = new Circle(radius);
		System.out.printf("Perimeter of the circle is %.2f\nArea of the circle is %.2f", circle.getPerimeter(),
				circle.getArea());
	}

}
