public class Test {

	public static void main(String[] args) {
		IceCream iceCream  = new BasicIceCream();
		//System.out.println(iceCream.getDescription());
		IceCream choco = new Chocolate(iceCream);
		IceCream vanilla = new Vanilla(iceCream);
		System.out.println(choco.getDescription());
		System.out.println(vanilla.getDescription());
		System.out.println(iceCream.getDescription());
		System.out.println(iceCream.getCost());
		System.out.println(choco.getCost());
		System.out.println(vanilla.getCost());
	}

}
