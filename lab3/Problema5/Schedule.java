
class Schedule {
	ClockTime departure;
	ClockTime arrival;
	public Schedule(ClockTime departure,ClockTime arrival) {
		this.departure = new ClockTime(departure.hour,departure.minute);
		this.arrival = new ClockTime(arrival.hour,arrival.minute);
	}
	int durata() {
		int ora=arrival.hour-departure.hour;
		return ora*60+arrival.minute+departure.minute;
	}
}

class Route {
	String origin;
	String destination;
	public Route(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
	}
	boolean verificare(Route obj) {
		if(this.origin.equals(obj.destination) && (this.destination.equals(obj.origin)))
			return true;
		return false;
	}
}

class ClockTime {
	int hour;
	int minute;
	public ClockTime(int hour, int minute) {
		this.hour=hour;
		this.minute=minute;
	}
	int compara(ClockTime obj) {
		if((this.hour > obj.hour) || ((this.hour==obj.hour) && (this.minute<obj.minute)))
			return 1; 
	return 2;
	}
}