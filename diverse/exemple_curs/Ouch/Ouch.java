
public class Ouch {
	static int ouch = 7 ;
	
	public static void main(String[] args) {
	//	new Ouch().go(ouch);
	//	System.out.println(ouch);
	//	Ouch myOuch = new Ouch();
	//	System.out.println(myOuch.ouch);
	//	myOuch.ouch++;
	//	myOuch.go(myOuch.ouch);
		
	//	System.out.println(myOuch.ouch);
	//	System.out.println(ouch);
		new Ouch().go(ouch);
		//System.out.println(ouch);
		new Ouch().go(ouch);
		//System.out.println(ouch);
		Ouch myOuch = new Ouch();
		//System.out.println(myOuch.ouch);
		new Ouch().go(ouch);
		System.out.println(ouch);
		
		///
		
		float f1= 2.3f;
		float[][] f2 = {{42.0f}, {1.7f, 2.3f}, {2.6f,2.7f}};
		float [] f3 = {2.7f};
		Long x = 42L;
		
		System.out.println(f3[0]);
	}
	void go(int ouch) {
	//	System.out.println(this.ouch);
		ouch++;
		for(int ouch1=3;ouch1<6;ouch1++) 
			
		System.out.println(" "+ouch);
	//	System.out.println(this.ouch);
	}

}
