
public class Test {
	public static void main(String args[]) {
		Outer<Integer> out = new Outer<Integer>();
		//Outer.Numar in1 = out.getInnerInstance();
		//chestia de mai sus genereaza eroare la compilare
		Number<Integer> in2 = out.getInnerInstance();
	}
}
