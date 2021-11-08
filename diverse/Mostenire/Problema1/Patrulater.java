import java.util.*;

class Patrulater {
    public int latura1, latura2, latura3, latura4;
    public double unghi1, unghi2, unghi3, unghi4;
 
    public Patrulater() {
        this(0, 0, 0, 0);
    }
 
    public Patrulater(int latura1, int latura2, int latura3, int latura4) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;
    }
 
    public Patrulater(double unghi1, double unghi2, double unghi3, double unghi4) {
        this(0, 0, 0, 0, unghi1, unghi2, unghi3, unghi4);
    }
 
    public Patrulater(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        this(latura1, latura2, latura3, latura4);
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi3;
        this.unghi4 = unghi4;
    }
 
    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }
}

class Paralelogram extends Patrulater {
	
	public Paralelogram() {
		this(0,0,0,0);
	}
	 public Paralelogram(int latura1, int latura2,int unghi1, int unghi2) {
		 super(latura1, latura1, latura2, latura2, unghi1, unghi1, unghi2,unghi2);
	 }
	 
	 public double arie() {
		 return latura1 * latura2 * Math.sin(Math.toRadians(unghi1));
	 }
}

class Romb extends Paralelogram {
	public int diag1, diag2;
	public Romb (int latura, int diag1, int diag2, int unghi1, int unghi2) {
		super(latura, latura, unghi1, unghi2);
		this.diag1 = diag1;
		this.diag2 = diag2;
	}
	
	public double arie() {
		return diag1*diag2/2;
	}
}

class Dreptunghi extends Paralelogram {
	public Dreptunghi (int latura1, int latura2) {
		super(latura1, latura2, 90, 90);
	}
	
	public double arie() {
		return latura1*latura2;
	}
}

class Patrat extends Dreptunghi {
	public Patrat(int latura) {
		super(latura, latura);
	}
	
	public double arie() {
		return latura1*latura1;
}
}
