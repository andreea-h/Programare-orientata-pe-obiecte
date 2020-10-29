import java.util.Arrays;

public class Problema8 {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]); //nr de elemente al vectorului
		double v[] = new double[n];
		int i;
		for(i=0;i<n;i++)
			v[i] = Math.random();
		System.out.println("Vectorul generat aleator este: ");
		for(i=0;i<n;i++)
			System.out.println(v[i]);
		System.out.print("\n");
		Arrays.sort(v);
		System.out.println("Vectorul ordonat este: ");
		for(i=0;i<n;i++)
			System.out.println(v[i]);
		System.out.print("\n");
		System.out.println("Indexul nr cautat este: " + Arrays.binarySearch(v, 0.02));
	}

}
