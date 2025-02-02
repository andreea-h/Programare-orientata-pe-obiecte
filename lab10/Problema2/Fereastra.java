import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.IOException;
import java.io.RandomAccessFile;

class Fereastra extends JFrame implements ActionListener  {
	
	String intrebare = new String();
	String rasp1 = new String();
	String rasp2 = new String();
	String rasp3 = new String();
	String rasp4 = new String();
	JRadioButton rb1 = new JRadioButton();
	JRadioButton rb2 = new JRadioButton();
	JRadioButton rb3 = new JRadioButton();
	JRadioButton rb4 = new JRadioButton();
	
	
	JTextField q = new JTextField();
	Button b = new Button("sumbit");  //butonul de validare
	
	 Fereastra(String titlu) {
		super(titlu);
		try {
		RandomAccessFile file = new RandomAccessFile("intrebare.txt", "r");
		intrebare = file.readLine();
		rasp1=file.readLine();
		rasp2=file.readLine();
		rasp3=file.readLine();
		rasp4=file.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		this.setSize(400,400);
		setLayout(new FlowLayout());
		
    	ButtonGroup bg = new ButtonGroup();
    	add(q);
		q.setEditable(false);
		q.setText(intrebare);
		rb1.setText(rasp1);
		rb2.setText(rasp2);
		rb3.setText(rasp3);
		rb4.setText(rasp4);
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);
		
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		rb3.addActionListener(this);
		rb4.addActionListener(this);
		JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(3, 1));
     
        radioPanel.add(rb1);
        radioPanel.add(rb2);
        radioPanel.add(rb3);
        radioPanel.add(rb4);
		add(radioPanel);
		b.setEnabled(false);
		add(b);
		b.addActionListener(this);
		show();
	}
	Color red = new Color(255,0,0);
	Color green = new Color(0,204,0);
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source instanceof JRadioButton) {  //butonul devine activ doar dupa ce s-a ales un rapsuns
			b.setEnabled(true);
		}
		if(source instanceof Button) {
			
			if((rb2.isSelected()==true)||(rb4.isSelected()==true) || (rb3.isSelected()==true)) {
			//   System.out.println("Raspuns gresit");
			/*	if(rb2.isSelected()==true) {
					rb2.setForeground(red);
				}
				if(rb3.isSelected()==true) {
					rb3.setForeground(red);
				}
				if(rb4.isSelected()==true) {
					rb4.setForeground(red);
				}*/
				rb1.setForeground(red);
			}
			if(rb1.isSelected()==true) {
				rb1.setForeground(green);
			}
	}
	}
	
}
