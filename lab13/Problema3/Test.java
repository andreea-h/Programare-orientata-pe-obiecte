import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader; 
public class Test {

	public static void main(String[] args) {
		FileReader f = null;
		try {
			f = new FileReader("test01.in");
			LineNumberReader lnr = new LineNumberReader(f); 
			while(lnr.ready()) {
				int a = lnr.getLineNumber();
				if(a%2==1)
					System.out.println(a+" "+lnr.readLine());
				else {
					//lnr.getLineNumber();
					lnr.readLine();
				}
			}
			lnr.close();
			f.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}