import java.io.*;
public class Test {

	public static void main(String[] args) throws  InterruptedException, FileNotFoundException, IOException  {
		FileReader r = new FileReader("test02.in");
		BufferedReader bufferread = new BufferedReader(r); 
        StreamTokenizer token = new StreamTokenizer(bufferread); 
        int t; 
        int nr = 0;
        while ((t = token.nextToken()) != StreamTokenizer.TT_EOF) {
            nr ++;
            System.out.println("Word : " + token.sval); 
        }
        System.out.println("Nr de cuvinte: "+nr);
        
		
	}

}
