
public class Test {
	static ShopSingleton shop = ShopSingleton.getInstance();
	
	static void addProduct(Product a) {
		if(!shop.products.contains(a))
			shop.products.add(a);
	}
	
	static void removeProduct(Product a) {
		if(shop.products.contains(a))
			shop.products.remove(a);
	}
	
	static public Product getCheapestProduct() {
		float min = shop.products.get(0).pret;
		Product rez = shop.products.get(0);
		for(Product a:shop.products) {
			if(a.pret<min) {
				min=a.pret;
				rez = a;	
			}
		}
		return rez;
	}
	
	public static void main(String[] args) {
		Product a = new Product(100,"ciocolata");
		Product b = new Product(300,"alune");
		Product c = new Product(60,"mere");
		addProduct(a);
		addProduct(b);
		addProduct(c);
		shop.showProducts();
		removeProduct(b);
		shop.showProducts();
		Product rez = getCheapestProduct();
		System.out.println(rez.pret+" "+rez.nume);
	}
}
