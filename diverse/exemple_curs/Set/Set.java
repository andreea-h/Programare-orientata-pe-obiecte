import java.util.*;
class Set extends Vector {
	Vector v;
	public boolean add(Object o) {
		if(!v.contains(o)) {
			return v.add(o);
		}
		return false;
	}

}
