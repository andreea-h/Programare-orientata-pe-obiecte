import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//se creeaza 3 obiecte ascultator care transfera textul din fiecare camp in vel rezultat
class Problema1 extends JFrame /*implements ActionListener*/  {
	private JTextField tf1, tf2, tf3,tf4; 
	private Button bt;
	public Problema1(String titlu) {
		super(titlu);
		this.setSize(400,400);
		setLayout(new FlowLayout());
		JTextField tf1 = new JTextField(16);
		add(tf1);
		JTextField tf2 = new JTextField(15);
		add(tf2);
		JTextField tf3 = new JTextField(15);
		add(tf3);
		final JTextField tf4 = new JTextField(15);
		add(tf4);
		
		Button bt = new Button("ok");
		add(bt);
		
		tf1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			//	System.out.println(tf1.getText());
				tf4.setText(tf4.getText()+tf1.getText());
			}
		});
		tf2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			//	System.out.println(tf2.getText());
				tf4.setText(tf4.getText()+tf2.getText());
			}
		});
		tf3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			//	System.out.println(tf3.getText());
				tf4.setText(tf4.getText()+tf3.getText());
			}
		});
		setVisible(true);
		show();
	
	bt.addActionListener(new ActionListener () {
	//utilizez apoi un singur obiect ascultator care compune datele din primele 3 campuri
	public void actionPerformed(ActionEvent e) {
		Object sursa = e.getSource();
		if(sursa instanceof Button) {
			String text1 = tf1.getText();
			String text2 = tf2.getText();
			String text3 = tf3.getText();
			String rez=new String(text1+" "+text2+" "+text3);
			tf4.setText(rez);
		}
	}
	});
	}
}