package Chat_Server;


import java.util.ArrayList;
import java.util.List;

public abstract class Conversation {
  protected final String id;
  protected List<User> users;
  protected List<Message> messageHistories;

  public Conversation(String id) {
    this.id = id;
    this.users = new ArrayList<>();
    this.messageHistories = new ArrayList<>();
  }

  public boolean addMessage(Message message) {
    this.messageHistories.add(message);
    return true;
  }

  public List<Message> getHistory() {
    return this.messageHistories;
  }

  public List<User> getUsers() {
    return this.users;
  }

  public String getId() {
    return this.id;
  }
}
