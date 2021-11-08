
public class Test {

	public static void main(String[] args) {
		Pensionar a = new Pensionar(50, 5000);
		System.out.println(a.strategy.getClass().getName()+"->" +a.getPensie());
		
		Pensionar b = new Pensionar(35, 5000);
		System.out.println(b.strategy.getClass().getName()+"->" +b.getPensie());
	
		Pensionar c = new Pensionar(15, 5000);
		System.out.println(c.strategy.getClass().getName()+"->"+c.getPensie());
	}

}
