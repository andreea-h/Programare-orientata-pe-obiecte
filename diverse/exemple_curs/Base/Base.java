
public class Base {
	int i;
	Base() {
		
		add(1);
		System.out.println("aici in base"+i);
	}
	void add(int v) {
		System.out.println("dyfuvh");
		i+=v;
	}
	void print() {
		System.out.println(i);
	}
}


class Extension extends Base {
	Extension() {
		
		add(2);
		System.out.println("aici in extension"+i);
	}
	void add(int v) {
		i+=v*2;
		System.out.println("iofndk");
	}
}

class Test {
	public static void  main(String args[]) {
		//bogo(new Extension());
		System.out.println(new Extension().i);
	}
	static void bogo(Base b) {
		
		b.add(8);
		b.print();
	}
}