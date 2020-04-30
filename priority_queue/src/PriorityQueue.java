import java.util.Arrays;

//this class represents priority queue
public class PriorityQueue <K extends Comparable<K>, V extends Comparable<V>>{
	
	private int numbEntries = 0;
	private int maxSize = 15;
	private Entry<K, V> [] heap = new Entry[maxSize];
	private String currState = "Min Heap";
	private String MIN_HEAP = "Min Heap";
	private String MAX_HEAP = "Max Heap";
	
	//method to remove the end of the queue (which is the top) and returns the key
	public Entry<K,V> removeTop() {
		return numbEntries != 0 ? heap[--numbEntries] : null;
	}

	//method to increase size of queue if it's full
	public void increaseSize(){
	      heap = Arrays.copyOf(heap, heap.length * 2);
	}
	
	//method to insert an entry with a key and a value in the queue
	public Entry<K,V> insert(K key, V value) {		
		if(size() >= numbEntries) {
			increaseSize();
		}
		Entry<K,V> entry = new Entry<K,V>(key,value);
		heap [numbEntries++] = entry;
		sort();
		return entry;
	}
	
	//method returns the top without deleting it (returns the key at the end of the queue)
	public Entry<K,V> top(){
		return numbEntries != 0 ? heap[numbEntries - 1] : null;
	}
	
	//method to remove an entry from the queue with reference
	public Entry<K,V> remove(Entry<K,V> e){
		for (int i = 0; i < size(); i++) {
			if(heap[i] == e) {
				for (int j = i+1; j < size(); j++)
					heap[j-1] = heap[j];
			numbEntries--;
			return e;
			}
		}
		return null;
	}
	
	//method finds entry with the specific key and replaces the old key with new key
	public K replaceKey(Entry<K,V> e, K key){
		K old = e.getKey();
		e.setKey(key);
		sort();
		return old;
	}
	
	//method finds entry with the specific value and replaces the old key with new value
	public V replaceValue(Entry<K,V> e, V value){
		V old = e.getValue();
		e.setValue(value);
		return old;
	}
	
	//switches the state of the queue
	public void toggle() {
		if(currState.equalsIgnoreCase(MAX_HEAP))
			currState = MIN_HEAP;
		else
			currState = MAX_HEAP;
		sort();
	}
	
	//method returns the state of the queue
	public String state() {
		return currState;
	}
	
	//method returns if the queue is empty or not
	public boolean isEmpty() {
		return (numbEntries == 0);
	}
	
	//method returns the size of the queue
	public int size() {
		return numbEntries;
	}
	
	//method that represents the heapify method of queues
	public void heapify(int heapSize, int index) {
		int curr = index;
		int right = (2 * index) + 1;
		int left = (2 * index) + 2;
		//this is a case of min heap
		if(currState.equalsIgnoreCase(MIN_HEAP)){
			if(left < numbEntries && heap[index].getKey().toString().toLowerCase().compareTo(heap[left].getKey().toString().toLowerCase()) > 0 && left < heapSize)
					curr = left;
			if (right < numbEntries && heap[curr].getKey().toString().toLowerCase().compareTo(heap[right].getKey().toString().toLowerCase()) > 0 && right < heapSize)
					curr = right;
		}
		
		//this is a case of max heap
		if(currState.equalsIgnoreCase(MAX_HEAP)){
			if(left < numbEntries && heap[index].getKey().toString().toLowerCase().compareTo(heap[left].getKey().toString().toLowerCase()) < 0 && left < heapSize)
					curr = left;
			if (right < numbEntries && heap[curr].getKey().toString().toLowerCase().compareTo(heap[right].getKey().toString().toLowerCase()) < 0 && right < heapSize)
					curr = right;
		}
		
		//if the root is not the largest element then keep heapifying
		if(curr != index){
			Entry<K,V> temp = heap[index];
			heap[index] = heap[curr];
			heap[curr] = temp;
			heapify(heapSize, curr);
		}
	}

	//sort the queue
	private void sort() {
	       for(int i = numbEntries / 2 - 1; i >= 0; i--) {
	           heapify(numbEntries, i);
	       }
	        for (int i= size()-1; i>=0; i--) {

	            // swap root and last.
	            Entry<K, V> temp = heap[0];
	            heap[0] = heap[i];
	            heap[i] = temp;
	            
	            // heapify the reduced tree.
	            heapify(i, 0);
	        }
	   }
	
	//method to print out the queue
	 public String toString()
	   {
	       String sb = "[";
	       for(int i = 0; i < numbEntries; i++)
	       {
	           sb += (heap[i]);  
	           if(i < numbEntries - 1)
	               sb += ", ";
	       }
	       sb += "]" ;
	       return sb.toString();
	   }
}



