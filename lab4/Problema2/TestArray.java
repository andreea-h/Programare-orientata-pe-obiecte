
class TestArray {
	public static void main(String args[]) {
		SortedArray el = new SortedArray();
		el.addElement(10);
		el.addElement(20);
		el.addElement(13);
		el.addElement(3);
		el.addElement(-9);
		System.out.println("Multimes este: "+ el);
		el.remove(3); //sterge el de pozitia 3
		System.out.println("Dupa stergerea el de pe pozitia 3 se obtine: "+ el);
	//	el.remove(0); //sterge el de pe pozitia 0
	//	System.out.println(el);
		el.remove((Integer)10); //sterge el cu valoarea 10
		System.out.println("Dupa stergerea el 10 se obtine: " + el);
		System.out.println("_______________________");
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

