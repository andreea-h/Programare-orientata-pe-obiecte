class Top {
 public Top(String s) { System.out.print("B"); }
}
public class Clidder extends Top {
 public Clidder(String s) {
	 super(s);
	 System.out.print("D"); }
 public static void main(String [] args) {
 new Clidder("C");
 System.out.println(" ");
} }