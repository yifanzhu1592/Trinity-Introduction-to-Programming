/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful,l properly formatted, variable names and CONSTANTS?
        Mark out of 10: 10
        Comment:   I used easy-to-understand meaningful,l properly formatted, variable names and CONSTANTS.
 2. Did I indent the code appropriately?
        Mark out of 5: 5
        Comment:   I indented the code appropriately.
 3. Did I implement the main line correctly with a loop which continues using the user says "no" ?
       Mark out of 10: 10
        Comment:  I implemented the main line correctly with a loop which continues using the user says "no".
 4. Did I obtain the relevant inputs from the user and produce the relevant outputs using the specified prompts & formats ?
       Mark out of 10: 10
        Comment:  I obtained the relevant inputs from the user and produce the relevant outputs using the specified prompts & formats.
 5. Did I implement the readDoubleFromUser function correctly and in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  I implemented the readDoubleFromUser function correctly and in a manner that can be easily understood.
 6. Did I implement the calculateMonthlyRepayment function correctly in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  I implemented the calculateMonthlyRepayment function correctly in a manner that can be easily understood.
 7. Did I implement the calculateMonthsToRepayMortgage function correctly in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  I implemented the calculateMonthsToRepayMortgage function correctly in a manner that can be easily understood.
 8. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment:  I completed this self-assessment carefully.
 Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class MortgageCalculator {
	
	static Scanner input = new Scanner(System.in);
	final static int MONTHS_IN_A_YEAR = 12;
	
	public static void main(String[] args) {
		
		final int DURATION = 20;
		
		boolean use = true;
		
		do {
			System.out.println("Welcome to the mortgage calculator.");
			
			System.out.print("Please enter the mortgage amount:  ");
			double Principal = readDoubleFromUser(input);
			
			System.out.print("Please enter the annual interest rate (APR):  ");
			double APR = readDoubleFromUser(input);
			
			System.out.format("Assuming a 20 year term, the monthly repayments would be %.2f\n",
								calculateMonthRepayment(Principal, DURATION, APR));
			
			System.out.print("How much can you afford to pay per month?  ");
			double paidMonthly = readDoubleFromUser(input);
			
			int month = calculateMonthsToRepayMortgage(Principal, paidMonthly, APR);
			int year = month / MONTHS_IN_A_YEAR;
			month = month - MONTHS_IN_A_YEAR * year;
			System.out.println("If you pay " + paidMonthly + " per month your mortgage would be paid off in " 
								+ year + " years and " + month + " months.");
			System.out.print("Would you like to use the mortgage calculator again (yes/no)?  ");
			while (!(input.hasNext("yes") || input.hasNext("no"))) {
				input.next();
				input.nextLine();
				System.err.print("Please enter yes or no: ");
			}
			if (input.hasNext("yes")) {
				use = true;
				input.next();
				input.nextLine();
			}
			else {
				use = false;
			}
		} while (use);
	}
	
	public static double readDoubleFromUser(Scanner input) {
		try {
			return input.nextDouble();
		}
		catch (InputMismatchException e) {
			System.err.println("Please enter a double number:");
			input.next();
			input.nextLine();
			return readDoubleFromUser(input);
		}
	}
	
	public static double calculateMonthRepayment(double Principal, double DURATION, double APR) {
		
		double repayment = Principal * (APR/MONTHS_IN_A_YEAR/100) / 
							(1 - Math.pow((1+APR/MONTHS_IN_A_YEAR/100),(-DURATION*MONTHS_IN_A_YEAR)));
		
		return repayment;
	}
	
	public static int calculateMonthsToRepayMortgage(double Principal, double paidMonthly, double APR) {
		
		int months = 0;
		final double MPR = APR / MONTHS_IN_A_YEAR;
		
		while (Principal > 0) {
			Principal = Principal * (1+MPR/100);
			Principal = Principal - paidMonthly;
			months++;
		}
		
		return months;
	}
}
