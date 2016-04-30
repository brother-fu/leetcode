package family;

public class MyHashMap<Key, Value> {
    private final int capacity = 10000;
    private Key[] keys;
    private Value[] vals;
    private int N;   // count
    private int M; //array size
    public MyHashMap() { 
//    	this.capacity = caapacity;
    	keys = (Key[]) new Object[10000];
    	vals = (Value[]) new Object[10000];
    	M = 10000;
    }
    private int hash(Object obj) {
    	return (obj.hashCode() & 0X7fffffff) % M; 
    	
    }
    public void put(Key key, Value val) {
    	if (key == null) return;
    	if (val == null) {
    		delete(key); // 不一定要这样；
    		return;
    	}
    	int i = 0;
    	for (i = hash(key); keys[i] != null;  i = (i + 1) % M) {
    		if (key.equals(keys[i])) {
    			vals[i] = val;
    			return;
    		}
    	}
    	keys[i] = key;
    	vals[i] = val;
    	N++;
    }
    public boolean containsKey(Key key) {
    	return get(key) != null;
    }
    public Value get(Key key) {
    	if (key == null) return null;
    	int i = 0;
    	for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
    		if (key.equals(keys[i]))
    			return vals[i];
    	}
    	return null;
    }
    
    public void delete(Key key) {
    	if (key == null) return;
    	int i = 0;
    	for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
    		if (key.equals(keys[i])) 
    			break;
    	}
    	keys[i] = null;
    	vals[i] = null;
    	N--;
    	for (; keys[i] != null; i = (i + 1) % M) {
    		Key keyToRehash = keys[i];
    		Value valToRehash = vals[i];
    		keys[i] = null;
    		vals[i] = null;
    		put (keyToRehash, valToRehash);
    		N--;
    	}
    }
    public static void main(String[] args) {
    	MyHashMap<Integer, String> mhm = new MyHashMap<Integer, String>();
    	mhm.put(1, "my");
    	System.out.println(mhm.get(1));
    	mhm.put(1, "hi");
    	System.out.println(mhm.get(1));
    	System.out.println(mhm.containsKey(2));
    	mhm.put(1, null);
    	System.out.println(mhm.containsKey(1));
    	
    }
    
}
