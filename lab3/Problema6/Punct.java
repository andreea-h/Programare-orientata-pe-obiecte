
class Punct {
	private int x;
	private int y;

	public Punct() {
		x=0;
		y=0;
	}
	int getX() {
		return x;
	}

	void setX(int x) {
		this.x=x;
	}
	int getY() {
		return y;
	}
	
	void setY(int y) {
		this.y=y;
	}
	public String toString() {
		return "("+x+" ,"+y+")";
	}
	double distance(int x,int y) {
		return Math.sqrt(Math.pow(this.x-x, 2)+Math.pow(this.y-y, 2));
	}
	double distance(Punct p1) {
		return Math.sqrt(Math.pow(this.x-p1.x, 2)+Math.pow(this.y-p1.y, 2));
	}
}

class Test {
	public static void main(String[] args) {
		Punct p1=new Punct();
		p1.setX(1);
		p1.setY(2);
		Punct p2=new Punct();
		p2.setX(-1);
		p2.setY(3);
		System.out.println(p1.distance(p2));
		System.out.println(p1.distance(1,0));
	}
}

