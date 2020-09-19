package datastructure;

public class Node<K,V> {
	private K key;
	private V value;
	private Node<K,V> prevNode;
	private Node<K,V> nextNode;
	
	public Node(K key, V value, Node<K,V> prevNode, Node<K,V> nextNode) {
		this.key = key;
		this.value = value;
		this.prevNode = prevNode;
		this.nextNode = nextNode;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Node<K, V> getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node<K, V> prevNode) {
		this.prevNode = prevNode;
	}

	public Node<K, V> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<K, V> nextNode) {
		this.nextNode = nextNode;
	}	
}
