
abstract class Product {
	float pret;
	String productName;
	
	public Product(String productName, float productPrice) {
		pret=productPrice;
		this.productName=productName;
	}
	
	abstract float getPriceReduced();
}

class Book extends Product {
	
	public Book(String productName, float productPrice) {
		super(productName, productPrice);
	}
	
	float getPriceReduced() {
		return (float)(this.pret-this.pret*0.15);
	}
}

class Food extends Product {
	
	public Food(String productName, float productPrice) {
		super(productName, productPrice);
	}
	
	float getPriceReduced() {
		return (float)(this.pret-this.pret*0.2);
	}
}

class Beverage extends Product {
	
	public Beverage(String productName, float productPrice) {
		super(productName, productPrice);
	}
	
	float getPriceReduced() {
		return (float)(this.pret-this.pret*0.05);
	}
}

class Computer extends Product {
	
	public Computer(String productName, float productPrice) {
		super(productName, productPrice);
	}
	
	float getPriceReduced() {
		return (float)(this.pret-this.pret*0.01);
	}
}