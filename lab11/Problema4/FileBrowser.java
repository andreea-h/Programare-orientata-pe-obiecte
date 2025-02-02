import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.io.*;


class FileNode {

    private File file;

    public FileNode(File file) {
        this.file = file;
    }

    public String toString() {
        String name = file.getName();
        if (name.equals("")) {
            return file.getAbsolutePath();
        } else {
            return name;
        }
    }
}

class listareRecursiva implements Runnable {
	 private DefaultMutableTreeNode root;
     private File fileRoot;
     public listareRecursiva(File fileRoot,DefaultMutableTreeNode root) {
         this.fileRoot = fileRoot;
         this.root = root;
     }
     public void run() {
    	 listeaza(fileRoot, root);
     }
     
     public void listeaza(File fileRoot, DefaultMutableTreeNode node) {
    	 File[] files = fileRoot.listFiles();
         if (files == null) return;

         for (File file : files) {
             DefaultMutableTreeNode childNode = 
                     new DefaultMutableTreeNode(new FileNode(file));
             node.add(childNode);
             if (file.isDirectory()) {
                 listeaza(file, childNode);
             }
         }
     }
}

public class FileBrowser extends JFrame {
	
	String[] head ={"Nume","Dimensiune","Data ultimei modificari", "Tipul"};
	DefaultMutableTreeNode root;
	DefaultTreeModel treeModel;
	JTree tree;
	JTable info;
   
	public FileBrowser(String title) {
		super(title);
		setLayout(new GridLayout());
		this.setSize(800, 600);
	}
	
	public void listare() {
		File fRoot = new File("/home/andreea/Desktop/MN");
		root = new DefaultMutableTreeNode(new FileNode(fRoot));
		treeModel = new DefaultTreeModel(root);
		tree=new JTree(treeModel);
		JScrollPane scrollPane = new JScrollPane(tree);
		this.add(scrollPane);
		listareRecursiva sbb = new listareRecursiva(fRoot, root);
		new Thread(sbb).start();
	}
	
	public void creareTabel() {
		
		Object[][] data={{"fisier","10","20/20/2020","jpg"}, {"fisier","20","30/30/2012","png"}};
		JTable t = new JTable(data, head);
		JScrollPane scrollpane = new JScrollPane(t);
		this.add(scrollpane);
	
	}
	
	public static void main(String[] args) {
		FileBrowser f = new FileBrowser("FileBrowser");
		f.listare();
		f.creareTabel();
		f.show();
	}

}
