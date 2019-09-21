/*  SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 10:	10
       Comment: Yes, I did.
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5:  5
       Comment: Yes, I did.
    3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:  5
       Comment: Yes, I did.
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:  10
       Comment: Yes, I did.
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10:  10
       Comment: Yes, I did.
   6. Did I indent the code appropriately?
       Mark out of 10:  10
       Comment: Yes, I did.
   7. Did I read the input correctly from the user using appropriate question(s)?
       Mark out of 10:  10
       Comment: Yes, I did.
   8. Did I compute the disposable income correctly?
       Mark out of 10:  10
       Comment: Yes, I did.
   9. Did I compute the disposable income percentage correctly?
       Mark out of 10:  10
       Comment: Yes, I did.
   10. Did I output the correct answer in the correct format (as shown in the examples)?
       Mark out of 10:  10
       Comment: Yes, I did.
   11. How well did I complete this self-assessment?
       Mark out of 10:  10
       Comment: Yes, I did.
   Total Mark out of 100 (Add all the previous marks):  100
*/

import java.util.Scanner;

public class DisposableIncome {
  public static void main(String[] args) {
	  
    final double TAX_RATE = 0.35;
    
    Scanner inputScanner = new Scanner(System.in);
    System.out.print("How much are you paid a month before tax? ");
    double income = inputScanner.nextDouble();
    double afterTaxIncome = income * (1 - TAX_RATE);
    System.out.print("How much do you pay in rent/mortgage a month? ");
    double accommodationCosts = inputScanner.nextDouble();
    System.out.print("How much does your commute cost a month? ");
    double travelCosts = inputScanner.nextDouble();
    System.out.print("How much do you spend on food per month? ");
    double foodCosts = inputScanner.nextDouble();
    
    double disposableIncome = afterTaxIncome - accommodationCosts - travelCosts - foodCosts;
    long percentageOfDisposableIncome = Math.round(disposableIncome / income * 100);
    System.out.format("Your monthly disposable income is €%.2f which is %d%% of your salary.",
                      disposableIncome, percentageOfDisposableIncome);
    
    inputScanner.close();
  }
}
