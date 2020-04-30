// -----------------------------------------------------
// Assignment 4
// Question 2
// Written by: Samuel Huang (40098855)
// -----------------------------------------------------

package part2;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This class will demonstrate the utilization of the CellList, CellPhone and CellNode classes.
 * @author Samuel Huang
 *
 */
public class CellListUtilization {

	public static void main(String[] args) {
		
		CellList c1 = new CellList();
		CellList c2 = new CellList();
		CellList c3 = new CellList();
		Scanner sc = null; //scanner for the input file
		Scanner kb = new Scanner(System.in); //for user input
		
		//to try and open the input file
		try {
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	
		//this will read through the entire input file
		while(sc.hasNext()) {
			long serialNum = sc.nextLong();
			String brand = sc.next();
			double price = sc.nextDouble();
			int year = sc.nextInt();
			//creating the CellPhone object with the information obtained
			CellPhone cp = new CellPhone(serialNum, brand, year, price);
			//if the CellList does not contain the CellPhone already, it will add it; otherwise, it won't
			if(!(c1.contains(cp.getSerialNum()))) {
				c1.addToStart(cp);
			}
		}
		//to display the contents of the CellList
		c1.showContents();
		
		System.out.println();
		//ask user for serial numbers to search
		System.out.print("Please enter three serial numbers that you would like to find. \n"
				+ "\nFirst serial number: ");
		long serialNum1 = kb.nextLong();
		if (c1.find(serialNum1) != null){
			System.out.println("Here is the information of the cellphone with this serial number (after " + c1.getIterations() + " iteration(s)): \n"
					+ "==============================");
			CellList.CellNode cn1 = c1.find(serialNum1);
			System.out.println("Brand: " + cn1.getCellPhone().getBrand());
			System.out.println("Price: " + cn1.getCellPhone().getPrice() + "$");
			System.out.println("Year: " + cn1.getCellPhone().getYear());
		}
		else {
			System.out.println("There is no cellphone with this serial number.");
		}
		
		System.out.print("\nSecond serial number: ");
		long serialNum2 = kb.nextLong();
		if (c1.find(serialNum2) != null){
			System.out.println("\nHere is the information of the cellphone with this serial number (after " + c1.getIterations() + " iteration(s)): \n"
					+ "==============================");
			CellList.CellNode cn2 = c1.find(serialNum2);
			System.out.println("Brand: " + cn2.getCellPhone().getBrand());
			System.out.println("Price: " + cn2.getCellPhone().getPrice() + "$");
			System.out.println("Year: " + cn2.getCellPhone().getYear());
		}
		else {
			System.out.println("There is no cellphone with this serial number.");
		}
		
		System.out.print("\nThird serial number: ");
		long serialNum3 = kb.nextLong();
		if (c1.find(serialNum3) != null){
			System.out.println("\nHere is the information of the cellphone with this serial number (after " + c1.getIterations() + " iteration(s)): \n" 
					+ "==============================");
			CellList.CellNode cn3 = c1.find(serialNum2);
			System.out.println("Brand: " + cn3.getCellPhone().getBrand());
			System.out.println("Price: " + cn3.getCellPhone().getPrice() + "$");
			System.out.println("Year: " + cn3.getCellPhone().getYear());
		}
		else {
			System.out.println("There is no cellphone with this serial number.");
		}
		
		System.out.println("\n\n\nDEMONSTRATION OF METHODS "
				+ "\n==========================");
		System.out.println("\n1. Demonstrating if the CellList c2 is empty or not: ");
		c2.showContents();
		
		//demonstration of addToStart() method
		
		System.out.println("\n2. Demonstrating the addToStart() method: ");
		CellPhone test1 = new CellPhone(10000, "Samsung", 2010, 800);
		CellPhone test2 = new CellPhone(10001, "Nokia", 1998, 50);
		CellPhone test3 = new CellPhone(10003, "iPhone", 2018, 1200);
		CellPhone test4 = new CellPhone(10004, "Blackberry", 2006, 200);
		System.out.println("\nAdding first CellPhone object: ");
		c2.addToStart(test1);
		c2.showContents();
		System.out.println("\nAdding second CellPhone object: ");
		c2.addToStart(test2);
		c2.showContents();
		System.out.println("\nAdding the two other CellPhone objects: ");
		c2.addToStart(test3);
		c2.addToStart(test4);
		c2.showContents();
		
		//demonstration of insertAtIndex() method
		
		System.out.println("\n3. Demonstrating the insertAtIndex() method from CellList class as well as clone() method from CellPhone class: ");
		System.out.println("\nInserting a clone of the Samsung cellphone at index 0. ");
		CellPhone test5 = test1.clone();
		c2.insertAtIndex(test5, 0);
		c2.showContents();
		System.out.println("\nInserting a clone of the Nokia cellphone at index 3. ");
		CellPhone test6 = test2.clone();
		c2.insertAtIndex(test6, 3);
		c2.showContents();
		
		//demonstration of deleteFromStart() method
		
		System.out.println("\n4. Demonstrating the deleteFromStart() method: ");
		System.out.println("\nDeleting the cellphone at the start of the CellList: ");
		c2.deleteFromStart();
		c2.showContents();
		System.out.println("\nAttempt to delete from an empty list: ");
		c3.deleteFromStart();
		c3.showContents();
		
		//demonstration of deleteFromIndex() method
		
		System.out.println("\n5. Demonstrating the deleteFromIndex() method: ");
		System.out.println("\nDeleting the cellphone from index 0:" );
		c2.deleteFromIndex(0);
		c2.showContents();
		System.out.println("\nDeleting the cellphone from index 3:" );
		c2.deleteFromIndex(3);
		c2.showContents();
		
		//demonstration of the replaceAtIndex() method
		
		System.out.println("\n6. Demonstrating the replaceAtIndex() method: ");
		System.out.println("Creating a CellPhone object with brand \"Huawei\".");
		CellPhone test7 = new CellPhone(10005, "Huawei", 2017, 900);
		System.out.println("\nReplacing the cellphone from index 0:" );
		c2.replaceAtIndex(test7, 0);
		c2.showContents();
		System.out.println("\nReplacing the cellphone from index 3:" );
		c2.replaceAtIndex(test7, 2);
		c2.showContents();
		
		//demonstration of the contains() method
		
		System.out.println("\n7. Demonstrating the contains() method:");
		System.out.print("\nThe list contain a CellPhone object with serial number 10005: ");
		System.out.println(c2.contains(10005));
		System.out.print("\nThe list contain a CellPhone object with serial number 12345: ");
		System.out.println(c2.contains(12345));
		
		//demonstration of the equals() method
		
		System.out.println("\n8. Demonstrating the equals() method:");
		
		System.out.println("\nDisplaying contents of list 1.");
		c2.showContents();
		System.out.println("\nCreating a list identical to the one above (except for serial number).");
		c3.addToStart(new CellPhone(12345, "Huawei", 2017, 900));
		c3.addToStart(new CellPhone(54321, "Nokia", 1998, 50));
		c3.addToStart(new CellPhone(11111, "Huawei", 2017, 900));
		c3.showContents();
		System.out.print("\nThe two lists equal: ");
		System.out.println(c2.equals(c3));
		
		System.out.println("\nDisplaying a list that is different to the one above.");
		c1.showContents();
		System.out.print("\nThe two lists are equal: ");
		System.out.println(c1.equals(c2));
		
		//demonstration of the find() method
		
		System.out.println("\n9. Demonstrating the find() method:");
		System.out.println("This is the list being used: ");
		c1.showContents();
		System.out.print("\nUsing the method to find the CellNode with CellPhone object with serial number 5909887: ");
		System.out.println(c1.find(5909887));
		System.out.print("\nUsing the method to find the CellNode with CellPhone object with serial number 1234567: ");
		System.out.println(c1.find(1234567));
		
		//demonstration of the danger of find() method
		
		System.out.println("\n10. Demonstrating the consequences of privacy leak: ");
		System.out.println("\nCreating a CellNode with the pointer resulting from the find() method (serial number 1119000).");
		CellList.CellNode destroyer = c1.find(1119000);
		System.out.println("\nDisplaying list before privacy leak.");
		c1.showContents();
		System.out.println("\nDisplaying list after privacy leak.");
		destroyer.setCellNode(null);
		c1.showContents();
		System.out.println("\nAs displayed above, the list can be destroyed because of the privacy leak.");
		
		sc.close();
		kb.close();
	}

}
