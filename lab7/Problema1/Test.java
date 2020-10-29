import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		try {
			MyTreeSet obj = new MyTreeSet();
			obj.obj1=obj.printWords("test01.txt");
			obj.obj2=obj.printWordsComparator(obj.obj1);
			System.out.println(obj.obj1);
			System.out.println(obj.obj2);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
