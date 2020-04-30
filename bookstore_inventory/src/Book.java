// -----------------------------------------------------
/* The purpose of this program to define a class named Book that will create objects, access them and mutate them. It also contains
 * methods that will print out the information about the object, the number of books created and if a book is equal to another.*/



/**
 * The Book class implements methods to create Book objects, copy them, access them and mutate them. It also contains methods that
 * will print out the information about the Book, the number of Books created and if a Book is equal to another.
 * @author Samuel Huang
 * Book class that contains 
 */

public class Book {
	
	/**
	 * Title of book
	 */
	String title;
	
	/**
	 * Author of book
	 */
	String author;
	
	/**
	 * ISBN of book 
	 */
	long ISBN;
	
	/**
	 * Price of book
	 */
	double price;
	
	/**
	 * Number of created Books
	 */
	static int numberOfCreatedBooks = 0;
	
	/**
	 * Book constructor
	 */
	public Book() {
		title = "N/A";
		author = "N/A";
		ISBN = 0;
		price = 0.0;
		numberOfCreatedBooks++;
	}
	
	/**
	 * This method creates a parameterized object Book
	 * @param title Title of the book
	 * @param author Author of the book
	 * @param ISBN ISBN of the book
	 * @param price Price of the book
	 */
	public Book(String title, String author, long ISBN, double price) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.price = price;
		numberOfCreatedBooks++;
	}
	
	/**
	 * This method creates a copy of an object Book
	 * @param other The other object Book that you wish to compare to
	 */
	public Book(Book other) {
		this.title = other.title;
		this.author = other.title;
		this.ISBN = other.ISBN;
		this.price = other.price;
		numberOfCreatedBooks++;
	}
	
	/**
	 * This method lets the user change the number of created books
	 * @param number The number of created books that the user wishes to change to
	 */
	public void setNumberCreatedBooks(int number) {
		numberOfCreatedBooks = number;
	}
	
	/**
	 * This method returns the title of an object Book
	 * @return Title of the object Book
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * This method returns the author of an object Book
	 * @return Author of the object Book
	 */
	public String getAuthor() {
		return this.author;
	}
	
	/**
	 * This method returns the ISBN of an object Book
	 * @return ISBN of the object Book
	 */
	public long getISBN() {
		return this.ISBN;
	}
	
	/**
	 * This method returns the price of an object Book
	 * @return Price of the object book
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * This method lets the user change the title of an object Book
	 * @param title The new title that the user wants
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * This method lets the user change the author of an object Book
	 * @param author The new author that the user wants
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * This method lets the user change the ISBN of an object Book
	 * @param ISBN The new ISBN that the user wants
	 */
	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}
	
	/**
	 * This method lets the user change the price of an object Book
	 * @param price The new price that the user wants
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * This method returns the author, title, ISBN and price of an object Book
	 * @return Author, title, ISBN and price of object Book
	 */
	public String toString() {
		String sentence = "Author: " + this.author.substring(0,1).toUpperCase() + this.author.substring(1).toLowerCase() + "\n"
				+ "Title: " + this.title + "\n"
				+ "ISBN: " + this.ISBN + "#\n"
				+ "Price: $" + this.price + "\n";
		return sentence;
	}
	
	/**
	 * This method returns the number of created object Books
	 * @return Number of created object Books
	 */
	public static int findNumberOfCreatedBooks() {
		return numberOfCreatedBooks;
	}
	
	/**
	 * This method tells the user if an object Book has the same ISBN and price of another object Book
	 * @param other The other object Book that is being compared
	 * @return True if the two object Books have the same ISBN and price, false otherwise
	 */
	public boolean equals(Book other) {
		if ((this.ISBN == other.ISBN) && (this.price == other.price))
			return true;
		else
			return false;
	}
	
}

	
	