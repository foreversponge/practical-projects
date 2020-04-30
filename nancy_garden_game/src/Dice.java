// -------------------------------------------------------
// Date: 30 November 2018
// -------------------------------------------------------
/* The purpose of this program to define a class named Dice that will create objects, access them as well as returning the sum of two random
 * dice rolls. It will also print out the result of each die roll. */ 

import java.util.Random;

public class Dice {

	//two dice attributes
	private int dice1;
	private int dice2;
	
	//default constructor
	public Dice() {
		this.dice1 = 0;
		this.dice2 = 0;
	}
	
	//accessor to return value of the first dice
	public int getDice1() {
		return this.dice1;
	}
	
	//accessor to return the value of the second dice
	public int getDice2() {
		return this.dice2;
	}
	
	//method that simulates rolling two dices and returning their sum
	public int rollDice() {
		Random random = new Random();
		this.dice1 = (int) random.nextInt(6)+1;
		this.dice2 = (int) random.nextInt(6)+1;
		int sum = this.dice1 + this.dice2;
		return sum;
	}
	
	//to display the value of each die
	public String toString() {
		String sentence = "Die 1: " + this.dice1 + "| Die 2: " + this.dice2;
		return sentence;
	}
}
