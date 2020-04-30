// -------------------------------------------------------
// Date: 30 November 2018
// -------------------------------------------------------
/* The purpose of this program is to simulate a game called Crazy Nancy's Garden. This program will run until there is a winner, who
 * is the first player that completely fills up his/her garden with flowers and trees (there are no ties in this game. */

import java.util.Random;
import java.util.Scanner;

public class LetsPlay {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in); //scanner object to receive user input
		
		//DISPLAYING WELCOME BANNER
		System.out.println("\t-----****-------****-------****-------****-----****-----");
		System.out.println("\t\t  Welcome to Crazy Nancy's Garden Game!");
		System.out.println("\t-----****-------****-------****-------****-----****-----");
		
		//DISPLAYING RULES OF THE GAME
		System.out.println("\nTo win this game you need some luck with the dice and a bit of strategy.\n" + 
				"Your garden is an NxN lot. You can plant flowers or trees. A flower takes one spot (1x1). A tree takes 4 spots (2x2).\n" + 
				"You roll the dice and based on the outcome, you must plant a pre-set number of trees and flowers.\n");
		
		System.out.println("Rolls and their outcome:\n "
				+ "---------------------\n"
				+ "3: You must plant a tree (2x2) and a flower (1x1).\n"
				+ "6: You must plant 2 flowers (2 times 1x1).\n"
				+ "12: You must plant 2 trees (2 times 2x2).\n"
				+ "5 or 10: The rabbit will randomly eat something that you have planted - It can be a flower or part of a tree (1x1).\n"
				+ "Any other EVEN rolls (2,4,8): You must plant a tree (2x2).\n"
				+ "Any other ODD rolls (5,7,9): You must plant a flower (1x1).\n\n"
				+ "Minimum number of players: 2.\n"
				+ "Minimum garden size: 3x3.\n\n"
				+ "You can only plant in empty locations. To plant a tree, you give the TOP LEFT coordinates of the 2x2 space\n"
				+ "and I will check to make sure all 4 locations are free.\n"
				+ "Please remember that you must enter coordinates that are valid (inside the displayed garden)");

		System.out.println("Before we start, please decide the size of the garden as well as the numbers of players that will be playing.\n"
				+ "Please keep in mind that the default size of the garden is 3x3 and cannot be smaller than that size. Furthermore, the\n"
				+ "minimum required number of gardeners is 2 and the maximum number of gardeners is 10. \n");
		
		//CHOOSING THE SIZE OF THE GARDEN
		
		boolean testGardenSize = true; //to test if the size is valid
		int userGardenSize;
		
		do {
			System.out.print("Desired size of the garden: ");
			userGardenSize = userInput.nextInt(); //this is the user's desired garden size that will be used for the game
			
			//to verify if the user enters a valid number for the size of the garden
			if (userGardenSize >= 3) { 
				System.out.print("The size of the garden has been set to " + userGardenSize + "x" + userGardenSize + ".\n");
				testGardenSize = false;
			}
			else
				System.out.println("Sorry, but the size of the garden cannot be smaller than 3x3.\n");
		} while (testGardenSize == true);

		//CHOOSE NUMBER OF PLAYERS
		
		boolean testNumberPlayers = true; //to test if number of players is valid
		int userNumberPlayers = 0; //initialize the number of players as an int
		
		do {
			System.out.print("\nDesired number of gardeners: ");
			userNumberPlayers = userInput.nextInt(); //this is the user's desired number of gardeners that will play the game
			
			//to verify if the user enters a valid number for the number of players
			if (userNumberPlayers >= 2 && userNumberPlayers <= 10) {
				System.out.println("Great, " + userNumberPlayers + " gardeners will battle to be the best!");
				testNumberPlayers = false;
			}
			else
				System.out.println("Sorry, but the minimum number of gardeners required is 2 and the maximum is 10.");
		} while (testNumberPlayers == true);
		
		//CREATING THE ARRAY THAT WILL STORE THE NAMES OF THE PLAYERS
		Player listOfPlayers [] = new Player[userNumberPlayers]; //creating an array to store the list of players
		String tempPlayerName = ""; //this string changes every time (hence temporary) since the user enters a new gardener's name
		
		//PLACING THE NAMES INTO THE ARRAY OF STRINGS CALLED Player
		System.out.println("\nWhat will the names of the gardeners be (no spaces allowed)?: \n");
	
		for (int i = 0; i < userNumberPlayers; i++) {
			System.out.print("Name of gardener " + (i+1) + ": "); //printing out the names of the gardeners
			tempPlayerName = userInput.next();
			listOfPlayers[i] = new Player(tempPlayerName.substring(0,1).toUpperCase() + tempPlayerName.substring(1).toLowerCase(), userGardenSize); //capitalizing the player's name
		}
		
		//DECIDING WHICH PLAYER GOES FIRST
		
		System.out.print("\nLet's see which gardener will go first!\n");
	
		Dice userFirstDice = new Dice(); //Dice object that will represent dice #1
		int firstRolls[] = new int[userNumberPlayers]; //array that will contain the value of the dice rolls
		int bestRoll = 0; //integer that represents the best roll out of all the gardener's rolls
		boolean differentRoll = true; //boolean that represents if all the rolls are different
		Player firstToStart = new Player("",userGardenSize); //Player object that represents the name of the gardener that will start
		
		do {
			
			for (int i = 0; i < firstRolls.length; i++) { //store the value of each player's rolls into the array firstRolls
				firstRolls[i] = userFirstDice.rollDice();
					if (firstRolls[i] > bestRoll) { //if the player's roll value beats the largest roll value
						bestRoll = firstRolls[i];
						firstToStart = listOfPlayers[i];
						differentRoll = true;
					}
					System.out.print(listOfPlayers[i].getName() + " rolled a " + firstRolls[i] + ".\n");
					for (int j = 0; j < i; j++) { //to verify if the player's roll value has not already been rolled by another player
						if (firstRolls[j] == firstRolls[i]) {
							differentRoll = false;
							System.out.print("We will start over since " + firstRolls[i] + " was rolled by " + listOfPlayers[j].getName() + " as well.\n\n");
							for (int z = 0; z < firstRolls.length; z++) //to reset the array that stores the value of each player's roll
								firstRolls[z] = 0;
							i = -1; //to reset the counter i to 0
							bestRoll = 0; //to reset the largest roll value to 0
							break;
						}
					}
			}
		} while (differentRoll == false);
		
		System.out.print("Since " + firstToStart.getName() + " rolled the highest value, he/she goes first.\n");
		System.out.print("\nTime to start the game! MAY THE BEST GARDENER WIN!\n\n");
		System.out.print("------------------------------------\n");
		
		//CREATING AN ARRAY OF STRINGS REPRESENTING THE ORDER OF TURNS OF THE PLAYERS 
		
		Player orderPlayers[] = listOfPlayers; //creating a copy of the list of players that will be changed to represent the order of the players
		int orderRolls[] = firstRolls; //creating a copy of the rolls of each players that will be changed to represent the highest value to the lowest value
		
		for (int i = 0; i < orderPlayers.length-1; i++) { 
			for (int j = 0; j < (orderPlayers.length-i - 1); j++)
				if (firstRolls[j] < firstRolls[j+1]) {
					int tempInt = firstRolls[j]; //temporary integer so that its value is not lost
					orderRolls[j] = orderRolls[j+1];
					orderRolls[j+1] = tempInt;
				
					Player tempPlayer = orderPlayers[j]; //temporary string so that it does not get lost
					orderPlayers[j] = orderPlayers[j+1]; 
					orderPlayers[j+1] = tempPlayer;
				}
		}
		
		boolean winner = false; //will remain false until a player has won
		String winnerPlayer = ""; //will contain the name of the winning player
		Dice userGameDice = new Dice(); //dice that will be used for the game
		int userGameRoll = 0; //integer that represents the value of the rolled dice
		boolean spotFree = true; //boolean that represents if there is a free spot in the garden
		int numberRounds = 0; //to count the number of rounds played
		
		do {
			//represents every player's turn
			for (int i = 0; i < orderPlayers.length; i++) {
				userGameRoll = userGameDice.rollDice();
				System.out.println("\n" + orderPlayers[i].getName() + ", you rolled " + userGameRoll + ". (" + userGameDice.toString() + ")");
				
				//if user rolls a 3
				if (userGameRoll == 3) {
					System.out.println("You must plant a tree (2x2) and a flower (1x1).\n");
					System.out.println(orderPlayers[i].showGarden());
					
					//if there are spots for a tree to be planted
					if (orderPlayers[i].howManyTreesPossible() != 0) {
						System.out.println("Let's start with the tree. You have " + orderPlayers[i].howManyTreesPossible() + " place(s) to do this.");
						do {
							System.out.print("Enter the desired coordinates (row, column): "); //ask for user to enter coordinates
							int r = userInput.nextInt();
							int c = userInput.nextInt(); 
							spotFree = true; 
							//if the desired coordinates have part of a tree planted already
							if (r < userGardenSize-1 && c < userGardenSize-1) { //to make sure the coordinates are within the grid of the garden
								if (orderPlayers[i].whatIsPlanted(r, c) == 't' || orderPlayers[i].whatIsPlanted(r+1, c) == 't' || orderPlayers[i].whatIsPlanted(r, c+1) == 't' || orderPlayers[i].whatIsPlanted(r+1, c+1) == 't') { //this means that the location has part of a tree
									System.out.println("Sorry, but that location is already taken by part of a tree.");
									spotFree = false;
								}
								//if the desired coordinates have a flower planted already
								else if (orderPlayers[i].whatIsPlanted(r, c) == 'f' || orderPlayers[i].whatIsPlanted(r+1, c) == 'f' || orderPlayers[i].whatIsPlanted(r, c+1) == 'f' || orderPlayers[i].whatIsPlanted(r+1, c+1) == 'f') { //this means that the location has a flower
									System.out.println("Sorry, but that location is already taken by a flower.");
									spotFree = false;
								}
								else if (orderPlayers[i].whatIsPlanted(r, c) == '-')  //this means that the location is empty
									orderPlayers[i].plantTreeInGarden(r, c);
								}
							else {
								System.out.println("Sorry, but the coordinates you entered are not valid because the tree will be outside the grid.");
								spotFree = false;
							}
						} while (spotFree == false);
						System.out.print("\n" + orderPlayers[i].getName() + ", here is your garden now: \n" + orderPlayers[i].showGarden());
					}
					else
						System.out.println("Sorry. There is no room to plant a tree.");
					
					//if there are spots for a flower to be planted
					if (orderPlayers[i].howManyFlowersPossible() != 0) {
						System.out.println("\nLet's continue with the flower. You have " + orderPlayers[i].howManyFlowersPossible() + " place(s) to do this.");
						do {
							System.out.print("Enter the desired coordinates (row, column): ");
							int r = userInput.nextInt();
							int c = userInput.nextInt(); 
							spotFree = true;
							if (r < userGardenSize && c < userGardenSize) { //to make sure the coordinates are within the grid of the garden
								if (orderPlayers[i].whatIsPlanted(r, c) == 't') { //this means that the location has part of a tree
									System.out.println("Sorry, but that location is already taken by part of a tree.");
									spotFree = false;
								}
								else if (orderPlayers[i].whatIsPlanted(r, c) == 'f') { //this means that the location has a flower
									System.out.println("Sorry, but that location is already taken by a flower.");
									spotFree = false;
								}
								else if (orderPlayers[i].whatIsPlanted(r, c) == '-') //this means that the location is empty
									orderPlayers[i].plantFlowerInGarden(r, c);
							}
							else {
								System.out.println("Sorry, but the coordinates you entered are not valid because the flower will be outside the grid.");
								spotFree = false;
							}
						} while (spotFree == false);
						System.out.print("\n" + orderPlayers[i].getName() + ", here is your garden now: \n\n" + orderPlayers[i].showGarden());
					}
					
					if(orderPlayers[i].isGardenFull() == true) { //to check if the player has won
						winner = orderPlayers[i].isGardenFull();
						winnerPlayer = orderPlayers[i].getName();
						break;
					}
				}
			
				//if user rolls 6
				if (userGameRoll == 6) {
					System.out.println("You must plant 2 flowers (2 times 1x1).\n");
					System.out.println(orderPlayers[i].showGarden());
					
					//if there are spots for the first flower to be planted
					if (orderPlayers[i].howManyFlowersPossible() != 0) {
						System.out.println("Let's start with the first flower. You have " + orderPlayers[i].howManyFlowersPossible() + " place(s) to do this.");
						do {
							System.out.print("Enter the desired coordinates (row, column): "); //ask for user to enter coordinates
							int r = userInput.nextInt();
							int c = userInput.nextInt(); 
							spotFree = true; 
							//if the desired coordinates have part of a tree planted already
							if (r < userGardenSize && c < userGardenSize) { //to make sure the coordinates are within the grid of the garden
								if (orderPlayers[i].whatIsPlanted(r, c) == 't') { //this means that the location has part of a tree
									System.out.println("Sorry, but that location is already taken by part of a tree.");
									spotFree = false;
								}
								else if (orderPlayers[i].whatIsPlanted(r, c) == 'f') { //this means that the location has a flower
									System.out.println("Sorry, but that location is already taken by a flower.");
									spotFree = false;
								}
								else if (orderPlayers[i].whatIsPlanted(r, c) == '-') //this means that the location is empty
									orderPlayers[i].plantFlowerInGarden(r, c);
							}
							else {
								System.out.println("Sorry, but the coordinates you entered are not valid because the flower will be outside the grid.");
								spotFree = false;
							}
						} while (spotFree == false);
						System.out.print("\n" + orderPlayers[i].getName() + ", here is your garden now: \n\n" + orderPlayers[i].showGarden());
					}
					
					//if there are spots for the second flower to be planted
					if (orderPlayers[i].howManyFlowersPossible() != 0) {
						System.out.println("\nLet's continue with the second flower. You have " + orderPlayers[i].howManyFlowersPossible() + " place(s) to do this.");
						do {
							System.out.print("Enter the desired coordinates (row, column): ");
							int r = userInput.nextInt();
							int c = userInput.nextInt(); 
							spotFree = true;
							if (r < userGardenSize && c < userGardenSize) { //to make sure the coordinates are within the grid of the garden
								if (orderPlayers[i].whatIsPlanted(r, c) == 't') { //this means that the location has part of a tree
									System.out.println("Sorry, but that location is already taken by part of a tree.");
									spotFree = false;
								}
								else if (orderPlayers[i].whatIsPlanted(r, c) == 'f') { //this means that the location has a flower
									System.out.println("Sorry, but that location is already taken by a flower.");
									spotFree = false;
								}
								else if (orderPlayers[i].whatIsPlanted(r, c) == '-') //this means that the location is empty
									orderPlayers[i].plantFlowerInGarden(r, c);
							}
							else {
								System.out.println("Sorry, but the coordinates you entered are not valid because the flower will be outside the grid.");
								spotFree = false;
							}
						} while (spotFree == false);
						System.out.print("\n" + orderPlayers[i].getName() + ", here is your garden now: \n\n" + orderPlayers[i].showGarden());
					}
					
					if(orderPlayers[i].isGardenFull() == true) { //to check if the player has won
						winner = orderPlayers[i].isGardenFull();
						winnerPlayer = orderPlayers[i].getName();
						break;
					}
				}
				
				//if user rolls 12
				if (userGameRoll == 12) {
					System.out.println("You must plant 2 tree (2 times 2x2).\n");
					System.out.println(orderPlayers[i].showGarden());
					
					//if there are spots for the first tree to be planted
					if (orderPlayers[i].howManyTreesPossible() != 0) {
						System.out.println("Let's start with the first tree. You have " + orderPlayers[i].howManyTreesPossible() + " place(s) to do this.");
						do {
							System.out.print("Enter the desired coordinates (row, column): "); //ask for user to enter coordinates
							int r = userInput.nextInt();
							int c = userInput.nextInt(); 
							spotFree = true; //
							//if the desired coordinates have part of a tree planted already
							if (r < userGardenSize-1 && c < userGardenSize-1) { //to make sure the coordinates are within the grid of the garden
								if (orderPlayers[i].whatIsPlanted(r, c) == 't' || orderPlayers[i].whatIsPlanted(r+1, c) == 't' || orderPlayers[i].whatIsPlanted(r, c+1) == 't' || orderPlayers[i].whatIsPlanted(r+1, c+1) == 't') { //this means that the location has part of a tree
									System.out.println("Sorry, but that location is already taken by part of a tree.");
									spotFree = false;
								}
								//if the desired coordinates have a flower planted already
								else if (orderPlayers[i].whatIsPlanted(r, c) == 'f' || orderPlayers[i].whatIsPlanted(r+1, c) == 'f' || orderPlayers[i].whatIsPlanted(r, c+1) == 'f' || orderPlayers[i].whatIsPlanted(r+1, c+1) == 'f') { //this means that the location has a flower
									System.out.println("Sorry, but that location is already taken by a flower.");
									spotFree = false;
								}
								else if (orderPlayers[i].whatIsPlanted(r, c) == '-')  //this means that the location is empty
									orderPlayers[i].plantTreeInGarden(r, c);
								}
							else {
								System.out.println("Sorry, but the coordinates you entered are not valid because the tree will be outside the grid.");
								spotFree = false;
							}
						} while (spotFree == false);
						System.out.print("\n" + orderPlayers[i].getName() + ", here is your garden now: \n" + orderPlayers[i].showGarden());
					}
					else
						System.out.println("Sorry. There is no room to plant a tree. You miss your turn.");
					
					//if there are spots for the second tree to be planted
					if (orderPlayers[i].howManyTreesPossible() != 0) {
						System.out.println("Let's continue with the second tree. You have " + orderPlayers[i].howManyTreesPossible() + " place(s) to do this.");
						do {
							System.out.print("Enter the desired coordinates (row, column): "); //ask for user to enter coordinates
							int r = userInput.nextInt();
							int c = userInput.nextInt(); 
							spotFree = true; //
							//if the desired coordinates have part of a tree planted already
							if (r < userGardenSize-1 && c < userGardenSize-1) { //to make sure the coordinates are within the grid of the garden
								if (orderPlayers[i].whatIsPlanted(r, c) == 't' || orderPlayers[i].whatIsPlanted(r+1, c) == 't' || orderPlayers[i].whatIsPlanted(r, c+1) == 't' || orderPlayers[i].whatIsPlanted(r+1, c+1) == 't') { //this means that the location has part of a tree
									System.out.println("Sorry, but that location is already taken by part of a tree.");
									spotFree = false;
								}
								//if the desired coordinates have a flower planted already
								else if (orderPlayers[i].whatIsPlanted(r, c) == 'f' || orderPlayers[i].whatIsPlanted(r+1, c) == 'f' || orderPlayers[i].whatIsPlanted(r, c+1) == 'f' || orderPlayers[i].whatIsPlanted(r+1, c+1) == 'f') { //this means that the location has a flower
									System.out.println("Sorry, but that location is already taken by a flower.");
									spotFree = false;
								}
								else if (orderPlayers[i].whatIsPlanted(r, c) == '-')  //this means that the location is empty
									orderPlayers[i].plantTreeInGarden(r, c);
								}
							else {
								System.out.println("Sorry, but the coordinates you entered are not valid because the tree will be outside the grid.");
								spotFree = false;
							}
						} while (spotFree == false);
						System.out.print("\n" + orderPlayers[i].getName() + ", here is your garden now: \n" + orderPlayers[i].showGarden());
					}
					else
						System.out.println("Sorry. There is no room to plant the second tree.");
					
					if(orderPlayers[i].isGardenFull() == true) { //to check if player has won
						winner = orderPlayers[i].isGardenFull();
						winnerPlayer = orderPlayers[i].getName();
						break;
					}
				}
				
				//if user rolls 2, 4 or 8
				else if (userGameRoll == 2 || userGameRoll == 4 || userGameRoll == 8)  {
					System.out.println("You must plant a tree (2x2).\n");
					System.out.println(orderPlayers[i].showGarden());
					
					//if there are spots for a tree to be planted
					if (orderPlayers[i].howManyTreesPossible() != 0) {
						System.out.println("Let's plant the tree. You have " + orderPlayers[i].howManyTreesPossible() + " place(s) to do this.");
						do {
							System.out.print("Enter the desired coordinates (row, column): "); //ask for user to enter coordinates
							int r = userInput.nextInt();
							int c = userInput.nextInt(); 
							spotFree = true; //
							//if the desired coordinates have part of a tree planted already
							if (r < userGardenSize-1 && c < userGardenSize-1) { //to make sure the coordinates are within the grid of the garden
								if (orderPlayers[i].whatIsPlanted(r, c) == 't' || orderPlayers[i].whatIsPlanted(r+1, c) == 't' || orderPlayers[i].whatIsPlanted(r, c+1) == 't' || orderPlayers[i].whatIsPlanted(r+1, c+1) == 't') { //this means that the location has part of a tree
									System.out.println("Sorry, but that location is already taken by part of a tree.");
									spotFree = false;
								}
								//if the desired coordinates have a flower planted already
								else if (orderPlayers[i].whatIsPlanted(r, c) == 'f' || orderPlayers[i].whatIsPlanted(r+1, c) == 'f' || orderPlayers[i].whatIsPlanted(r, c+1) == 'f' || orderPlayers[i].whatIsPlanted(r+1, c+1) == 'f') { //this means that the location has a flower
									System.out.println("Sorry, but that location is already taken by a flower.");
									spotFree = false;
								}
								else if (orderPlayers[i].whatIsPlanted(r, c) == '-')  //this means that the location is empty
									orderPlayers[i].plantTreeInGarden(r, c);
								}
							else {
								System.out.println("Sorry, but the coordinates you entered are not valid because the tree will be outside the grid.");
								spotFree = false;
							}
						} while (spotFree == false);
						System.out.print("\n" + orderPlayers[i].getName() + ", here is your garden now: \n" + orderPlayers[i].showGarden());
					}
					else
						System.out.println("Sorry. There is no room to plant a tree. You miss your turn.");
					
					if(orderPlayers[i].isGardenFull() == true) { //to check if player has won
						winner = orderPlayers[i].isGardenFull();
						winnerPlayer = orderPlayers[i].getName();
						break;
					}	
				}
				
				//if user rolls 7, 9 or 11
				else if (userGameRoll == 7 || userGameRoll == 9 || userGameRoll == 11)  {
					System.out.println("You must plant a flower (1x1).\n");
					System.out.println(orderPlayers[i].showGarden());
					
					//if there are spots for a flower to be planted
					if (orderPlayers[i].howManyFlowersPossible() != 0) {
						System.out.println("\nLet's plant the flower. You have " + orderPlayers[i].howManyFlowersPossible() + " place(s) to do this.");
						do {
							System.out.print("Enter the desired coordinates (row, column): ");
							int r = userInput.nextInt();
							int c = userInput.nextInt(); 
							spotFree = true;
							if (r < userGardenSize && c < userGardenSize) { //to make sure the coordinates are within the grid of the garden
								if (orderPlayers[i].whatIsPlanted(r, c) == 't') { //this means that the location has part of a tree
									System.out.println("Sorry, but that location is already taken by part of a tree.");
									spotFree = false;
								}
								else if (orderPlayers[i].whatIsPlanted(r, c) == 'f') { //this means that the location has a flower
									System.out.println("Sorry, but that location is already taken by a flower.");
									spotFree = false;
								}
								else if (orderPlayers[i].whatIsPlanted(r, c) == '-') //this means that the location is empty
									orderPlayers[i].plantFlowerInGarden(r, c);
							}
							else {
								System.out.println("Sorry, but the coordinates you entered are not valid because the flower will be outside the grid.");
								spotFree = false;
							}
						} while (spotFree == false);
						System.out.print("\n" + orderPlayers[i].getName() + ", here is your garden now: \n\n" + orderPlayers[i].showGarden());
					}
					
					if(orderPlayers[i].isGardenFull() == true) { //to see if player has won
						winner = orderPlayers[i].isGardenFull();
						winnerPlayer = orderPlayers[i].getName();
						break;
					}	
				}
		
				//if user rolls 5 or 10
				else if ((userGameRoll == 5 || userGameRoll == 10) && numberRounds !=0) { //if numberRounds is 0 then it's the first round so the rabbit can't "eat" anything
					Random rabbit = new Random();
					boolean rabbitEatSpot = false;
					if (orderPlayers[i].isGardenEmpty() == false) { //the rabbit can't "eat" anything if the garden is empty
						System.out.println("Oh no! The rabbit will randomly eat something that you have planted in your garden.");
						System.out.println("\nYour garden before: \n");
						System.out.println(orderPlayers[i].showGarden());
						while (rabbitEatSpot == false) { //this will run until the a flower or part of a tree is removed from the garden
							int r = (int) rabbit.nextInt(userGardenSize);
							int c = (int) rabbit.nextInt(userGardenSize);
							if (orderPlayers[i].whatIsPlanted(r, c) == '-')
								rabbitEatSpot = false;
							else if (orderPlayers[i].whatIsPlanted(r, c) == 't') { //if the rabbit "eats" part of a tree
								orderPlayers[i].eatHere(r, c);
								rabbitEatSpot = true;
								System.out.println("It ate part of the tree in location (" + r + "," + c + ").\n"); 
								}
							else if (orderPlayers[i].whatIsPlanted(r, c) == 'f') { //if the rabbit "eats" a flower
								orderPlayers[i].eatHere(r, c);
								rabbitEatSpot = true;
								System.out.println("It ate part of the flower in location (" + r + "," + c + ").\n");
								}
						}
						System.out.println("Your garden after: \n");
						System.out.println(orderPlayers[i].showGarden());
					}
					else
						System.out.println("But there is nothing in your garden for the rabbit to eat."); //
				}
				else if ((userGameRoll == 5 || userGameRoll == 10) && numberRounds == 0) //there is nothing for the rabbit to eat on the first round
					System.out.println("But there is nothing in your garden for the rabbit to eat.\n");
			}
			numberRounds++; //to count the number of rounds played
		} while (winner == false);
		
		//DISPLAYING WINNER AND RESULTS
		System.out.println("\nWE HAVE A WINNER!");
		System.out.println("FINAL RESULTS: ");
		System.out.println("-----------------");
		System.out.println("Here are the gardens of each player after " + numberRounds + " rounds.\n"); 
		
		for (int i = 0; i < userNumberPlayers; i++) { //to display every player's garden
			System.out.println(orderPlayers[i].getName() + "'s garden:\n");
			System.out.print(orderPlayers[i].showGarden());
		}
	
		System.out.println("And the winner is... " + winnerPlayer.toUpperCase() + "! What a beautiful garden!"); 
		
		//DISPLAY CLOSING MESSAGE
		System.out.println("That was the game! Hope you had fun!");
		userInput.close(); //closing Scanner object
	}
}



