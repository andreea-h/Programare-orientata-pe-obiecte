import java.util.*;
class ArrayMap<K,V> extends AbstractMap<K,V> {
	K key;
	V value;
	ArrayList list =null;
	//Entry - clasa interna pentru a modela o intrare in dictionar
	public ArrayMap()  {
        list = new ArrayList();
    }

	class Entry implements Map.Entry {
		K key;
		V value;
		
		public Entry(K key, V value) {
			this.key=key;
			this.value=value;
		}
		
		public V getValue() {
			return this.value;
		}
		
		public K getKey() {
			return this.key;
		}
		public V setValue(Object newValue) {
			V old=value; 
			value=(V)newValue;
			return old;
		}
		public String toString(){
	         return this.key + " = " + this.value;
	    }
		
	}
	
	private Set entries = null;
	
	public Set<Map.Entry<K, V>> entrySet() {
		if(entries==null) {
			entries = new AbstractSet() {
				 public void clear() {
	                    list.clear();
	                }
	                public Iterator iterator() {
	                    return list.iterator();
	                }
	                public int size() {
	                    return list.size();
	                }

			};
		}
		return entries;
	}	
	
	public V put(K key, V value) {
        int size = list.size();
        Entry entry=null;
        int i;
        if (key == null) 
        {
            for (i = 0; i < size; i++)  {
                entry=(Entry)(list.get(i));
                if (entry.getKey() == null) {
                    break;
                }
            }
        } 
        else  {
            for (i = 0; i < size; i++) {
                entry = (Entry) (list.get(i));
                if (key.equals(entry.getKey())) {
                    break;
                }
            }
        }
        Object oldValue = null;
        if (i < size) {
            oldValue = entry.getValue();
            entry.setValue(value);
        }
        else {
            list.add(new Entry(key, value));
        }
        return (V)oldValue;
    }
	
	public Set<K> keySet() {
		return super.keySet();
	}
	
	public Collection<V> values() {
		return super.values();
	}
	
	public V get(Object obj) {
		return super.get(obj);
	}

}
