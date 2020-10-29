public class Test{
public static void main (String [] args) {
Mihai stud1 = new Dana();
Ana stud2 = new Mihai();
Ana stud3 = new Dana();
Dana stud4 = new Dana();
Mihai stud5 = new Mihai();
stud1.print(new Ana());
((Dana)stud1).print(new Mihai());
((Mihai)stud2).print(new Ana());
stud2.print(new Dana());
stud2.print(new Mihai());
stud3.print(new Dana());
stud3.print(new Ana());
stud3.print(new Mihai());
((Dana)stud3).print(new Mihai());
((Dana)stud3).print(new Dana());
stud4.print(new Dana());
stud4.print(new Ana());
stud4.print(new Mihai());
stud5.print(new Dana());
stud5.print(new Mihai());
stud5.print(new Ana()); } }