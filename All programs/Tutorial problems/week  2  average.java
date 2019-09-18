// Write a program which takes in 3 numbers and computes their average
// and standard deviation.


import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    double num1 = 0;
    double num2 = 0;
    double num3 = 0;
    int NUMBER_OF_INPUT = 3;
    Scanner input = new Scanner(System.in);
    
    System.out.print("Please enter your first number:");
    num1 = input.nextDouble();
    System.out.print("Please enter your second number:");
    num2 = input.nextDouble();
    System.out.print("Please enter your third number:");
    num3 = input.nextDouble();

    double average = (num1 + num2 + num3) / NUMBER_OF_INPUT;
    double numerator = Math.pow(num1 - average, 2)
                     + Math.pow(num2 - average, 2)
                     + Math.pow(num3 - average, 2);
    double standardDeviation = Math.pow(numerator / NUMBER_OF_INPUT, 0.5);

    System.out.println("The average of these 3 numbers are: " + average);
    System.out.format("The standardDeviation of these 3 numbers are: %.2f",
                      standardDeviation);
  }
}
