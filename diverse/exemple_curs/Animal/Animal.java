
public class Animal {
	
	String type = "mamifer";
	public void show() {
		System.out.println("Animalul este un: " + type);
	}
}

class Dog /*extends Animal*/ {
	static String type= "ana";
	public Dog() {
		
	}
	public Dog(String type) {
		this.type = type;
	}
	public void show() {
		System.out.println("Cainele este un: " + type); 
	}
}

class Test {
	public static void main(String args[]) {
		Animal a = new Animal();
		Dog a2 = new Dog("ciobanesc");
		System.out.println(a.type);
		System.out.println(a2.type);
		System.out.println(a.type);
		System.out.println(a2.type);
		Dog a3 = new Dog();
		System.out.println(a3.type);
	//	a.show();
	//	a2.show();
		
	}
}