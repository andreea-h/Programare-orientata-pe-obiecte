import java.util.*;

public class Channel extends Observable {
	ArrayList<User> users = new ArrayList<User>();
	String name;
	
	void subscribe(User user) {
		if(!users.contains(user)) {
			users.add(user);
		}
	}
	
	void unsubscribe(User user) {
		users.remove(user);
	}
	
	void notify(String notification) {
		for(User a:users) {
			a.update(this, notification);
		}
	}
}
