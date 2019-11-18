/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5: 5
       Comment: I used appropriate CONSTANTS.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5: 5
       Comment: I used meaningful CONSTANTS names.
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 10: 10
       Comment: I used meaningful variable names.
   4. Did I indent the code appropriately?
       Mark out of 10: 10
       Comment: I indented the code appropriately.
   5. Did I use an appropriate loop (or loops) to produce the different verses?
       Mark out of 20: 20
       Comment: I used appropriate loops to produce the different verses. 
   6. Did I use a switch to build up the verses?
       Mark out of 25: 25
       Comment: I used switches to build up the verses.
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))?
       Mark out of 10: 10
       Comment: I avoided duplication of code and of the lines which make up the verses.
   8. Does the program produce the correct output?
       Mark out of 10: 10
       Comment: The program produced the correct output.
   9. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: I did this self-assessment carefully.
   Total Mark out of 100 (Add all the previous marks): 100
*/

public class TwelveDaysOfChristmas {
	public static void main(String[] args) {
		
		final int AMOUNT_OF_VERSES = 12;
		
		String verse = "";
		
		for (int loopTime = 1; loopTime <= AMOUNT_OF_VERSES; loopTime++) {
			verse = "On the ";
			switch (loopTime) {
			case 1:
				verse += "first";
				break;
			case 2:
				verse += "second";
				break;
			case 3:
				verse += "third";
				break;
			case 4:
				verse += "fourth";
				break;
			case 5:
				verse += "fifth";
				break;
			case 6:
				verse += "sixth";
				break;
			case 7:
				verse += "seventh";
				break;
			case 8:
				verse += "eighth";
				break;
			case 9:
				verse += "ninth";
				break;
			case 10:
				verse += "tenth";
				break;
			case 11:
				verse += "eleventh";
				break;
			case 12:
				verse += "twelfth";
				break;
			default:
				break;
			}
			verse += " day of Christmas\n";
			verse += "my true love sent to me:\n";
			switch (loopTime) {
			case 12:
				verse += "12 drummers drumming,\n";
			case 11:
				verse += "11 pipers piping,\n";
			case 10:
				verse += "10 lords a-leaping,\n";
			case 9:
				verse += "9 ladies dancing,\n";
			case 8:
				verse += "8 maids a-milking,\n";
			case 7:
				verse += "7 swans a-swimming,\n";
			case 6:
				verse += "6 geese a-laying,\n";
			case 5:
				verse += "5 gold rings,\n";
			case 4:
				verse += "4 calling birds,\n";
			case 3:
				verse += "3 French Hens,\n";
			case 2:
				verse += "2 Turtle Doves,\nAnd ";
			case 1:
				verse += "a Partridge in a Pear Tree.\n\n";
			default:
				break;
			}
			System.out.print(verse);
		}
	}
}
