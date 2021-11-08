import java.io.*;
public class Animal {
	public void eat() {
 }
}
class Dog2 extends Animal {
	public void eat(String a) throws IOException{ 
		/* no Exceptions */}
	
	
	public static void main(String [] args) {
		Animal a = new Dog2();
		Animal a2 = new Animal();
		Dog2 d = new Dog2();
		d.eat(); // ok
		try {
			a.eat(); // compiler error -
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			a2.eat();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
 // unreported exception
 }
}