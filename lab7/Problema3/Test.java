import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		try
		{
			SListSet test = new SListSet();
			
			System.out.println(test.printWords("test01.txt"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		

	}

}
