import java.util.Scanner;

import javax.swing.JOptionPane;

public class ComputePI {

	public static void main(String[] args) {
		
		final int INTEGER = 3;
		final int NUMERATOR = 4;
		final int BEGINNING_MIDDLE_DENOMINATOR = 3;
		final int MIDDLE_DENOMINATOR_CHANGE = 2;
		
		String input = JOptionPane.showInputDialog("How many terms do you want for computing PI?");
		Scanner inputScanner = new Scanner(input);
		int terms = inputScanner.nextInt();
		double PI = 0;
		int times = 0;
		int sign = 1;
		int middleDenominator = BEGINNING_MIDDLE_DENOMINATOR;
		
		while (times < terms) {
			if (times == 0) {
				PI += INTEGER;
			}
			else {
				PI += (double) sign * NUMERATOR / ((middleDenominator - 1)
												 *  middleDenominator
												 * (middleDenominator + 1));
				middleDenominator += MIDDLE_DENOMINATOR_CHANGE;
				sign = -sign;
			}
			times++;
		}
		
		JOptionPane.showMessageDialog(null, "PI is estimated to be " + PI);
	}

}
