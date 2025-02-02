import java.util.*;

public class LinkedSet extends LinkedList {
	public boolean add(Object obj) {
		boolean exista = this.contains(obj);
		if(exista==true)
			return false; //obj exista deja in lista
		else {
			super.add(obj);
			return true;
		}
	}
	
	public void add(int i, Object obj) {
		if(this.contains(obj)==false)
			super.add(i, obj);
	}
	
	public Object set(int i, Object obj) {
		if(this.contains(obj)==false)
			return super.set(i, obj);
		return this.get(i);
	}
}
