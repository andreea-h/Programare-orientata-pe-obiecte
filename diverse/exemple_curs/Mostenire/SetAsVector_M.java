import java.util.*;
	
public class SetAsVector_M extends Vector{
	
	public boolean add(Object a) {
		if(this.contains(a)) {
			return false;
		}
		return super.add(a);
	}
	public static void main(String[] args) {
		SetAsVector_M st1 = new SetAsVector_M();
		st1.insertElementAt("abc", 0);
		st1.insertElementAt("ccc", 0);
		st1.insertElementAt("ddd", 2);
		System.out.println(st1);
		int i=0;
		int j;
		eticheta:
		while (i < 10) {
		System.out.println("i="+i);
		j=0;
		i++;
		while (j < 10) {
		j++;
		if (j==5) continue eticheta;
		// if (j==5) break eticheta;
		System.out.println("j="+j);
		}
		
		}
	}

}
