
public class Test5 {

	public static void main(String[] args) {
		Tren t = new Tren();
		t.addVagon(new CalatoriA());
	    t.addVagon(new CalatoriB());
	    t.addVagon(new CalatoriA());
	    t.addVagon(new CalatoriA());
	    t.addVagon(new CalatoriA());
	    t.addVagon(new CalatoriB());
	    t.addVagon(new CalatoriB());
	    t.addVagon(new Marfa());
	    System.out.println("Trenul 1");
	    System.out.println(t);
	    
	    Tren t1 = new Tren();
		t1.addVagon(new CalatoriA());
		t1.addVagon(new CalatoriB());
		t1.addVagon(new CalatoriA());
		System.out.println("Trenul 2");
		System.out.println(t1);
		int rez = t1.compareTo(t);
		if(rez<0) {
			System.out.println("Trenul 1 are mai multe colete");
		}
		else
			System.out.println("Trenul 2 are mai multe colete");
		
	}

}
