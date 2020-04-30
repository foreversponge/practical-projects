import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This exception class will be used to deal with the errors that can happen during the execution of the program.
 * @author Samuel Huang
 *
 */

class FileExistsException extends Exception {

	/**
	 * Default constructor for the object FileExistsException
	 */
	public FileExistsException() {
		super("\nException: There is already an existing file for that author. File will be renamed as BU, and older BU files will be deleted!");
	}
	
	/**
	 * 
	 * @param s The parameterized constructor for the object FileExistsException that will display a personalized message.
	 */
	public FileExistsException(String s) {
		super(s);
	}
	
	/**
	 * An accessor to display the message of the exception.
	 */
	public String getMessage() {
		return super.getMessage();
	}
}

/**
 * This class will demonstrate the execution of a program that will create files with specific formats with an author that the user wishes to obtain
 * by reading through multiple files.
 * @author Samuel Huang
 *
 */
public class AuthorBibCreator {
	
	/**
	 * Number of articles that have the name of the author requested by the user.
	 */
	private static int authorCount = 0;

	private static int ACMcounter = 0;
	
	public static void main(String[] args) throws FileExistsException {
		/**
		 * Scanner to take user input.
		 */
		Scanner kb = new Scanner(System.in);
		Scanner scs[] = new Scanner[10]; //array of scanners that will be used to open the files
		
		//Welcome message
		System.out.print("Welcome to Samuel Huang's AuthorBibCreator!\n\n"
				+ "Please enter your desired author's name: ");
		String userChoice = kb.nextLine();
		String author = userChoice.substring(0,1).toUpperCase() + userChoice.substring(1);
		
		int counter = 0;
		
		//To go through all the files to see if they exist or not.
		try {
			
			for (int i = 0; i < 10; i++) {
				scs[i]= new Scanner(new FileInputStream("Latex" + (i+1) + ".bib"));
				counter++;
			}
		}
			
		catch (FileNotFoundException e) {
			System.out.println(("\nCould not open input file Latex" + counter + ".bib "
					+ "for reading. Please check if the file exists! Program will terminate after closing any opened files."));	
			for (int i = 0; i < scs.length; i++) {
				if(scs[i] != null) {
					scs[i].close();
				}
			}
			System.exit(0);
			}
		
		//To test if the output files exist already or not.
		File testIEEE = new File (author + "-IEEE.json");
		File testACM = new File (author + "-ACM.json");
		File testNJ = new File (author + "-NJ.json");
		File testIEEE_BU = new File (author + "-IEEE-BU.json");
		File testACM_BU = new File (author + "-ACM-BU.json");
		File testNJ_BU = new File (author + "-NJ-BU.json");
		
		//This part of the code will deal with the replacement and deletion of already existing output files.
		if (testIEEE.exists() || testACM.exists() || testNJ.exists()) {
			try {
			throw new FileExistsException();
			}
			
			catch (FileExistsException e) {
				if (testIEEE.exists()) {
						System.out.println("\nA file already exists with the name: " + author + "-IEEE.json\n"
							+ "File will be renamed as: " + author + "-IEEE-BU.json and any old BUs will be deleted.");
					if (testIEEE_BU.exists()) {
						testIEEE_BU.delete();
					}
					testIEEE.renameTo(new File(author + "-IEEE-BU.json"));
				}
				if (testACM.exists()) {
					System.out.println("\nA file already exists with the name: " + author + "-ACM.json\n"
							+ "File will be renamed as: " + author + "-ACM-BU.json and any old BUs will be deleted.");
					if (testACM_BU.exists()) {
						testACM_BU.delete();
					}
					testACM.renameTo(new File(author + "-ACM-BU.json"));
				}
				if (testNJ.exists()) {
					System.out.println("\nA file already exists with the name: " + author + "-NJ.json\n"
							+ "File will be renamed as: " + author + "-NJ-BU.json and any old BUs will be deleted.");
					if (testNJ_BU.exists()) {
						testNJ_BU.delete();
					}
					testNJ.renameTo(new File(author + "-NJ-BU.json"));
				}
			}
		}
			
		PrintWriter fileIEEE = null;
		PrintWriter fileACM = null;
		PrintWriter fileNJ = null;
		
		
		//This code will try and create the output files; if an exception occurs, all the input files will be closed
		try {
			fileIEEE = new PrintWriter(new FileOutputStream(author + "-IEEE.json"));
			fileACM = new PrintWriter(new FileOutputStream(author + "-ACM.json"));
			fileNJ = new PrintWriter(new FileOutputStream(author + "-NJ.json"));
		}
		
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			testIEEE.delete();
			testACM.delete();
			testNJ.delete();
			for (int i = 0; i < scs.length; i++) {
				if(scs[i] != null) {
					scs[i].close();
				}
			}
			System.exit(0);
		}
		
		for (int i = 0; i < scs.length ; i++) {
			processBibFiles(author, scs[i], fileIEEE, fileACM, fileNJ);
		}
		
		fileIEEE.close();
		fileACM.close();
		fileNJ.close();
		kb.close();
		
		//Closing message
		if(authorCount!=0) {
			System.out.println("\nA total of " + authorCount + " record(s) were found for author(s) with name " + author + ".\n"
				+ "Files " + author + "-IEEE.json, " + author + "-ACM.json and " + author + "-NJ.json have been created.");
		
			System.out.println("\nGoodbye! Hope you enjoyed creating the needed files using AuthorBibCreator.");
		}
		else {
			System.out.println("\nNo record(s) were found for author(s) with name " + author + ".\n");
			testNJ.delete();
			testACM.delete();
			testIEEE.delete();
		}
		
		fileIEEE.close();
		fileACM.close();
		fileNJ.close();
		kb.close();
	}
	
	/**
	 * 
	 * @param author Name of the author requested by the user
	 * @param latex Input file
	 * @param IEEE IEEE-format output file
	 * @param ACM ACM-format output file
	 * @param NJ NJ-format output file
	 */
	public static void processBibFiles(String author, Scanner latex, PrintWriter IEEE, PrintWriter ACM, PrintWriter NJ) {
		/**
	 	* Boolean to see if the article has a match with the requested author name of the user
	 	*/
		boolean authorMatch = false;
		/**
		 * Array of strings that will contain the names of the author(s)
		 */
		String names[] = null;
		/**
		 * Number of names
		 */
		int numbNames = 0;
		/**
		 * The index of the bracket that closes the fields
		 */
		int indexCloseBkt;
		/**
		 * String that will contain the content of the journal
		 */
		String journal = null;
		/**
		 * String that will contain the content of the title
		 */
		String title = null;
		/**
		 * String that will contain the content of the year
		 */
		String year = null;
		/**
		 * String that will contain the content of the volume
		 */
		String volume = null;
		/**
		 * String that will contain the content of the number
		 */
		String number = null;
		/**
		 * String that will contain the content of the pages
		 */
		String pages = null;
		/**
		 * String that will contain the content of the doi
		 */
		String doi = null;
		/**
		 * String that will contain the content of the month
		 */
		String month = null;
		/**
		 * String that will contain the content of the line
		 */
		String line = null;
		
		//This part of the code will read until the end of the file
		while(latex.hasNextLine()) {
			line = latex.nextLine();
			authorMatch = false;
			if(line.contains("@ARTICLE{")) { //if true, then this is the beginning of an article
				while (line.indexOf("}") != 0){ //if false, then it is the end of the article
					line = latex.nextLine();
					if(line.contains("author={")) {
						indexCloseBkt = line.indexOf("}");
						String temp = line.substring(8,indexCloseBkt);
						StringTokenizer token = new StringTokenizer(temp, " ");
						numbNames = token.countTokens();
						names = new String[numbNames];
						for (int i = 0; i < numbNames; i++) {
							names[i] = token.nextToken(); //storing the tokens in the array of strings
						}
						if(line.contains(author)) {
							authorMatch = true;
						}
						else {
							authorMatch = false;
						}
					}
					//the following code will simply obtain the information needed for every field
					
					else if(line.contains("journal={")) {
						indexCloseBkt = line.indexOf("}");
						journal = line.substring(9,indexCloseBkt);
					}
			
					else if(line.contains("title={")) {
						indexCloseBkt = line.indexOf("}");
						title = line.substring(7,indexCloseBkt);
					}
			
					else if(line.contains("year={")) {
						indexCloseBkt = line.indexOf("}");
						year = line.substring(6,indexCloseBkt);
					}
			
					else if(line.contains("volume={")) {
						indexCloseBkt = line.indexOf("}");
						volume = line.substring(8,indexCloseBkt);
					}
					else if(line.contains("number={")) {
						indexCloseBkt = line.indexOf("}");
						number = line.substring(8,indexCloseBkt);
					}
					else if(line.contains("pages={")) {
						indexCloseBkt = line.indexOf("}");
						pages = line.substring(7,indexCloseBkt);
					}
					else if(line.contains("doi={")) {
						indexCloseBkt = line.indexOf("}");
						doi = line.substring(5,indexCloseBkt);
					}
			
					else if(line.contains("month={")) {
						indexCloseBkt = line.indexOf("}");
						month = line.substring(7,indexCloseBkt);
					}
				}
			}
			
			//if the article contains the name requested by the user, then the variables store in the code above will be used; otherwise, it
			//will be discarded in the following loop
			if(authorMatch == true) {
				authorCount++;
				ACMcounter++;
				for (int j = 0; j < numbNames-1; j++) {
					if(names[j].indexOf(".") != -1 && !names[j].equalsIgnoreCase("and")) {
						IEEE.write(names[j] + " ");
					}
					else if (!names[j].equalsIgnoreCase("and")){
						IEEE.write(names[j] + ", ");
					}
				}
				IEEE.write(names[names.length-1] + ". ");
				IEEE.write("\"" + title + "\", " + journal + ", vol. " + volume + ", no." + number + ", p. " + pages + ", " + month
					+ " " + year + ".\n\n");
			
				int x = 0;
				boolean test = false;
				ACM.write("["+ ACMcounter + "] ");
				while (test == false) {
					if (names[x].contains(".")) {
					ACM.write(names[x] + " ");
					x++;
					}
					else {
						ACM.write(names[x] + " et al. " + year + ". " + title + ". " + journal + ". " + volume + ", " + number + " (" + year
								+ "), " + pages + ". DOI:https://doi.org/" + doi + ".\n\n");
								x++;
						test=true;
					}
				}
				
				for (int z = 0; z < numbNames-1; z++) {
					if(names[z].indexOf(".") != -1 && !names[z].equalsIgnoreCase("and")) {
						NJ.write(names[z] + " ");
						}
					else if (!names[z].equalsIgnoreCase("and")){
						NJ.write(names[z] + " & ");
					}
				}
				NJ.write(names[names.length-1] + ". " + title + ". " + journal + ". " + volume + ", " + pages + "(" + year + ").\n\n");
			}
		}
		
	}

}




