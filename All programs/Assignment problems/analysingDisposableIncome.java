/* SELF ASSESSMENT
   1. Did I use easy-to-understand meaningful variable and CONSTANT names? 
       Mark out of 10: 10
       Comment: Yes, I did.
   2. Did I format the variable and CONSTANT names properly (in lowerCamelCase and UPPERCASE_WITH_UNDERSCORES)?
       Mark out of 10: 10
       Comment: Yes, I did.
   3. Did I indent the code appropriately?
       Mark out of 10: 10
       Comment: Yes, I did.
   4. Did I read the input correctly from the user using appropriate questions?
       Mark out of 15: 15
       Comment: Yes, I did.
   5. Did I computer the disposable income and disposable income percentage correctly, and output it in the correct format?
       Mark out of 15: 15
       Comment: Yes, I did.
  6. Did I use an appropriate series of if statements to generate the income analysis to the user?
       Mark out of 25: 25
       Comment: Yes, I did.
   7. Did I provide the correct output for each possibility in an easy to read format?
       Mark out of 10: 10
       Comment: Yes, I did.
   8. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: Yes, I did.
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;

public class DisposableIncome {
  public static void main(String[] args) {

    final double TAX_RATE = 0.35;
    final double AVERAGE_MONTHLY_DISPOSABLE_INCOME = 500;
    final double MUCH_MORE_THAN = 1.5;
    final double MUCH_LESS_THAN = 0.5;

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
    System.out.format("Your monthly disposable income is €%.2f which is %d%% of your salary.\n",
                      disposableIncome, percentageOfDisposableIncome);
    
    if (disposableIncome <= 0) {
      System.out.println("You has no disposable income.");
    }
    else if (disposableIncome > MUCH_MORE_THAN * AVERAGE_MONTHLY_DISPOSABLE_INCOME) {
      System.out.println("Your disposable income is much more than the average.");
    }
    else if (disposableIncome > AVERAGE_MONTHLY_DISPOSABLE_INCOME) {
      System.out.println("Your disposable income is more than the average.");
    }
    else if (disposableIncome < MUCH_LESS_THAN * AVERAGE_MONTHLY_DISPOSABLE_INCOME) {
      System.out.println("Your disposable income is much less than the average.");
    }
    else if (disposableIncome < AVERAGE_MONTHLY_DISPOSABLE_INCOME) {
      System.out.println("Your disposable income is less than the average.");
    }
    else {
      System.out.println("Your disposable income is exactly the average.");
    }

    inputScanner.close();
  }
}
