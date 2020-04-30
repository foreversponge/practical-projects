package part1;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This class will create a file that will contain all the words respecting certain conditions of an input file (dictionary), in alphabetical order.
 * @author Samuel Huang
 *
 */
public class Sub_Dictionary {
	
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);  //For user input
		Scanner sc = null; //To read the file
		PrintWriter pw = null; //To write on the file
		
		System.out.print("Please enter the name of the file for which you would like to create a sub-dictionary: ");
		String userFile = keyboard.next();
		
		//Trying to open the file that will be read, and creating a file to write on
		try{
			sc = new Scanner(new FileInputStream(userFile));
			pw = new PrintWriter(new FileOutputStream("SubDictionary.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println(("\nCould not open the file " + userFile
					+ " for reading. Please check if the file exists! Program will terminate after closing any opened files."));	
			System.exit(0);
		}

		//Creating an array list
		
		ArrayList<String> arrayFile = new ArrayList<String>();
		int counter = 0; //number of entries found
		
		//This will read the whole file
		while(sc.hasNext()) {
			boolean addWord = true;
			String nextWord = sc.next().toUpperCase();
			//to check the following conditions that are specified in the assignment
			if (nextWord.contains("?") || nextWord.contains(".") || nextWord.contains(",") || 
				nextWord.contains(";") || nextWord.contains(":") || nextWord.contains("=") || 
				nextWord.contains("’S") || nextWord.contains("’M") || nextWord.contains("!")) {
				nextWord = nextWord.replace("?", "");
				nextWord = nextWord.replace(".", "");
				nextWord = nextWord.replace(",", "");
				nextWord = nextWord.replace(";", "");
				nextWord = nextWord.replace(":", "");
				nextWord = nextWord.replace("=", "");
				nextWord = nextWord.replace("’S", "");
				nextWord = nextWord.replace("’M", "");
				nextWord = nextWord.replace("!", "");
			}
			
			//if the word is a character
			if(nextWord.length() == 1) {
				if(!(nextWord.equals("A") || nextWord.equals("I"))){
					addWord = false;
				}
			}
			
			//if the word contains a number
			if(nextWord.contains("1") || nextWord.contains("2") || nextWord.contains("3") ||
					nextWord.contains("4") || nextWord.contains("5") || nextWord.contains("6") || 
					nextWord.contains("7") || nextWord.contains("8") || nextWord.contains("9")) {
				addWord = false;
			}
			
			//to add the word if the conditions are met
			if(!(arrayFile.contains(nextWord)) && addWord == true && !(nextWord.equals(""))){
				counter++; //to count the number of entries in the dictionary
				arrayFile.add(nextWord);
			}
		}
		
		//to sort the array list in alphabetical order
		arrayFile.sort(null);
		
		pw.write("The document produced in this sub-dictionary, which includes " + counter + " entries.\n\n");
		
		//to write on the file the dictionary
		String letter = arrayFile.get(0).substring(0,1);
		pw.write(letter + "\n");
		pw.write("==\n");
		for(int i = 0; i < arrayFile.size(); i++) {
			String currentWord = arrayFile.get(i);
			if (currentWord.substring(0,1).equalsIgnoreCase(letter)) {
				pw.write(currentWord + "\n");
			}
			else {
				letter = currentWord.substring(0, 1);
				pw.write("\n\n" + letter + "\n");
				pw.write("==\n");
				pw.write(currentWord + "\n");
			}
		}
		
		//close Scanners and PrintWriter
		keyboard.close();
		pw.close();
		sc.close();
	}
}

