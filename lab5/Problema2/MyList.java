public class MyList {
    private Node head;
    private int size;

    public MyList() {
        head = new Node(null);
        size = 0;
    }

    //Adauga un obiect in lista
    public void add(Object data) {
        Node temp = new Node(data);
        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        size++;
    }

    public void add(Object data, int index) {
        Node temp = new Node(data);
        Node current = head;
        for(int i = 0; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        size++;
    }

    public Object get(int index) {
        if(index < 0 && index >= this.size) {
            return null;
        } else {
            Node current = head.getNext();
            for(int i = 0; i < index; i++) {
                if(current.getNext() == null) {
                    return null;
                }
                current = current.getNext();
            }
            return current.getData();
        }
    }

    public boolean remove(int index) {
        if(index < 0 || index >= size) {
            return false;
        }
        Node current = head;
        for(int i = 0; i < index; i++) {
            if(current.getNext() == null) {
                return false;
            }
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public String toString() {
        Node current = head.getNext();
        String result = "";
        while(current != null) {
            result += "[" + current.getData() + "] ";
            current = current.getNext();
        }
        return result;
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.next = null;
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.next = next;
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

class Graph extends MyList {
	int vizitat[];
	int nr; //numarul de noduri din graf
	
	public Graph(int nr) {
		this.nr=nr;
		int i;
		for(i=0;i<=nr;i++) {
			add(new MyList());
		}
		vizitat = new int[nr];
	}
	
	public String toString() {
		String rez = new String();
		int i;
		for (i=1;i<=nr;i++) {
			rez=rez.concat(i+": "+get(i).toString()+"\n");
		}
		return rez;
	}
	
	void add(int x,int y) {
		//adauga pe y in lista de adiacenta a lui x
		((MyList)get(x)).add(y);
	}
	
	void dfs(int start) {
		System.out.print(start+ " ");
		vizitat[start-1] = 1;
		MyList lista = (MyList)get(start);
		int i=0;
		if(lista.size()!=0) {
			while(lista.get(i)!=null) {
				int n=(int)lista.get(i);
				i++;
				if(vizitat[n-1]==0) {
					dfs(n);
			}
			}
		}
	}
}

