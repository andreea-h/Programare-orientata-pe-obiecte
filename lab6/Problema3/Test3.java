import java.util.*;
public class Test3 {

	public static void main(String[] args) {
		Vector studenti = new Vector();
		Student s1 = new Student("Georgescu",3);
		s1.addMedie(9.2);
		s1.addMedie(6.2);
		s1.addMedie(4);
		Student s2 = new Student("Alexandrescu",3);
		s2.addMedie(9.2);
		s2.addMedie(8.3);
		s2.addMedie(6);
		Student s3 = new Student("Alexandrescu",3);
		s3.addMedie(9);
		s3.addMedie(10);
		s3.addMedie(9);
		Student s4 = new Student("Avram",3);
		s4.addMedie(9);
		s4.addMedie(10);
		s4.addMedie(7);
		studenti.add(s1);
		studenti.add(s2);
		studenti.add(s3);
		studenti.add(s4);
		System.out.println(studenti);
		Collections.sort(studenti);
		System.out.println(studenti);
		
	}

}
