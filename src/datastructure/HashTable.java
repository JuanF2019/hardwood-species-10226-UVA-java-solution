package datastructure;

public class HashTable<K,V> implements Dictionary<K,V> {

	public static final int DEFAULT_CAPACITY = 1000000;
	//Node's array size
	private int capacity;
	//Number of elements in the table
	private int length;
	
	private Node<K,V>[] nodesArray;		
	
	@SuppressWarnings("unchecked")
	public HashTable() {
		nodesArray = (Node<K,V>[]) new Node[DEFAULT_CAPACITY];
		capacity = DEFAULT_CAPACITY;
	}
	
	
	@SuppressWarnings("unchecked")
	public HashTable(int capacity) {
		nodesArray = (Node<K,V>[]) new Node[capacity];
		this.capacity = capacity;
	}
	
	public void insert(K key, V value) {
		int i = hash(key);
		
		if(nodesArray[i] == null) {
			nodesArray[i] = new Node<K,V>(key,value,null,null);
		}
		else {						
			nodesArray[i] = new Node<K,V>(key,value,null,nodesArray[i]);			
		}	
		length++;
	}
	
	public V delete(K key) {
		int i = hash(key);
		
		if(nodesArray[i] == null) {
			return null;
		}
		else {
			boolean found = false;
			Node<K,V> temp = nodesArray[i];
			
			while(temp != null && !found) {
				if(temp.getKey().equals(key)) {
					found = true;					
				}
				else {
					temp = temp.getNextNode();
				}				
			}
			if(found) {
				if(temp.getPrevNode() == null && temp.getNextNode() == null) {
					nodesArray[i] = null;
				}
				else if(temp.getPrevNode() == null) {
					nodesArray[i] = temp.getNextNode();
					nodesArray[i].setPrevNode(null);					
				}
				else if(temp.getNextNode() == null) {
					temp.getPrevNode().setNextNode(null);
				}
				else {
					temp.getNextNode().setPrevNode(temp.getPrevNode());
					temp.getPrevNode().setNextNode(temp.getNextNode());
				}	
				
				length--;
				return temp.getValue();
			}
			else {
				return null;
			}			
		}			
	}
	
	public V search(K key) {
		int i = hash(key);
					
		if(nodesArray[i] == null) {
			return null;
		}
		else {
			Node<K,V> temp = nodesArray[i];
			while(temp != null) {
				if(temp.getKey().equals(key)) {
					return temp.getValue();
				}
				else {
					temp = temp.getNextNode();
				}
				
			}
			return null;
		}
	}
	
	public int hash(K key) {
		return (key.hashCode()%capacity < 0)? (key.hashCode()%capacity)*-1 : key.hashCode()%capacity;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
}
