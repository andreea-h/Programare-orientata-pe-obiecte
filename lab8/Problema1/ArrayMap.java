import java.util.*;

class ArrayMap<K,V> extends AbstractMap<K,V> {
    
    private Set entries ; //Set este o interfata !!!
    //Set este o interfata pentru o colectie de obiecte neordonate
    //obiectele nu pot fi duplicate
    private ArrayList list; //colectia este un obiect de tip ArrayList
    public ArrayMap()  {
        list = new ArrayList();
    }
    public Set entrySet() {
        if (entries==null) {
        	//Set va fi implementata cu clasa AbstractSet
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
    public int size() {
        return list.size();
    }
    public V put(Object key, Object value) {
        int size = list.size();
        ArrayMapEntry entry=null;
        int i;
        if (key == null) 
        {
            for (i = 0; i < size; i++)  {
                entry=(ArrayMapEntry)(list.get(i));
                if (entry.getKey() == null) {
                    break;
                }
            }
        } 
        else  {
            for (i = 0; i < size; i++) {
                entry = (ArrayMapEntry) (list.get(i));
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
            list.add(new ArrayMapEntry(key, value));
        }
        return (V)oldValue;
    }
    
    class ArrayMapEntry<K, V> implements Map.Entry<K,V> {
        K key;
        V value;
        public ArrayMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return this.key;
        }
        
        public V getValue() {
            return this.value;
        }
        
        public V setValue(Object value) {
            V old = this.value;
            this.value = (V)value;
            return old;
        }
        
        public String toString(){
            return this.key + " = " + this.value;
        }
        
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) 
                return false;
            Map.Entry e = (Map.Entry) o;
            return (key == null ? e.getKey() == null : key.equals(e.getKey())) && (value == null ? e.getValue() == null : value.equals(e.getValue()));
        }
        
        public int hashCode() {
            int keyHash = (key == null ? 0 : key.hashCode());
            int valueHash = (value == null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }
    }
    
} 