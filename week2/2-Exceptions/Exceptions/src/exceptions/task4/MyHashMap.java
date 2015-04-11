package exceptions.task4;

import java.util.HashMap;

public class MyHashMap<K, V> extends HashMap<K, V> {
	private final static boolean NULL_ALLOWED = false;
	private boolean nullAllowed;
	
	
	public MyHashMap() {
		this(NULL_ALLOWED);
	}

	public MyHashMap(boolean nullAllowed) {
		setNull(nullAllowed);
	}
	
	private boolean isNullAllowed() {
		return this.nullAllowed;
	}
	
	public void setNull(boolean nullAllowed) {
		this.nullAllowed = nullAllowed;
	}
	
	private void checkKey(Object key) {
		if (key == null && !this.isNullAllowed()) {
			throw new NullKeyException();
		}
	}
	
	@Override
	public V put(K key, V value) {
		checkKey(key);
		V object = super.put(key, value);
		return object;
	}
	
	@Override
	public V get(Object key) {
		checkKey(key);
		V object = super.get(key);
		return object;
	}

}


