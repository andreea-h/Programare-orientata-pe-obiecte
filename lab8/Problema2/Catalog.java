import java.util.*;

public class Catalog<Student> extends TreeSet<Catalog.Student> {
	class Student implements Comparable {
		String name;
		double media;
		int clazz;
		
		public String toString() {
			String rez = new String();
			rez=this.name+" "+this.media+" "+this.clazz;
			return rez;
		}
		public Student(String nume, double media, int clazz) {
			this.name=nume;
			this.media=media;
			this.clazz=clazz;
		}
		public int compareTo(Object a) {
			if(this.media == ((Student)a).media)
				return this.name.compareTo(((Student)a).name);
			else {
				if(media < ((Student)a).media) {
					return -1;
				}
				else
					return 1;
			}
		}
	}
	
	//Comparator comparator;
	
	public Catalog(Comparator comparator) {
		super();
		//this.comparator = comparator;
	}
	
	public Catalog() {
		super();
	}
	
	public void addStudent(String nume, double media, int clazz) {
		Student obj =new Student(nume, media, clazz);
		this.add(obj);
	}
	
	
	public Student getStudent(String name) {
		Iterator<Catalog.Student> it = this.iterator();
		while(it.hasNext()) {
			Student a = (Student)it.next();
			if(a.name.equals(name))
				return a;
		}
		return null;
	}
	
	public void removeStudent(String name) {
		Iterator<Catalog.Student> it = this.iterator();
		while(it.hasNext()) {
			Student o =(Student)it.next();
			if(o.name.equals(name)) {
				it.remove();
			}
		}
	}
	
	//ordonarea alfabetica a studentilor dintr-o grupa 
	public Catalog byClass(int clazz) {
		//definim o clasa anonima
		Catalog<Student>c = new Catalog<Student>(new Comparator<Student>() {	
			public int compare(Catalog.Student a, Catalog.Student b) {
				return a.name.compareTo(b.name);
			}
		});
		
		Iterator<Catalog.Student> it = this.iterator();
		while(it.hasNext()) {
			Student a = (Student)it.next();
			if(a.clazz == clazz) 
				c.add(a);
		}
		return c;
	}
	
}
