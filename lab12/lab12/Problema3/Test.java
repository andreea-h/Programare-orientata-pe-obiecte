
public class Test {

	public static void main(String[] args) {
		Channel channel = new Channel();
		User a = new User("Ana");
		User b = new User("Ion");
		User c = new User("Maria");
		channel.subscribe(a);
		channel.subscribe(b);
		channel.subscribe(c);
		channel.notify("mesaj1");
		channel.notify("mesaj2");
		channel.notify("mesaj3");
		for(User user:channel.users) {
			System.out.println(user.name+" --> "+user.notifications);
		}
	}

}
