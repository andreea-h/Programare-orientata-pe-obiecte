import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;

public class Buton extends JFrame {
	JButton b = new JButton("Colors");
	int contor=0;
	Color[] culori = {new Color(255,0,0), new Color(0,0,255), new Color(20,50,30), new Color(255,255,0), new Color(250,10,80)};
	public Buton(String titlu) {
		super(titlu);
		this.setSize(100,100);
		setLayout(new FlowLayout());
		add(b);
		show();
	
	b.setMnemonic(KeyEvent.VK_C);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b) {
				if(contor <=4 )
					b.setForeground(culori[contor++]);
				else{
					contor=0;
					b.setForeground(culori[contor++]);
				}
			}
		}
	});
	
	}
}
