
class TestArray {
	public static void main(String args[]) {
		SortedArray el = new SortedArray();
		el.addElement(10);
		el.addElement(20);
		el.addElement(13);
		el.addElement(3);
		el.addElement(-9);
		System.out.println(el);
		el.remove(3);
		System.out.println(el);
		el.remove(0);
		System.out.println(el);
	}

}
