import java.util.*;

class Product {
	float pret;
	String nume;
	
	public Product(float pret, String nume) {
		this.pret = pret;
		this.nume = nume;
	}
}

class ShopSingleton {
	String name;
	ArrayList<Product> products = new ArrayList<Product>();
	
	private ShopSingleton() {
		
	}
	
	private static ShopSingleton instance = null;
	
	public static ShopSingleton getInstance() {
		if(instance==null) {
			instance = new ShopSingleton();
		}
		return instance;
	}
	
	void showProducts() {
		for(Product a:products) {
			System.out.println(a.nume+"->"+a.pret);
		}
	}
}
