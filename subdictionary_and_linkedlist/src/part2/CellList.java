package part2;
import java.util.NoSuchElementException;

/**
 * This class will be used to create the linked lists for the assignment.
 * @author Samuel Huang
 *
 */
public class CellList {
	
	/**
	 * This inner class will be used to create nodes that will compose the linked list of CellPhone objects.
	 * @author Samuel Huang
	 *
	 */
	public class CellNode {
		
		/**
		 * CellPhone attribute of a CellNode
		 */
		private CellPhone cp;
		
		/**
		 * CellNode attribute of a CellNode
		 */
		private CellNode next;
		
		/**
		 * Default constructor
		 */
		public CellNode() {
			cp = null;
			next = null;
		}
		
		/**
		 * Parameterized constructor
		 * @param cp CellPhone object
		 * @param next CellNode object
		 */
		public CellNode(CellPhone cp, CellNode next) {
			this.cp = cp;
			this.next = next;
		}
		
		/**
		 * Copy constructor
		 * @param copy CellNode that will be copied
		 */
		public CellNode(CellNode copy) {
			cp = copy.cp.clone();
			next = copy.next;
		}
		
		/**
		 * Accessor method for CellPhone object
		 * @return CellPhone object
		 */
		public CellPhone getCellPhone() {
			return this.cp;
		}
		
		/**
		 * Accessor method for CellNode object
		 * @return CellNode object
		 */
		public CellNode getCellNode() {
			return this.next;
		}
			
		/**
		 * Mutator method for CellPhone object
		 * @param cp CellPhone object that will be changed
		 */
		public void setCellPhone(CellPhone cp) {
			this.cp = cp;
		}
		
		/**
		 * Mutator method for CellNode object
		 * @param next CellNode object that will be changed
		 */
		public void setCellNode(CellNode next) {
			this.next = next;
		}
		
		/**
		 * Clone method for a CellNode object
		 */
		public CellNode clone() {
			return new CellNode(this);
		}
	}
	
	/**
	 * CellNode object that will create the CellList
	 */
	private CellNode head;
	
	/**
	 * Integer providing size of the CellList
	 */
	private int size;
	
	/**
	 * Integer providing the number of interations in the find() method
	 */
	private int iterations;
	
	/**
	 * Default constructor
	 */
	public CellList() {
		head = null;
		size = 0;
	}
	
	/**
	 * Parameterized constructor
	 * @param cl CellList
	 */
	public CellList(CellList cl) {
		this.head = cl.head;
		this.size = cl.size;
	}
	
	/**
	 * Method that will add a CellPhone object to the beggining of the CellList
	 * @param x CellPhone
	 */
	public void addToStart(CellPhone x) {
		head = new CellNode(x, head);
		size++;
	}
	
	/**
	 * Method that will insert a CellPhone object at an index in the CellList
	 * @param x CellPhone object	
	 * @param index Index at which the CellPhone will be inserted in the CellList
	 */
	public void insertAtIndex(CellPhone x, int index) {
		if(!(index >= 0 && index <= (size-1))) { //if index is invalid
			try {
				throw new NoSuchElementException();
			}
			catch(NoSuchElementException e) {
				System.out.println("The index is invalid. The program will now terminate.");
				System.exit(0);
			}
		}
		
		else {
			if(index == 0) {
				addToStart(x);
			}
			else {
				CellNode t = head;
				for (int i = 0; i < index-1; i++) {
					t = t.next;
				}
				t.next = new CellNode(x,t.next);
				t = null;
				size++;
			}
		}
	}
	
	/**
	 * Method that will delete the first node in the CellList
	 */
	public void deleteFromStart() {
		if (head == null) {
			System.out.println("There is nothing to delete.");
		}
		
		else {
			head = head.next;
			size--;
		}
	}
	
	/**
	 * Method that will remove a node from the desired index in the CellList
	 * @param index Index of the node that will be removed
	 */
	public void deleteFromIndex(int index) {
		if(!(index >= 0 && index <= (size-1))) { //if index is invalid
			try {
				throw new NoSuchElementException();
			}
			catch(NoSuchElementException e) {
				System.out.println("The index is invalid. The program will now terminate.");
				System.exit(0);
			}
		}
		
		else {
			if (index == 0) {
				deleteFromStart();
			}
			else {
				CellNode t = head;
				for(int i = 0; i < index-1; i++) {
					t = t.next;
				}
				t.next = t.next.next;
				size--;
				t = null;
			}
		}
	}
	
	/**
	 * Method that will replace a CellPhone object of a CellNode in a specific index in the CellList with another CellPhone object
	 * @param x CellPhone object	
	 * @param index Index of the CellPhone object of a CellNode that will be replaced by another CellPhone object
	 */
	public void replaceAtIndex(CellPhone x, int index) {
		if(!(index >= 0 && index <= (size-1))) { //if index is invalid
			try {
				throw new NoSuchElementException();
			}
			catch(NoSuchElementException e) {
				System.out.println("The index is invalid. The program will now terminate.");
				System.exit(0);
			}
			
			
		}
		
		else {
			if (index == 0) {
				head = new CellNode(x, head.next);
			}
			else {
				CellNode t = head;
				for(int i = 0; i < index-1; i++) {
					t = t.next;
				}
				t.next = new CellNode(x, t.next.next);
				t = null;
			}
		}
	}
	
	/**
	 * Method that will tell return a boolean depending on if the CellList contains a CellNode with a CellPhone object that has the desired serial number.
	 * @param serialNum Long Serial number that is compared with
	 * @return True if the CellList contains a CellNode with a CellPhone object with the same serial number as the one passed in the parameter
	 */
	public boolean contains(long serialNum) {
		if (head == null) {
			return false;
		}
		else {
			CellNode t = head;
			while(t.next != null && t.cp.getSerialNum() != serialNum) {
				t = t.next;
			}
			if(t.cp.getSerialNum() == serialNum) {
				t = null;
				return true;
			}
			else {
				t = null;
				return false;
			}
		}
	}
	
	/**
	 * Method that will return the size of the CellList
	 * @return Integer representing the size of the CellList
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Method that will display the content of the CellList
	 */
	public void showContents() {
		if(size == 0) {
			System.out.println("The list is empty. There is no information to display.");
		}
		else {
			System.out.println("\nThe current size of the list is " + size + ". Here are the contents of the list."
				+ "\n===============================================");
			CellNode t = head;
			while(t != null) {
				System.out.print("[" + t.cp.getSerialNum() + ": " + t.cp.getBrand() + " " + t.cp.getPrice() + "$ " + t.cp.getYear() + "]" + " ---> ");
				t = t.next;
			}
			System.out.println("X");
		}
	}
	
	/**
	 * Method that returns if two CellLists are equal to each other
	 * @param other Other CellList
	 * @return True if both CellLists are equal, false otherwise
	 */
	public boolean equals(CellList other) {
		if(this == null || other == null) {
			return false;
		}
		else if(this.size == other.size) {
				CellNode t1 = this.head;
				CellNode t2 = other.head;
			while (t1.cp.equals(t2.cp) && t1.next != null) {
					t1 = t1.next;
					t2 = t2.next;
				}
			if(t1.cp.equals(t2.cp)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	/**
	 * Method that will return the number of iterations (to be used in the find() method)
	 * @return Integer representing the number of iterations made
	 */
	public int getIterations() {
		return iterations;
	}
	
	/**
	 * Method that will return the CellNode that contains the CellPhone object with the serial number passed in the parameter.
	 * !!IMPORTANT!! Because this method is public and the CellNode class is also public, it will result in a privacy leak. This
	 * is due to the fact that since this method returns a pointer to the CellNode that is found, the user can use the accessors
	 * mutators in the CellNode class to modify the content the of the list. This consequently allows the user to destroy the list.
	 * To avoid this issue, we can make the class CellNode private, or make the method find() private, or simply return a clone
	 * of the CellNode that is found with the method find().
	 * @param serialNum Long serial number that will be compared to
	 * @return CellNode that contains the CellPhone object with the serial number passed in the parameter
	 */
	public CellNode find(long serialNum) {
		if (head == null) {
			return null;
		}
		else {
			iterations = 1;
			CellNode t = head;
			while (t.next != null && t.cp.getSerialNum() != serialNum) {
				iterations++;
				t = t.next;
			}
			if(t.cp.getSerialNum() == serialNum) {
				return t;
			}
			else {
				return null;
			}
		}
	}
}

	

