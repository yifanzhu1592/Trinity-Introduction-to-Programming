import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5: 5]
- Comment: I have the correct method definition
- My method reads the words from the "words.txt" file. [Mark out of 5: 5]
- Comment: My method reads the words from the "words.txt" file.
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5: 5]
- Comment: It returns the contents from "words.txt" in an ArrayList.

2. readWordList
- I have the correct method definition [Mark out of 5: 5]
- Comment: I have the correct method definition
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5: 5]
- Comment: My method reads the words provided (which are separated by commas), saves them to an ArrayList of String references and returns it.

3. isUniqueList
- I have the correct method definition [Mark out of 5: 5]
- Comment: I have the correct method definition
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5: 5]
- Comment: My method compares each word in the array with the rest of the words in the list.
- Exits the loop when a non-unique word is found. [Mark out of 5: 5]
- Comment: Exits the loop when a non-unique word is found.
- Returns true is all the words are unique and false otherwise. [Mark out of 5: 5]
- Comment: Returns true is all the words are unique and false otherwise.

4. isEnglishWord
- I have the correct method definition [Mark out of 5: 5]
- Comment: I have the correct method definition
- My method uses the binarySearch method in Arrays library class. [Mark out of 3: 3]
- Comment: My method uses the binarySearch method in Arrays library class.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2: 2]
- Comment: Returns true if the binarySearch method return a value >= 0, otherwise false is returned.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5: 5]
- Comment: I have the correct method definition
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10: 10]
- Comment: My method loops through the length of a words comparing characters at the same position in both words searching for one difference.

6. isWordChain
- I have the correct method definition [Mark out of 5: 5]
- Comment: I have the correct method definition
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10: 10]
- Comment: My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10: 10]
- Comment: Reads all the words from file words.txt into an ArrayList using the Scanner
- Asks the user for input and calls isWordChain [Mark out of 5: 5]
- Comment: Asks the user for input and calls isWordChain

 Total Mark out of 100 (Add all the previous marks): 100
*/

public class LewisCarrollsWordLinksPuzzleGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a comma separated list of words (or an empty list to quit):");
		String inputList = input.nextLine();
		while (!inputList.isEmpty()) {
			ArrayList<String> list = readWordList(inputList);
			if (isWordChain(list)) {
				System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
			} else {
				System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
			}
			System.out.println("Enter a comma separated list of words (or an empty list to quit):");
			inputList = input.nextLine();
		}
	}

	static ArrayList<String> readDictionary() {
		File file = new File("words.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> list = new ArrayList<String>();
		while (sc.hasNextLine()) {
			list.add(sc.nextLine());
		}

		return list;
	}

	static ArrayList<String> readWordList(String commaSeparatedList) {
		List<String> wordList = Arrays.asList(commaSeparatedList.split(",\\s*"));
		ArrayList<String> list = new ArrayList<String>();
		for (String word : wordList) {
			list.add(word);
		}

		return list;
	}

	static boolean isUniqueList(ArrayList<String> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					return false;
				}
			}
		}

		return true;
	}

	static boolean isEnglishWord(String word) {
		return Arrays.binarySearch(readDictionary().toArray(), word) >= 0;
	}

	static boolean isDifferentByOne(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				count++;
			}
		}

		return count == 1;
	}

	static boolean isWordChain(ArrayList<String> list) {
		if (!isUniqueList(list)) {
			return false;
		}

		for (Object word : list) {
			if (!isEnglishWord((String) word)) {
				return false;
			}
		}

		int index = 0;

		while (index < list.size() - 1 && isDifferentByOne(list.get(index), list.get(index + 1))) {
			index++;
		}

		return index == list.size() - 1;
	}

}
