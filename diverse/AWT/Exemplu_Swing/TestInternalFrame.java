import javax . swing .*;
import java . awt .*;
class FereastraPrincipala extends JFrame {
	public FereastraPrincipala ( String titlu ) {
		super ( titlu );
		setSize (300 , 200) ;
		setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
		FereastraInterna fin1 = new FereastraInterna ();
		fin1 . setVisible ( true );
		FereastraInterna fin2 = new FereastraInterna ();
		fin2 . setVisible ( true );
		JDesktopPane desktop = new JDesktopPane ();
		desktop .add( fin1 );
		desktop .add( fin2 );
		setContentPane ( desktop );
		fin2 . moveToFront ();
	}
}

class FereastraInterna extends JInternalFrame {
	static int n = 0; // nr. de ferestre interne
	static final int x = 30, y = 30;
	public FereastraInterna () {
		super (" Document #" + (++ n),
			true , // resizable
			true , // closable
			true , // maximizable
			true );// iconifiable
		setLocation (x*n, y*n);
		setSize ( new Dimension (200 , 100) );
	}
}

class TestInternalFrame {
	public static void main ( String args []) {
		new FereastraPrincipala (" Test ferestre interne "). show ();
	}
}