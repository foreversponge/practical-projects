// -------------------------------------------------------
// Date: 30 November 2018
// -------------------------------------------------------
/* The purpose of this program to define a class named Player that will create objects, access them, as well as return information about
 * the garden of a player, such as the number of flowers or trees that can be planted, the plant that is in a certain location in the
 * garden, if the garden is empty or full, and printing out the garden. It also has methods that will simulate the action of planting
 * a flower or tree in the garden as well as remove them (simulating the rabbit eating them). */

public class Player {

	String name; //string 
	private Garden garden; //garden
	
	
	//constructor that will contain the player's name and the size of his/her garden
	public Player(String userName, int gardenSize) {
		this.name = userName;
		this.garden = new Garden(gardenSize);
	}
	
	//to get the name of the player
	public String getName() {
		return this.name;
	}
	
	//to call the method in the Garden class to get the number of flowers that can be planted in the player's garden
	public int howManyFlowersPossible() {
		return this.garden.countPossibleFlowers();
	}
	
	//to call the method in the Garden class to get the number of trees that can be planted in the player's garden
	public int howManyTreesPossible() {
		return this.garden.countPossibleTrees();
	}
	
	//to call the method in the Garden class to get what is planted at the location desired in the player's garden
	public char whatIsPlanted(int r, int c) {
		return this.garden.getInLocation(r, c);
	}
	
	//to call the method in the Garden class to insert the desired character 't' in the desired locations in the player's garden
	public void plantTreeInGarden(int r, int c) {
		this.garden.plantTree(r, c);
	}
	
	//to call the method in the Garden class to insert the desired character 'f' in the desired location in the player's garden
	public void plantFlowerInGarden(int r, int c) {
		this.garden.plantFlower(r, c);
	}
	
	//to call the method in the Garden class to remove the character at the desired location in the player's garden
	public void eatHere(int r, int c) {
		this.garden.removeFlower(r, c);
	}
	
	//to call the method in the Garden class to see if the garden is full or not
	public boolean isGardenFull() {
		return this.garden.gardenFull();
	}
	
	//to call the method in the Garden class to see if the garden is empty or not
	public boolean isGardenEmpty() {
		return this.garden.gardenEmpty();
	}
	
	//to call the method in the Garden class to print out what the garden looks like
	public String showGarden() {
		return this.garden.toString();
	}
}
