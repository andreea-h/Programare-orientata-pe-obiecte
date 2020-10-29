
class A 
{ 
   protected void display() 
    { 
        System.out.println("GeeksforGeeks"); 
    } 
} 
  
class B 
{ 
   public static void main(String args[]) 
      { 
          A obj = new A(); 
          //trying to access private method of another class 
          obj.display(); 
      } 
} 

public class Test {

	public static void main(String[] args) {
		Double x1, y1, z1;
		Double z3;
		double x2, y2, z2;
		x1 = 10.0;
		y1 = 4.0;
		z1 = x1*x1+y1*y1;
		z2 = z1; //unboxing
		System.out.println(z1.getClass().getName());
		System.out.println(z1);
		System.out.println(z2);
		z3 = z1;
		z1 = 116.0; //se face autoboxing, adca se impacheteaza valoarea 116 a tipului primitiv in tipul clasei wrapper, returnandu-se rezultatul intr-un obiect nou
		//referita z1 va primi adresa noului obiect creat
		System.out.println(z1==z3);
	}

}
