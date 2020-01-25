/* SELF ASSESSMENT 
   1.  createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment: I used the correct method definition.
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5: 5
Comment: I created an array of size n-1 (passed as the parameter) and initialised it.
Did I return the correct item?
Mark out of 5: 5
Comment: I returned the correct item.
   2.  crossOutMultiples
Did I use the correct method definition?
Mark out of 5: 5
Comment: I used the correct method definition.
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2: 2
Comment: I ensured the parameters are not null and one of them is a valid index into the array
Did I loop through the array using the correct multiple?
Mark out of 5: 5
Comment: I looped through the array using the correct multiple.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3
Comment: I crossed out correct items in the array that were not already crossed out.
   3.  sieve   
Did I have the correct function definition?
Mark out of 5: 5
Comment: I have the correct function definition.
Did I make calls to other methods?
Mark out of 5: 5
Comment: I made calls to other methods.
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 2
Comment: I returned an array with all non-prime numbers are crossed out.
   4.  sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 5
Comment: I have the correct function definition.
Did I ensure the parameter to be used is not null?
Mark out of 3: 3
Comment: I ensured the parameter to be used is not null.
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10: 10
Comment: I Looped through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets.
   5.  nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5: 5
Comment: I have the correct function definition.
Did I ensure the parameter to be used is not null?  
Mark out of 3: 3
Comment: I ensured the parameter to be used is not null.
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5: 5
Comment: I looped through the array updating the String variable with just the non-crossed out numbers.
   6.  main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5: 5
Comments: I asked  the user for input n and handles input errors.
Did I make calls to other methods (at least one)?
Mark out of 5: 5
Comment: I made calls to other methods (at least one).
Did I print the output as shown in the question?  
Mark out of 5: 5
Comment: I printed the output as shown in the question.
   7.  Overall
Is my code indented correctly?
Mark out of 4: 4
Comments: My code is indented correctly
Do my variable names make sense?
Mark out of 4: 4
Comments: My variable names make sense.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments: My variable names, method names and class name follow the Java coding standard.
      Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class SieveOfEratosthenes {
	
	public static boolean[] createSequence(int N) {
		boolean[] sequence = new boolean[N-1];
		for (int i = 0; i < N - 1; i++) {
			sequence[i] = true;
		}
		
		return sequence;
	}
	
	public static void crossOutHigherMultiples(boolean[] sequence, int n) {
		if (sequence != null && n >= 2 && n < sequence.length) {
			for (int i = n - 1; i < sequence.length; i++) {
				if ((i + 2) % n == 0) {
					sequence[i] = false;
				}
			}
		}
	}
	
	public static boolean[] sieve(int N) {
		boolean[] sequence = createSequence(N);
		System.out.println(nonCrossedOutSubseqToString(sequence));
		
		for (int i = 2; i < N; i++) {
			String oldSequence = sequenceToString(sequence);
			crossOutHigherMultiples(sequence, i);
			String newSequence = sequenceToString(sequence);
			if (!oldSequence.equals(newSequence)) {
				System.out.println(sequenceToString(sequence));
			}
		}
		
		System.out.println(nonCrossedOutSubseqToString(sequence));
		
		return sequence;
	}
	
	public static String sequenceToString(boolean[] sequence) {
		String seq = "" + 2;
		
		if (sequence != null) {
			for (int i = 1; i < sequence.length; i++) {
				if (sequence[i]) {
					seq += ", " + (i + 2);
				}
				else {
					seq += ", [" + (i + 2) + "]";
				}
			}
		}
		
		return seq;
	}
	
	public static String nonCrossedOutSubseqToString(boolean[] sequence) {
		String seq = "" + 2;
		
		if (sequence != null) {
			for (int i = 1; i < sequence.length; i++) {
				if (sequence[i]) {
					seq += ", " + (i + 2);
				}
			}
		}
		
		return seq;
	}
	
	public static void main(String[] args) {
		try {
			System.out.print("Enter int >= 2 : ");
			Scanner input = new Scanner(System.in);
			int N = input.nextInt();
			if (N < 2) {
				System.err.println("Not a valid input.");
			}
			else {
				sieve(N);
			}
		}
		catch (InputMismatchException e) {
			System.err.println("Not a valid input.");
		}
	}
	
}
