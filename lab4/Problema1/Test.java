
class Test {

	public static void main(String[] args) {
		Paralelogram test = new Paralelogram(10,20,30,150);
		System.out.println(test.latura1+" "+test.latura2+" "+test.latura3+" "+test.latura4);
		System.out.println(test.unghi1+" "+test.unghi2+" "+test.unghi3+" "+test.unghi4);
		System.out.println(test.arie());
		Romb rmb = new Romb(10,20,13,30,60);
		System.out.println(rmb.arie());
		Dreptunghi dr = new Dreptunghi(5,50);
		System.out.println(dr.arie());
		Patrat p = new Patrat(10);
		System.out.println(p.arie());

	}

}
