import java.text.DecimalFormat;
interface Persoana extends Comparable {
    public double calculMedieGenerala();
    public String getNume();
    public void setNume(String nume);
    public void addMedie(double medie);
}
//implementeaza metodele de mai sus + metoda compareTo
class Student implements Persoana {
	private String nume;
	private double note[];
	int nr; //numarul de medii din vector la finalizarea adaugarii mediilor
	public Student(String nume, int nr) {
		this.nume = nume;
		note = new double[nr]; 
		this.nr=0; //se incrememteaza la fiecare adaugare
	}
	
	public double calculMedieGenerala(){
		int i;
		double sum=0;
		for(i=0;i<note.length;i++) {
			sum = sum + note[i];
		}
		return sum/(note.length);
	}
	
	public String getNume() {
		return nume;
	}
	
	public void setNume(String name) {
		nume = name;
	}
	
	public void addMedie(double medie) {
		note[nr++]=medie;
	}
	
	public int compareTo(Object o) {
		if(!(o instanceof Student)) {
			throw new ClassCastException("Cele 2 obiecte nu pot compara!!!");
		}
		Student s = (Student)o;
		if((s.nume).equals(nume)) {
			double m1=s.calculMedieGenerala();
			double m2=this.calculMedieGenerala();
			return (int)(m1-m2);
		}
		else {
			return nume.compareTo(s.nume);
		}	
	}
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	public String toString() {
		int i;
		String rez = new String();
		for(i=0; i<note.length;i++) {
			rez = rez + note[i]+ " ";
		}
		String rez1 = new String();
		rez1 = rez + "--->"+df2.format(calculMedieGenerala());
		return nume + " " +rez1;
	}
}