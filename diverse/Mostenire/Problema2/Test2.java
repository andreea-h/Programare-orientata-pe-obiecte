
public class Test2 {

	public static void main(String[] args) {
		MyStack st = new MyStack();
		st.push(10);
		st.push(20);
		st.push(-3);
		st.push(2);
		System.out.println(st);
		System.out.println(st.pop());
		System.out.println(st);
		System.out.println(st.pop());
		System.out.println(st);
	}

}
