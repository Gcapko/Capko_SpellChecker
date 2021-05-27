/*Author Name: Grayson Capko
 * Date: 5/26/2021
 * Project Name: Capko_SpellChecker
 * Purpose: Take two files at the command line interface. Pass these two files as arguments one will be the dictionary
 * the other is the test file. Compare each word from the test file and see if it exists in the dictionary file. 
 * If not print word. 
 */
package SpellCheck_Pack;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Capko_SpellChecker {

	public static void main(String[] args) throws IOException {
		/*
		 * The program should accept two text file names on the command line
		The program should read both files into string variables. The first is the file to check,
		 and the second is the dictionary. (Sample file  testStates.txt  download and  dictionary.txt  download)
	Both strings should be split into lists of words (two ArrayList collections)
	Implement your main loop. For each word in the document file, if that word doesn't exist in the dictionary,
	 print it out, saying that it is an unknown word
	
		 */

		//Take dictionary file from command line and feed it into an array List. 
		//I started with the dictionary first so I can use testWord method as I feed the test file into the arrayList. 
		File dictionaryFile = new File(args[1]);		
		String word;
		List<String> dictionary = new ArrayList<>();

		BufferedReader dictionaryReader = new BufferedReader(new FileReader(dictionaryFile));

		while((word = dictionaryReader.readLine()) != null)
		{
			dictionary.add((word));
		}
		dictionaryReader.close();
		
		//Take test File from command line and feed it into an array list, while passing each word
		//into the test word method. 
		File testFile = new File(args[0]);
		BufferedReader testReader = new BufferedReader(new FileReader(testFile));
		List<String> test = new ArrayList<>();
		
		while((word = testReader.readLine()) != null)
		{	
			
			test.add(word);
			testWord(dictionary, word);
		}
		testReader.close();
		
		testWord(dictionary, "Florida");
		testWord(dictionary, "florida");
		
		System.out.println("Done");
		
		
	}
	//Takes an arrayList and a String. The method checks arrayList to see if it contains
	//String. If it does not contain it, print the string. 
	private static void testWord(List<String> dictionary, String word) 
	{
		
		boolean exists = dictionary.contains(word);
		if(!exists) 
		{
			System.out.println(word + " is a unknown word");
		}
	}
}
