
abstract class Hero extends StormFire {
	void print() {
		System.out.println("Hero");
	}
}

class Warrior extends Hero { 
	void print() {
		System.out.println("Warrior");
	}
}

 class Ninja extends Hero {
    void print() {
    	System.out.println("Ninja");
    }
}

class Rogue extends Hero {
	void print() {
		System.out.println("Rogue");
	}
	
}

class StormFire extends BadLuck {
	 void execute(Hero h) {
	//	 System.out.println("in StormFire class "+h.getClass().getName());
		 h.print();
	 }
    void execute(Warrior w) {
    //	 System.out.println("in StormFire class "+w.getClass().getName());
    	 w.print();
    }
    void execute(Ninja n) {
    //	 System.out.println("in StormFire class "+n.getClass().getName());
    	 n.print();
    }
    void execute(Rogue r) {
    //	 System.out.println("in StormFire class "+r.getClass().getName());
    	 r.print();
    }
}