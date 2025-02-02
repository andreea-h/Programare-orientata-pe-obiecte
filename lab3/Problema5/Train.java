class Train {
	private Route r;
	private Schedule s;
	private boolean local;
	public Train(String origin,String destination,int op,int mp,int os,int ms,boolean local){
		r=new Route(origin,destination);
		s=new Schedule(new ClockTime(op,mp),new ClockTime(os,ms));
		s.departure=new ClockTime(op,mp);
		s.arrival=new ClockTime(os,ms);
		this.local=local;
	}
	int bilet() {
		int x;
		if(local==true)
			x=1;
		else
			x=2;
		return x*s.durata();
	}
	
	public String toString() {
		return local + r.origin + s.departure.hour + ":" + s.departure.minute +"\n"+r.destination + s.arrival.hour + ":" + s.arrival.minute  ;
	}
	
	public static void main(String[] args) {
		Train drum = new Train("bucuresti","galati",15,22,19,10,true);
		System.out.println(drum);
		System.out.println(drum.s.durata());
	}
}
