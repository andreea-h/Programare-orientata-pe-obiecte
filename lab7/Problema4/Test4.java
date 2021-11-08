import java.io.IOException;

public class Test4 {

	public static void main(String args[]) {
		try {
		Problema4 test = new Problema4();
		test.dictionar = test.construire_dictionar("test01.txt");
		test.afisare(test.dictionar);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
