
import java.util.*;
public class Task2 {

    public static void main(String args[]) {
        Catalog catalog = new Catalog();
        catalog.addStudent("Alexandru", 7, 324);
        catalog.addStudent("Ioana", 5, 321);
        catalog.addStudent("Maria", 10, 322);
        catalog.addStudent("Ionut", 6.2, 323);
        catalog.addStudent("Diana", 7, 322);
        //nu putem instantia interfata Comparator
        //se creeaza o instanta a clasei anonime care implememteaza interfata Comparator!!!!
        Catalog catalog2 = new Catalog(new Comparator<Catalog.Student>() 
        {
            public int compare(Catalog.Student o1, Catalog.Student o2) {
                if(o1.media==o2.media) // pentru medii egale->sortare alfabetica
                {	
                	System.out.println(o1.media+" "+o2.media);
                	return o1.name.compareTo(o2.name);
                }
                else { //descrescator dupa medie
                //	return (int)(o2.media - o1.media);
                	System.out.println(o1.media+" "+o2.media);
                	if(o1.media > o2.media)
                		return -1;
                	else
                		return 1;
                }
            }
        });
        catalog2.addAll(catalog);

        System.out.println("Verificam...");
        System.out.println("Continutul colectiei: " + catalog);
        System.out.println("Continutul colectiei: " + catalog2);

        Catalog.Student last = null;
        Iterator it = catalog.iterator();
      //  for (Catalog.Student o : catalog) 
        while(it.hasNext()){
        	Catalog.Student o = (Catalog.Student)it.next();
            if (last == null) {
                last = o;
                continue;
            }
            int r = last.media != o.media ? new Double(last.media).compareTo(o.media) : last.name.compareTo(o.name);
            if (r != last.compareTo(o)) {
                System.err.println("Catalog.Student.compareTo a fost implementata gresit.");
            }
        }

        if (catalog.size() != 5) {
            System.err.println("Catalog.size() a fost implementata gresit.");
        }
       
        catalog.removeStudent("Ionut");
        if (catalog.size() != 4) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }
        catalog.removeStudent("");
        if (catalog.size() != 4) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }

        if (catalog.byClass(322).size() != 2) {
            System.err.println("Catalog.byClass() a fost implementata gresit.");
        }

        catalog.removeStudent("Maria");
        if (catalog.byClass(322).size() != 1) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }

        if (catalog.getStudent("Maria") != null) {
            System.err.println("Catalog.getStudent() a fost implementata gresit.");
        }

        if ((catalog.getStudent("Alexandru") == null) || (catalog.getStudent("Alexandru").media != 7)) {
            System.err.println("Catalog.getStudent() a fost implementata gresit.");
        }
    }

}
