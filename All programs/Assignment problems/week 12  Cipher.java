/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5: 5
        Comment: I used easy-to-understand meaningful variable names formatted properly

 2. Did I indent the code appropriately?

        Mark out of 5: 5
        Comment:   I indented the code appropriately

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20: 20
        Comment:  I wrote the createCipher function correctly and invoke it correctly

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  20
        Comment: I wrote the encrypt function correctly and invoke it correctly

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  20
        Comment: I wrote the decrypt function correctly and invoke it correctly

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

       Mark out of 25:  25
        Comment: I wrote the main function body correctly

 7. How well did I complete this self-assessment?

        Mark out of 5: 5
        Comment: I completed this self-assessment

 Total Mark out of 100 (Add all the previous marks): 100

*/ 

import java.util.Random;
import java.util.Scanner;

public class Cipher {
	
	final static int NUMBER_OF_ELEMENTS = 27;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		char[] cipher = new char[NUMBER_OF_ELEMENTS];
		createCipher(cipher);
		
		boolean end = false;
		
		do {
			System.out.print("Enter the plain text: ");
			String plain = input.nextLine().toLowerCase();
			char[] plainText = plain.toCharArray();
			
			System.out.println();
			
			char[] encrypt = encrypt(plainText, cipher);
			System.out.print("The encrypted phrase is ");
			for (int index = 0; index < encrypt.length; index++) {
				System.out.print(encrypt[index]);
			}
			
			System.out.println("\n");
			
			char[] decrypt = decrypt(encrypt, cipher);
			System.out.print("The decrypted phrase is ");
			for (int index = 0; index < decrypt.length; index++) {
				System.out.print(decrypt[index]);
			}
			
			System.out.println("\n");
			
			System.out.print("Do you want to continue? ");
			if (input.hasNext("yes")) {
				input.next();
				input.nextLine();
				end = false;
			}
			else {
				end = true;
			}
		} while (!end);
	}
	
	public static void createCipher(char[] cipher) {
		Random rand = new Random();
		
		int index = rand.nextInt(NUMBER_OF_ELEMENTS);
		cipher[index] = ' ';
		for (char character = 'a'; character <= 'z'; character++) {
			do {
				index = rand.nextInt(NUMBER_OF_ELEMENTS);
			} while (cipher[index] != 0);
			cipher[index] = character;
		}
	}
	
	public static char[] encrypt(char[] plainText, char[] cipher) {
		char[] encrypted = new char[plainText.length];
		
		for (int index = 0; index < plainText.length; index++) {
			if (plainText[index] != ' ') {
				int newIndex = plainText[index] - 'a';
				encrypted[index] = cipher[newIndex];
			}
			else {
				encrypted[index] = cipher[NUMBER_OF_ELEMENTS - 1];
			}
		}
		
		return encrypted;
	}
	
	public static char[] decrypt(char[] encrypted, char[] cipher) {
		char[] plainText = new char[encrypted.length];
		
		for (int index = 0; index < encrypted.length; index++) {
			for (int newIndex = 0; newIndex < cipher.length; newIndex++) {
				if (cipher[newIndex] == encrypted[index]) {
					if (newIndex != NUMBER_OF_ELEMENTS - 1) {
						plainText[index] = (char) (newIndex + 'a');
					}
					else {
						plainText[index] = ' ';
					}
				}
			}
		}
		
		return plainText;
	}
	
}
