import java.util.*;
import java.io.*;

public class Test {
	
	public static void main(String[] args) {
		Director dir = new Director("Folder");
		File file = new File("/home/andreea/~/eclipse-workspace/lab12/Problema5/files");
		File[] files = file.listFiles();
		for(File f:files) {
			//System.out.println(f.g etName());
			Repository r = null;
			if(f.isFile()==true) {
				r = new Fisier(f.getName());
			}
			else if(f.isDirectory()==true) {
				r = new Director(f.getName());
			}
			dir.addChild(r);
		}
		
		Cat cat = new Cat();
		Ls ls = new Ls();
		for(Repository a:dir.content) {
			if(a instanceof Fisier) {
				a.accept(cat);
			}
			else
				if(a instanceof Director) {
					a.accept(ls);
				}
			
		//	new Fisier(a.getName()).accept(cat);
		//	new Director(a.getName()).accept(ls);
	//		cat.visit(new Fisier(a.getName()));
	//		ls.visit(new Director(a.getName()));
		}
	}
}
