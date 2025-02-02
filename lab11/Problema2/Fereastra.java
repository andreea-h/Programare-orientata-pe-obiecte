import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;

public class Fereastra extends JFrame {
	DefaultListModel model;
	static JList list;
	static JTextField f1 = new JTextField();
	static JTextField f2 = new JTextField();
	JButton stergere = new JButton("Buton de stergere");
	JLabel l1 = new JLabel("Titlu");
	JLabel l2 = new JLabel("Autor");
	JPanel p = new JPanel();
	public Fereastra (DefaultListModel<Book> lista) {
		setLayout(new GridLayout());
		this.setSize(400,400);
		model = new DefaultListModel();
		list = new JList();
		p.setSize(400,400);
		p.add(l1);
		p.add(l2);
		p.add(f1);
		p.add(f2);
		stergere.setSize(20,20);
		this.add(stergere);
		this.add(p);
		list = new JList(lista);
		this.add(list);
		ListSelectionListener listListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				 if(list.isSelectionEmpty())  {
					 return;
				 }
			    JList jlist = (JList)e.getSource();
			    Object selected[] = jlist.getSelectedValues();
			    Book b=(Book)selected[0];
			    f1.setText(b.getName());
			    f2.setText(b.getAuthor());
			    pack();
				}	    
			};
	    list.addListSelectionListener(listListener);
	    
		stergere.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				Object sursa = e.getSource();
				if(sursa instanceof JButton) {
					int selection = list.getSelectedIndex();
					lista.remove(selection);
					pack();
				}
			}
			});

	    
	    
   }
	
	public static void main(String args[]) {
		DefaultListModel<Book> lst = new DefaultListModel<Book>();
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
		lst.addElement(b1);
		lst.addElement(b2);
		lst.addElement(b3);
		lst.addElement(b4);
		lst.addElement(b5);
		lst.addElement(b6);
		lst.addElement(b7);
		lst.addElement(b8);
		lst.addElement(b9);
		lst.addElement(b10);
		
		Fereastra f = new Fereastra(lst);
		f.setResizable(false);
		f.setVisible(true);
		f.show();
	}
}
