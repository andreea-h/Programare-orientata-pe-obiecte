
public class X {
	
	private final void met() {
		System.out.println("A");
	}
} 

class Y extends X {
	public final void met() {
		System.out.println("B");
	}
	public static void main(String[] args) {
		new Y().met();
		double x=0;
		System.out.println(x/0);
		String s = "-";
		try {
			throw new Exception();
		}
		catch(Exception e) {
			try {
				try {
					throw new Exception();
				}
				catch(Exception ex) {
					s += "ic ";
				}
				
				double y=2;
				System.out.println(y/0);
			}
			catch(Exception ex) {
				s+="mc ";
			}
			finally {
				s+="mf ";
			}
		}
		System.out.println(s);
	}
		

}
