
class Problema6 {

	boolean ePrim(int n){
	
		int i;
		for(i=2; i<=Math.sqrt(n); i++)
			if(n%i == 0)
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		Problema6 obiect = new Problema6();
		int i;
		for(i=2; i<=20 ;i++) {
			if(obiect.ePrim(i))
				System.out.println(i+" Este prim");
			else
				System.out.println(i+" Nu este prim");
		}
		
	}

}
