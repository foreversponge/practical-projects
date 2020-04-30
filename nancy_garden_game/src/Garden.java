// -------------------------------------------------------
// Date: 30 November 2018
// -------------------------------------------------------
/* The purpose of this program to define a class named Garden that will create objects, access them, mutate them, as well as initializing
 * a garden so it only contains '-' characters as well as booleans that tell the user if the garden is full or empty. This class will also
 * print out the garden itself in a string. */

public class Garden {

	char garden[][]; //array that will represent the garden of each player
	
	//default garden constructor
	public Garden() {
		this.garden = new char[3][3];
		initializeGarden(3);
	}
	
	//garden constructor that 
	public Garden(int gardenSize) {
		this.garden = new char[gardenSize][gardenSize];
		initializeGarden(gardenSize);
	}

	//initialize the garden by "filling" it with the character '-'
	private void initializeGarden(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.garden[i][j] = '-';
			}
		}
	}
	
	//to get the character in the desired location
	public char getInLocation(int r, int c) {
		return garden[r][c];
	}

	//to insert the character 'f' at the desired location
	public void plantFlower(int r, int c) {
		this.garden[r][c] = 'f';
	}
	
	//to insert the character 't' at the desired locations
	public void plantTree(int r, int c) {
		this.garden[r][c] = 't';
		this.garden[r+1][c] = 't';
		this.garden[r][c+1] = 't';
		this.garden[r+1][c+1] = 't';
	}
	
	//to remove the character at the desired location
	public void removeFlower(int r, int c) {
		this.garden[r][c] = '-';
	}
	
	//to get the number of possible locations to insert the 't' character
	public int countPossibleTrees() {
		int counter = 0;
		for (int i = 0; i < this.garden.length-1; i++) {
			for (int j = 0; j < this.garden.length-1; j++) { 
				if (this.garden[i][j] == '-' && this.garden[i][j+1] == '-' && this.garden[i+1][j] == '-' && this.garden[i+1][j+1] == '-') //since the tree takes a 2x2 square
					counter ++;
			}
		}
		return counter;
	}
	
	//to get the number of possible locations to insert the 'f' character
	public int countPossibleFlowers() {
		int counter = 0;
		for (int i = 0; i < this.garden.length; i++) {
			for (int j = 0; j < this.garden.length; j++) {
				if (this.garden[i][j] == '-')
					counter ++;
			}
		}
		return counter;
	}	
	
	//to see if the garden is full or not
	public boolean gardenFull() {
		int counter = 0;
		for (int i = 0; i < this.garden.length; i++) {
			for (int j = 0; j < this.garden.length; j++) {
				if (this.garden[i][j] == '-')
					counter++; 
			}
		}
		if (counter == 0) //if counter is not zero then it means that the garden is not full since there is a '-' (empty space) in the garden
			return true;
		else
			return false;
	}
	
	//to see if the garden is empty or not
	public boolean gardenEmpty() {
		int counter = 0;
		for (int i = 0; i < this.garden.length; i++) {
			for (int j = 0; j < this.garden.length; j++) {
				if (this.garden[i][j] == 't' || this.garden[i][j] == 'f')
					counter++;
			}
		}
		if (counter == 0) //if counter is zero then it means that all the locations in the garden is NOT filled with 't' or 'f' (so it's empty)
			return true;
		else
			return false;
	}

	//to print out what the garden looks like
	public String toString() {
		String firstRow = "  | "; 
		for (int i = 0; i < this.garden.length; i++) //to display the first row of the grid
			firstRow += i + " ";
		
		firstRow += "\n";
		
		String otherRows = ""; 

		for (int i = 0; i < this.garden.length; i++) { //to display the other rows of the grid
			if (i < 10) { //so the spaces between the locations are not shifted weirdly
				otherRows += i + " | ";
				for (int j = 0; j < this.garden.length; j++) {
					if (j >= 10) //so the spaces between the locations are not shifted weirdly
						otherRows += this.garden[i][j] + "  ";
					else
						otherRows += this.garden[i][j] + " ";
				}
			}
			
			if(i >= 10) { //so the spaces between the locations are not shifted weirdly
				otherRows += i + "| ";
				for (int j = 0; j < this.garden.length; j++) {
					if (j >= 10)
						otherRows += this.garden[i][j] + "  ";
					else
						otherRows += this.garden[i][j] + " ";
				}
			}
			otherRows += "\n";
		}
		String gardenMatrix = firstRow + otherRows;
		return gardenMatrix;
	}
			
}

