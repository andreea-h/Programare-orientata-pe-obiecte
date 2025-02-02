
class Goldbach {

	boolean ePrim(int n){
		
		int i;
		for(i=2; i<=Math.sqrt(n); i++)
			if(n%i == 0)
				return false;
		return true;
	}
	
	void afisare (int n) {
		
		int k=0;
		int j=0;
		int nr=2;
		while( k<n ) {
			
			for(j=1;j<=nr/2;j++)
			{
				if(ePrim(j) && ePrim(nr-j)) {
					int t=nr-j;
					System.out.println(nr + "=" + j + "+" + t);
				}
			}
			nr = nr+2;
			k++;
		}
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Goldbach obiect = new Goldbach();
		obiect.afisare(n);

	}

}
