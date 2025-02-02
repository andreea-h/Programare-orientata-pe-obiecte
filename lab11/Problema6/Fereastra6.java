import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;
import javax.imageio.*;


class BookRenderer extends JPanel implements ListCellRenderer {
	JLabel titlu;
	JLabel autor;
	JLabel imagine;
	DefaultListCellRenderer renderer = new DefaultListCellRenderer();
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		JLabel jrenderer =(JLabel) renderer.getListCellRendererComponent(list, value,index,isSelected, cellHasFocus);
	    if(isSelected==false) {
	    	if(index%2==0) {
	    		jrenderer.setBackground(Color.GREEN);
	    	}
	    	else if(index%2==1) {
	    		jrenderer.setBackground(Color.YELLOW);
	    	}	
	    }	
	    else if(isSelected==true) {
	    	jrenderer.setBackground(Color.RED);
	    }
	    return this;
	}
}

public class Fereastra6 extends JFrame /*implements ListSelectionListener*/{
	DefaultListModel model;
	public JList list;
	static JTextField f1 = new JTextField();
	static JTextField f2 = new JTextField();
	JButton stergere = new JButton("REMOVE THIS");
	JLabel l1 = new JLabel("Titlu");
	JLabel l2 = new JLabel("Autor");
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel l6;
	JLabel l7;
	JLabel l8;
	
	JPanel p = new JPanel();
	public Fereastra6() {
		
	}
	public Fereastra6 (DefaultListModel<Book> lista) {
		setLayout(new GridLayout());
		this.setResizable(false);
		this.setSize(600,600);
		model = new DefaultListModel();
		list = new JList();
		p.setSize(400,400);
		p.add(l1);
		p.add(f1);
		p.add(l2);
		p.add(f2);
		int i;
		
		JPanel p2 = new JPanel();
		l3 = new JLabel();
		l3.setIcon(new ImageIcon("./Imagini/" +lista.get(0).getIconName()));
		p2.add(l3);
		l4 = new JLabel();
		l4.setIcon(new ImageIcon("./Imagini/" +lista.get(1).getIconName()));
		p2.add(l4);
		l5 = new JLabel();
		l5.setIcon(new ImageIcon("./Imagini/" +lista.get(2).getIconName()));
		p2.add(l5);
		l6 = new JLabel();
		l6.setIcon(new ImageIcon("./Imagini/" +lista.get(3).getIconName()));
		p2.add(l6);
		l7 = new JLabel();
		l7.setIcon(new ImageIcon("./Imagini/" +lista.get(4).getIconName()));
		p2.add(l7);
		l8 = new JLabel();
		l8.setIcon(new ImageIcon("./Imagini/" +lista.get(5).getIconName()));
		p2.add(l8);
		list = new JList(lista);
		this.add(list);
		this.add(stergere);
		this.add(p2);
		this.add(p);
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
					//System.out.println(selection);
					lista.remove(selection);
					pack();
				}
			}
			});
		
		

   }
	
	public static void main(String args[]) {
		DefaultListModel<Book> lst = new DefaultListModel<Book>();
		Book b1=new Book("C/C++ Programming ","Autor1","");
		b1.setIconName("cpp.jpg");
		Book b2=new Book("Java Programming ","Autor2","");
		b2.setIconName("java.jpg");
		Book b3=new Book("C# Programming ","Autor3","");
		b3.setIconName("wp.jpg");
		Book b4=new Book("IOS Programming ","Autor4","");
		b4.setIconName("ios.jpg");
		Book b5=new Book("Windows Phone Programming ","Autor5","");
		b5.setIconName("wp.jpg");
		Book b6=new Book("Android Programming ","Autor6","");
		b6.setIconName("android.jpg");
		
		lst.addElement(b1);
		lst.addElement(b2);
		lst.addElement(b3);
		lst.addElement(b4);
		lst.addElement(b5);
		lst.addElement(b6);
		
		Fereastra6 f = new Fereastra6(lst);
		BookRenderer br = new BookRenderer();
		//list.setCellRenderer(br);  
	    f.pack();
		f.show();
	}
}
