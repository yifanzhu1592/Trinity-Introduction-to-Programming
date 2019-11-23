/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful, properly formatted, variable names and CONSTANTS?
        Mark out of 10: 10
        Comment:  I used meaningful, properly formatted, variable names and CONSTANTS.
 2. Did I implement the getVerse function correctly and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  I implemented the getVerse function correctly and in a manner that can be understood.
 3. Did I implement the getChristmasGift function correctly using a switch statement and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  I implement the getChristmasGift function correctly using a switch statement and in a manner that can be understood
 4. Did I implement the getOrdinalString function correctly using if or conditional operators and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  I implemented the getOrdinalString function correctly using if or conditional operators and in a manner that can be understood.
 5. Does the program produce the output correctly?
       Mark out of 10: 10
        Comment:  The program produced the output correctly.
 6. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment: I did it carefully.
 Total Mark out of 100 (Add all the previous marks): 100
*/ 

public class TwelveDaysExtended {
	
	final static int FIRST_DAY_OF_CHRISTMAS = 1;
	final static int SECOND_DAY_OF_CHRISTMAS = 2;
	final static int THIRD_DAY_OF_CHRISTMAS = 3;
	final static int FOURTH_DAY_OF_CHRISTMAS = 4;
	final static int FIFTH_DAY_OF_CHRISTMAS = 5;
	final static int SIXTH_DAY_OF_CHRISTMAS = 6;
	final static int SEVENTH_DAY_OF_CHRISTMAS = 7;
	final static int EIGHTH_DAY_OF_CHRISTMAS = 8;
	final static int NINTH_DAY_OF_CHRISTMAS = 9;
	final static int TENTH_DAY_OF_CHRISTMAS = 10;
	final static int ELEVENTH_DAY_OF_CHRISTMAS = 11;
	final static int TWELFTH_DAY_OF_CHRISTMAS = 12;
	
	public static void main(String[] args) {
		
		final int AMOUNT_OF_VERSES = 12;
		
		for (int loopTime = FIRST_DAY_OF_CHRISTMAS; loopTime <= AMOUNT_OF_VERSES; loopTime++) {
			System.out.print(getVerse(loopTime));
		}
	}
	
	public static String getOrdinalString(int verseNumber) {
		if (verseNumber == FIRST_DAY_OF_CHRISTMAS)
			return("first");
		else if (verseNumber == SECOND_DAY_OF_CHRISTMAS)
			return("second");
		else if (verseNumber == THIRD_DAY_OF_CHRISTMAS)
			return("third");
		else if (verseNumber == FOURTH_DAY_OF_CHRISTMAS)
			return("fourth");
		else if (verseNumber == FIFTH_DAY_OF_CHRISTMAS)
			return("fifth");
		else if (verseNumber == SIXTH_DAY_OF_CHRISTMAS)
			return("sixth");
		else if (verseNumber == SEVENTH_DAY_OF_CHRISTMAS)
			return("seventh");
		else if (verseNumber == EIGHTH_DAY_OF_CHRISTMAS)
			return("eighth");
		else if (verseNumber == NINTH_DAY_OF_CHRISTMAS)
			return("ninth");
		else if (verseNumber == TENTH_DAY_OF_CHRISTMAS)
			return("tenth");
		else if (verseNumber == ELEVENTH_DAY_OF_CHRISTMAS)
			return("eleventh");
		else
			return("twelfth");
	}
	
	public static String getChristmasGift(int giftNumber) {
		switch (giftNumber) {
		case TWELFTH_DAY_OF_CHRISTMAS:
			return("12 drummers drumming");
		case ELEVENTH_DAY_OF_CHRISTMAS:
			return("11 pipers piping");
		case TENTH_DAY_OF_CHRISTMAS:
			return("10 lords a-leaping");
		case NINTH_DAY_OF_CHRISTMAS:
			return("9 ladies dancing");
		case EIGHTH_DAY_OF_CHRISTMAS:
			return("8 maids a-milking");
		case SEVENTH_DAY_OF_CHRISTMAS:
			return("7 swans a-swimming");
		case SIXTH_DAY_OF_CHRISTMAS:
			return("6 geese a-laying");
		case FIFTH_DAY_OF_CHRISTMAS:
			return("5 gold rings");
		case FOURTH_DAY_OF_CHRISTMAS:
			return("4 calling birds");
		case THIRD_DAY_OF_CHRISTMAS:
			return("3 French Hens");
		case SECOND_DAY_OF_CHRISTMAS:
			return("2 Turtle Doves");
		case FIRST_DAY_OF_CHRISTMAS:
			return("a Partridge in a Pear Tree");
		default:
			return null;
		}
	}
	
	public static String getVerse(int number) {
		String verse = "On the " + getOrdinalString(number) + " day of Christmas\nmy true love sent to me:\n";
		if (number > FIRST_DAY_OF_CHRISTMAS) {
			for (int loopTime = number; loopTime >= SECOND_DAY_OF_CHRISTMAS; loopTime--) {
				verse += getChristmasGift(loopTime) + ",\n";
			}
			verse += "and ";
		}
		return verse += getChristmasGift(FIRST_DAY_OF_CHRISTMAS) + ".\n\n";
	}
	
}
