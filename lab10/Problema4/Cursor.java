import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;

public class Cursor extends JFrame  {
	JSlider Red = new JSlider(JSlider.HORIZONTAL, 0, 255,0);
	JSlider Green = new JSlider(JSlider.HORIZONTAL, 0, 255,0);
	JSlider Blue = new JSlider(JSlider.HORIZONTAL, 0, 255,0);
	JTextField status = new JTextField(30);
	public Cursor(String titlu) {
		super(titlu);
		this.setSize(400,400);
		setLayout(new FlowLayout());
		//pentru fiecare obj JSlider se specifica opientarea
		//valoarea minima
		//valoarea maxima
		//valoarea initiala
		
		add(Red);
		add(Green);
		add(Blue);
		add(status);
	 /*   Red.addChangeListener(new ChangeListener() {
	    	public void stateChanged(ChangeEvent e) {
	    		JSlider obj =(JSlider)(e.getSource());
	    		//System.out.println(obj.getValue());
	    		int value=0;
	    		value=Red.getValue()+Green.getValue()+Blue.getValue();
	    		Color c = new Color(value);
	    		status.setForeground(c);
	    	}
	    });*/
	    ChangeListener listener = new ChangeListener()
	    {
	    	public void stateChanged(ChangeEvent e) {
	    	//	value = Red.getValue()+Green.getValue()+Blue.getValue();
	    		Color c= new Color(Red.getValue(),Green.getValue(),Blue.getValue());
	    		status.setBackground(c);
	    	}	
	    };
	    Red.addChangeListener(listener);
        Green.addChangeListener(listener);
	    Blue.addChangeListener(listener);
	    
	 
		
		show();
	}
}
