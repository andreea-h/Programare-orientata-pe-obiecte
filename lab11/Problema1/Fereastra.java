import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Fereastra extends JFrame {
	public Fereastra(Vector<Book> carti) {
		super("Carti");
		this.setSize(400,400);
		setLayout(new FlowLayout());
		JList l = new JList(carti);
		JScrollPane scrollableList = new JScrollPane(l);
		this.add(scrollableList);
	}
	
	public static void main(String args[]) {
		Book b1=new Book("C/C++ Programming ","Autor1","");
		Book b2=new Book("Java Programming ","Autor2","");
		Book b3=new Book("C# Programming ","Autor3","");
		Book b4=new Book("IOS Programming ","Autor4","");
		Book b5=new Book("Windows Phone Programming ","Autor5","");
		Book b6=new Book("Android Programming ","Autor6","");
		Book b7=new Book("Cartea7 ","Autor7","");
		Book b8=new Book("Cartea8 ","Autor8","");
		Book b9=new Book("Cartea9 ","Autor9","");
		Book b10=new Book("Cartea10 ","Autor10","");
		
		Vector<Book> v = new Vector<Book>();
		v.add(b1);
		v.add(b2);
		v.add(b3);
		v.add(b4);
		v.add(b5);
		v.add(b6);
		v.add(b7);
		v.add(b8);
		v.add(b9);
		v.add(b10);
		Fereastra f = new Fereastra(v);
		f.show();
	}
}

