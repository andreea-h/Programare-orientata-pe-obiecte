
interface Number<T> {
	public T getValue();
}

class Outer<T> {
	public Number<T> getInnerInstance() {
		class Numar<T> implements Number<T> {
			T value;
			public T getValue() {
				return value;
			}
		}
		return new Numar();
	}
}

