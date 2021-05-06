package chat;

public class Chatbot {
	private static Chatbot instance;
	
	private Chatbot() {
		// TODO Auto-generated constructor stub
	}

	public static Chatbot getInstance() {
		
		if(instance == null) {
			instance = new Chatbot();
		}
		
		return instance;
	}
	
	public boolean checkForbiddenMessage(String message, Chat chat, User user) {
		if(message.contains("cat")) {
			chat.removeUser(user);
			chat.sendMessage("Cat is a forbidden word");
			return true;
		}
	
		return false;
	}
	
	public void postMessage(String message) {
		System.out.println("Posted message: " + message);
	}
}
