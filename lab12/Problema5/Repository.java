import java.io.IOException;
import java.util.*;
import java.io.*;

interface Visitor {
	void visit(Director f);
	void visit(Fisier f);
}

class Ls implements Visitor {
	public void visit(Director f) {
		 System.out.println("Numele directorului: "+f.getName());
         for (Repository repo: f.content) {
             System.out.println(repo.getName()); 
         }
	}
	
	public void visit(Fisier f) {
		System.out.println("Not a folder");
	}
}

class Cat implements Visitor {
	 public void visit(Director f) {
		 System.out.println("Not a file");
     }
     public void visit(Fisier f) {
        try {
        	RandomAccessFile raf = new RandomAccessFile(f.getName(),"r");
        	System.out.println("Continutul fisierului: ");
        	String s;
        	while((s = raf.readLine())!=null) {
        		System.out.println(s);
        	}
        	System.out.println("------------------------");
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
     }
}

abstract class Repository {
	private String name;
	public String getName() {
		return name;
	}
	
	public Repository(String name) {
		this.name = name;
	}
	
	abstract public void accept(Visitor f);
}

class Fisier extends Repository {
	
	public Fisier(String name) {
		super(name);
	}
	
	public void accept(Visitor f) {
		f.visit(this);
	}
}

class Director extends Repository {
	ArrayList<Repository> content = new ArrayList<Repository>();
	
	public Director(String name) {
		super(name);
	}
	
	void addChild(Repository rep) {
		content.add(rep);
	}
	
	public void accept(Visitor f) {
		f.visit(this);
	}
}

