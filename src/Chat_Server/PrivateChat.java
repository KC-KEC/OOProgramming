package Chat_Server;

public class PrivateChat extends Conversation{

  public PrivateChat(String id, User user1, User user2) {
    super(id);
    this.users.add(user1);
    this.users.add(user2);
  }
}
