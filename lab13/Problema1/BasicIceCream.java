interface IceCream {
	String getDescription();
	double getCost();
}


//con - obiect de tipul BasicIceCream
class BasicIceCream implements IceCream {
	public String getDescription() {
		return "Adding cone";
	}
	
	public double getCost() {
		return 0.5;
	}
}

abstract class TopingDecorator implements IceCream {
	private IceCream tempIceCream;
	
	TopingDecorator(IceCream iceCream) {
		tempIceCream = iceCream;
	}
	
	public String getDescription() {
		return tempIceCream.getDescription();
	}
	
	public double getCost() {
		return tempIceCream.getCost();
	}
}

class Chocolate extends TopingDecorator {
	public Chocolate(IceCream iceCream) {
		super(iceCream);
	}
	
	public String getDescription() {
		return super.getDescription()+"\nAdding choco";
	}
	
	public double getCost() {
		double p = super.getCost();
		return p+1.5;
	}
}

class Vanilla extends TopingDecorator {
	public Vanilla(IceCream iceCream) {
		super(iceCream);
	}
	
	public String getDescription() {
		return super.getDescription()+"\nAdding vanilla";
	}
	
	public double getCost() {
		double p = super.getCost();
		return p+2;
	}
}