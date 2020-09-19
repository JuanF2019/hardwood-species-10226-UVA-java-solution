package datastructure;

public interface Dictionary<K,V> {
	public void insert(K key, V value);
	public V delete(K key);
	public V search(K key);
	public boolean isEmpty();
	public int getLength();
	public int getCapacity();
}
