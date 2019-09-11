// Write a program which comput the Body Mass Index (BMI) of a person.
// The BMI is computed by dividing the weight of a person (in kgs) by the square of the height of the person in meters.


import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    double weight = 0, height = 0, BMI;
    Boolean pass;
    Scanner input = new Scanner(System.in);
    
    // get the weight
    do {
      System.out.print("Please enter your weight in kgs: ");
      if (!input.hasNextDouble()) {
        pass = false;
        // using next() and nextLine() to eliminate the wrong inputs
        input.next();
        input.nextLine();
      }
      else {
        pass = true;
        weight = input.nextDouble();
      }
    } while (!pass);
    
    input.nextLine();
    
    // get the height
    do {
      System.out.print("Please enter your height in metres: ");
      if (!input.hasNextDouble()) {
        pass = false;
        // using next() and nextLine() to eliminate the wrong inputs
        input.next();
        input.nextLine();
      }
      else {
        pass = true;
        height = input.nextDouble();
      }
    } while (!pass);
    
    BMI = weight / Math.pow(height, 2);
    
    System.out.format("Your BMI is %.2f\n", BMI);

    input.close();
  }
}
