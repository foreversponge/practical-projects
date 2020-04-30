// -------------------------------------------------------
// Date: 12 November 2018
// -------------------------------------------------------
/* The purpose of this program is to generate a road map of matches to represent the FIFA World Cup. The program will keep generating
 * random tournament results as well as random scores until the user's desired team wins a tournament or until the maximum number of 
 * tournaments is reached (20, in this case). The program will then display statistics of the tournaments that were generated, such as 
 * the average number of goals in each match, the average number of goals in each tournament and the number of matches that had goals
 * above that average. */

import java.util.Scanner;
import java.util.Random;

public class fifa_simulation {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the FIFA WORLD CUP SIMULATOR. This program will generate a FIFA World Cup road map of matches with the following teams: \nUruguay, Portugal, France, Argentina, Brazil,"
						+ " Mexico, Belgium, Japan, Spain, Russia, Croatia, Denmark, Sweden, Switzerland, Colombia, England.\n"); //to display welcome banner
		
		Scanner userInput = new Scanner(System.in); //creating a scanner object called "user_input"
		
		Random random = new Random(); //creating an object to generate random numbers
		
		boolean testValidity = false; //boolean that will be used to test the user's input's validity
		
		String[] teams16 = {"Uruguay", "Portugal", "France", "Argentina", "Brazil", "Mexico",
				"Belgium", "Japan", "Spain", "Russia", "Croatia", "Denmark", "Sweden", "Switzerland",
				"Colombia", "England"}; //creating an array containing all the teams that will play in the tournament
		
		int [][] goalsMatch = new int[15][20]; //creating an array that will contain the number of goals in every match in a tournament
		String[] teams8 = new String[8]; //creating an array that will contain the 8 teams that will pass the first round
		String[] teams4 = new String[4]; //creating an array that will contain the 4 teams that will pass the quarter-finals
		String[] teams2 = new String[2]; //creating an array that will contain the 2 teams that will pass the semi-finals
		String[] winner = new String[1]; //creating an array that will contain the winning team of the tournament
		
		int suddenDeath = 0; //to be used to determine which team will win in a situation where a match is tied
		
		String[] userChoice = new String[1]; //an array that will contain the user's desired team
		String[][] round1 = new String[8][2]; //a 2-D array that will contain the matches (between two teams) in the first round
		int[][] score1 = new int[8][2]; //a 2-D array that will contain the scores (of two teams) in the first round
		String[][] round2 = new String[4][2]; //a 2-D array that will contain the matches (between two teams) in the quarter-finals
		int[][] score2 = new int[4][2]; //a 2-D array that will contain the scores (of two teams) in the quarter-finals
		String[][] round3 = new String[4][2]; //a 2-D array that will contain the matches (between two teams) in the semi-finals
		int[][] score3 = new int[4][2]; //a 2-D array that will contain the scores (of two teams) in the semi-finals
		String[][] round4 = new String[2][2]; //a 2-D array that will contain the matches (between two teams) in the finals
		int[][] score4 = new int[2][2]; //a 2-D array that will contain the scores (of two teams) in the finals
		int counter, tourn; //to keep count of the number of tournaments that were generated and to keep track of which tournament is
							//being played
		
		
		
		/* START OF VERIFICATION: the following code will verify the user's input (to make sure that the user does indeed choose a team
		 * that is in the list of teams available */
		
		do {
			System.out.print("Enter your favorite team: ");
			String userFavTeam = userInput.nextLine(); //to define the user's desired team as a string
			userChoice[0] = userFavTeam; //storing the user's desired team in an array
			System.out.println(); 
			
			for (int i = 0; i < teams16.length - 1 ; i++) // to go through every element in the array containing the teams available  
				if (teams16[i].equalsIgnoreCase(userFavTeam)) //and to see if the user's desired team is part of that array 
						testValidity = true;
				if (testValidity == false)
				System.out.print("Your team is not in the Round of 16.\n\n");
		}
		while (testValidity == false);
		
		/* END OF VERIFICATION */
		
		
		/* START OF GENERATING TOURNAMENTS: the following code will generate tournaments and display scores of every match until
		 * the user's desired team wins or until the maximum number of tournaments has been generated */
		
		for(counter = 1, tourn = 0; counter <= 20; counter++, tourn++) {
		
			System.out.println("ROUND OF 16: \n"); 
		
			for (int i = 0, j = 0; i <= teams16.length-1; i+=2, j++) { //this code will place the array of 16 strings (teams) into
				round1[j][0] = teams16[i];							   //the array that represents the first round
				round1[j][1] = teams16[i+1];
			}
		
			for(int x = 0; x <= (teams16.length-1)/2; x++) { //to generate random numbers to represent the goals scored
				score1[x][0] = (int) random.nextInt(5);      //by each team in each match in the round of 16
				score1[x][1] = (int) random.nextInt(5); 	 //and placing the goals into an array
				
				if (score1[x][0] == score1[x][1]) { //to randomly determine which team has a higher score (the sudden death situation)
					suddenDeath = random.nextInt(2);
					if (suddenDeath == 0)
						score1[x][0] += 1;
					if (suddenDeath == 1)
						score1[x][1] += 1;
				}
				goalsMatch[x][tourn] = score1[x][0] + score1[x][1]; //to keep track of the number of goals scored in that match
			}
			
			for (int i = 0; i <= (teams16.length-1)/2; i++) //to print out the result of the match
				System.out.println("[" + round1[i][0] + " " + score1[i][0] + ":" + + score1[i][1] + " " + round1[i][1] + "]");
			
			for (int z = 0; z <= (teams16.length-1)/2; z++) { 

				if (score1[z][0] > score1[z][1])
					teams8[z] = round1[z][0];
				else 
					teams8[z] = round1[z][1];
				}
		
			System.out.println("\nQUARTER-FINALS: ");
		
			for (int i = 0, j = 0; i <= teams8.length-1; i+=2, j++) { //to place each element in the array of 8 strings (teams) into
				round2[j][0] = teams8[i];						      //the array that represents the second round
				round2[j][1] = teams8[i+1];
			}
		
			for(int x = 0; x <= (teams8.length-1)/2; x++) { //to generate random numbers to represent the goals scored
				score2[x][0] = (int) random.nextInt(5);		//by each team in each match in the quarter-finals
				score2[x][1] = (int) random.nextInt(5);		// and placing the goals into an array
				
				if (score2[x][0] == score2[x][1]) { //to randomly determine which team has a higher score (the sudden death situation)
					suddenDeath = random.nextInt(2);
					if (suddenDeath == 0)
						score2[x][0] += 1;
					if (suddenDeath == 1)
						score2[x][1] += 1;
				}
				goalsMatch[x+8][tourn] = score2[x][0] + score2[x][1]; //to keep track of the number of goals scored in each match
			}
			
			for (int i = 0; i <= (teams8.length-1)/2; i++) //to print out the result of the match
				System.out.println("[" + round2[i][0] + " " + score2[i][0] + ":" + + score2[i][1] + " " + round2[i][1] + "]");
		
			for (int z = 0; z <= (teams8.length-1)/2; z++) {

				if (score2[z][0] > score2[z][1]) 
					teams4[z] = round2[z][0];
			
				if (score2[z][0] < score2[z][1]) 
					teams4[z] = round2[z][1];
			}
		
			System.out.println("\nSEMI-FINALS: ");
		
			for (int i = 0, j = 0; i <= teams4.length-1; i+=2, j++) { //to place each element in the array of 4 strings (teams) into
				round3[j][0] = teams4[i];							  //the array that represents the third round
				round3[j][1] = teams4[i+1];	
			}
		
			for(int x = 0; x <= (teams4.length-1)/2; x++) { //to generate random numbers to represent the goals scored
				score3[x][0] = (int) random.nextInt(5); //by each team in each match in the semi-finals 
				score3[x][1] = (int) random.nextInt(5); //and placing the goals into an array
				
				if (score3[x][0] == score3[x][1]) { //to randomly determine which team has a higher score (the sudden death situation)
					suddenDeath = random.nextInt(2);
					if (suddenDeath == 0)
						score3[x][0] += 1;
					if (suddenDeath == 1)
						score3[x][1] += 1;
				}
				goalsMatch[x+12][tourn] = score3[x][0] + score3[x][1]; //to keep track of the number of goals scored in each match
			} 
			for (int i = 0; i <= (teams4.length-1)/2; i++) //to print out the result of the match
			System.out.println("[" + round3[i][0] + " " + score3[i][0] + ":" + + score3[i][1] + " " + round3[i][1] + "]");
		
			for (int z = 0; z <= (teams4.length-1)/2; z++) {

				if (score3[z][0] > score3[z][1]) 
					teams2[z] = round3[z][0];
			
				if (score3[z][0] < score3[z][1]) 
					teams2[z] = round3[z][1];
			}
		
			System.out.println("\nFINALS: ");
		
			for (int i = 0, j = 0; i <= teams2.length-1; i+=2, j++) { //to place each element in the array of 2 strings (teams) into
				round4[j][0] = teams2[i];							  //the array that represents the fourth round
				round4[j][1] = teams2[i+1];
			}
			
			for(int x = 0; x <= (teams2.length-1)/2; x++) { //to generate random numbers to represent the goals scored
				score4[x][0] = (int) random.nextInt(5); //by each team in each match in the finals
				score4[x][1] = (int) random.nextInt(5); //and placing the goals into an array
				
				if (score4[x][0] == score4[x][1]) { //to randomly determine which team has a higher score (the sudden death situation)
					suddenDeath = random.nextInt(2);
					if (suddenDeath == 0)
						score4[x][0] += 1;
					if (suddenDeath == 1)
						score4[x][1] += 1;
				}
				goalsMatch[14][tourn] = score4[x][0] + score4[x][1]; //to keep track of the number of goals scored in each match
			}
			
			for (int i = 0; i <= (teams2.length-1)/2; i++) //to print out the result of the match
				System.out.println("[" + round4[i][0] + " " + score4[i][0] + ":" + + score4[i][1] + " " 
						+ round4[i][1] + "]\n");
		
			for (int z = 0; z <= (teams2.length-1)/2; z++) { //to determine which team is the winner of the tournament

				if (score4[z][0] > score4[z][1]) 
					winner[z] = round4[z][0];
			
				if (score4[z][0] < score4[z][1]) 
					winner[z] = round4[z][1];
			}
		
			String winningTeam = winner[0]; 
			System.out.println("Tournament: " + counter); //to display which tournament has been generated
			System.out.println("The winner is: " + winningTeam + "\n"); //to display the winning team of that tournament
		
			if (winningTeam.equalsIgnoreCase(userChoice[0])) { //to display that the winning team is the user's desired team and how many tournaments it took for that team to win
				System.out.println("It took " + counter + " tournament(s) of the game for " + winningTeam + " to win!");
				break;
			}
			else if (counter == 20) { //to display that the user's desired team has not won after the maximum number of tournaments has been played
				System.out.print("Sorry, the maximum number of tournaments have been played and " 
						+ (String)userChoice[0].substring(0,1).toUpperCase() 
						+ userChoice[0].substring(1) +  " has not won.\n");
			}
			
		}
		
		/*END OF GENERATING TOURNAMENTS */
		
		
		/*START OF GOAL STATS */
		
		if (counter == 21) //in the case that the number of tournaments reaches 20 so that the counter will stay at 20
			counter -= 1;
			
		System.out.print("\n\nGOAL STATS\n");
		
		double totalAvgGoalTourn = 0;  //creating a double that will store the value of the total average of goals scored in all tournaments
		double roundedTotalAvgGoalTourn = 0; //creating a double that will store rounded average goals of all tournaments
		int matchesOverAverage = 0; //creating a double that will store the number of matches that was above the goals average of all tournaments
		int i, j;
		
		for (i = 0, j = 0; i < counter && i <= 19 ; i++, j++) {
				double totalGoalsTourn = 0; //double that represents the total goals in tournament
				double avgMatch; //to store the average number of goals scored per match
				System.out.print("\n[Tournament " +  j + "] Total goals: ["); //to display the number of goals scored in every match in every tournament
				for (int x = 0; x <= 14; x++) {
					if (x <14) {
						totalGoalsTourn += goalsMatch[x][i];
						System.out.print(goalsMatch[x][i] + ",");
					}
					if (x == 14) { //last "number of goals" in a tournament
						totalGoalsTourn += goalsMatch[14][i];
						System.out.print(goalsMatch[14][i] + "]");
					}
				}
				avgMatch = Math.round((totalGoalsTourn / 15) * 10.0)/ 10.0;
				System.out.print(" [Average :" + avgMatch + "]"); //to display the average number of goals scored in all matches in one tournament
				totalAvgGoalTourn += avgMatch; 
		}
		
		roundedTotalAvgGoalTourn = Math.round((totalAvgGoalTourn/j)*10.0)/10.0; 
		
		System.out.println("\n\nAverage goals for " + (counter) + " tournament(s): " + roundedTotalAvgGoalTourn); //to display the average goals for the number of tournaments played
		
		for (int z = 0; z < counter; z++) {
			for (int w = 0 ; w <=14; w++) {
				if (goalsMatch[w][z] > roundedTotalAvgGoalTourn) 
					matchesOverAverage += 1;
			}
		}
		
		System.out.println("Total matches in all tournaments that are above the average goal value: " + matchesOverAverage); //to display the number of matches that had a number of goal higher than the
																															 //average number of goals for all tournaments
		
		System.out.println("\nThank you for using FIFA WORLD CUP SIMULATOR!"); //to display closing message
		
		userInput.close(); //to close the scanner object
	}

}






