/**
 * This class will be used to create, access and mutate CellPhone objects, as well as return its information and check equality between two of these objects.
 * @author Samuel Huang
 *
 */
public class CellPhone {

	/**
	 * Serial Number of the CellPhone object
	 */
	private long serialNum;
	/**
	 * Brand of the CellPhone object
	 */
	private String brand;
	/**
	 * Year of manufacturing of the CellPhone object
	 */
	private int year;
	/**
	 * Price of the CellPhone object
	 */
	private double price;
	
	Scanner kb = new Scanner(System.in);
	
	/**
	 * Default constructor
	 */
	public CellPhone() {
		serialNum = 0;
		brand = "No brand.";
		year = 0;
		price = 0; 
	}
	
	/**
	 * Parameterized constructor
	 * @param serialNum Serial number of the CellPhone object
	 * @param brand Brand of the CellPhone object
	 * @param year Year of manufacturing of the CellPhone object
	 * @param price Price of the CellPhone object
	 */
	public CellPhone(long serialNum, String brand, int year, double price) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	/**
	 * Copy constructor
	 * @param copy CellPhone object that will be copied
	 * @param serialNum Serial number of the copied CellPhone object
	 */
	public CellPhone(CellPhone copy, long serialNum) {
		this.serialNum = serialNum;
		this.brand = copy.brand;
		this.year = copy.year;
		this.price = copy.price;
		
	}
	
	/**
	 * Accessor that will return the serial number of the CellPhone object
	 * @return Serial number of the CellPhone object
	 */
	public long getSerialNum() {
		return this.serialNum;
	}
	
	/**
	 * Accessor that will return the brand of the CellPhone object
	 * @return Brand of the CellPhone object
	 */
	public String getBrand() {
		return this.brand;
	}
	
	/**
	 * Accessor that will return the year of manufacturing of the CellPhone object
	 * @return Year of manufacturing of the CellPhone object
	 */
	public int getYear() {
		return this.year;
	}
	
	/**
	 * Accessor that will return the price of the CellPhone object
	 * @return Price of the CellPhone object
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * Mutator that will change the serial number of the CellPhone object
	 * @param serialNum Serial number of the CellPhone object
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	
	/**
	 * Mutator that will change the brand of the CellPhone object
	 * @param brand Brand of the CellPhone object
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Mutator that will change the year of manufacturing of the CellPhone object
	 * @param year Year of manufacturing of the CellPhone object
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Mutator that will change the price of the CellPhone object
	 * @param price Price of the CellPhone object
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Clone method
	 */
	public CellPhone clone() {
		System.out.print("You are cloning a CellPhone. Please enter its serial number: ");
		long userSerialNum = kb.nextLong();
		return new CellPhone(this, userSerialNum);
	}
	
	/**
	 * toString method that will return the information of the CellPhone object
	 */
	public String toString() {
		return "Serial number: " + serialNum + 
				"\nBrand: " + brand + 
				"\nYear: " + year + 
				"\nPrice: " + price;
	}
	
	/**
	 * equals method of the CellPhone object
	 */
	public boolean equals(Object other) {
		if(other == null || this.getClass() != other.getClass()) {
			return false;
		}
		else {
			CellPhone x = (CellPhone) other;
			return (this.brand.equals(x.brand) && this.price == x.price && this.year == x.year);
 		}
	}
}

