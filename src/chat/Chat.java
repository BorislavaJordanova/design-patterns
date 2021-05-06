package chat;
import java.util.ArrayList;
import java.util.List;

public class Chat implements MessageMediator {

	private List<User> users;
	private Chatbot chatBot;
	
	public Chat() {
		this.users = new ArrayList<>();
	}

	@Override
	public void sendMessage(String message, User user) {
		if(message == "addBot") {
			chatBot = Chatbot.getInstance();
		}
		
		for(User chatUser: this.users) {
			// Skip the one who sends the message
			if(chatUser != user) {
				chatUser.receive(message);
			}
		}
		
		if(chatBot != null) {
			chatBot.checkForbiddenMessage(message, this, user);
		}
	}
	
	@Override
	public void sendMessage(String message) {
		for(User chatUser: this.users) {
			chatUser.receive(message);
		}
	}

	@Override
	public void addUser(User user) {
		this.users.add(user);
	}
	
	@Override
	public void removeUser(User user) {
		this.users.remove(user);
	}

}
