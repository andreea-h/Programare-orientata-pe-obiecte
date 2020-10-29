class Ana {
public void print(Ana p) {
System.out.println("Ana 1\n");
}
}
class Mihai extends Ana {
public void print(Ana p) {
System.out.println("Mihai 1\n");
}
public void print(Mihai l) {
System.out.println("Mihai 2\n");
}
}
class Dana extends Mihai {
public void print(Ana p) {
System.out.println("Dana 1\n");
}
public void print(Mihai l) {
System.out.println("Dana 2\n");
}
public void print(Dana b) {
System.out.println("Dana 3\n");
}
}