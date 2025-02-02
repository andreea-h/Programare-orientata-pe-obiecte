class MyQueue {
	private final int Infinit = 9500;
	private MyArray element;
	private int first;
	private int last;
	private int nr_elem;
	
	public MyQueue() {
		element = new MyArray();
		first = 0;
		last = -1;
		nr_elem = 0;
	}
	
	void enqueue(int value) {
		nr_elem++;
		int pos=element.getSize();
		element.set(pos, value);
		last++;
	}
	
	int dequeue() {
		int f=element.get(first);
		first++;
		nr_elem--;
		return f;
	}
	
	int getSize() {
		return nr_elem;
   }
	
	boolean isEmpty() {
		if(nr_elem == 0)
			return true;
		return false;
	}
	
	public String toString() {
		StringBuffer rez=new StringBuffer();
		int i;
		for(i=first;i<=last;i++)
			rez.append(element.get(i)+" ");
		String rez1 = new String(rez);
		return rez1;
	}
}

class MyArray {
    private int v[];
    private int size;
 
    public MyArray() {
        this(100);
    }
 
    public MyArray(int length) {
        size = 0;
        v = new int[length];
    }
 
    public int get(int poz) {
        if(poz < size) {
            return v[poz];
        } else {
            return -1;
        }
    }
 
    public void set(int pos, int value) {
        v[pos] = value;
        size++;
    }
 
    public int getSize() {
        return size;
    }
}
 
