import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;
import java.io.*;

public class Problema6 extends JFrame{
	public Problema6(String titlu) {
		super(titlu);
		this.setSize(400,400);
		setLayout(new FlowLayout());
		Label l = new Label("Calea");
		
		JTextField text = new JTextField("Introdu calea catre un fisier");	
		JButton b = new JButton("listare continut fisier");
		
		JTextArea textArea = new JTextArea(20,20);
		JScrollPane scrollableTextArea = new JScrollPane(textArea);
		//textArea.setVisible(false);
		scrollableTextArea.setVisible(false);
		add(l);
		add(text);
		add(b);
		add(textArea);
		add(scrollableTextArea);
		show();
		
		
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				File f = new File(text.getText().toString());
				scrollableTextArea.setVisible(true);
				getContentPane().validate();
				getContentPane().repaint();
				if(f.exists() && !f.isDirectory()) {
					String rez = new String(text.getText().toString());
					textArea.setVisible(true);
					scrollableTextArea.setVisible(true);
					//listare continut fisier
					try {
						RandomAccessFile fisier = new RandomAccessFile(rez, "r");
						String linie;
						
						while((linie=new String(fisier.readLine()))!=null) {
						//	    System.out.println(linie);
								textArea.setText(textArea.getText()+linie+"\n");
						}
					}
					catch(IOException ex)
					{
						ex.printStackTrace();
					}
					
				}
			}
		});
	}
}
