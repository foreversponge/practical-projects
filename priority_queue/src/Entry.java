//this class represents the entries in a queue
public class Entry <K extends Comparable<K>, V extends Comparable<V>>{

	private K key;
	private V value;
	
	//default constructor
	public Entry() {
		key = null;
		value = null;
	}
	
	//parameterized constructor
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	//to get the key
	public K getKey() {
		return this.key;
	}
	
	//to get the value
	public V getValue() {
		return this.value;
	}
	
	//to set the key
	public void setKey(K key) {
		this.key = key;
	}
	
	//to set the value
	public void setValue(V value) {
		this.value = value;
	}
	
	//to print out the entry
	public String toString() {
		return "(" + key + ", " + value + ")";
	}
}
