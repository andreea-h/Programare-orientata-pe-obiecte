public class Problema5 {
	
	int putere(int a, int b) {
		if (b == 1) {
			return a;
		}
		else
			return a*putere(a, b-1);
	}
	
	
	public static void main(String[] args) {
		Problema5 obiect = new Problema5();
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.print("Rezultatul este: ");
		System.out.println(obiect.putere(a, b));
		System.out.println(Math.pow(a, b));

	}

}
