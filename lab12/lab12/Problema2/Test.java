
public class Test {

	public static void main(String[] args) {
		ProductFactory pr = new ProductFactory();
		Product p1 = pr.factory("Book", "pr1", 10);
		System.out.println(p1.getClass().getName()+" "+p1.getPriceReduced());
		Product p2 = pr.factory("Food", "pr2", 20);
		System.out.println(p2.getClass().getName()+" "+p2.getPriceReduced());
		Product p3 = pr.factory("Beverage", "pr3", 50);
		System.out.println(p3.getClass().getName()+" "+p3.getPriceReduced());
		Product p4 = pr.factory("Computer", "pr4", 80);
		System.out.println(p4.getClass().getName()+" "+p4.getPriceReduced());
	}

}
