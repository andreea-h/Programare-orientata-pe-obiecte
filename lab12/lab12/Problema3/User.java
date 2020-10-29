import java.util.*;

public class User implements Observer {
	String name;
	ArrayList<String> notifications = new ArrayList<String>();
	
	public User(String name) {
		this.name = name;
	}
	
	public void update(Observable channel, Object message) {
		notifications.add((String)message);	
	}
}
