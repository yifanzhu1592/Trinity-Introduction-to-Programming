import java.util.Scanner;
import javax.swing.JOptionPane;


public class MinMax {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter your list of numbers separated by spaces:");
		Scanner numberScanner = new Scanner( input );
		if (numberScanner.hasNextDouble())
		{
			double currentNumber = numberScanner.nextDouble();
			double minimumNumber = currentNumber;
			double maximumNumber = currentNumber;
			while (numberScanner.hasNextDouble())
			{
				currentNumber = numberScanner.nextDouble();
				if (currentNumber < minimumNumber)
					minimumNumber = currentNumber;
				if (currentNumber > maximumNumber)
					maximumNumber = currentNumber;
			}
			JOptionPane.showMessageDialog(null, "The numbers you entered are between " +
					minimumNumber + " and " + maximumNumber );
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No numbers provided.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
