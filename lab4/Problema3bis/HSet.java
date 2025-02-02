import java.util.*;

class HSet extends Hashtable {
	//Adauga un element in multime, daca nu exista deja
	public boolean add(Object value) {
		if(this.containsValue(value))
			return false;
		else {
			super.put(value, value);
			return true;
		}
	}
	//returneaza un String cu elementele multimii (doar cheile, nu perechi)
	public String toString() {
		Enumeration enu = this.keys();
		String rez=new String();
		while(enu.hasMoreElements()) {
			rez=rez.concat(enu.nextElement()+" ");
		}
		return rez;
	}
	//Sterge perechea corespunzatoare cheii, intorcand valoarea
	public Object remove(Object key) {
		if(!this.contains(key))
			return null; // key nu exista in multime
		else {
		Object rez = super.remove(key);
		return rez;
	}
		}

}
