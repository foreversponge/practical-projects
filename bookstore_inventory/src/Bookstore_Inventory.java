// -----------------------------------------------------
/* This program will allow the user to manage different books in an inventory. The user will be able to add books into the inventory and
 * change the information of those books. The user will also be able to search which books are written by a specific author and
 * which books are under a certain price. */

import java.util.Scanner;

/**
 * The Bookstore_Inventory class will allow the user to manage different books in an inventory. The user will be able to add books into the inventory and
 * change the information of those books. The user will also be able to search which books are written by a specific author and
 * which books are under a certain price.
 * @author Samuel Huang
 */

public class Bookstore_Inventory {
	
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		
		System.out.println("Hello. This program, written by Samuel Huang, will help you create an inventory for your bookstore.\n"); //Welcome message
		System.out.print("What is the maximum number of books your store's inventory can contain?: "); 
		int maxBooks = userInput.nextInt(); 
		Book inventory [] = new Book[maxBooks]; //creating an inventory with the desired size of the user
		boolean displayMenu = true; //Boolean that will decide whether or not to display the menu
		int numbFails = 0; //to keep track of the number of fails for password
		boolean quitMain = false; //boolean that will decide whether or not to quit to the main menu
		
		/* Displaying the options to the user */
		do {
			System.out.print("\nWhat do you want to do?\n" + 
				"1. Enter new books (password required)\n" + 
				"2. Change information of a book (password required)\n" +
				"3. Display all books by a specific author\n" + 
				"4. Display all books under a certain a price\n" + 
				"5. Quit\n" + 
				"Please enter your choice > ");
		
			int userChoiceMenu = userInput.nextInt();
		
			final String realPw = "password";
		
			if (userChoiceMenu == 1) { //if the user chooses option 1
				int numberAttempts = 0; //to keep track of the number of attempts for the password
				
				if (inventory.length - Book.numberOfCreatedBooks == 0) { //if the inventory is full
					System.out.println("The bookstore's directory is full!");
				}
				
				else {
					do {
						System.out.print("Please enter your password: > "); 
						String attemptPw = userInput.next();
						boolean test1 = false; //to decide whether or not to quit the option to add books
						if (attemptPw.equals(realPw) == true) { //if the user enters the right password
							do {
								System.out.print("Access granted. Please enter the number of books you wish to add to the bookstore's inventory: > ");
								int userNumberBooks = userInput.nextInt();  //the number of books the user wants to add
								if (userNumberBooks <= (inventory.length - Book.numberOfCreatedBooks)) { //
									for (int i = 0; i < userNumberBooks ; i++) { //changing all the information about the Book object with accessors and mutators
										System.out.println("\nNew Book #" + (i+1));
										System.out.print("Title: ");
										String desiredTitle = userInput.next();
										System.out.print("Author: ");
										String desiredAuthor = userInput.next();
										System.out.print("ISBN: ");
										long desiredISBN = userInput.nextLong();
										System.out.print("Price: ");
										double desiredPrice = userInput.nextDouble();
										inventory [i] = new Book(desiredTitle, desiredAuthor, desiredISBN, desiredPrice);
									}
									System.out.println("Done! You will now return to the main menu.");
									test1 = true; //this will decide whether or not to quit option 1
									quitMain = true; //this will decide whether or not to quit to the main menu
								
								}
								else { //if the user wants to add a number of book that will surpass the maximum size of the inventory
									System.out.println("Sorry, that number exceeds the maximum number of books you can have in the inventory. You only have "
											+ (inventory.length - Book.numberOfCreatedBooks) + " available slot(s) in the inventory.");
									quitMain = false; //this will ask the user for another number that he/she wants to add
								}
							} while (test1 == false && quitMain == false); 
						}
					
					else { //if the user enters the wrong password
						numberAttempts++; 
						if (numberAttempts == 3) { //if the user entered the wrong password 3 times
							numbFails++;
							if (numbFails == 4) { //if the user failed to enter the right password and was exited to the main menu 4 times
								System.out.print("Program detected suspicious activities and will terminate immediately!");
								System.exit(0); //program will exit
							}
							
							else { //this will let the user know he/she attempted 3 times but failed to enter the right password
								System.out.println("Sorry, that is not the correct password. You have reached the maximum number of 3 attempts. "
								+ "You will now be sent back to the main menu.");
							}
						}
						
						else //if the user still has attempts to enter the correct password
							System.out.println("Sorry, that is not the correct password. Try again.");
					}
				} while (numberAttempts != 3 && quitMain == false); //if the number of attempts reaches 3, the user will be returned to the main menu
				}
			}
			
			else if (userChoiceMenu == 2) { //if the user chooses option 2
				int numberAttempts = 0;
				do {
					System.out.print("Please enter your password: > ");
					String attemptPw = userInput.next();
					boolean test2 = false; //this will decide whether or not to quit option 2
					if (attemptPw.equals(realPw) == true) {
						do {
							System.out.print("Please enter the book's number that you wish to update (The first book in the "
									+ "book store's inventory is labeled as \"Book #0\"): > ");
							int userBookNumb = userInput.nextInt(); //the Book number that the user wishes to update
							
							if (inventory[userBookNumb] == null) { //if the there is no object Book in that index of the array inventory
								System.out.print("\nThere is no book registered at that number. Would you like to:\n");
								boolean test3 = false; //this will decide whether or not to quit the option of labeling books
								do {
									System.out.print("1. Re-enter another book number\n"
										+ "2. Return to main menu\n"
										+ "Your choice: > ");	
									int userChoice2 = userInput.nextInt();
									if (userChoice2 == 1) { //if user decides to re-enter another book number
										test3 = true; //the program will not quit the option of labeling books
										quitMain = false; //the program will not quit the to the main menu
									}
									else if (userChoice2 == 2) { //if the user decides to quit to the main menu
										System.out.println("You will now be returned to the main menu.");
										test3 = true; //the program will quit the option of labeling books
										quitMain = true; //the program will quit to the main menu
									}
									
									else { //the user did not choose between option 1 or 2
										System.out.print("That is not a valid option.");
										test3 = false; //the program will not quit the labeling books option
										quitMain = false; //the program will not quit to the main menu
									}
								} while (test3 == false && quitMain == false);
								
							}
							
							else { //the user entered an index of the array inventory that contains an object Book
								System.out.println("\nInformation about Book #" + userBookNumb + ":"); //to display the number of that object Book
								System.out.println(inventory[userBookNumb].toString()); //prints out the information of the Book
								boolean test4; //this will decide whether or not to quit the otion to change information about the book
								do {
									
								test4 = false;
								/* to ask the user if he/she would like to change the author, title, ISBN, price or to quit to the main menu */
								System.out.print("What information would you like to change?\n" +
										"1. Author\n" +
										"2. Title\n"  +
										"3. ISBN\n" +
										"4. Price\n" +
										"5. Quit\n" + 
										"Enter your choice > ");
								int userChoice3 = userInput.nextInt();
								if (userChoice3 == 1) { //the user chooses to change the author of the Book
									System.out.print("What will the name of the author be changed to? >" );
									String userAuthorCh = userInput.next();
									inventory[userBookNumb].setAuthor(userAuthorCh); 
									System.out.println("Updated information about Book #" + userBookNumb + ":\n");
									System.out.println(inventory[userBookNumb].toString()); //prints out the updated information about the Book
								}
								
								else if (userChoice3 == 2) { //the user chooses to change the title of the Book
									System.out.print("What will the title be changed to? > " );
									String userTitleCh = userInput.next();
									inventory[userBookNumb].setTitle(userTitleCh);
									System.out.println("Updated information about Book #" + userBookNumb + ":\n");
									System.out.println(inventory[userBookNumb].toString()); //prints out the updated information about the Book
								}
								
								else if (userChoice3 == 3) { //the user chooses to change the ISBN of the Book
									System.out.print("What will the ISBN be changed to? > " );
									long userISBNCh = userInput.nextLong();
									inventory[userBookNumb].setISBN(userISBNCh);
									System.out.println("Updated information about Book #" + userBookNumb + ":\n");
									System.out.println(inventory[userBookNumb].toString()); //prints out the updated information about the Book
								}
								
								else if (userChoice3 == 4) { //the user chooses to change the price of the Book
									System.out.print("What will the price be changed to? > " );
									double userPriceCh = userInput.nextDouble();
									inventory[userBookNumb].setPrice(userPriceCh);
									System.out.println("\nUpdated information about Book #" + userBookNumb + ":\n");
									System.out.println(inventory[userBookNumb].toString()); //prints out the updated information about the Book
								}
								
								else if (userChoice3 == 5) { //the user chooses to quit to the main menu
									test4 = true; //this will quit the option to change information about the book
									quitMain = true; //this will quit to the main menu
								}
								
								else //if the user enters an option that is not between 1 and 5
									System.out.println("Sorry, that option is invalid.\n");
								} while (test4 == false);
								
							}
						} while (test2 == false && quitMain == false);
					}

					else { //if the user does not enter the correct password
						numberAttempts++;
						if (numberAttempts == 3) { //if the user enters 3 incorrect passwords
								System.out.println("Sorry, that is not the correct password. You have reached the maximum number of 3 attempts. "
								+ "You will now be sent back to the main menu.");
							}
						
						else {
							System.out.println("Sorry, that is not the correct password. Try again.");
							quitMain = false; //this will not quit to the main menu
						}
					}
				} while (numberAttempts != 3 && quitMain == false);
			}
			
			
			else if (userChoiceMenu == 3) { //if the user chooses to display which books are written by an author
				System.out.print("\nPlease enter the desired author's name: > ");
				String userAuthor = userInput.next();
				int counter = 0;
				for (int i = 0; i < inventory.length; i++) { //goes through every element of the array inventory
					if (inventory[i] == null) //if there is nothing at the index of that inventory
						continue;
					else if (inventory[i].getAuthor().equalsIgnoreCase(userAuthor)) { //if the user's desired author matches the author of the Book at that index
						System.out.println("\nBook #" + i);
						System.out.print(inventory[i].toString()); //prints out the information of the Book
						counter++;
					}
				}
				if (counter == 0) //if the counter is 0, it means there were no objects Book that had the author that the user desired
					System.out.println("There was no match. You will now return to the main menu.");
				else
					System.out.println("\nDone! You will now return to the main menu.");
			}
			
			else if (userChoiceMenu == 4) { //if the user chooses to display which books are under a certain price
				System.out.print("Please enter the desired price: > ");
				double userPrice = userInput.nextDouble();
				int counter = 0;
				for (int i = 0; i < inventory.length; i++) { //goes through every element of the array inventory
					if (inventory[i] == null) //if there is nothing at the index of that inventory
						continue;
					else if (inventory[i].getPrice() < userPrice) { //if the user's desired price matches the price of the Book at that index
						System.out.println("\nBook #" + i); 
						System.out.print(inventory[i].toString()); //prints out the information of the Book
						counter++;
					}
				}
				if (counter == 0)
					System.out.println("There was no match. You will now return to the main menu.");
				else
					System.out.println("\nDone! You will now return to the main menu.");
				
			}
			
			else if (userChoiceMenu == 5) { //if the user chooses to quit the program
				System.out.println("You will now exit the program."); //closing message
				System.exit(0); //quits the program
			}
			
			else //the user did not enter a valid option
				System.out.println("That is not a valid option. Please try again.");
			
		} while (displayMenu == true);
		userInput.close();
	}

}
