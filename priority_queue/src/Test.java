//class to test the priority queue class
public class Test {

	public static void main(String[] args) {
	       PriorityQueue<String, Integer> test = new PriorityQueue<String, Integer>();
	       PriorityQueue<String, Integer> emptyTest = new PriorityQueue<String, Integer>();

	       test.insert("Bobby", 1);
	       test.insert("Sam", 2);
	       test.insert("police", 3);
	       test.insert("bear", 4);
	       Entry entry2 = test.insert("crazy", 5);
	       test.insert("elephant", 6);
	       Entry entry1 = test.insert("red", 7);
	       test.insert("animal", 8);
	       Entry entry3 = test.insert("vivid", 9);
	       Entry entry4 = test.insert("pear", 10);


	       System.out.println("Test of insert(k,v)...\n");
	       
	       System.out.println("Current State: " + test.state());      
	       System.out.println("Array of entries: " + test);  
	      
	       System.out.println("\nTest removeTop(): " + test.removeTop());
	       System.out.println("Array of entries: " + test);
	      
	       System.out.println("\nTest toggle()...");
	       test.toggle();  
	      
	       System.out.println("\nCurrent State: " + test.state());      
	       System.out.println("Array of entries: " + test);
	      
	       System.out.println("\nTest top(): " + test.top());
	       System.out.println("Array of entries: " + test);
	       
	       System.out.print("\nTest remove(e) by removing \"red\": Old key -->"); 
	       System.out.println(test.remove(entry1));
	       System.out.println("Array of entries: " + test);
	       
	       System.out.print("\nTest replaceKey(e,k) with \"crazy\" to \"sane\": Old key --> "); 
	       System.out.println(test.replaceKey(entry2, "sane"));
	       System.out.println("Array of entries: " + test);
	       
	       System.out.print("\nTest replaceValue(e,v) with 5 to 25: Old key --> "); 
	       System.out.println(test.replaceValue(entry2, 33));
	       System.out.println("Array of entries: " + test);
	       
	       System.out.print("\nTest replaceValue(e,v) with 7 to 49: Old key --> "); 
	       System.out.println(test.replaceValue(entry3, 81));
	       System.out.println("Array of entries: " + test);
	       
	       System.out.println("\nArray of entries of queue \"test\": " + test);
	       System.out.println("Test isEmpty() with queue \"test\": " + test.isEmpty()); 
	       System.out.println("Test size() with queue \"test\": " + test.size()); 
	       
	       System.out.println("\nArray of entries of queue \"emptyTest\": " + emptyTest);
	       System.out.print("Test isEmpty() with of queue \"emptyTest\": " + emptyTest.isEmpty()); 
	       
	       System.out.println("\n\nTest toggle()...");
	       test.toggle();  
	       System.out.println("\nCurrent State: " + test.state()); 
	       System.out.println("Array of entries: " + test);
	       
	       System.out.println("\nTest removeTop(): " + test.removeTop());
	       System.out.println("Array of entries: " + test);
	       System.out.println("\nTest size(): " + test.size());
	       
	       System.out.print("\nTest remove(e) by removing \"pear\": Old key -->"); 
	       System.out.println(test.remove(entry4));
	       System.out.println("Array of entries: " + test);
	       
	       System.out.println("\n\nTest toggle()...");
	       test.toggle();  
	       System.out.println("\nCurrent State: " + test.state()); 
	       System.out.println("Array of entries: " + test);
	       System.out.println("\nTest size(): " + test.size());
	}
}
