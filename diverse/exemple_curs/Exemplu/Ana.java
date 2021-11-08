	class Ana  {
	public void print(Ana p) {
		System.out.println("Ana 1\n");
		}
	}

	class Mihai extends Ana {
	public void print(Ana p) {
		System.out.println("Mihai 1\n");
		}	
	public void print(Mihai l) {
		System.out.println("Mihai 2\n");
		}
	}
	
	class Dana extends Mihai {
		public void print(Ana p) {
		System.out.println("Dana 1\n");
		}
		public void print(Mihai l) {
			System.out.println("Dana 2\n");
		}
		public void print(Dana b) {
			System.out.println("Dana 3\n");
		}
	}
	
	class Test {
		public static void main(String args[]) {
			Mihai stud1 = new Dana();
			Ana stud2 = new Mihai();
			Ana stud3 = new Dana();
			Dana stud4 = new Dana();
			Mihai stud5 = new Mihai();
			stud1.print(new Ana());//1
			((Ana)stud1).print(new Mihai());//2
			((Mihai)stud2).print(new Ana()); //3
			stud2.print(new Dana()); //4
			stud2.print(new Mihai());//5
			//System.out.println((stud1).getClass().getName());
			//System.out.println(stud1.getClass().getName());
			//System.out.println(stud2.getClass().getName());
			//System.out.println(stud3.getClass().getName());
			stud3.print(new Dana()); //6
			stud3.print(new Ana()); 
			stud3.print(new Mihai()); 
			((Dana)stud3).print(new Mihai()); 
			Ana stud6 = new Mihai();
			System.out.println(stud6.getClass().getName());
			(stud6).print(new Dana());
			//System.out.println(stud2.getClass().getName());
			stud5.print(new Dana());
			System.out.println(stud5.getClass().getName());
			((Ana)stud1).print(new Mihai()); 
			System.out.println(((Ana)stud1).getClass().getName());
		}
		
	}