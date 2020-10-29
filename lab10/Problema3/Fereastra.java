import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.IOException;
import java.io.RandomAccessFile;

class Fereastra extends JFrame implements  ItemListener  {
	
	String intrebare = new String();
	String rasp1 = new String();
	String rasp2 = new String();
	String rasp3 = new String();
	String rasp4 = new String();
	JCheckBox cb1 = new JCheckBox();
	JCheckBox cb2 = new JCheckBox();
	JCheckBox cb3 = new JCheckBox();
	JCheckBox cb4 = new JCheckBox();
	
	JTextField q = new JTextField();

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
		
    	
    	add(q);
		q.setEditable(false);
		q.setText(intrebare);
		cb1.setText(rasp1);
		cb2.setText(rasp2);
		cb3.setText(rasp3);
		cb4.setText(rasp4);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(3, 1));
     
        radioPanel.add(cb1);
        radioPanel.add(cb2);
        radioPanel.add(cb3);
        radioPanel.add(cb4);
		add(radioPanel);
	  
		show();
	}
	Color red = new Color(255,0,0);
	Color green = new Color(0,204,0);
	
	
	
    public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cb1) { //raspuns corect
			cb1.setForeground(green);
		}
		if(e.getSource()==cb2) { //raspuns corect
			cb2.setForeground(green);
		}
		if(e.getSource()==cb2) { //raspuns corect
			cb2.setForeground(green);
		}
		if(e.getSource()==cb3) { 
			cb3.setForeground(red);
		}
		if(e.getSource()==cb4) { 
			cb4.setForeground(red);
		}
	}
	
	
}
